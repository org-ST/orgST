package org.orgst.Extras;

import java.util.Scanner;
import org.orgst.App;
import org.orgst.Variables.ChannelData;
public class ChannelViewer {
    String[] yes_ins = {"y","yes","Yes","Y","check","Check"};
    String[] no_ins = {"n","no","No","N"};
    public static void help(){
        System.out.println("commands: check, products, people, website, info, comment, edit, test");
    }
    public static void CV(String[] args) {
        System.out.println("Channel Viewer V2.0.1 - Java Beta");
        System.out.println("Would you like to check the current channels?");
        for (int i = 0; i < ChannelData.Channels.toArray().length; i++){
            System.out.println( i+1 + " " + ChannelData.Channels.get(i));
        }
        Scanner inpscanner = new Scanner(System.in);
        while (true){
            System.out.print("..> ");
            String inp = inpscanner.nextLine();   
            try {
            int inpi = Integer.parseInt(inp);
            String channel = ChannelData.Channels.get(inpi-1);
            CVchannel(channel, inpscanner, args);
            } catch (Exception e) {
                switch(inp){
                    case "help" : help(); break;
                    case "exit" : App.main(args); break;
                    case "DON'T YOU FRICKIN DARE" : System.out.println("ok man geez"); break;
                    case "edit": org.orgst.Extras.Apps.ChannelHelper.main(args);; break;
                    case "test": org.orgst.channelapps.AppTester.start(args);
                } 
            }
        }
    };
    public static void CVchannel(String channel, Scanner scanner, String[] args) {
        ChannelData.Data data = ChannelData.channels.get(channel);
        System.out.println("Welcome to: " + data.name);
        while (true){
            System.out.print("..> ");
            String inp = scanner.nextLine();
            switch(inp){
                // Make this actually open the file once ALL of them are ported to Java
                case "check" : if (data.files == null){
                    System.out.println("There are no files associated with this channel");
                } else {
                    System.out.println("We found some files");
                        data.files.run();
                }
                break;
                case "web" : if (data.website == null){
                    System.out.println("There is no website for this channel");
                } else {
                    WebOpener.open(data.website);
                }
                break;
                // If a channel gets products then implement the product command from channelviewer.py it (not gonna until then though)
                case "people" : for (String person : data.people){
                    System.out.println(person);
                }
                break;
                case "info" : System.out.println(data.info);
                break;
                case "comment" : System.out.println(data.comment);
                break;
                case "help" : help(); break;
                case "exit" : App.main(args); break;
            }
        }
    }
}
