package org.orgst.Extras;

import java.io.*;

public class RunCalcTrash {
    public static void start() {
        try {
            // Load the JAR and find the resource
            InputStream in = RunCalcTrash.class.getResourceAsStream("/calctrash.py");

            // Check if resource is found
            if (in == null) {
                System.out.println("Resource not found: /calctrash.py");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}