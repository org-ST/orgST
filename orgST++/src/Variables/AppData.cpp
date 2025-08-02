//===------- AppData.cpp - Application Data Code - C++ ------------------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//
#include <map>

namespace OrgST::Variables {
    std::map<std::string, std::string> AppData;
    void FillAppData(){
        AppData.insert(std::make_pair<std::string, std::string>("Version", "1.8.0"));
        AppData.insert(std::make_pair<std::string, std::string>("Updates", "9"));
        AppData.insert(std::make_pair<std::string, std::string>("Authors", "progman.task, Wdboyes13, chureki"));
        AppData.insert(std::make_pair<std::string, std::string>("Title", "orgST"));
        AppData.insert(std::make_pair<std::string, std::string>("Sponsors", "orgST Public, Archive, CalcTech, toyathing"));
        AppData.insert(std::make_pair<std::string, std::string>("GitHub", "https://github.com/MakiDevelops/orgST"));
        AppData.insert(std::make_pair<std::string, std::string>("Website", "https://orgst.ca"));
    }
}