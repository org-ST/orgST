package org.orgst.ChannelApps;
import java.util.*;
import org.orgst.Variables.Ops;
import java.lang.*;
public class CTPorted {
    public static String[][] ans;
    public static boolean check_input(Object to_check){
        if (to_check instanceof Integer || to_check instanceof Float) {
            return true;
        } else {
            return false;
        }
    }
    public static void start(){
        System.out.println("CalcTrash V1.0.3 by @Table");
        while (true){
            System.out.println("Input operation, else, enter \"help\" for all commands");
            Scanner cScanner = new Scanner(System.in);
            String c = cScanner.nextLine();
            for (Ops.op o : Ops.ops) {
                if (o.hasName(c)) {
                    String[] opTD = new String[o.info.argCount];
                    opTD[0] = o.info.opName;
                    Scanner opScanner = new Scanner(System.in);
                    for (int i = 0; i < o.info.argCount; i++) {
                        System.out.print("Please enter a number: ");
                        opTD[i+1] = opScanner.nextLine();
                    }
                    String out;
                    switch(opTD[0]) {
                        case "add": out = Double.toString(Double.parseDouble(opTD[1]) + Double.parseDouble(opTD[2])); break;
                        case "subtract": out = Double.toString(Double.parseDouble(opTD[1]) - Double.parseDouble(opTD[2])); break;
                        case "multiply": out = Double.toString(Double.parseDouble(opTD[1]) * Double.parseDouble(opTD[2])); break;
                        case "divide": out = Double.toString(Double.parseDouble(opTD[1]) / Double.parseDouble(opTD[2])); break;
                        case "exponentiate": out = Double.toString(Math.pow(Double.parseDouble(opTD[1]), Double.parseDouble(opTD[2]))); break;
                        case "squareRoot": out = Double.toString(Math.sqrt(Double.parseDouble(opTD[1])));
                    }
                    
                }
            }
        }
    }
}
