//===------- Methods.cpp - Functions/Methods for orgST++ - C++ -----------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//

#include <string>
#include <vector>
#include <iostream>
#include "Extras/Flag.hpp"
#include "Variables/AppData.hpp"
#include "OrgID/OrgID.hpp"

namespace OrgST::Methods {
    void help(std::vector<std::string> command){
        std::cout << "flag, clear" << std::endl;
    }
    void flag(){
        OrgST::Extras::Flag();
    }
    void head(){
        std::cout << "\033[H\033[2J";
        std::cout.flush();
        std::cout << "orgST © 2024-2025 by Wdboyes13, Table37, MakiDevelops. Is licensed under GPLv3\n Available at https://github.com/MakiDevelops/orgST/blob/main/LICENSE\n'orgST', 'organizationSTATION', and the orgST logo are trademarks of orgST." << std::endl;
        std::cout << "-----------------------------------------" << std::endl;
        std::cout << "orgST Terminal 1.8 - C++ Ported" << std::endl;
        std::cout << "Ported by Wdboyes13" << std::endl;
        std::cout << "Refer to the readme for more information." << std::endl;
    }
    std::string input(){
        std::string ret;
        std::cout << "..> ";
        std::cin >> ret;
        return ret;
    }
    void clear(){
        std::cout << "\033[H\033[2J";
        std::cout.flush();
    }
    void hist(){
        for (const auto& entry : OrgST::Variables::AppData){
            std::cout << entry.first << " : " << entry.second << std::endl;
        }
    }
    void orgid(){
#ifndef NOSSL
        std::cout << "What do you want to do\nC - Create orgID\nV - Verify OrgID" << std::endl;
        auto opt = input();
        if (opt == "C"){
            OrgST::OrgID::Client::crusr();
        } else if (opt == "V"){
            OrgST::OrgID::Client::verusr();
        } else {
            std::cout << "Invalid Option" << std::endl;
        }
#else
        std::cout << "Sorry, you didn't build orgST with OpenSSL" << std::endl;
#endif
    }
}