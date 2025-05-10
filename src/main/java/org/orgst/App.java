package org.orgst;

import java.io.PrintStream;

public class App {
   //TODO Possibly add JVM Optimization Post-Exec
   public static final PrintStream originalOut = System.out;
    public static void main(String[] args) {
        System.setOut(org.orgst.App.originalOut);
        Methods.head();
        while (true){
        String Cmd = Methods.input();
        String[] words = Cmd.split("\\s+");
        switch (words[0]) {
            case "run": //
                Methods.run();
            case "help": //
                Methods.help(words);
                break;
            case "sauce": //
                Methods.sauce();
                break;
            case "clear": //
                Methods.clear();
                break;
            case "hist": //
                Methods.hist();
                break;
            case "orgid": //
                Methods.orgid();
                break;
            case "pride": //
                Methods.flag();
                break;
            case "esc": //
                Methods.clear();
                System.exit(0);
                break;
            case "git": //
                System.out.println(org.orgst.Variables.AppData.AppData.get("GitHub"));
                break;
            case "apl":
                AppLoader.main();
                break;
            default:
                System.out.println("Command not found " + words[0]);
                break;
        }
    }
    }
}
