package org.orgst.ChannelApps;
import java.util.Scanner;
public class AppTester {
    public static void start(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            String inp = input.nextLine();
            switch(inp) {
                case "help": System.out.println("help, exit, info");
                case "exit": org.orgst.Extras.ChannelViewer.CV(args);
                case "info": System.out.println("print(\"apptest.py for orgST\" + \" | version\" + \" 1\")");
            }       
        }
    }
}
