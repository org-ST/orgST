package org.orgst.Extras;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Flag {
    public static void start(){
     JFrame frame = new JFrame("My Nerdy Window");
        JButton button = new JButton("Click me!");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.getContentPane().add(button); // add button to frame
        frame.setVisible(true);
    }
}
