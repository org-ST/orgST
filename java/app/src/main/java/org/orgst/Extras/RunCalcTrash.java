package org.orgst.Extras;
import java.io.*;
import java.nio.file.*;
public class RunCalcTrash {
    public static void start() {
        try {
            // Define where to extract to
            Path tempScript = Files.createTempFile("calctrash", ".py");

            // Load the JAR and find the resource
            InputStream in = RunCalcTrash.class.getResourceAsStream("/org/orgst/ChannelApps/AppDeps/calctrash.py");
            Files.copy(in, tempScript, StandardCopyOption.REPLACE_EXISTING);

            // Make sure it's readable & executable
            tempScript.toFile().setExecutable(true);

            // Run the script
            ProcessBuilder pb = new ProcessBuilder("python3", tempScript.toAbsolutePath().toString());
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();

            // Delete the temp file after (optional)
            Files.delete(tempScript);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}