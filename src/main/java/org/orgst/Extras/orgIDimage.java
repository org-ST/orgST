package org.orgst.Extras;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class orgIDimage{
    public static void main(String[] args){
        try {
            System.out.println("Please sign into your orgID");
            boolean res = org.orgst.OrgID.Client.verusr();
        /* if (!res){
            System.out.println("We could not verify your orgID");
            System.out.println("To create a new one enter 1\nTo try again enter 2\nTo exit enter 3");
            Scanner scanner = new Scanner(System.in);
            System.out.print(">> ");
            String inp = scanner.nextLine();
            switch (inp){
                case "1": org.orgst.OrgID.Client.crusr(); break;
                case "2": orgIDimage.main(args); break;
                case "3": System.exit(0); break;
                default: System.out.println("Invalid input, Exiting orgST"); System.exit(1);
            }} */
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter the Birthday, for your orgID (MM-DD): ");
            String inp2 = scanner.nextLine();
            String username = org.orgst.OrgID.Client.username;
            System.out.print("Enter the comment you want: ");
            String comment = scanner.nextLine();
            BufferedImage img = ImageIO.read(orgIDimage.class.getClassLoader().getResourceAsStream("template.png"));
            BufferedImage out = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = out.createGraphics();
            g.drawImage(img, 0, 0, null);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.setColor(Color.decode("#375EEA"));
            g.drawString(username, 600, 650);
            g.dispose();
            ImageIO.write(out, "png", new File("output.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
