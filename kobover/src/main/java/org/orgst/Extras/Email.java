package org.orgst.Extras;

import java.util.Properties;
import java.util.Scanner;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class Email {
    public static InternetAddress getRecipient() throws AddressException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the recipients email address: ");
        String rec = scanner.nextLine();
        return new InternetAddress(rec);
    }
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Supported providers: Gmail, Outlook, iCloud");
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String pass = scanner.nextLine();
        Properties props = new Properties();
        if (email.contains("@gmail.com")){
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
        }
        if (email.contains("@outlook.com")){
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.office365.com");
            props.put("mail.smtp.port", "587");
        }
        if (email.contains("@icloud.com")){
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.mail.me.com");
            props.put("mail.smtp.port", "587");
        }
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, pass);
            }
        });
        try {
            System.out.println("Successfully logged in!");
            System.out.println("Normally you would write your email here!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
