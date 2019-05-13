
package Monopoly.Controller;

import Monopoly.Animations.ResizeHeightTranslation;
import Monopoly.GraphicsInterface;
import Monopoly.Human;
import Monopoly.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Jonathan Hopper
 */
public class TitleController implements Initializable{
    
    @FXML private ImageView titleLogo;
    @FXML private Line titleLogoPath;
    @FXML private VBox titleBackground;
    
    @FXML private AnchorPane rootPane;
    @FXML private Button startButton;
    @FXML private Button trueStartButton;
    
    private ArrayList<Player> playerList = new ArrayList<>();
    private ArrayList<Pane> activePlayers = new ArrayList<>();
    private final ArrayList<Image> iconList = new ArrayList();
    
    @FXML private VBox infoContainer;
    
    private final ArrayList<Pane> paneList = new ArrayList();
    @FXML private Pane player1Pane;
    @FXML private Pane player2Pane;
    @FXML private Pane player3Pane;
    @FXML private Pane player4Pane;
    
    @FXML private ChoiceBox playerAmount;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        if(!GraphicsInterface.isSplashScreenLoaded)
            loadSplashScreen();
        else {

            // manually set visibility in fxml file when done
            infoContainer.setVisible(false);
            player1Pane.setVisible(false);
            player2Pane.setVisible(false);
            player3Pane.setVisible(false);
            player4Pane.setVisible(false);
            trueStartButton.setVisible(false);
            //THIS WILL BE REMOVED

            // adding icons to array to sort through
            iconList.addAll(Arrays.asList(
                    new Image("/images/characterIcons/null.png"),
                    new Image("/images/characterIcons/john.jpg"),
                    new Image("/images/characterIcons/gabe.png"), 
                    new Image("/images/characterIcons/kamran.jpg"), 
                    new Image("/images/characterIcons/cody.jpg"), 
                    new Image("/images/characterIcons/john2.jpg"), 
                    new Image("/images/characterIcons/ruben.jpg"),
                    new Image("/images/characterIcons/jacob.jpg"),
                    new Image("/images/characterIcons/nate.jpg"),
                    new Image("/images/characterIcons/allysa.jpg"),
                    new Image("/images/characterIcons/quin.jpg"),
                    new Image("/images/characterIcons/scott.jpg"),
                    new Image("/images/characterIcons/john3.jpg"),
                    new Image("/images/characterIcons/john4.jpg"),
                    new Image("/images/characterIcons/leah.jpg")
            ));

            // playerAmount choiceBox listener
            paneList.addAll(Arrays.asList(player1Pane, player2Pane, player3Pane, player4Pane));
            playerAmount.setItems(FXCollections.observableArrayList(2, 3, 4));
            playerAmount.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue ov, Number value, Number new_value) {
                    paneList.forEach( (tPane) -> {
                        tPane.setVisible(false);
                    });
                    for(int i = 0; i <= (int)new_value + 1; i++)
                        paneList.get(i).setVisible(true);
                }
            });

            // Introduction sign scroll
            // DO NOT EDIT THE INVISIBLE LINE
            PathTransition transition = new PathTransition();
            transition.setNode(titleLogo);
            transition.setDuration(Duration.seconds(5));
            transition.setPath(titleLogoPath);
            transition.setCycleCount(1);
            transition.play();

            // Rectangle pertruding from logo
            transition.setOnFinished( (e) -> {
                titleBackground.setVisible(true);
                ResizeHeightTranslation test = new ResizeHeightTranslation(Duration.seconds(1.5), titleBackground, 300);
                test.play();
            });
        }
    }
    
    private void loadSplashScreen() {
        GraphicsInterface.isSplashScreenLoaded = true;
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(("/JavaFX/Splash.fxml")));
            rootPane.getChildren().setAll(pane);
            
            FadeTransition fadeIn = 
                    new FadeTransition(Duration.seconds(1), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);
            
            FadeTransition fadeOut = 
                    new FadeTransition(Duration.seconds(1), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);
            
            fadeIn.play();
            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });
            
            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane titleScreen = FXMLLoader.load(getClass().getResource(("/JavaFX/Title.fxml")));
                    rootPane.getChildren().setAll(titleScreen);
                } catch (IOException ex) { }
            });
        } catch (IOException ex) { }
        
    }
    
    // changes player icons
    @FXML
    private void handleIconButton(ActionEvent event) {
        Button tempButton = (Button) event.getSource();
        // we can assume the last object is our imageView
        // *making sure the imageView is the last object within the pane*
        ImageView characterIcon = (ImageView) tempButton.getParent().getChildrenUnmodifiable().get(tempButton.getParent().getChildrenUnmodifiable().size() - 1);
        try {
            // if an image is already within the imageView
            int idx = iconList.indexOf(characterIcon.getImage());
            
            if(tempButton.getId().contains("up")) {
                if(idx == iconList.size() - 1)
                    characterIcon.setImage(iconList.get(0));
                else if(idx == -1)
                    characterIcon.setImage(iconList.get(1));
                else
                    characterIcon.setImage(iconList.get(idx + 1));
            }
            else if(tempButton.getId().contains("down")) {
                if(idx == 0)
                    characterIcon.setImage(iconList.get(iconList.size() - 1));
                else
                    characterIcon.setImage(iconList.get(idx - 1));
            }
        } catch (Exception e) {
            // if not, use the first image
            if(tempButton.getId().contains("up"))
                characterIcon.setImage(iconList.get(1));
            else if(tempButton.getId().contains("down"))
                characterIcon.setImage(iconList.get(iconList.size() - 1));
        }
        
        // displays true start button when >=2 players are set
        // also defines playerList
        activePlayers.clear();
        paneList.forEach( (tPane) -> {
            ImageView characterImage = (ImageView) tPane.getChildren().get(tPane.getChildren().size() - 1);
            if(!(characterImage.getImage() == null || characterImage.getImage() == iconList.get(0)))
                activePlayers.add(tPane);
            if(activePlayers.size() < 2)
                trueStartButton.setVisible(false);
            else
                trueStartButton.setVisible(true);
        });
    }
    
    // Method for start button
    @FXML
    private void handleTitleButton(ActionEvent event) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1));
        makeFade(fadeOut, rootPane, 1, 0);
        fadeOut.setOnFinished((e) -> {
            titleLogo.setVisible(false);
            titleBackground.setVisible(false);
            startButton.setVisible(false);
            infoContainer.setVisible(true);
            makeFade(new FadeTransition(Duration.seconds(1)), rootPane, 0, 1);
        });
    }
    
    // goes to main stage
    @FXML
    private void handleMainStartButton(ActionEvent event) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1));
        makeFade(fadeOut, rootPane, 1, 0);
        fadeOut.setOnFinished((e) -> {
            loadMainStage();
        });
    }
    
    // fading function
    private void makeFade(FadeTransition fade, Node node, int fromValue, int toValue) {
        fade.setNode(node);
        fade.setFromValue(fromValue);
        fade.setToValue(toValue);
        fade.play();
    }
    
    // opens the main game stage
    private void loadMainStage() {
        try {
            activePlayers.forEach( (tPane) -> {
                ImageView characterImage = (ImageView) tPane.getChildren().get(tPane.getChildren().size() - 1);
                playerList.add(new Human(characterImage.getImage(), Integer.parseInt(tPane.getId().charAt(6) + "")));
            });

            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/JavaFX/Main.fxml")
            );
            loader.setController(new MainController(playerList));
            Parent mainStage = loader.load();
            
            Scene mainScene = new Scene(mainStage);
            Stage currentStage = (Stage) rootPane.getScene().getWindow();
            currentStage.setScene(mainScene);
            
            
            
        } catch (IOException ex) { }
    }
    
}
