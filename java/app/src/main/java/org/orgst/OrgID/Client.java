package org.orgst.OrgID;
import java.security.*;

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
