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
public class HumanPlayer extends Player {
    
    HumanPlayer (TicTacToe brd) {
        super(brd, 'N');
    }
    
    HumanPlayer (TicTacToe brd, char chr) {
        super(brd, chr);
    }
    
    /*Uses the Scanner to read integer input from 1 to 9, and returns a pair of indices that 
    represent the row and column that was selected by the player.
    */
    @Override
    public int[] selectPosition()
    {
        int[] position = new int[]{ticTac.getBoard().length, ticTac.getBoard().length};
        int number;
        
        Scanner input = new Scanner(System.in);
        
        //If an invalid integer is used to select the row and column, the input prompt is repeated.
        do  {
            System.out.printf("Enter a position from 1 to 9:%n");
            number = input.nextInt();
        
            if(number >= 1 && number <= 9 && playerChar != ' ')
                position = convertPosition(number);
        }
        while (!checkPosition(position[0], position[1]));
        
        return position;
    }
}
