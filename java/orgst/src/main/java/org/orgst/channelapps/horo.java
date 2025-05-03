package org.orgst.channelapps;
import java.io.*;
import java.net.*;
import java.nio.file.*;
public class horo {
	public static int run(String command) {
		try {
		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        int exitCode = process.waitFor();
        return exitCode;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return 1;
		}
	}
	public static void start() {
		String destFile = "horo.jar";
		File file = new File(destFile);
		try {
		URL url = new URI( "https://github.com/MakiDevelops/homeroom/raw/refs/heads/main/homeroom/target/HomeRoom-1.0.jar").toURL();
		
		if (file.exists()) {
			run("java -jar " + destFile);
		} else {
			InputStream in = url.openStream();
			Files.copy(in, new File(destFile).toPath(), StandardCopyOption.REPLACE_EXISTING);
			
		}} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}