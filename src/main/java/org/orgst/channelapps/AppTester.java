package org.orgst.channelapps;
import java.util.Scanner;
public class AppTester {
    public static void start(String[] args){
        while (true){
            System.out.print(">> ");
            Scanner input = new Scanner(System.in);
            String inp = input.nextLine();
            switch(inp) {
                case "load": org.orgst.AppLoader.main();
                case "help": System.out.println("help, exit, info, load");
                case "exit": org.orgst.Extras.ChannelViewer.CV(args);
                case "info": System.out.println("apptest.py for orgST" + " | version" + " 1");
            }
        }
    }
}
