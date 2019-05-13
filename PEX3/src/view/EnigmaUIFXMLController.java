/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import enigma.EnigmaMachine;
import enigma.CipherWheel;
import enigma.SubstitutionCipher;
import java.io.BufferedWriter;
import java.nio.charset.Charset;

public class EnigmaUIFXMLController {
    String fileName;
    private List<String> lines;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Integer> outerStartChoiceBox;
    
    ObservableList<Integer> outerStartOptions = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                                                                                15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28);

    @FXML
    private ChoiceBox<Integer> innerStartChoiceBox;
    
    ObservableList<Integer> innerStartOptions = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                                                                                15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28);

    @FXML
    private TextArea reflectorText;

    @FXML
    private ChoiceBox<Integer> midStartChoiceBox;
    
    ObservableList<Integer> midStartOptions = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                                                                                15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28);

    @FXML
    private ChoiceBox<String> innerWheelChoiceBox;
    
    ObservableList<String> innerCipher = FXCollections.observableArrayList("Cipher I","Cipher II", "Cipher III", "Cipher IV", "Cipher V");

    @FXML
    private ChoiceBox<String> outerWheelChoiceBox;
    
    ObservableList<String> outerCipher = FXCollections.observableArrayList("Cipher I","Cipher II", "Cipher III", "Cipher IV", "Cipher V");

    @FXML
    private TextArea inputText;

    @FXML
    private Label label;

    @FXML
    private Button codeButton;
    
    @FXML
    private Button openButton;
    
    @FXML
    void handleCodeButtonAction(ActionEvent event) {
        System.out.printf("Your %s pizza is ready!%n", outerWheelChoiceBox.getValue());
        
        CipherWheel cipher = new CipherWheel(innerCipher.indexOf(innerWheelChoiceBox.getValue()) + 1,
                                            midCipher.indexOf(midWheelChoiceBox.getValue()) + 1,
                                            outerCipher.indexOf(outerWheelChoiceBox.getValue()) + 1,
                                            innerStartChoiceBox.getValue() - 1,
                                            midStartChoiceBox.getValue() - 1,
                                            outerStartChoiceBox.getValue() - 1);
        SubstitutionCipher plug = new SubstitutionCipher(plugBoardText.getText());
        SubstitutionCipher reflect = new SubstitutionCipher(reflectorText.getText());
        
        EnigmaMachine enigma = new EnigmaMachine(cipher, plug, reflect, lines);
        
        String content = "";
                
        for(String line : enigma.code()) {
            content += line + "\n";
        }

        outputText.setText(content);
        
        Charset chars = Charset.forName("US-ASCII");
        fileName = "Coded" + fileName;
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), chars)) {
            writer.write(content);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    
    @FXML
    void handleOpenButtonAction(ActionEvent event) {
        lines = new ArrayList<>();
        
        FileChooser fc = new FileChooser();
        fc.setTitle("View Files");
        fc.getExtensionFilters().addAll( new ExtensionFilter("Text Files","*.txt"),  new ExtensionFilter("All Files","*.*"));
        fc.setInitialDirectory( new File(System.getProperty("user.home")));
        File file = fc.showOpenDialog(openButton.getScene().getWindow());
        
        if (file != null) { 
            
            try (Stream<String> fileLines = Files.lines(file.toPath())) {
                fileName = file.getName();
                lines = fileLines.collect(Collectors.toList());
                String content = "";
                
                for(String line : lines) {
                    content += line + "\n";
                }
                
                inputText.setText(content);
            }
            catch (IOException ex){
                Logger.getLogger(EnigmaUIFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @FXML
    private TextArea outputText;

    @FXML
    private TextArea plugBoardText;

    @FXML
    private ChoiceBox<String> midWheelChoiceBox;
    
    ObservableList<String> midCipher = FXCollections.observableArrayList("Cipher I","Cipher II", "Cipher III", "Cipher IV", "Cipher V");

    @FXML
    void initialize() {
        outerWheelChoiceBox.setItems(outerCipher);
        outerWheelChoiceBox.setValue("Cipher III");
        midWheelChoiceBox.setItems(midCipher);
        midWheelChoiceBox.setValue("Cipher II");
        innerWheelChoiceBox.setItems(innerCipher);
        innerWheelChoiceBox.setValue("Cipher I");
        
        outerStartChoiceBox.setItems(outerStartOptions);
        outerStartChoiceBox.setValue(1);
        midStartChoiceBox.setItems(midStartOptions);
        midStartChoiceBox.setValue(1);
        innerStartChoiceBox.setItems(innerStartOptions);
        innerStartChoiceBox.setValue(1);
    }
}
