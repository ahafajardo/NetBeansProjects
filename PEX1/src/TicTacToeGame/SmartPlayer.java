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
public class SmartPlayer extends Player {
    SmartPlayer (TicTacToe brd) {
        super(brd, 'N');
    }
    
    SmartPlayer (TicTacToe brd, char chr) {
        super(brd, chr);
    }
    
    /* SmartPlayer's selectPosition() method is the most involved of the classes that inherit from Player.
    First, it checks if there is a winning move. If so, the method ends there, returning the position that
    yields the win. Then, if there is no winning move, the method checks if the opposing player is threatening
    a win, and blocks it. If none of the above is the case, the method checks if the central space is open. If
    so, it is selected. Finally, the method will pick a random, valid position if none of the previous conditions
    are fulfilled.
    */
    @Override
    public int[] selectPosition()
    {
        int[] position = new int[]{3, 3};
        int number;
        int[] playerWinPosition = new int[2];
        SecureRandom rand = new SecureRandom();
        
        playerWinPosition = checkPossibleWin();
        
        if(playerWinPosition[0] != position[0] && playerWinPosition[1] != position[1]) {
            System.out.printf("Smart Computer's move:%n");
            return playerWinPosition;
        }
        
        playerWinPosition = blockPossibleWin();
        
        if(playerWinPosition[0] != position[0] && playerWinPosition[1] != position[1]) {
            System.out.printf("Smart Computer's move:%n");
            return playerWinPosition;
        }
        
        if(checkPosition(1, 1)){
            position[0] = 1;
            position[1] = 1;
            System.out.printf("Smart Computer's move:%n");
            return position;
        }
        
        do  {
            
            number = rand.nextInt(9) + 1;
        
            if(number >= 1 && number <= 9 && playerChar != ' ')
                position = convertPosition(number);
        }
        while (!checkPosition(position[0], position[1]));
        
        System.out.printf("Smart Computer's move:%n");
        
        return position;
    }
    
    int[] checkPossibleWin() {
        TicTacToe testBoard = new TicTacToe();
        /*Here, I had to do some research. My algorithm hinges on being able to make a clone of the 2d array that
        represents the TicTacToe board, so that I can test every possible move that could lead to a win condition,
        without disturbing the original board. I was aware that I could use clone() on an array in order to create 
        a deep copy, but it failed when I attempted clone() on a 2d array. So, I searched for a way to clone
        a 2 dimensional array, and from this source (http://www.java2s.com/Code/Java/Collections-Data-Structure/clonetwodimensionalarray.htm),
        I learned what was wrong with my original approach: clone() makes a deep copy of the exterior array, but the interior 
        arrays were still referring to the original board. So, as a result, the original board was being modified, against my 
        intentions. So, to create a completely separate clone of the original TicTacToe board, I had to first instantiate a
        new 2d array, and then, I cloned each of the original arrays and inserted them into the exterior array of the new board.
        Tao Jin was the author of the original algorithm, and I adapted the code for my purposes here.
        */
        testBoard.setBoard(new char[3][3]);
        for(int i = 0; i < testBoard.getBoard().length; i++) {
            testBoard.getBoard()[i] = ticTac.getBoard()[i].clone();
        }
        Player currentPlayer = new SmartPlayer(testBoard, 'O');
        Player opposingPlayer = new HumanPlayer(testBoard, 'X');
        testBoard.setP1(opposingPlayer);
        testBoard.setP2(currentPlayer);
        boolean possibleWin = false;
        int[] position = new int[2];
        
        //The original board has been cloned correctly, so it is time to test each position on the board for a possible win.
        for(int i = 1; i <= 9; i++){
            position = convertPosition(i);
            testBoard.fillSpace(currentPlayer, position);
            if(currentPlayer.checkWinCondition()){
                possibleWin = true;
                break;
            }
            //To prevent false positives, the cloned board must be cleared of the change that was just made.
            testBoard.getBoard()[position[0]][position[1]] = ticTac.getBoard()[position[0]][position[1]];
        }
        
        if(possibleWin)
            return position;
        //If there is no possible win, return a pair of indices that are out of range of the original 2d array.
        else{
            position = new int[]{3, 3};
            return position;
        }
    }
    
    int[] blockPossibleWin() {
        TicTacToe testBoard = new TicTacToe();
        //same cloning algorithm as before.
        testBoard.setBoard(new char[3][3]);
        for(int i = 0; i < testBoard.getBoard().length; i++) {
            testBoard.getBoard()[i] = ticTac.getBoard()[i].clone();
        }
        Player currentPlayer = new SmartPlayer(testBoard, 'O');
        Player opposingPlayer = new HumanPlayer(testBoard, 'X');
        testBoard.setP1(opposingPlayer);
        testBoard.setP2(currentPlayer);
        boolean possibleWin = false;
        int[] position = new int[2];
        
        //The order and preference that winning plays are checked is determined randomly.
        SecureRandom rand = new SecureRandom();
        int checkCase = rand.nextInt(3);
        
        //The original board has been cloned correctly, so it is time to test each position on the board for a possible win.
        for(int i = 1; i <= 9; i++){
            position = convertPosition(i);
                    
            testBoard.fillSpace(opposingPlayer, position);
            
            switch(checkCase){
                case 0:
                    //check diagonals and rows for a win, but if a win from the rows is threatened, columns won't be checked.
                    if(opposingPlayer.checkDiags()){
                        possibleWin = true;
                    }
                    if(opposingPlayer.checkRows()){
                        possibleWin = true;
                    }
                    else if(opposingPlayer.checkCols()){
                        possibleWin = true;
                    }
                    break;
                case 1:
                    //check columns and rows for a win, but if a win from the rows is threatened, diagonals won't be checked.
                    if(opposingPlayer.checkRows()){
                        possibleWin = true;
                    }
                    if(opposingPlayer.checkCols()){
                        possibleWin = true;
                    }
                    else if(opposingPlayer.checkDiags()){
                        possibleWin = true;
                    }
                    break;
                case 2:
                    //check diagonals and columns for a win, but if a win from the diagonals is threatened, rows won't be checked.
                    if(opposingPlayer.checkCols()){
                        possibleWin = true;
                    }
                    if(opposingPlayer.checkDiags()){
                        possibleWin = true;
                    }
                    else if(opposingPlayer.checkRows()){
                        possibleWin = true;
                    }
                    break;
            }
                    
            //ends the for loop if a possible win is found.
            if(possibleWin) 
                break;
            //To prevent false positives, the cloned board must be cleared of the change that was just made.
            testBoard.getBoard()[position[0]][position[1]] = ticTac.getBoard()[position[0]][position[1]];
        }
        
        if(possibleWin)
            return position;
        //If there is no possible win, return a pair of indices that are out of range of the original 2d array.
        else{
            position = new int[]{3, 3};
            return position;
        }
    }
}
