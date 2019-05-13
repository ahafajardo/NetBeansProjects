/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class FXMLDocumentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView questionMark;

    @FXML
    private Button rotateButton;
    
    @FXML
    private Button bounceButton;

    @FXML
    void rotateQuestion(ActionEvent event) {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(1000));
        rotateTransition.setNode(questionMark);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(50);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }
    
    @FXML
    void bounceQuestion(ActionEvent event) {
        Path path = new Path();
        MoveTo moveTo = new MoveTo(0, 0);
        CubicCurveTo cubicCurveTo = new CubicCurveTo(25, 25, 0, 150, 25, 150);
        path.getElements().add(moveTo);
        path.getElements().add(cubicCurveTo);
        
        //Creating a path transition 
        PathTransition pathTransition = new PathTransition(); 

        //Setting the duration of the path transition 
        pathTransition.setDuration(Duration.millis(1000)); 

        //Setting the node for the transition 
        pathTransition.setNode(questionMark); 

        //Setting the path 
        pathTransition.setPath(path);  

        //Setting the orientation of the path 
        pathTransition.setOrientation(PathTransition.OrientationType.NONE); 

        //Setting the cycle count for the transition 
        pathTransition.setCycleCount(50); 

        //Setting auto reverse value to false 
        pathTransition.setAutoReverse(true); 

        //Playing the animation 
        pathTransition.play(); 
    }

    @FXML
    void initialize() {

    }
    
    void rotate() {
        
    }
}

