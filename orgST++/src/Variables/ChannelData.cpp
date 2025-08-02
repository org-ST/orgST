//===------- ChannelData.cpp - Channe; Data Code - C++ -------------------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//
#include "ChannelData.h"

#include <vector>
#include <map>
#include <string>

namespace OrgST::Variables::ChannelData{

std::string Join(const std::vector<std::string>& vec, const std::string& delim) {
    // Join an std::vector<std::string> into a single std::string
    std::string result;
    for (size_t i = 0; i < vec.size(); ++i) {
        result += vec[i];
        if (i != vec.size() - 1) {
            result += delim;
        }
    }
    return result;
}

class Data {
public:
std::string name;
void (*files)(void);
std::string website;
bool products;
std::vector<std::string> people;
std::string info;
std::string date;
std::string comment;
Data (std::string name, void (*files)(void), std::string website, bool products, std::vector<std::string> people, std::string info, std::string date, std::string comment){
    this->name = name;
    this->website = website;
    this->products = products;
    this->people = people;
    this->info = info;
    this->date = info;
    this->comment = info;
    this->date = date;
    this->comment = comment;
}
std::string toString(){
	std::string ret;
	ret.append("Name: " + this->name);
    if (!this->website.empty()){
        ret.append("\nWebsite: " + this->website);
    }
    ret.append("\nPeople: " + Join(this->people, ", "));
    ret.append("\nProducts: " + std::string(this->products ? "Yes" : "No"));
    ret.append("\nInfo: " + this->info);
    ret.append("\nDate: " + this->date);
    ret.append("\nComment: " + this->comment + "\n");
    return ret;
}
};

std::vector<std::string> Channels;
std::map<std::string, Data> ChannelsData;

void InitChannelData(){
    Channels.push_back("OrgST Public Channel");
    Channels.push_back("CalcTech Channel");
    Channels.push_back("Toyathings MMD Channel");
    Channels.push_back("The Archive Channel");
    Channels.push_back("The Debug Channel");
    Channels.push_back("The Home Room Channel");

    Data* orgst = new Data("The OrgST Public Channel",
                            nullptr, "https://satelliteearth.wordpress.com",
                             false, {"Wdboyes13, program.task"},
                             "The Public OrgST Channel.", "2024-12-21",
                                "Welcome to OrgST's workspace");
	ChannelsData.insert(std::pair<std::string, Data>("OrgST Public Channel",*orgst));
}
}