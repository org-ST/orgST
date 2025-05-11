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
