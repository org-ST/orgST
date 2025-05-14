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
package org.orgst.Salvade;

import org.orgst.AppLoader;

import java.io.*;

public class Main implements AppLoader.AlApp {
    public static void start() {
        try {
            String command = "which pypy"; // or "pypy --version"
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                command = "where pypy";
            }

            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            
            // Load the resource
            if (exitCode!=0){
                org.orgst.Salvade.DLpypy.main();
            }
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
