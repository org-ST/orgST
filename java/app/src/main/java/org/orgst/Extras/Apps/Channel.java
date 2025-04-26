package org.orgst.Extras.Apps;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.orgst.Variables.ChannelData;
public class Channel extends Application {
    static ChannelData.Data data;
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        Button name = new Button("Name");
        Button site = new Button("WebSite");
        Button date = new Button("Date");
        Button comm = new Button("Comment");
        name.setOnAction(e -> {
            label.setText(data.name);
        });
        site.setOnAction(e -> {
            label.setText(data.website);
        });
        date.setOnAction(e -> {
            label.setText(data.date);
        });
        comm.setOnAction(e -> {
            label.setText(data.comment);
        });
        Group root = new Group();
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Update Demo");
        primaryStage.show();
    }

    public static void Start(ChannelData.Data dataarg) {
        data = dataarg;
        launch();
    }
}