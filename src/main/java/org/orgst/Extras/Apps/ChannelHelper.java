/*
orgST - A fun java console with apps
Copyright (C) 2025  Wdboyes13, MakiDevelops, Table37

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see https://www.gnu.org/licenses/.
 */
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
        data.append("import org.orgst.Variables.ChannelData.Data; public class " + name.replace(" ", "") + " { public static Data data(){ return new Data(");
        FileWriter writer = new FileWriter("UserChannels/" + name.replace(" ", "") + ".java");
        System.out.print("Enter your channel comment : ");
        String comment = inp.nextLine();
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
        data.append("\"" + name + "\",()-> {" + meth + "},\"" + site + "\",false,new String[]{\"" + pepls + "\"},\"" + info + "\",\"" + date + "\",\""+comment+"\");}}");
        writer.write(data.toString());
        writer.close();
    } catch (IOException e){
        e.printStackTrace();
    }}
}
