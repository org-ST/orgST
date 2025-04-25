package org.orgst.OrgID;
import java.security.*;
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
        HttpClient client = HttpClient.newHttpClient();
        String json = "{\"usr\":\"" + usr + "\", \"pass\"";
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
