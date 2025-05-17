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
import java.awt.Desktop;
import java.net.URI;

public class WebOpener {
    public static void open(String url) {
        try {
            URI uri = new URI(url); // your website here
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            } else {
                System.out.println("Desktop not supported, can't open browser.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}