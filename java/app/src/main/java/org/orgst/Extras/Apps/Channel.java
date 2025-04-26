package org.orgst.Extras.Apps;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.orgst.Variables.ChannelData;
public class Channel extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parameters data = getParameters();
        Label label = new Label();
        Button button = new Button("Press me");

        button.setOnAction(e -> {
            label.setText("Button was pressed! 🎉");
        });

        Group root = new Group();
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Update Demo");
        primaryStage.show();
    }

    public static void Start(ChannelData.Data data) {
        launch();
    }
}