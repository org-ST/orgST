package org.william;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.File;
public class App 
{
    public static String rainbowify(String text) {
        StringBuilder out = new StringBuilder("\033[1m");
        int len = text.length();
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                out.append(" ");
                continue;
            }
            int r = (int)(Math.sin(0.3 * i + 0) * 127 + 128);
            int g = (int)(Math.sin(0.3 * i + 2) * 127 + 128);
            int b = (int)(Math.sin(0.3 * i + 4) * 127 + 128);
            out.append(String.format("\u001B[38;2;%d;%d;%dm", r, g, b)).append(c);
        }
        return out.append("\033[0m").toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.io.File currentDir = new java.io.File(System.getProperty("user.dir"));

        while (true) {
            System.out.print(rainbowify(currentDir.getAbsolutePath() + " gsh :3 "));
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) break;

            String[] tokens = input.split(" ");
            if (tokens[0].equals("cd")) {
                if (tokens.length > 1) {
                    File newDir = new File(tokens[1]);
                    if (!newDir.isAbsolute()) {
                        newDir = new File(currentDir, tokens[1]);
                    }
                    if (newDir.exists() && newDir.isDirectory()) {
                        currentDir = newDir;
                    } else {
                        System.out.println(rainbowify("Directory not found: " + tokens[1]));
                    }
                }
                continue;
            }

            try {
                ProcessBuilder pb = new ProcessBuilder(tokens);
                pb.directory(currentDir); // run in updated directory
                pb.redirectErrorStream(true);
                Process proc = pb.start();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(proc.getInputStream())
                );
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(rainbowify(line));
                }

                proc.waitFor();
            } catch (Exception e) {
                System.out.println(rainbowify("Error\n" + e.getMessage()));
            }
        }
    }
}
