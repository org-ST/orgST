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
                        window.close();
                        org.orgst.Salvade.Main.start();
                        break;
                    }
                    case "exit": {
                        window.close();
                        // Exit the program after closing the window
                        System.exit(0); // Properly terminate the application
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