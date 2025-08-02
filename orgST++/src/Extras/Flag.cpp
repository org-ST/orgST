//===------- Flag.cpp - Pride Flag function for orgST - C++ --------------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//

#include <iostream>

namespace OrgST::Extras {
    void Flag(){
        std::cout << "\033[31m" << "==============================" << "\033[0m" << std::endl;
        std::cout << "\033[38;5;214m" << "==============================" << "\033[0m" << std::endl;
        std::cout << "\033[33m" << "==============================" << "\033[0m" << std::endl;
        std::cout << "\033[32m" << "==============================" << "\033[0m" << std::endl;
        std::cout << "\033[34m" << "==============================" << "\033[0m" << std::endl;
        std::cout << "\033[35m" << "==============================" << "\033[0m" << std::endl;
    }
}