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
            System.out.println( i+1 + " " + ChannelData.Channels[i]);
        }
        Scanner inpscanner = new Scanner(System.in);
        while (true){
            System.out.print("..> ");
            String inp = inpscanner.nextLine();
            int inpi = Integer.parseInt(inp);
            try {
            String channel = ChannelData.Channels[inpi + 1];
            CVchannel(channel, inpscanner);
            } catch (Exception e) {
                switch(inp){
                    case "help" : help(); break;
                    case "exit" : break;
                } 
            }
        }
    };
    public static void CVchannel(String channel, Scanner scanner) {
        ChannelData.Data data = ChannelData.channels.get(channel);
        System.out.println("Welcome to: " + data.name);
        while (true){
            System.out.println("..> ");
            String inp = scanner.nextLine();
            switch(inp){
                case "check" : if (data.files == null){
                    System.out.println("There are no files associated with this channel");
                }
            }
        }
    }
}
