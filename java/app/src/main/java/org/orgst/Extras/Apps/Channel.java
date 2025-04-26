package org.orgst.Extras.Apps;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.orgst.Variables.ChannelData;
import java.util.List;
import java.util.Arrays;
public class Channel {
    public static void Start(ChannelData.Data data) {
        Stage stage = new Stage(); // create a NEW stage
        Label label = new Label();
        Button name = new Button("Name");
        Button site = new Button("WebSite");
        Button date = new Button("Date");
        Button comm = new Button("Comment");
        
        name.setOnAction(e -> label.setText(data.name));
        site.setOnAction(e -> label.setText(data.website));
        date.setOnAction(e -> label.setText(data.date));
        comm.setOnAction(e -> label.setText(data.comment));
        
        Group root = new Group(label, name, site, date, comm);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle(data.name);
        stage.show();
    }
}