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
                boolean appFound = false; // Flag to track whether the app was found
                
                switch (input) {
                    case "salvade": {
                        appFound = true;
                        org.orgst.Salvade.Main.start();
                        break;
                    }
                    case "exit": {
                        appFound = true;
                        org.orgst.App.main(new String[0]);
                        break;
                    }
                    default: {
                        System.out.println("Unknown app: " + input);
                        break;
                    }
                }
                
                if (appFound) {
                    window.close(); // Close the window only if a valid app was found
                } else {
                    // You could add a "try again" message or make some changes here if needed.
                    System.out.println("Invalid option. Please try again.");
                    nameIn.setText(""); // Clear the text box for a new attempt
                }
            }));

            MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
            gui.addWindowAndWait(window);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}