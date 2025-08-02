//===------- AppData.hpp - Application Data Header - C++ Header ----------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//
#pragma once

#include <map>

namespace OrgST::Variables {
    extern std::map<std::string, std::string> AppData;
    void FillAppData();
}