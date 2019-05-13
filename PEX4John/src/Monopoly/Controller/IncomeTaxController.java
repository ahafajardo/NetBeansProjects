
package Monopoly.Controller;

import Monopoly.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonathan Hopper
 */
public class IncomeTaxController implements Initializable {

    private final Player player;
    
    public IncomeTaxController(Player p) {
        player = p;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void handle10PercentButton(ActionEvent event) {
        Stage stageWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
        player.setBalance(player.getBalance() - (player.getBalance() * 0.1));
        stageWindow.close();
    }
    
    @FXML
    public void handle200DollarsButton(ActionEvent event) {
        Stage stageWindow = (Stage) ((Button) event.getSource()).getScene().getWindow();
        player.setBalance(player.getBalance() - 200);
        stageWindow.close();
    }
}
