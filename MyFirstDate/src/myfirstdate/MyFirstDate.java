/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstdate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author adfaj
 */
public class MyFirstDate extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome to Florida Poly");
        
        
        Label lbl1 = new Label();
        lbl1.setText("Welcome to Florida Poly!");
        
        TextField usefld = new TextField();
        
        StackPane root = new StackPane();
        root.getChildren().add(lbl1);
        root.getChildren().add(usefld);
        
        Scene scene = new Scene(root, 300, 250);
        
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
