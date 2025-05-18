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
package org.orgst;
import java.util.Map;
import java.util.Scanner;

import org.orgst.Variables.AppData;
import org.orgst.Variables.ChannelData;
public class Methods {
    // Contains help entries for every function in this file
    public static void help(String[] command){
        if (command.length == 2){
            switch(command[1]){
                case "sal" : {
                    System.out.println("Command : sal");
                    System.out.println("Function : Run's salvade (Requires Python 3)");
                    break;
                }
                case "pride" : {
                    System.out.println("Command : Pride");
                    System.out.println("Function : Open's window with pride flag");
                    break;
                }
                case "clear" : {
                    System.out.println("Command : Clear");
                    System.out.println("Function : Clears the current orgST terminal");
                    break;
                }
                case "orgid" : {
                    System.out.println("Command : orgID");
                    System.out.println("Function : Start's orgID App");
                    break;
                }
                case "hist" : {
                    System.out.println("Command : Hist");
                    System.out.println("Function : Prints App Data");
                    break;
                }
                case "git" : {
                    System.out.println("Command : Git");
                    System.out.println("Function : Prints GitHub Link");
                    break;
                }
                case "sauce" : {
                    System.out.println("Command : Sauce");
                    System.out.println("Function : Prints all Channel Data");
                    break;
                }
                case "esc" : {
                    System.out.println("Command : Esc");
                    System.out.println("Function : Exits orgST");
                    break;
                }
                case "run" : {
                    System.out.println("Command : Run");
                    System.out.println("Function : Starts ChannelViewer");
                    break;
                }
                case "apl" : {
                    System.out.println("Command : Apl");
                    System.out.println("Function : Starts App Loader");
                }
            }
        } else if (command.length == 1){
            System.out.println("Cmd's: pride, clear, help, orgid, hist, git, sauce, esc, run, apl");
        } else {
            System.out.println("Invalid call of Method org.orgst.Methods.help()");
        }
    }
    public static void orgid(){
        Scanner inp = new Scanner(System.in);
        System.out.print("What do you want to do\nC - Create orgID\nV - Verify orgID\n..> ");
        String opt = inp.nextLine();
        switch(opt){
            case "V": org.orgst.OrgID.Client.verusr(); break;
            case "C": org.orgst.OrgID.Client.crusr(); break;
            default: System.out.println("Invalid option");
        }
    }
    public static void head() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("orgST © 2024-2025 by Wdboyes13, Table37, MakiDevelops. Is licensed under GPLv3\n Available at https://github.com/MakiDevelops/orgST/blob/main/LICENSE\n'orgST', 'organizationSTATION', and the orgST logo are trademarks of orgST.");
        System.out.println("-----------------------------------------");
        System.out.println("orgST Terminal 1.8 - Java Ported");
        System.out.println("Ported by Wdboyes13");
        System.out.println("Refer to the readme for more information.");
    };
    public static String input(){
        Scanner inp = new Scanner(System.in);
        System.out.print("..> ");
        String Cmd = inp.nextLine();
        return Cmd;
    }
    public static void sauce() {
        for (Map.Entry<String, ChannelData.Data> entry : ChannelData.channels.entrySet()) {
        System.out.println("Key: " + entry.getKey());
        System.out.println(entry.getValue());
        }
    }
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        head();
    }
    public static void hist(){
        for (Map.Entry<String, String> entry : AppData.AppData.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static void run(){
        String[] args = {};
        org.orgst.Extras.ChannelViewer.CV(args);
        
    }
}
