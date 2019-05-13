/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author adfaj
 */
public class Flag extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        
        Scene scene = new Scene(root, 400, 200);
        scene.setFill(Color.WHITE);
        
        Stop[] stopsLeft = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.RED)};
        LinearGradient gradient1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stopsLeft);
        
        Rectangle rect1 = new Rectangle(0, 0, 100, 200);
        rect1.setFill(gradient1);
        
        final ImageView selectedImage = new ImageView();   
        Image image1 = new Image(Flag.class.getResourceAsStream("question.png"));
        selectedImage.setImage(image1);
        selectedImage.setLayoutX(100);
        
        Stop[] stopsRight = new Stop[] { new Stop(0, Color.GREEN), new Stop(1, Color.WHITE)};
        LinearGradient gradient2 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stopsRight);
        
        Rectangle rect2 = new Rectangle(300, 0, 100, 200);
        rect2.setFill(gradient2);
        
        root.getChildren().add(rect1);
        root.getChildren().add(selectedImage);
        root.getChildren().add(rect2);
        
        primaryStage.setTitle("Cool Flag");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
