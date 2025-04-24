package org.orgst;
import java.util.Map;
import java.util.Scanner;
public class Methods {
    public static String head() {
        System.out.println("orgST © 2024-2025 by Wdboyes13, progman.task is licensed under CC BY-NC-ND 4.0\n" + "'orgST', 'organizationSTATION', and the orgST logo are trademarks of orgST.");
        System.out.println("---------------------------------------");
        System.out.println("orgST Terminal 1.8 - Java");
        System.out.println("Refer to the readme for more information.");
        Scanner inp = new Scanner(System.in);
        String Cmd = inp.nextLine();
        inp.close();
        return Cmd;
    };
    public static void sauce() {
        for (Map.Entry<String, Vars.Data> entry : Vars.channels.entrySet()) {
        System.out.println("Key: " + entry.getKey());
        System.out.println("Value: " + entry.getValue()); // will call toString() on Data
    }
    }
}
