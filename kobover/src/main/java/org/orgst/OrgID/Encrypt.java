/*
orgST - A fun java console with apps
Copyright (C) 2025  Wdboyes13, MakiDevelops, Table37

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package org.orgst.OrgID;

import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public class Encrypt {
    public static String encrypt(String password, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        OAEPParameterSpec oaepParams = new OAEPParameterSpec(
            "SHA-256",
            "MGF1",
            MGF1ParameterSpec.SHA256,
            PSource.PSpecified.DEFAULT
        );

        cipher.init(Cipher.ENCRYPT_MODE, publicKey, oaepParams);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes); // optional: encode to string
    }
}
