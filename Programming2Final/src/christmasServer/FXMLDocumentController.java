/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package christmasServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author adfaj
 */
public class FXMLDocumentController implements Initializable {
    private BufferedReader in;
    private BufferedWriter out;
    private String serverName = "cop3330.hpc.lab";
    private int serverPort = 2016;
    private Socket socket;
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        connectToServer();
        getStreams();
    }
    
    public void connectToServer() {
        System.out.println();
        try {
            socket = new Socket(serverName, serverPort);
        } catch (IOException e) {
            System.out.println("Can't connect.");
        }
        System.out.println("Connection success!");
    }
    
     public void getStreams() {
        System.out.println("Streaming started.");
        try {
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            out.write("color\n");
            out.flush();
            System.out.println(in.readLine());
            socket.close();
        }
        catch (IOException e) {
            System.out.println("Can't get streams.");
        }
        System.out.println("Streaming success!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
