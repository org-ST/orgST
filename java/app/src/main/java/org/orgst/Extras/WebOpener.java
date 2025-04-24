package org.orgst;
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