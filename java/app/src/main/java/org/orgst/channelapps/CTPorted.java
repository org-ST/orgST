package org.orgst.ChannelApps;
import java.util.*;
public class CTPorted {
    public static Float[] ans;
    public static void start(){
    System.out.println("CalcTrash V1.0.3 by @Table");
    }
    public static Object take_input(Boolean special, String prompt){
        try {
            System.out.println(prompt);
        } catch (Exception e){System.out.println("ProgramError: expected string in arg prompt"); return false;}
        Scanner inp = new Scanner(System.in);
        String a = inp.nextLine();
        try {
            Float af = Float.parseFloat(a);
            return af;
        } catch(Exception e) {
            if (a.equals("lop") && special == true){
                try {
                    System.out.print("How many operations back? \n >>");
                    String c = inp.nextLine();
                    int ci = Integer.parseInt(c);
                    Float af = ans[ans.length - ci*2];
                    return af;
                } catch (ArrayIndexOutOfBoundsException g){
                    System.out.println("Error: there was no lop to get");
                    return false;
                } catch (Exception f){
                    System.out.println("Error: invalid value");
                }
            } else if (a.equals("cancel") && special == true){
                System.out.println("Operation Canceled");
                return false;
            } else {
                System.out.println("Error: please input a number");
            }
        }
        return false;
    }
}
