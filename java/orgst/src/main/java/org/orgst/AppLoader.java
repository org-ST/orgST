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
                        window.close();
                        org.orgst.Salvade.Main.start();
                        break;
                    }
                    case "exit": {
                        window.close();
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
}