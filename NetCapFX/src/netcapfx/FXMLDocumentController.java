/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcapfx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author adfaj
 */
public class FXMLDocumentController implements Initializable {
    
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private Boolean christmas = false;
    private String localhost = "127.0.0.1";
    private int localPort = 1997;
    private String serverName = "cop3330.hpc.lab";
    private int serverPort = 2016;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    @FXML
    private Label label;
    
    @FXML
    private TextArea message;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void connectToServer() {
        System.out.println();
        try {
            if(!christmas)
                socket = new Socket(localhost, localPort);
            else
                socket = new Socket();
        } catch (IOException e) {
            System.out.println("Can't connect.");
        }
        System.out.println("Connection success!");
    }
    
    public void getStreams() {
        System.out.println("Streaming started.");
        try {
            if(!christmas) {
                 in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                 out = new PrintWriter(socket.getOutputStream(), true);
            }
            else {
                output = new ObjectOutputStream(socket.getOutputStream());
                output.flush();
            }
        }
        catch (IOException e) {
            System.out.println("Can't get streams.");
        }
        System.out.println("Streaming success!");
    }
    
    public void processLocalConnection() {
        System.out.println("Processing...");
        try {
            for (int i = 0; i < 2; i++){
                System.out.println("Appending text");
                message.appendText(in.readLine() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error in processing local connection");
        }
        System.out.println("Processing success!");
    }
    
    public void processXmasConnection() {
        String serverMessage = "";
        System.out.println();
        
        try {
            serverMessage = (String) input.readObject();
            message.appendText((String) serverMessage + "");
        } catch (Exception e) {
        }
    }
    
    public void localConnect(ActionEvent event) {
        connectToServer();
        System.out.println("Done connecting.");
        getStreams();
        processLocalConnection();
    }
    
    private void sendData(String message) {
        try {
            output.writeObject(out);
        } catch (Exception e) {
        }
    }
    
}
