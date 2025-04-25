package org.orgst.Extras;

import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Flag {
    public static void start(){
        try {
            InputStream is = Flag.class.getResourceAsStream("/flag.png");
            BufferedImage img = ImageIO.read(is);
            JFrame frame = new JFrame("Pride");
            ImageIcon flag = new ImageIcon(img);
            JLabel flagLabel = new JLabel(flag);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(300, 200);
            frame.getContentPane().add(flagLabel); // add button to frame
            frame.setVisible(true);
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.print("..> ");
    }
}
