package org.orgst.Extras.Apps;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.orgst.Variables.ChannelData;
import java.util.List;
import java.util.Arrays;
// Add people - info - check
public class Channel {
    public static void Start(ChannelData.Data data) {
        Stage stage = new Stage(); // create a NEW stage
        Label label = new Label();
        label.setTranslateY(80);
        label.setTranslateX(125);
        Button name = new Button("Name");
        Button site = new Button("WebSite");
        Button date = new Button("Date");
        Button comm = new Button("Comment");
        Button peple = new Button("People");
        Button info = new Button("Info");
        Button check = new Button("Check");
        List<Button> buttons = Arrays.asList(name, site, date, comm, peple, info, check);
        info.setOnAction(e -> {
            label.setText(data.info);
        });
        check.setOnAction(e -> {
            if (data.files != null){
                label.setText("Please check your terminal...");
                for (Runnable file : data.files){
                    file.run();
                }
            } else {
                label.setText("No files available");
            }
        });
        peple.setOnAction(e -> {
            StringBuilder peopleStringBuilder = new StringBuilder();
            for (String st : data.people){
                peopleStringBuilder.append(st + ", ");
            }
            label.setText(peopleStringBuilder.toString());
        });
        name.setOnAction(e -> label.setText(data.name));
        site.setOnAction(e -> {
                    if (data.website !=null){
                        label.setText("Opening..."); org.orgst.Extras.WebOpener.open(data.website);
                    } else {
                        label.setText("There is no website :(");
                    }

                }
            );
        date.setOnAction(e -> label.setText(data.date));
        comm.setOnAction(e -> label.setText(data.comment));
        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            button.setLayoutX(20);
            button.setLayoutY(20 + (i * 40));
        }
        Group root = new Group(label, name, site, date, comm, peple, info, check);
        Scene scene = new Scene(root, 500, 200);
        stage.setOnCloseRequest(e -> {
            Platform.exit();
        });
        stage.setScene(scene);
        stage.setTitle(data.name);
        stage.show();
    }
}