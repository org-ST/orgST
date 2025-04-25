package org.orgst.OrgID;
import java.security.*;
import java.security.spec.*;
import javax.crypto.spec.*;

import javax.crypto.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.*;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    public static void submit(String url, String username, String password){
        try {
        PublicKey pub = KeyLoader.loadPublicKey();
        String passw = Encrypt.encrypt(password, pub);
        String usr = Encrypt.encrypt(username, pub);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
