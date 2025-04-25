package org.orgst.OrgID;

import java.io.InputStream;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class KeyLoader {

    public static PublicKey loadPublicKey() throws Exception {
        // 👇 Load file from classpath inside JAR
        InputStream is = KeyLoader.class.getClassLoader().getResourceAsStream("public_key.pem");

        if (is == null) {
            throw new IllegalArgumentException("Public key file not found in classpath!");
        }

        // 👇 Read and decode PEM
        String pem = new String(is.readAllBytes())
            .replace("-----BEGIN PUBLIC KEY-----", "")
            .replace("-----END PUBLIC KEY-----", "")
            .replaceAll("\\s", "");

        byte[] decoded = Base64.getDecoder().decode(pem);

        // 👇 Turn it into an RSA PublicKey object
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
