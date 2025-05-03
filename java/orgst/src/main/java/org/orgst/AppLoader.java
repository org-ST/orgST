package org.orgst;
import java.io.IOException;
import java.util.Scanner;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
public class AppLoader {
    public static void main(){
        try{
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        panel.addComponent(new Label("App Name"));
        TextBox nameIn = new TextBox();
        panel.addComponent(nameIn);
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);
        panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
        panel.addComponent(new Button("Open", () -> {
            String input = nameIn.getText().trim().toLowerCase(); // normalize input

            switch (input) {
                case "salvade":{
                    window.close();
                    org.orgst.Salvade.Main.start();
                    break;
                }
                case "exit": {
                    window.close();
                    org.orgst.App.main(new String[0]);
                }
                default:
                    window.close();
                    System.out.println("Unknown app: " + input);
                    break;
            }
        }));

        // Create window to hold the panel
        

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static void start(){
        Scanner inp = new Scanner(System.in);
        while (true){
        System.out.print("Which app do you want to load\n1 - Salvade\n>> ");
        String input = inp.nextLine();
        String[] args = new String[1];
        switch(input){
            case "1" : org.orgst.Salvade.Main.start();
            case "exit": org.orgst.App.main(args);
            default : System.out.println("Invalid Option: " + input);
        }}
    }
}
