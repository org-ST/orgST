package org.orgst.Extras;
import java.io.*;

public class PYR {
    public static void run() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python3", "app.py");
            pb.inheritIO(); // makes it use your terminal I/O directly
            Process process = pb.start();
            process.waitFor(); // wait for the process to finish
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}