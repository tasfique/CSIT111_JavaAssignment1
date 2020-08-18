//Student's Full name: Tasfique Enam
//Student's ID: 5886429
//Modification Date: 28/04/17
//Purpose of this file: Assignment1

package TicTacToe;
import java.util.Scanner;

public class TicTacToe {
    public char [][] board;
    public boolean gameplay = true;
    int nameCounter1 = 0;
    int nameCounter2 = 0;
    int counter =0 ;
    String Winner;
    
    
    public TicTacToe() {
        board = new char[3][3]; //creating of a new board of 3 by 3 grid and filling it with stars
        for (int row=0; row<board.length; row++){
            for (int col=0; col<board.length; col++){
                board[row][col] = '*';
            }
        } 
}
    //end
    //to clear the board when the game is over.
    public void BoardClear(int clear){
        if (clear==1){
            for (int row=0; row<board.length; row++){
            for (int col=0; col<board.length; col++){
                board[row][col] = '*';
            }
        }
      }
    }
    //end
    //display the gameboard with vertical and horizontal lines.
    public void ShowBoard(){
        for (int row=0; row<board.length; row++){
            for (int col=0; col<board[0].length; col++){
                System.out.print("\t"+board[row][col]);
                if (col == 0 || col ==1)
                    System.out.print("\t|");
            }
            if (row==0 || row==1)
            System.out.println("\n------------------------------------------------\n");
        }
    }
    //end
    public boolean WinnerCheck(){ //to keep the game active.
        return gameplay;
    }
    //end
    public void input(char player){ //to ask the players to input row and coloumns
        Scanner keyboard = new Scanner(System.in);
        int row, col;
        do{
            System.out.println("Enter Row ");
            row = keyboard.nextInt();
            
            System.out.println("Enter Column ");
            col = keyboard.nextInt(); 
         }while(inValid(row,col));
        
        Move(player,row-1,col-1);
    }
    //end
    //looping for checking winners in row.
    public boolean WinnerCheck(String name1, String name2){
        for(int row=0; row<board.length; row++){
           
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != '*'){                   
                if (board[row][0] == 'X'){
                     System.out.println( " \n Has won the round.\n " +name2);
                 nameCounter2++;
                 Winner = name2;
                 gameplay = false;
                  counter = counter + 1;
                }
                if (board[row][0] == 'O'){
                    System.out.println( " \n Has won the round.\n " +name1);
                 nameCounter1++;
                Winner = name1;
                gameplay = false;
                counter = counter + 1;
                }
            }
        }
        //checking winners in column
        for(int col=0; col<board[0].length; col++){
            
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != '*'){                   
                if (board[col][0] == 'X'){
                     System.out.println( " \n Has won the round.\n " +name2);
                 nameCounter2++;
                 Winner = name2;
                 gameplay = false;
                 counter = counter + 1;
                }
                if (board[col][0] == 'O'){
                    System.out.println( " \n Has won the round.\n " +name1);
                 nameCounter1++;
                Winner = name1;
                gameplay = false;
                counter = counter + 1;
                }
            }
        }
        //checking winners in cross
        if( board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '*'){
            if (board[0][0] == 'X'){
                System.out.println( " \n Has won the round.\n " +name2);
                nameCounter2++;
                Winner = name2;
                gameplay = false;
                counter = counter + 1;
            }
            if (board[0][0] == 'O'){
                System.out.println( " \n Has won the round.\n " +name1);
                nameCounter1++;
                Winner = name1;
                gameplay = false;
                counter = counter + 1;
            }
        }
        if(board[0][2] == board[1][1] &&  board[1][1] == board[2][0] && board[0][2] != '*'){
             if (board[0][0] == 'X'){
                 System.out.println( " \n Has won the round.\n " +name2);
                 nameCounter2++;
                 counter = counter + 1;
                 Winner = name2;
             
             }else if (board[0][0] == 'O'){
                 System.out.println( " \n Has won the round.\n " +name1);
                 nameCounter1++;
                 counter = counter + 1;
                 Winner = name1;
                 gameplay = false;
             }
        }
        return false;
        //end
    }
    //Checking if there is any winner or not, and letting the game to continue
    public boolean GameStatus(int Status1){
        if(Status1 ==1){
            return gameplay = true;
        }else{
            return gameplay = false;
        }
    }
    //end
    public void gameCounterReset(int newCounter)        //check for counter.... 
    {
        if(newCounter ==1)
        {
            nameCounter1 =0;
            nameCounter2 =0;
            counter =0;
        }
    }
    
    public int counter(){   //check for how many times a player has won the games.
        return counter;
    }
    public int counterForO(){   //check for how many times player1 has won the game.
        return nameCounter1;
    }
    public int counterForX(){   //check for how many times player2 has won the game.
        return nameCounter2;
    }
    public String Winner(){   //check for the winner.
        return Winner;
    }
    public boolean inValid(int row, int col){  //for invalid row and columns enetered.
        if (row > 3 || row < 1 ||col >3 || col <1 || !Empty(row,col))
            return true;
        else
            return false;
    }
    public boolean Empty(int row, int col){
        if (board[row-1][col-1] == '*')
            return true;
        else
            return false;
    }
    //Validating if a player has inputted the right value for row and column
    public boolean Move(char player,int row,int col){
        if(row>=0 && row<=2 && col>=0 && col <=2){
            if(board[row][col] != '*')
                return false;
            else{
                board[row][col] = player;
                return true;
                }          
        }else
            return false;
    }
    //The main method.
    public static void main(String[] args){
        TicTacToe Game = new TicTacToe();
        
        char choice,choiceNo;
        int status;
        
        //a "do loop" is used when the players starts a new game, thier names will be reset and they need to enter their names again. 
        do{
            Scanner read = new Scanner(System.in);
            System.out.println("\nPlease enter Player 1 name."); //input of player 1
            String name1 = read.nextLine();
            System.out.println("Hello "+name1+"!!!");
            
            System.out.println("\nPlease enter Player 2 name."); //input of player 2
            String name2 = read.nextLine();
            System.out.println("Hello "+name2+"!!!");
            System.out.println("Welcome to The TicTacToe Game ");
            
            do{
                {    //switching turns for each of the players.
                    Game.ShowBoard();
                    int counter = 1;
                    while (Game.WinnerCheck() && counter<10){
                        if (counter %2 == 1){
                            System.out.println("\n\nIt's your turn " + name1 + ".\n");
                            System.out.println("Enter the row and column number you wish to choose.");
                            
                            Game.input('O');
                        }else{
                            System.out.println("\n\nIt's your turn " + name2 + ".\n");
                            System.out.println("Enter the row and column number you wish to choose.");
                            
                            Game.input('X');
                        }
                        counter++;
                         System.out.println("\n");
                        Game.ShowBoard();         
                        Game.WinnerCheck(name1, name2); //checking for the game winner.
                        
                        if(counter==10){
                            System.out.print("It's a stale mate! We got no winners!\n"); //when the board is completely filled and there is no winners it show a draw.
                        }
                    }
                }
                System.out.println("\n Would you like to play again?"); //asking the players if they want to play again.
                choice = read.next().charAt(0);
                read.nextLine();
                choiceNo = Character.toUpperCase(choice);
                
                if (choiceNo != 'N'){      //if they select no the game terminates.
                     status =1;
                     Game.GameStatus(status);
                     int CleanValue = 1;
                     Game.BoardClear(CleanValue);
                }else{
                    status =0 ;              //if they don't pick no it clears the game board and restarts
                    Game.GameStatus(status);
                    int CleanValue = 0;
                    Game.BoardClear(CleanValue);
                }
                int WinnerCounter1 = Game.counterForO();
                int WinnerCounter2 = Game.counterForX();
                int counter = Game.counter();
                String nameWinner = Game.Winner();
                
                choiceNo = Character.toUpperCase(choice);
                
                if(choiceNo =='N'){
                    System.out.println("\nThank you for playing ");
                    System.out.println("you have played "+ counter + " round of the tic-tac-toe game\n");  
                    System.out.println(name1 + "you have won " + WinnerCounter1 + " time(s).");
                    System.out.println(name2 + "you have won " + WinnerCounter2 + " time(s).");
                    System.out.println("The ovarall winner is " + nameWinner);
                
                    if (choiceNo != 'N'){
                    status =1 ;
                    Game.GameStatus(status);
                    int CleanValue = 1;
                    Game.BoardClear(CleanValue);
                }else{
                    status =0 ;
                    Game.GameStatus(status);
                    int CleanValue = 0;
                    Game.BoardClear(CleanValue);
                }
                }
                
            }while(choiceNo != 'N');
            
            System.out.println("Start a new game ? ");
            choice = read.next().charAt(0);
            read.nextLine();
            choiceNo = Character.toUpperCase(choice);
            
            if (choiceNo != 'N'){
               status =1 ;
               Game.GameStatus(status);
               int ClearValue = 1;
               Game.BoardClear(ClearValue);
               int CounterClear =1;
               Game.gameCounterReset(CounterClear);
            }else{
               status =0 ;
               Game.GameStatus(status);
               int ClearValue = 0;
               Game.BoardClear(ClearValue);
            }
        }while(choiceNo != 'N');
    }
}