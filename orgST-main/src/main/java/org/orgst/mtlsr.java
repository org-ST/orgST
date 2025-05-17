package org.orgst;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.Enumeration;

public class mtlsr {
    public static void main(String[] args) throws Exception {
        File jarFile = new File("orgST.jar");

        // Load classes
        URL[] urls = { jarFile.toURI().toURL() };
        try (URLClassLoader loader = new URLClassLoader(urls);
             JarFile jar = new JarFile(jarFile)) {

            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".class")) {
                    String className = entry.getName()
                            .replace('/', '.')
                            .replace(".class", "");
                    System.out.println("Class: " + className);

                    try {
                        Class<?> clazz = loader.loadClass(className);
                        for (Method method : clazz.getDeclaredMethods()) {
                            System.out.println("  Method: " + method.getName());
                        }
                    } catch (Throwable t) {
                        System.out.println("  Failed to load class: " + t);
                    }
                }
            }
        }
    }
}