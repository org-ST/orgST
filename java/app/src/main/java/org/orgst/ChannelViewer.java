package org.orgst;

import java.util.Scanner;

public class ChannelViewer {
    String[] yes_ins = {"y","yes","Yes","Y","check","Check"};
    String[] no_ins = {"n","no","No","N"};
    public static void help(){
        System.out.println("commands: check, products, people, website, info, comment");
    }
    public static void CV() {
        System.out.println("Channel Viewer V2.0.1");
        System.out.println("Would you like to check the current channels?");
        for (int i = 0; i < ChannelData.Channels.length; i++){
            System.out.println(ChannelData.Channels[i]);
        }
        Scanner inpscanner = new Scanner(System.in);
        while (true){
            
            String inp = inpscanner.nextLine();
            
        }
    };
    
}
