
package Monopoly.Controller;

import Monopoly.Game;
import Monopoly.Player;
import Monopoly.Tile.Property;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Jonathan Hopper
 */
public class MainController implements Initializable{
    
    private final ArrayList<Player> playerList;
    private Game monoPoly;
    
    @FXML private Button diceButton;
    @FXML private VBox playerBox;
    @FXML private Pane propertyPane;
    @FXML private Pane dicePane;
    @FXML private GridPane mainPane;

    public MainController(ArrayList<Player> players) {
        playerList = players;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        monoPoly = new Game(playerList, mainPane, propertyPane, dicePane);
        playerList.forEach( (tPlayer) -> {
            HBox uniquePlayerBox = 
                    (HBox) playerBox.getChildren().get(tPlayer.getID() - 1);
            ImageView uniquePlayerImage = 
                    (ImageView) uniquePlayerBox.getChildren().get(1);
            tPlayer.setBalanceLabel( (Label) uniquePlayerBox.getChildren().get(3));
            uniquePlayerBox.setVisible(true);
            uniquePlayerImage.setImage(tPlayer.getIcon());
        });
    }

    @FXML
    private void handleRollDiceButton() {
        monoPoly.rollDice();
        diceButton.setDisable(true);
    }
    
    @FXML
    private void handleNextTurnButton() {
        monoPoly.nextPlayer();
        diceButton.setDisable(false);
    }
    
    @FXML
    private void handlePurchaseButton() {
        Property propertyTile = 
                (Property) monoPoly.getCurrentPlayer().getTile();
        propertyTile.Purchase(monoPoly.getCurrentPlayer());
        propertyPane.setVisible(false);
    }
    
    @FXML
    private void handleCancelButton() {
        propertyPane.setVisible(true);
    }
    
    @FXML
    private void handlePlayerClick(MouseEvent event) {
        PlayerController playerView = null;
        Label playerLabel = (Label) event.getSource();
        int playerID = Integer.parseInt(
                playerLabel.getText().charAt(playerLabel.getText().length() - 2) + ""
        );
        for(int i = 0; i < playerList.size(); i++) {
            if(playerID == playerList.get(i).getID())
                playerView = new PlayerController(playerList.get(i));
        }
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/JavaFX/Player.fxml")
            );
            
            fxmlLoader.setController(playerView);
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Player " + playerID);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
}
