/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeGame;

import java.util.Scanner;

/**
 *
 * @author adfaj
 */

public class GameTest {
    public static void main(String[] args){
        TicTacToe game = new TicTacToe();
        String answer = "";
        Scanner input = new Scanner(System.in);
        boolean playingGame = true;
        
        //Master game loop.
        do {
            game.playGame();
            
            System.out.printf("Play Again? Y/N?%n");
            do {
                answer = input.next();
            } while(!"Y".equals(answer) && !"N".equals(answer));
            
            if("N".equals(answer))
                playingGame = false;
        } while(playingGame);
        
        System.out.printf("Bye!%n");
    }
}
