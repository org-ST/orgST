package org.orgst.Salvade;
import java.io.*;

public class Main {
    public static void start() {
        try {
            // Load the resource
            InputStream in = Main.class.getResourceAsStream("/sal.py");

            if (in == null) {
                System.out.println("Resource not found: /sal.py");
                return;
            }

            // Write it to a temp file
            File tempScript = File.createTempFile("sal_script", ".py");
            FileOutputStream out = new FileOutputStream(tempScript);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();

            // Run the temp file
            ProcessBuilder pb = new ProcessBuilder("python3", tempScript.getAbsolutePath());
            pb.inheritIO(); // This makes the Python output appear in your console too
            Process p = pb.start();
            p.waitFor();

            // Clean up temp file if you want
            tempScript.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
