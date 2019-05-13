/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzamaker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author adfaj
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<String> ingredients = FXCollections.observableArrayList("Extra Cheese","Pepperoni", "Mushrooms");
    
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    void handleButtonAction(ActionEvent event) {
        System.out.printf("Your %s pizza is ready!%n", choiceBox.getValue());
    }
    
    @FXML
    private ChoiceBox<String> choiceBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBox.setItems(ingredients);
        choiceBox.setValue("Extra Cheese");
    }    
    
}
