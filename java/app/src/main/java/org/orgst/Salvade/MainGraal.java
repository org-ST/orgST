package org.orgst.Salvade;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import org.graalvm.polyglot.Source;

public class MainGraal {
    public static void main(String[] args){
        try {
        String resourceName = "/sal.py";

        ClassLoader classLoader = MainGraal.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(resourceName)) {
            if (inputStream == null) {
                System.err.println("Could not find resource: " + resourceName);
                return;
            }
            try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
                try (Context context = Context.newBuilder("python").allowIO(true).build()) {
                    Source source = Source.newBuilder("python", reader, resourceName)
                            .build(); // Specify the language and the resource name

                    Value bindings = context.getBindings("python");
                    Value result = context.eval(source); // Evaluate the Source object

                    // Interact with Python objects as before
                    Value message = bindings.getMember("message_from_jar");
                    if (message != null) {
                        System.out.println("Message from Python resource: " + message.asString());
                    }

                    Value greetFunction = bindings.getMember("greet");
                    if (greetFunction != null) {
                        Value greeting = greetFunction.execute("Java from JAR (Corrected)");
                        System.out.println(greeting.asString());
                    }
                }
            }
        }
    } catch(IOException e){
        e.printStackTrace();
    }
    }
}