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

import java.io.IOException;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class AppLoader {
    public interface AlApp {
        static void start() {

        }
    }
    public static void main() {
        // Start the GUI in a separate thread
        Thread guiThread = new Thread(() -> startGUI());
        guiThread.start();
        
        // Wait for the GUI to finish before continuing with console input
        try {
            guiThread.join(); // Wait for the GUI thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After GUI interaction, continue with Scanner input
        startConsoleInput();
    }

    // Method to start the laterna GUI
    private static void startGUI() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            Screen screen = new TerminalScreen(terminal);
            screen.startScreen();

            // Create panel to hold components
            Panel panel = new Panel();
            panel.setLayoutManager(new GridLayout(2));
            panel.addComponent(new Label("Options: "));
            panel.addComponent(new Label("salvade"));
            panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
            panel.addComponent(new Label("homeroom"));
            panel.addComponent(new Label("exit"));
            panel.addComponent(new Label("App Name"));
            TextBox nameIn = new TextBox();
            panel.addComponent(nameIn);
            BasicWindow window = new BasicWindow();
            window.setComponent(panel);
            panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
            panel.addComponent(new Button("Open", () -> {
                String input = nameIn.getText().trim().toLowerCase(); // normalize input

                switch (input) {
                    case "salvade": {
                    	try {
                            window.close();
                            screen.stopScreen();
                            terminal.close(); } catch(IOException e) {
                            	e.printStackTrace();
                            }
                        org.orgst.Salvade.Main.start();
                        break;
                    }
                    case "homeroom": {
                        try {
                            window.close();
                            screen.stopScreen();
                            terminal.close(); } catch(IOException e) {
                            e.printStackTrace();
                        }
                        org.orgst.horo.start();
                        break;
                    }
                    case "exit": {
                    	try {
                        window.close();
                        screen.stopScreen();
                        terminal.close(); } catch(IOException e) {
                        	e.printStackTrace();
                        }
                    	org.orgst.App.main(new String[0]);
                        break;
                    }
                    default: {
                        System.out.println("Unknown app: " + input);
                        nameIn.setText("");
                        break;
                    }
                }
            }));

            MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
            gui.addWindowAndWait(window);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to handle console input after GUI interaction
    private static void startConsoleInput() {
    }
}















