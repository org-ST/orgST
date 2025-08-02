//===------- Client.cpp - orgID Client Main - C++ -----------------------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//

#ifndef NOSSL

#include "OrgID.hpp"
#define CPPHTTPLIB_OPENSSL_SUPPORT
#include "../../third-party/cpp-httplib/httplib.h"
#include <iostream>
#include <string>
#include <sstream>
#include <iomanip>

namespace OrgST::OrgID::Client {

    bool isAtLeastXYearsAgo(const std::string& dateStr, int years) {
        std::tm tm = {};
        std::istringstream ss(dateStr);
        ss >> std::get_time(&tm, "%Y-%m-%d");
        if (ss.fail()) {
            std::cout << "Invalid date format: " << dateStr << std::endl;
            return false;
        }

        // Normalize tm_year (years since 1900) and tm_mon (0-11)
        int inputYear = tm.tm_year + 1900;
        int inputMonth = tm.tm_mon + 1;
        int inputDay = tm.tm_mday;

        // Get current time
        std::time_t t = std::time(nullptr);
        std::tm* now = std::localtime(&t);
        int currentYear = now->tm_year + 1900;
        int currentMonth = now->tm_mon + 1;
        int currentDay = now->tm_mday;

        // Calculate threshold year, month, day
        int thresholdYear = currentYear - years;
        int thresholdMonth = currentMonth;
        int thresholdDay = currentDay;

        // Compare dates:
        if (inputYear < thresholdYear) {
            return true;
        } else if (inputYear > thresholdYear) {
            return false;
        }

        // Same year, compare month
        if (inputMonth < thresholdMonth) {
            return true;
        } else if (inputMonth > thresholdMonth) {
            return false;
        }

        // Same month, compare day
        return inputDay <= thresholdDay;
    }
    std::string HOST = "https://orgid.onrender.com";

    int submit(std::string url, std::string username, std::string password){
        try {
            auto key = OrgST::OrgID::KeyLoader::loadPublicKeyFromPEM("./pub.pem");
            auto passw = OrgST::OrgID::Encrypt::encrypt(password, key);
            auto usr = OrgST::OrgID::Encrypt::encrypt(username, key);
            std::string json = "{\"usr\":\"" + usr + "\", \"pass\":\"" + passw + "\"}";

			httplib::SSLClient client(HOST);
			auto resp = client.Post(url, json, "application/json");

            std::cout << "Status: " << resp->status << std::endl;
            std::cout << "Response: " << resp->body << std::endl;

        } catch (std::exception &e){
            std::cout << e.what() << std::endl;
            return 1;
        }
        return 0;
    }
    bool crusr(){
        std::string agestring;
        std::cout << "Enter your Date of Birth (YYYY-MM-DD) We do not store this: " << std::endl;
        std::cin >> agestring;
        if (!isAtLeastXYearsAgo(agestring, 13)){
            std::cout << "You must be at least 13 years old to create an account." << std::endl;
            exit(0);
        }
        std::string usrnm;
        std::string passwd;
        std::cout << "Enter a username: ";
        std::cin >> usrnm;
        std::cout << "Enter a password: ";
        std::cin >> passwd;
        std::string url = "/create";
        int res = submit(url, usrnm, passwd);
        switch(res){
            case 200 : return true;
            case 409 : return false;
            default : return false;
        }
    }
    bool verusr(){
        std::string username;
        std::string password;
        std::string url = "/verify";
        std::cout << "Enter your username: ";
        std::cin >> username;
        std::cout << "Enter your password: ";
        std::cin >> password;
        switch(int res = submit(url, username, password)){
            case 200 : return true; break;
            case 404 : return false; break;
            case 401 : return false; break;
            default : return false; break;
        }
    }

}

#endif