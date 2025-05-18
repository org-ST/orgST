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
