
package Monopoly;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * @author Jonathan Hopper
 */
public class GraphicsInterface extends Application {
    
    public static Boolean isSplashScreenLoaded = false;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/JavaFX/Title.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Mono-POLY!");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}