
package Monopoly.Controller;

import Monopoly.Board;
import Monopoly.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


/**
 * @author Jonathan Hopper
 */
public class PlayerController implements Initializable{

    @FXML private Label playerName;
    @FXML private Label playerBalance;
    @FXML private HBox playerProperties;
    
    private final Player player;

    public PlayerController(Player p) {
        player = p;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerName.setText("Player " + player.getID());
        playerBalance.setText("$" + player.getBalance());
        player.ownedTiles.forEach( (tile) -> {
            playerProperties.getChildren().add(
                    new ImageView(
                            new Image("/images/Property/" + 
                                    Board.tileList.indexOf(tile) + ".png", 
                                    81.0, 126.0, true, true)
                    )
            );
        });
    }
}
