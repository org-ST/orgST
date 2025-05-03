package org.orgst.Salvade;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class DLpypy {
    public static void main() {
        try {
            // Check if PyPy is installed
            String command = "which pypy"; // or "pypy --version"
            String os = System.getProperty("os.name").toLowerCase();
            String arch = System.getProperty("os.arch").toLowerCase();
            if (os.contains("win")) {
                command = "where pypy";
            }

            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            // If PyPy is not installed (exitCode 1)
            if (exitCode != 0) {
                System.out.println("PyPy not found. Downloading...");

                // Select download URL based on OS
                String url = "";
                String destFile = "pypy.tar.bz2";

                if (os.contains("win")) {
                    if (arch.contains("arm")) {
                        // For ARM on Windows, it's not well-supported by PyPy, so we might skip it
                        System.out.println("ARM-based Windows support for PyPy is Not Available.");
                        return;
                    } else {
                        url = "https://downloads.python.org/pypy/pypy3.10-v7.3.19-win64.zip"; // Windows x86
                        destFile = "pypy.zip";
                    }
                } else if (os.contains("mac")) {
                    if (arch.contains("aarch64")) {
                        // ARM-based macOS (Apple M1/M2)
                        url = "https://downloads.python.org/pypy/pypy3.11-v7.3.19-macos_arm64.tar.bz2"; // macOS ARM
                    } else {
                        // Intel macOS
                        url = "https://downloads.python.org/pypy/pypy3.11-v7.3.19-macos_x86_64.tar.bz2"; // macOS x86_64
                    }
                    destFile = "pypy-macos.tar.bz2";
                } else if (os.contains("nix") || os.contains("nux")) {
                    if (arch.contains("aarch64")) {
                        // Linux ARM (aarch64)
                        url = "https://downloads.python.org/pypy/pypy3.11-v7.3.19-aarch64.tar.bz2"; // Linux ARM
                    } else {
                        // x86_64 Linux
                        url = "https://downloads.python.org/pypy/pypy3.10-v7.3.19-linux64.tar.bz2"; // Linux x86_64
                    }
                    destFile = "pypy-linux.tar.bz2";
                }
                try {
                URL downloadUrl = new URI(url).toURL();

                try (InputStream in = downloadUrl.openStream()) {
                    Files.copy(in, new File(destFile).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Downloaded PyPy!");

                    // Extract the downloaded file (based on the type of archive)
                    if (os.contains("win")) {
                        // Windows uses .zip, so we need to unzip
                        Process unzip = new ProcessBuilder("cmd", "/c", "powershell Expand-Archive " + destFile).start();
                        unzip.waitFor();
                        System.out.println("Extracted PyPy on Windows.");
                    } else {
                        // macOS and Linux use .tar.bz2, so we use tar
                        Process tar = new ProcessBuilder("tar", "-xjf", destFile).start();
                        tar.waitFor();
                        System.out.println("Extracted PyPy on " + (os.contains("mac") ? "macOS" : "Linux"));
                    }

                    // Optionally, set up installation (add to PATH or move to desired directory)
                    System.out.println("PyPy is ready to use.");
                } catch (IOException e) {
                    System.out.println("Failed to download or extract PyPy: " + e.getMessage());
                }
            } catch (URISyntaxException e) {e.printStackTrace();}
            } else {
                System.out.println("PyPy is already installed!");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}