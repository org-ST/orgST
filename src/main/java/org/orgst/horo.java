package org.orgst;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class horo implements org.orgst.AppLoader.AlApp{

	public static int run(List<String> command) {
		// JVM Optimized Process Launcher
		try {
			System.out.println("Running: " + String.join(" ", command));
			ProcessBuilder processBuilder = new ProcessBuilder(command);
			processBuilder.redirectErrorStream(true);
			Process process = processBuilder.start();

			// Optional: forward process output to console
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			}

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
			URL url = new URI("https://github.com/MakiDevelops/homeroom/raw/refs/heads/main/homeroom/target/HomeRoom.jar").toURL();

			if (!file.exists()) {
				System.out.println("Downloading horo.jar...");
				InputStream in = url.openStream();
				Files.copy(in, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
				in.close();
			}

			List<String> command = Arrays.asList(
					"java",
					"-XX:+TieredCompilation",
					"-XX:+UseStringDeduplication",
					"-Xverify:none",
					"-Xmx1024m",
					"-Xms256m",
					"-Dawt.useSystemAAFontSettings=on",
					"-Dswing.aatext=true",
					"-XX:+UseShenandoahGC",
					"-jar",
					destFile
			);

			run(command);

		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}