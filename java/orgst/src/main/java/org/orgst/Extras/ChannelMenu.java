package org.orgst.Extras;
import org.orgst.Variables.ChannelData;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
public class ChannelMenu extends Application {
    public static void main(String[] args) {
        System.out.println("Launching");
        launch(args);
    }
    public void start(Stage primStage){
        Button[] buttons = new Button[ChannelData.Channels.length];
        GridPane root = new GridPane();
        root.setVgap(10);
        root.setHgap(10);
        for (int i = 0; i < ChannelData.Channels.length; i++){
            buttons[i] = new Button(ChannelData.Channels[i]);
            final int index = i;
            buttons[i].setOnAction(e -> {org.orgst.Extras.Apps.Channel.Start(ChannelData.channels.get(ChannelData.Channels[index]));});
            root.add(buttons[i] , 0, i);
        }
        primStage.setOnCloseRequest(e -> {
        	primStage.close();
            Platform.exit();
            org.orgst.App.main(new String[0]);
        });
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);
        primStage.setScene(scene);
        primStage.show();
    }
}
