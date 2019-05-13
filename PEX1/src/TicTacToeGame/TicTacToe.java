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

//PvP is Human vs Human, PvR is Human vs Random Computer, and PvE is Human vs Semi-Smart Computer.
enum GameMode {
    PvP, PvR, PvE
}

public class TicTacToe {
    private char[][] board;
    private Player p1;
    private Player p2;
    
    public TicTacToe() {
        board = new char[][]{{' ',' ',' '},
                             {' ',' ',' '},
                             {' ',' ',' '}};
        
        //' ' represents an empty square on the board.
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }
    
    /*The TicTacToe object initiates the game, and uses the GameMode enumeration and text input to determine the
    composition of the players.
    */
    public void playGame () {
        GameMode mode;
        Scanner input = new Scanner(System.in);
        int selector = 0;
        
        do{
            System.out.printf("Choose a mode, 0 for Player vs Player,%n"
                            + "1 for Player vs Random Computer,%n"
                            + "or 2 for Player vs Semi-Smart Computer:%n");
            selector = input.nextInt();
        } while (selector > 2 || selector < 0);
        
        switch (selector) {
            case 0:
                mode = GameMode.PvP;
                break;
            case 1:
                mode = GameMode.PvR;
                break;
            case 2:
                mode = GameMode.PvE;
                break;
            default:
                mode = GameMode.PvP;
        }
        
        switch (mode) {
            case PvP:
                p1 = new HumanPlayer(this, 'X');
                p2 = new HumanPlayer(this, 'O');
                break;
            case PvR:
                p1 = new HumanPlayer(this, 'X');
                p2 = new RandomPlayer(this, 'O');
                break;
            case PvE:
                p1 = new HumanPlayer(this, 'X');
                p2 = new SmartPlayer(this, 'O');
                break;
        }
        
        /*Turns start at one. If the turn is odd, player 1 makes a move. If the turn is even, player 2 makes a move.
        This continues until the game is over.
        */
        int turns = 1; 
        
        do {
            int[] posPair = new int[2];
            System.out.printf(this.toString());
            
            if(turns % 2 == 0){
                posPair = p2.selectPosition();
                fillSpace(p2, posPair);
            }
            else{
                posPair = p1.selectPosition();
                fillSpace(p1, posPair);
            }
            
            turns++;
        } while (checkGameOver() == false);
        
        //After the game is over, the board prints itself.
        System.out.printf(this.toString());
        
        if(p1.checkWinCondition())
            System.out.printf("Player 1 wins!%n");
        else if(p2.checkWinCondition())
            System.out.printf("Player 2 wins!%n");
        else
            System.out.printf("Tie!%n");
        
        /*After the game is over, the board clears itself. There is no need to clear the players,
        since they will be re-assigned on the next call of playGame().
        */
        setBoard(new char[][]{{' ',' ',' '},
                             {' ',' ',' '},
                             {' ',' ',' '}});
        
    }
    
    /*To display the board in ASCII, I found that it was best to override the currently existing toString() method,
    as I did not want to have two methods that output a string representation of the object.
    */
    @Override public String toString() {
        String output = "";
        
        System.out.printf("Positions:%n");
        
        System.out.printf(" 1|2|3 %n"
                        + "-------%n"
                        + " 4|5|6 %n"
                        + "-------%n"
                        + " 7|8|9 %n");
        
        System.out.printf("Board:%n");
        
        for(int i = 0; i < board.length; i++) {
            output += " ";
            
            for(int j = 0; j < board[i].length; j++) {
                output += board[i][j];
                if(j < board[i].length - 1)
                     output += "|";
            }
            if(i < board[i].length - 1)
                output += "%n-------%n";
        }
        output += "%n";
        return output;
    }
    
    //checks to ensure that space is empty with checkPosition, then fills the space with the player's character.
    public void fillSpace(Player player, int[] posPair) {
        if(checkPosition(posPair[0], posPair[1]) == true) {
            board[posPair[0]][posPair[1]] = player.playerChar;
        }
    }
    
    
    //checks the specified row and column and determines whether the space is empty. If so, it returns true. Otherwise, false.
    public boolean checkPosition (int row, int col) {
        if(row < board.length && col < board.length){
            if(board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }
    
    
    //checks if player 1 or 2 won. If not, then it checks whether the entire board has been filled.
    public boolean checkGameOver() {
        if(p1.checkWinCondition() || p2.checkWinCondition())
            return true;
        
        for(int i = 0; i < board.length; i++) {
            
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ' ')
                    return false;
            }
                
        }
        
        return true;
    }
}
