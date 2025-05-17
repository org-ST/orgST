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
package org.orgst.Extras;

import org.orgst.Variables.ChannelData;
import org.orgst.Extras.Apps.Channel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChannelMenu {
    public static void main(String[] args) {
        GetUsrChannels.get();
        System.out.println("Launching");

        // Create frame
        JFrame frame = new JFrame("Channel Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the window but don't exit the application

        // Add a WindowListener to run a custom function on close
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose(); // Disposes the window after running the function
            }
        });
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null); // Center window

        // Use a grid layout: 1 column, variable rows
        JPanel panel = new JPanel(new GridLayout(ChannelData.Channels.toArray().length, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        for (int i = 0; i < ChannelData.Channels.toArray().length; i++) {
            String name = ChannelData.Channels.get(i);
            JButton button = new JButton(name);
            final int index = i;
            button.addActionListener(e ->
                    Channel.Start(ChannelData.channels.get(ChannelData.Channels.get(index)))
            );
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}