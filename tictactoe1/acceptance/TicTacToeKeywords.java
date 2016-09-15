import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	public TicTacToe game;
	
	public void startNewGame() {
		 game=new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		game.placeCharacter(row,col);
	}
	
	public String getMark(int row, int col) {
		if(game.getCharacter(row,col)== TicTacToe.Character.X){
			return "X";
		}
		else if (game.getCharacter(row, col) == TicTacToe.Character.O) {
			return "O";
		}
		else return "";

	}
    
	public String getWinner() {
		if (game.userHasWonSituations() == TicTacToe.Character.X) {
			return "X";
		}
		else if (game.userHasWonSituations() == TicTacToe.Character.O) {
			return "O";
		}
		else if (game.tieSituation()) {
			return "TIE";
		}
		else return "";
	}

	
}
