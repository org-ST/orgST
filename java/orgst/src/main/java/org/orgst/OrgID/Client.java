package org.orgst.OrgID;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.security.PublicKey;
public class Client {
    public static String HOST = "https://orgid.onrender.com";
    public static int submit(String url, String username, String password){
        try {
        PublicKey pub = KeyLoader.loadPublicKey();
        String passw = Encrypt.encrypt(password, pub);
        String usr = Encrypt.encrypt(username, pub);
        String json = "{\"usr\":\"" + usr + "\", \"pass\":\"" + passw + "\"}";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(json))
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());
        return response.statusCode();
        } catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }
    public static boolean crusr(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = inp.nextLine();
        System.out.print("Enter a password: ");
        String password = inp.nextLine();
        String url = HOST + "/create";
        int res = submit(url, username, password);
        inp.close();
        switch(res){
            case 200 : return true;
            case 409 : return false;
            default : return false;
        }
    }
    public static boolean verusr(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = inp.nextLine();
        System.out.print("Enter your password: ");
        String password = inp.nextLine();
        String url = HOST + "/verify";
        int res = submit(url, username, password);
        inp.close();
        switch(res){
            case 200 : return true;
            case 404 : return false;
            case 401 : return false;
            default : return false;
        }
    }
}
