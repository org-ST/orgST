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
package org.orgst.Extras;
import javax.tools.*;
import org.orgst.Variables.ChannelData;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;
import java.lang.Object;
import java.lang.IllegalAccessException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
public class GetUsrChannels {
    public static void get(){
        File folder = new File("UserChannels/");
        File[] files = folder.listFiles((dir,  name) -> name.endsWith(".java"));
        if (files !=null){
            try {
                parse(files);
                URL[] urls = {folder.toURI().toURL()};
                URLClassLoader classLoader = new URLClassLoader(urls);
                for (File file : files){
                    String className = file.getName().replace(".java", "");
                    Class<?> cls = classLoader.loadClass(className);
                    Method method = cls.getMethod("data");
                    Object object = method.invoke(null);
                    if (object instanceof ChannelData.Data){
                        ChannelData.channels.put(((ChannelData.Data) object).name, (ChannelData.Data) object);
                        ChannelData.Channels.add(((ChannelData.Data) object).name);
                    }

                }
            } catch (IOException | IllegalAccessException| InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void parse(File[] files) throws IOException{
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        List<? extends File> javaFiles = Arrays.asList(files);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(javaFiles);
        compiler.getTask(null, fileManager, null, null, null, compilationUnits).call();
        fileManager.close();
    }
}
