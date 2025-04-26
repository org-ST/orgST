package org.orgst.Extras;
import org.orgst.Variables.ChannelData;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.control.Button;
public class ChannelMenu extends Application {
    Button[] ChannelButtons;
    public void start(Stage primStage){
        for (int i = 0; i < ChannelData.Channels.length; i++){
            ChannelButtons[i] = new Button(ChannelData.Channels[i]);
        }
    }
}
