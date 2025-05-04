package org.orgst.Extras.Apps;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class ChannelHelper {
    public static void main(String[] a){
    Scanner inp = new Scanner(System.in);
    try {
        System.out.println("All fields MUST be filled out");
        System.out.print("Enter channel name : ");
        StringBuilder data = new StringBuilder();
        String name = inp.nextLine();
        data.append("import org.orgst.Variables.ChannelData.Data; public class " + name.replace(" ", "") + " { public static void data(){ Data " + name.toLowerCase().replace(" ", "") + " = new Data(");
        FileWriter writer = new FileWriter(name.replace(" ", "") + ".java");
        System.out.print("Enter your channel comment : ");
        System.out.print("Enter the JAVA Method for your channel to run (Must include semicolon): ");
        String meth = inp.nextLine();
        System.out.print("Enter your channels website : ");
        String site = inp.nextLine();
        System.out.print("Enter your channels devs : ");
        String pepls = inp.nextLine();
        System.out.print("Enter your channels info : ");
        String info = inp.nextLine();
        System.out.print("Enter your channels creation date : ");
        String date = inp.nextLine();
        data.append("\"" + name + "\",new Runnable[]{()-> {" + meth + "}},\"" + site + "\",new String[]{\"" + pepls + "\"},\"" + info + "\",\"" + date + "\");}");
        writer.write(data.toString());
        writer.close();
    } catch (IOException e){
        e.printStackTrace();
    }}
}
