
package Monopoly.Controller;

import Monopoly.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @author Jonathan Hopper
 */
public class CardController implements Initializable {

    @FXML private ImageView cardImage;
    
    private final Player player;
    private final int cardIndex;
    
    public CardController(Player p, int cardNumber) {
        player = p;
        cardIndex = cardNumber;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void handleOKButton(ActionEvent event) {
        Stage stageWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stageWindow.close();
    }
}
