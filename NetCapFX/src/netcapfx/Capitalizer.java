/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcapfx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author adfaj
 */
public class Capitalizer implements Runnable {
    private Socket socket;
    private int clientNumber;

    public Capitalizer(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            out.println("Hello, you are client #" + clientNumber + ".");
            out.println("Enter a single period to quit");
            
            while(in.readLine() != "."){
                String input = in.readLine();
                if (input.equals("") || input.equals(".")){
                    out.println("No input.");
                    break;
                }
                out.println(input.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("Ach!");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Could not close socket.");
            }
            
            System.out.println("Connnection with client# " + clientNumber + " closed.");
        }
        
    }
    
    
}
