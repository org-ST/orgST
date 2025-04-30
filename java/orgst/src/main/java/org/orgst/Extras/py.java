package org.orgst.Extras;
import java.util.Scanner;
public class py {
    private static final Scanner scanner = new Scanner(System.in);
    public static void print(Object msg) {
        System.out.println(msg);
    }
    public static String input(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
