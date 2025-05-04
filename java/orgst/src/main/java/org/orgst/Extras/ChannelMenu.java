package org.orgst.Extras;

import org.orgst.Variables.ChannelData;
import org.orgst.Extras.Apps.Channel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChannelMenu {
    public static void main(String[] args) {
        System.out.println("Launching");

        // Create frame
        JFrame frame = new JFrame("Channel Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the window but don't exit the application

        // Add a WindowListener to run a custom function on close
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                org.orgst.Extras.ChannelMenu.main(new String[0]);
                frame.dispose(); // Disposes the window after running the function
            }
        });
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center window

        // Use a grid layout: 1 column, variable rows
        JPanel panel = new JPanel(new GridLayout(ChannelData.Channels.length, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        for (int i = 0; i < ChannelData.Channels.length; i++) {
            String name = ChannelData.Channels[i];
            JButton button = new JButton(name);
            final int index = i;
            button.addActionListener(e ->
                    Channel.Start(ChannelData.channels.get(ChannelData.Channels[index]))
            );
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}