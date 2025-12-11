/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viva2_q4;

/**
 *
 * @author tehjiajie
 * Question 4: Tic-Tac-Toe Winner Checker
 * Write a Java program that determines whether there is a winner in a completed 3 × 3 
    Tic-Tac-Toe board. 
    The program reads three input lines, each containing exactly three characters. 
    *  "Winner: X" or "Winner: O" if a player has won, 
    *  "No winner" if the game has no winning line. 
 */
import java.util.*;
public class Viva2_q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        //declare an 2D array to store the value of tic tac toe entered by user 
        char[][] board = new char[3][3];
        
        //prompt user to input each row, split it and store in array
        for(int i=0; i<3; i++){
            System.out.print("Enter row "+ (i+1) + ": ");
            String line = sc.nextLine();
            for(int j=0; j<3; j++){
                board[i][j] = line.charAt(j);
            }
        }
        
        //call method checkWinner() to determine the winner is 'X' or 'Y' or '.'(No winner)
        char winner = checkWinner(board);
        
        //check the tic tac toe entered byb user is valid or not
        //Because 'X' move first, therefore step 'X' must be greater or equal than step 'O'.
        boolean validation = countMoves(board,'X')>=countMoves(board,'O');
        
        //if not valid: print invalid messages, else: print the winner.
        if(!validation)
            System.out.println("\nInvalid board: number of moves is not valid. ");
        else
            if(winner=='.')
                System.out.println("No winner");
            else
                System.out.println("Winner: "+ winner);
        
        sc.close();
    }
    
    /* 
    char checkWinner(char[][] board)
    Returns 'X' if player X has won,'O' if player O has won, or '.' if there is no winner. 
    A win occurs when the same symbol appears in any complete row, column, or one of the two diagonals. 
    */
    public static char checkWinner(char[][] board)  {
        int count_X = 0, count_O = 0;
        //check for each row, if got 3 repeating symbol in one row, it is the winner.
        for(int i=0; i<3; i++){
            count_X = 0;
            count_O = 0;
            
            //First loop check index:00 01 02   
            //2nd: 10 11 12   
            //3rd: 20 21 22
            for(int j =0; j<3; j++){
                if(board[i][j]=='X')
                    count_X++;
                else if(board[i][j]=='O')
                    count_O++;
            }
            
            //if got 3 repeating symbol in one row, it is the winner.
            if(count_X == 3)
                return 'X';
            else if(count_O ==3)
                return 'O';
        }
        
        //check for each column,if got 3 repeating symbol in one column, it is the winner.
        for(int i=0; i<3; i++){
            count_X = 0;
            count_O = 0;
            
            /*First check index:
                00
                10
                20
              Follow by 2nd and 3rd column
            */
            for(int j =0; j<3; j++){
                if(board[j][i]=='X')
                    count_X++;
                else if(board[j][i]=='O')
                    count_O++;
            }
            
            //if got 3 repeating symbol in one column, it is the winner.
            if(count_X == 3)
                return 'X';
            else if(count_O ==3)
                return 'O';
        }
        
        //check for two diagonal, if got 3 repeating symbol in one diagonal, it is the winner.
        //if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')
        //    return 'X';
        //else if(board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X')
        //    return 'X';
        
        /*check for:
           00
              11
                 22
        */
        count_X = 0;
        count_O = 0;
        for(int i=0; i<3; i++){
            if(board[i][i]=='X')
                count_X++;
            else if(board[i][i]=='O')
                count_O++;
            }
        if(count_X == 3)
                return 'X';
        else if(count_O == 3)
                return 'O';  
        
        /*check for:
                 02
              11
           20
        */
        count_X = 0;
        count_O = 0;
        for(int i=0; i<3; i++){
 
            if(board[i][2-i]=='X')
                count_X++;
            else if(board[i][2-i]=='O')
                count_O++;
            }
        if(count_X == 3)
                return 'X';
        else if(count_O == 3)
                return 'O';
        
        //if no winner, return '.'
        return '.';
    }
    
    
    /*
    int countMoves(char[][] board, char player)
    Returns the total number of moves made by the specified player. 
    */
    public static int countMoves(char[][] board, char player){
        int count = 0;
        //calculate the total move of 'player'
        //'player' are 'X' or 'Y'
        //check for all index in array
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == player)
                    count++;
            }
        }
        return count;
        
    }
    
}
