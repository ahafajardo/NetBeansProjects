/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netcapfx;

import java.io.IOException;
import java.net.ServerSocket;


/**
 *
 * @author adfaj
 */
public class NetCapServer {
    public static void main(String[] args) throws IOException {
        System.out.println("The capitalization server is running.");
        int clientNumber = 0;
        ServerSocket listener = new ServerSocket(1997);
        try {
            while(true){
                new Capitalizer(listener.accept(), clientNumber++).run();
            }
        }
        finally {
            listener.close();
        }
    }
}
