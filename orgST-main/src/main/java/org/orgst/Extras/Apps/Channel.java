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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Arrays;
import org.orgst.Variables.ChannelData;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Channel {
    public static void Start(ChannelData.Data data) {
        // Create JFrame instead of Stage
        JFrame frame = new JFrame(data.name); // Set the title to data.name
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close the window but don't exit the application

        frame.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosing(WindowEvent e) {
                                        org.orgst.Extras.ChannelMenu.main(new String[0]);
                                        frame.dispose(); // Disposes the window after running the function
                                    }
                                });

        frame.setVisible(true);

        // Create a label for displaying information
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setBounds(125, 80, 250, 20); // Set position for label

        // Create buttons
        JButton nameButton = new JButton("Name");
        JButton siteButton = new JButton("WebSite");
        JButton dateButton = new JButton("Date");
        JButton commButton = new JButton("Comment");
        JButton peopleButton = new JButton("People");
        JButton infoButton = new JButton("Info");
        JButton checkButton = new JButton("Check");

        // List of buttons
        List<JButton> buttons = Arrays.asList(nameButton, siteButton, dateButton, commButton, peopleButton, infoButton, checkButton);
        // Set ActionListeners for buttons
        infoButton.addActionListener(e -> label.setText(data.info));
        checkButton.addActionListener(e -> {
            if (data.files != null) {
                label.setText("Please check your terminal...");
                // Here, you might want to close the window or handle the file execution differently
                data.files.run();
                frame.setVisible(false);
            } else {
                label.setText("No files available");
            }
        });
        peopleButton.addActionListener(e -> {
            StringBuilder peopleStringBuilder = new StringBuilder();
            for (String st : data.people) {
                peopleStringBuilder.append(st).append(", ");
            }
            label.setText(peopleStringBuilder.toString());
        });
        nameButton.addActionListener(e -> label.setText(data.name));
        siteButton.addActionListener(e -> {
            if (data.website != null) {
                label.setText("Opening...");
                org.orgst.Extras.WebOpener.open(data.website); // Assuming this method works for Swing
            } else {
                label.setText("There is no website :(");
            }
        });
        dateButton.addActionListener(e -> label.setText(data.date));
        commButton.addActionListener(e -> label.setText(data.comment));

        // Set layout to null for absolute positioning (or use another layout manager)
        frame.setLayout(null);

        // Set positions for buttons
        int yPosition = 20;
        for (JButton button : buttons) {
            button.setBounds(20, yPosition, 100, 30); // Positioning buttons vertically
            yPosition += 40; // Spacing between buttons
            frame.add(button);
        }

        // Add label to the frame
        frame.add(label);

        // Display the frame
        frame.setVisible(true);
    }
}