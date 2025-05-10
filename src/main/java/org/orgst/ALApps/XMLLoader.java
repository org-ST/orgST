package org.orgst.ALApps;
import org.w3c.dom.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class XMLLoader {
    public interface XMLApp {
        void start();
    }
    public static void loadXML(String path) throws Exception {
        File inputFile = new File("mk.xml");  // Your XML filename here
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        URL schemaLocation = new URI("https://raw.githubusercontent.com/Wdboyes13/BetterMake/refs/heads/main/BMF.xsd").toURL();
        Schema schema = factory.newSchema(schemaLocation);

        // Create validator
        Validator validator = schema.newValidator();

        // Validate the XML file
        validator.validate(new StreamSource(inputFile));

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

    }
}
