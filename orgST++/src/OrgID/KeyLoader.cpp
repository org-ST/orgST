//===------- KeyLoader.cpp - Public Key Loader for orgID - C++ -----------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//
#ifndef NOSSL

#include "../../third-party/CryptoPP/cryptlib.h"
#include "../../third-party/CryptoPP/rsa.h"
#include "../../third-party/CryptoPP/files.h"
#include "../../third-party/CryptoPP/filters.h"
#include "../../third-party/CryptoPP/base64.h"
#include "../../third-party/CryptoPP/osrng.h"
#include "../../third-party/CryptoPP/secblock.h"
#include <string>
#include <fstream>
#include <sstream>
#include <iostream>
#include <stdexcept>

namespace OrgST::OrgID::KeyLoader {
CryptoPP::RSA::PublicKey loadPublicKeyFromPEM(const std::string& pemPath) {
    using namespace CryptoPP;

    // 1. Load PEM file into string
    std::ifstream file(pemPath);
    if (!file.is_open()) {
        throw std::runtime_error("Failed to open PEM file");
    }

    std::stringstream buffer;
    buffer << file.rdbuf();
    std::string pem = buffer.str();

    // 2. Remove PEM headers
    std::string header = "-----BEGIN PUBLIC KEY-----";
    std::string footer = "-----END PUBLIC KEY-----";

    size_t start = pem.find(header);
    size_t end = pem.find(footer);

    if (start == std::string::npos || end == std::string::npos) {
        throw std::runtime_error("Invalid PEM format");
    }

    std::string base64 = pem.substr(start + header.size(), end - (start + header.size()));
    
    // Remove newlines/whitespace
    base64.erase(std::remove_if(base64.begin(), base64.end(), ::isspace), base64.end());

    // 3. Decode Base64
    std::string decoded;
    StringSource ss(base64, true, new Base64Decoder(new StringSink(decoded)));

    // 4. Load into PublicKey
    RSA::PublicKey publicKey;
    StringSource keySource(decoded, true);
    publicKey.Load(keySource);

    return publicKey;
}
}

#endif