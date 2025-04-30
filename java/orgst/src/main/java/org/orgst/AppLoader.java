package org.orgst;
import java.util.Scanner;
public class AppLoader {
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
