//===------- Encrypt.cpp - Encryption functions for orgID - C++ ----------------------*-===//
//
// Copyright (C) 2025 Wdboyes13
// Part of Wdboyes13's orgST++, under the GNU General Public License v3.
// See https://weelam.ca/license/ for license information.
// SPDX-License-Identifier: GPL-3.0-or-later
//
//===----------------------------------------------------------------------------------===//
#ifndef NOSSL

#include "../../third-party/CryptoPP/rsa.h"
#include  <string>
#include "../../third-party/CryptoPP/oaep.h"
#include "../../third-party/CryptoPP/sha.h"
#include "../../third-party/CryptoPP/base64.h"
#include "../../third-party/CryptoPP/files.h"
#include "../../third-party/CryptoPP/osrng.h"
#include <string>

namespace OrgST::OrgID::Encrypt {
    std::string encrypt(const std::string& password, const CryptoPP::RSA::PublicKey& publickey){
        CryptoPP::AutoSeededRandomPool prng;
        CryptoPP::RSAES_OAEP_SHA256_Encryptor encryptor(publickey);

        std::string ciphertext;
        CryptoPP::StringSource ss1(
            password, true,
            new CryptoPP::PK_EncryptorFilter(
                prng, encryptor, 
                    new CryptoPP::StringSink(ciphertext)
            )
        );

        std::string encoded;
        CryptoPP::StringSource ss2(
            ciphertext,
            true,
            new CryptoPP::Base64Encoder(
                new CryptoPP::StringSink(encoded),
                false // don't insert line breaks
            )
        );

        return encoded;
    }
}

#endif