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
package org.orgst.Extras;

import java.util.Scanner;
import org.orgst.App;
import org.orgst.Variables.ChannelData;
import javazoom.jl.player.Player;
import java.io.InputStream;
public class ChannelViewer {
    String[] yes_ins = {"y","yes","Yes","Y","check","Check"};
    String[] no_ins = {"n","no","No","N"};
    public static void help(){
        System.out.println("Channel Commands: check, products, people, website, info, comment\nMain Menu Commands: edit, test, rl\nExtras : exit, help");
    }
    public static void get(){
        GetUsrChannels.get();
        for (int i = 0; i < ChannelData.Channels.toArray().length; i++){
            System.out.println( i+1 + " " + ChannelData.Channels.get(i));
        }}
    public static void CV(String[] args) {
        org.orgst.Methods.M3Player player = new org.orgst.Methods.M3Player();
        player.play("/ChannelViewer.mp3");
        System.out.println("Channel Viewer V2.0.1 - Java Beta");
        get();
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
                    case "rl": get(); break;
                    case "help" : help(); break;
                    case "exit" : player.stop(); App.main(args); break;
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
                    System.out.println("There are no files/functions associated with this channel");
                } else {
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
