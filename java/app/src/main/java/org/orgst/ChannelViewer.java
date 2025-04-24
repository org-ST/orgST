package org.orgst;

public class ChannelViewer {
    String[] yes_ins = {"y","yes","Yes","Y","check","Check"};
    String[] no_ins = {"n","no","No","N"};
    public static void help(){
        System.out.println("commands: check, products, people, website, info, comment");
    }
    public static void CV() {
    System.out.println("Channel Viewer V2.0.1");
    System.out.println("Would you like to check the current channels?");
    }
}
