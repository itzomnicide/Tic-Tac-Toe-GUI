package edu.jsu.mcis;
import java.io.*;
import java.util.*;

public class TicTacToe {
   
	public enum Character {
      X,O,TIE,EMPTY;
	  }
	
	Character[][] grid = new Character[3][3];
	int switchTurns=0;
    Character selectedCharacter;
	
	public TicTacToe(){
		for(int rows = 0; rows < 3; rows++){
			for(int columns = 0; columns < 3; columns++){
				grid[rows][columns] = Character.EMPTY;
				}
			}
	}
	
	public void boardDisplay(){
		for(int rows = 0; rows < 3; rows++){
			for(int columns = 0; columns < 3; columns++){
				if(slotClearOrFilled(rows, columns)){
					System.out.print(" ");
				}
				
				else{
					System.out.print(grid[rows][columns]);
				}
				if(columns < 2){
					System.out.print(" "+ "|");
                }
            }
                if(rows < 2){
					System.out.println();
					System.out.println("--------");
                }
        }
   }
	public void getUserInput(){
      Scanner userInput = new Scanner(System.in).useDelimiter("[,\\s+]");
      System.out.println();
	  System.out.println("Enter a valid position:");
      int UserRowInput = Integer.valueOf(userInput.nextInt());
      int UserColumnInput = Integer.valueOf(userInput.nextInt());
      placeCharacter(UserRowInput, UserColumnInput);
		
    }
	public void placeCharacter(int rows, int columns){
		if(slotClearOrFilled(rows,columns)){
			if(switchTurns == 0){
				selectedCharacter = Character.X;
				switchTurns++;
            }
            else if(switchTurns == 1){
				selectedCharacter = Character.O;
				switchTurns--;
            }
			grid[rows][columns] = selectedCharacter;
        }
			else{
				System.out.println("Not a valid move! Please enter position on grid again!");
      
			}	
   
    }
	public Character getCharacter(int rows, int columns){
      return grid[rows][columns];
    }
   
	public boolean slotClearOrFilled(int rows, int columns){
		if(grid[rows][columns] == Character.EMPTY) {
			return true;
        }
		return false;
    }
   
 
   
	public Character userHasWonSituations(){
		if(grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0])return grid[0][0];
		else if(grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1])return grid[0][1];
		else if(grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2])return grid[0][2];
		else if(grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2])return grid[0][0];
        else if(grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2])return grid[1][0];
		else if(grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2])return grid[2][0];
		else if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])return grid[0][2];
		else if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])return grid[0][0];
		else{
			return Character.EMPTY;
        }
   
    }
   
   
	public boolean gridIsComplete(){
		for(int rows = 0; rows < 3; rows++){
			for(int columns = 0; columns < 3; columns ++){
				if (grid[rows][columns] == TicTacToe.Character.EMPTY){
					return false;
               
                }
            }
        }
		return true;
    }
   
	public boolean tieSituation(){
		if(userHasWonSituations()== Character.EMPTY && gridIsComplete()){
			return true;
        }
		return false;
	}
   
   
	public void RunGameAndCheckGameConditions(){
		int num = 0;
		while(num == 0){
			boardDisplay();
			getUserInput(); 
			if(userHasWonSituations() == Character.X){
				num = 1;
				System.out.println("Congrats player 1 wins.");
				
			}
			else if(userHasWonSituations() == Character.O){
				num = 1;
				System.out.println("Congrats Player 2 wins.");
				
			}
			else if(tieSituation()== true){
				num=1;
				System.out.println("Game is a Tie");
				
		    }  
        }
		
   }
  
   public static void main(String[] args){
      TicTacToe game = new TicTacToe();
	  System.out.println("");
	  System.out.println("**Instructions**");
	  System.out.println("Welcome to TicTacToe. Player 1 is X. Player 2 is O.");
	  System.out.println("Enter a valid postion on the grid that ranges from (0-2).");
	  System.out.println("First number is your row and Second number is the column.");
	  System.out.println("The two numbers should be seperated by a comma without any spaces.");
	  game.RunGameAndCheckGameConditions();
	}
}

