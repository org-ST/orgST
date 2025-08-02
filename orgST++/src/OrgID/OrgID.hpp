//===------- OrgID.hpp - Header for orgID Functions - C++ ---------------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//

#ifndef NOSSL

#pragma once

#include "../../third-party/CryptoPP/rsa.h"

namespace OrgST::OrgID::Encrypt {
    std::string encrypt(const std::string& password, const CryptoPP::RSA::PublicKey& publickey);
}

namespace OrgST::OrgID::KeyLoader {
    CryptoPP::RSA::PublicKey loadPublicKeyFromPEM(const std::string& pemPath);
}

namespace OrgST::OrgID::Client {
    bool isAtLeastXYearsAgo(const std::string& dateStr, int years);
    int submit(std::string url, std::string username, std::string password);
    bool crusr();
    bool verusr();
}

#endif