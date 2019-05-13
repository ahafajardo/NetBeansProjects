/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToeGame;

/**
 *
 * @author adfaj
 */
public abstract class Player {
    //All classes that inherit from Player must have access to the board and to the character they write on the board.
    protected char playerChar;
    protected TicTacToe ticTac;
    
    //Default character is 'N', as in, there is no character set.
    Player (TicTacToe tt) {
        playerChar = 'N';
        ticTac = tt;
    }
    
    Player (TicTacToe tt, char chr) {
        playerChar = chr;
        ticTac = tt;
    }
    
    //Every implementation of Player must implement selectPosition(). Otherwise, they would not be able to progress the game.
    abstract public int[] selectPosition();

    public char getPlayerChar() {
        return playerChar;
    }
    
    //converts digits 1 through 9 into a pair of indices that represent a position on the TicTacToe board.
    public int[] convertPosition(int in) {
        
        int[] result = new int[2];
        
        if(in < 4){
            result[0] = 0;
            result[1] = in - 1;
        }
        else if(in < 7){
            result[0] = 1;
            result[1] = in - 4;
        }
        else{
            result[0] = 2;
            result[1] = in - 7;
        }
        
        return result;
    }
    
    //Uses checkPosition() from TicTacToe, so that ticTac object does not need to be called constantly.
    public boolean checkPosition (int row, int col) {
        boolean moveValidator = false;
        
        moveValidator = ticTac.checkPosition(row, col);
        
        return moveValidator;
    }
    
    //Checks rows, columns, and diagonals for three of the player's character in a row.
    public boolean checkWinCondition() {
        if(checkRows() || checkCols() || checkDiags())
            return true;
        else
            return false;
    }
    
    /*Check the rows of the board, which is a 2d array. This algorithm was the simplest to create:
    just check each sub array for a character other than than the player's character, and if there
    are no differing characters in the sub array, then there are three X's or O's in a row. Therefore,
    a player has won.
    */
    public boolean checkRows () {
        boolean playerWin = false;
        boolean winningRow = false;
        
        char[][] board = ticTac.getBoard();
        
        if(playerChar == ' ')
            return false;
        
        for(int i = 0; i < board.length; i++) {
            
            for(int j = 0; j < board[i].length; j++) {
                winningRow = true;
                if(board[i][j] != playerChar){
                    winningRow = false;
                    break;
                }
            }
            if (winningRow == true) {
                playerWin = true;
                break;
            }
                
        }
        
        return playerWin;
    }
    
    /*Check the columns of the board, which is a 2d array. This algorithm is less obvious than checking
    rows, but it isn't too bad: instead of checking each sub array in a nested for loop, I check the jth
    sub array and the ith element of that sub array. i increments every time that j completes 3 iterations,
    so it checks that three elements with the same index, but differing sub arrays, share the same character.
    If so, a column has been filled on the board, and a player has won.
    */
    public boolean checkCols () {
        boolean playerWin = false;
        boolean winningCol = false;
        
        char[][] board = ticTac.getBoard();
        
        if(playerChar == ' ')
            return false;
        
        for(int i = 0; i < board.length; i++) {
            
            for(int j = 0; j < board[i].length; j++) {
                winningCol = true;
                if(board[j][i] != playerChar){
                    winningCol = false;
                    break;
                }
            }
            if (winningCol == true) {
                playerWin = true;
                break;
            }
                
        }
        
        return playerWin;
    }
    
    /*Check the diagonals of the board, which is a 2d array. This algorithm is the most involved of the three: 
    First, I check the 2d array from the top left to the bottom right, and in order to do so, I iterate through
    the 2d array using the same index for both the exterior array and the subarray within it. So, when I am checking
    the first element, I use the indices 0 and 0, then, 1 and 1, and so on. If that diagonal does not yield a winning 
    combination, I move on to the last remaining diagonal: from the top right to the bottom left. To check this diagonal,
    the first index still iterates from 0 to the length of the array - 1, but the last index counts down from the length
    of the array to 0. 0 and 2, 1 and 1, and finally, 2 and 0. If there is a winning combination on that diagonal, then
    a player has won.
    */
    public boolean checkDiags () {
        boolean playerWin = false;
        boolean winningDiag = false;
        
        char[][] board = ticTac.getBoard();
        
        if(playerChar == ' ')
            return false;
        
            
        for(int i = 0; i < board.length; i++) {
            winningDiag = true;
            if(board[i][i] != playerChar){
                winningDiag = false;
                break;
            }
        }
        if(winningDiag == false)
            for(int i = 0; i < board.length; i++) {
                winningDiag = true;
                if(board[i][board.length - 1 - i] != playerChar){
                    winningDiag = false;
                    break;
            }
                
        }
        if (winningDiag == true) {
            playerWin = winningDiag;
        }

        return playerWin;
    }
}
