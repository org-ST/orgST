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
