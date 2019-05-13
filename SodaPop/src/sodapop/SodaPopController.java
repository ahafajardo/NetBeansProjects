package sodapop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SodaPopController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button coke;

    @FXML
    private Button pepsi;
    
    @FXML
    private Pane sodaPane;

    @FXML
    void initialize() {
        assert coke != null : "fx:id=\"coke\" was not injected: check your FXML file 'SodaPop.fxml'.";
        assert pepsi != null : "fx:id=\"pepsi\" was not injected: check your FXML file 'SodaPop.fxml'.";

    }
    
    @FXML
    void voteCoke(ActionEvent event) {
        launchWinner();
    }

    @FXML
    void votePepsi(ActionEvent event) {
        launchWinner();
    }
    
    public void launchWinner(){
        Parent root = null;
        FXMLLoader root1 = null;
        root1 = new FXMLLoader(getClass().getResource("Winner.fxml"));
        try {
            root = (Parent)root1.load();
        } catch (IOException e) {
        }
        
        WinnerController controller = root1.<WinnerController>getController();
        
        Scene sc = new Scene(root);
        Stage st = new Stage();
        
        st.setScene(sc);
        st.show();
        st.setAlwaysOnTop(true);
    }
}
