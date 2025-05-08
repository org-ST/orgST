package org.orgst;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        File jarFile= new File(Main.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .toURI());
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-XX:+TieredCompilation",
                "-XX:TieredStopAtLevel=1",
                "-XX:CompileThreshold=1000",
                "-XX:+UseStringDeduplication",
                "-XX:+AlwaysPreTouch",
                "-XX:+UseCodeCacheFlushing",
                "-Xmx1g",
                "-Xms256m",
                "-XX:MaxGCPauseMillis=200",
                "-XX:+ParallelRefProcEnabled",
                "-XX:+UseShenandoahGC",
                "-XX:+HeapDumpOnOutOfMemoryError",
                "-cp",
                jarFile.getAbsolutePath(),
                "org.orgst.App"
        );
        pb.inheritIO();
        Process proc = pb.start();
        proc.waitFor();
        System.out.println("Exited process " + proc.pid() + " with code " + proc.exitValue());
    }
}
