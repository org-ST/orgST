package org.orgst.Extras;
import org.orgst.Variables.ChannelData;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
public class ChannelMenu extends Application {
    Button[] buttons;
    int btnY = 20;
    int btnX = 20;
    public void start(Stage primStage){
        Group root = new Group();
        for (int i = 0; i < ChannelData.Channels.length; i++){
            buttons[i] = new Button(ChannelData.Channels[i]);
        }
                for (int i = 0; i < buttons.length; i++){
            final int index = i;
            buttons[i].setOnAction(e -> {});
            buttons[i].setTranslateX(btnX);
            buttons[i].setTranslateY(btnY);
            root.getChildren().add(buttons[i]);
            btnY += 40;
        }
    }
}
