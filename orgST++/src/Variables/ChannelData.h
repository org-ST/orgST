//===------- ChannelData.hpp - Channel Data Header- C++ Header -----------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//
#pragma once

#include <string>
#include <vector>

std::string Join(const std::vector<std::string>& vec, const std::string& delimiter);

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

    Data(std::string name,
         void (*files)(void),
         std::string website,
         bool products,
         std::vector<std::string> people,
         std::string info,
         std::string date,
         std::string comment);

    std::string toString();
};