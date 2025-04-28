package org.orgst.Salvade;
import java.io.*;
<<<<<<< HEAD

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

=======
public class Main {
    public static void start() {
        try {
            // Load the JAR and find the resource
            InputStream in = Main.class.getResourceAsStream("/sal.py");

            // Check if resource is found
            if (in == null) {
                System.out.println("Resource not found: /sal.py");
                return; // Or handle error
            }

            // Create a buffered reader to read the script from the InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // Read the entire script into a string
            StringBuilder scriptContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                scriptContent.append(line).append("\n");
            }

            // Close the reader
            reader.close();

            // Pass the script content to Python
            ProcessBuilder pb = new ProcessBuilder("python3", "-c", scriptContent.toString());
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
>>>>>>> 2d375c70e4e5980501842c7f104567d5fe9181b9
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 2d375c70e4e5980501842c7f104567d5fe9181b9
