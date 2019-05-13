/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeGame;

import java.security.SecureRandom;

/**
 *
 * @author adfaj
 */
public class RandomPlayer extends Player {
    RandomPlayer (TicTacToe brd) {
        super(brd, 'N');
    }
    
    RandomPlayer (TicTacToe brd, char chr) {
        super(brd, chr);
    }
    
    /*Has very similar logic compared to HumanPlayer's selectPosition() method, the difference 
    being that the integer being selected randomly, rather than being collected from the Scanner.
    */
    @Override
    public int[] selectPosition()
    {
        int[] position = new int[]{ticTac.getBoard().length, ticTac.getBoard().length};
        int number;
        SecureRandom rand = new SecureRandom();
        
        do  {
            
            number = rand.nextInt(9) + 1;
        
            if(number >= 1 && number <= 9 && playerChar != ' ')
                position = convertPosition(number);
        }
        while (!checkPosition(position[0], position[1]));
        
        System.out.printf("Random Computer's move:%n");
        
        return position;
    }
}
