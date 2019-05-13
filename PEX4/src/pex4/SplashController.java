/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adfaj
 */
public class SplashController implements Initializable {

     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button carButton;
    
    private boolean isCar;

    @FXML
    private Button dogButton;
    
    @FXML
    private Pane splashPane;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        assert carButton != null : "fx:id=\"carButton\" was not injected: check your FXML file 'Splash.fxml'.";
        assert dogButton != null : "fx:id=\"dogButton\" was not injected: check your FXML file 'Splash.fxml'.";
        
    }
    
    @FXML
    void pickCar(ActionEvent event) {
        isCar = true;
        launchGame();
        
    }

    @FXML
    void pickDog(ActionEvent event) {
        isCar = false;
        launchGame();
        
    }
    
    public void launchGame(){
        Parent root = null;
        FXMLLoader root1 = null;
        root1 = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        try {
            root = (Parent)root1.load();
        } catch (IOException e) {
        }
        
        FXMLDocumentController controller = root1.<FXMLDocumentController>getController();
        
        Image carIcon = new Image("res/monopolySpritesCarFinal.png", 75, 45, false, false);
        Image dogIcon = new Image("res/monopolySpritesDogFinal.png", 62, 45, false, false);
        
        if(isCar) {
            controller.players = FXCollections.observableArrayList(new Human(new Avatar(carIcon, "Car")), new Human(new Avatar(dogIcon, "Dog")));
        }
        else {
            controller.players = FXCollections.observableArrayList(new Human(new Avatar(dogIcon, "Dog")), new Human(new Avatar(carIcon, "Car")));
        }
        
        Scene sc = new Scene(root);
        Stage st = new Stage();
        
        st.setScene(sc);
        st.show();
    }
}
