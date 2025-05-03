package org.orgst.Extras;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Platform;
public class Flag extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load the image from the resources folder
        Image image = new Image(getClass().getResourceAsStream("/flag.png"));

        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);

        // Add the ImageView to the layout (StackPane in this case)
        StackPane root = new StackPane();
        root.getChildren().add(imageView);

        // Create the scene and add it to the stage
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Pride Flag");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest( event -> {
        		Platform.exit();
        		org.orgst.App.main(new String[0]);
        	}
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}