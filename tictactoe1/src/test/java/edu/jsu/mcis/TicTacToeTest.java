package edu.jsu.mcis;
import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	
	@Test
	public void testInitialBoardIsEmpty() {
	TicTacToe test = new TicTacToe();
		boolean blank = true;
		for (int row = 0; row < 3; row++){
			for (int column = 0; column < 3; column++){
				if (test.grid[row][column] != TicTacToe.Character.EMPTY){
					blank = false;
				}
			}
		}
		assertTrue(blank);

		
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe test = new TicTacToe();
		test.placeCharacter(0,2);
		assertEquals(TicTacToe.Character.X, test.getCharacter(0,2));
	}
	
	@Test
    public void testMarksShouldSwitchBetweenXandO() {
		TicTacToe test= new TicTacToe();
        test.placeCharacter(1, 1);
        assertEquals(TicTacToe.Character.X, test.getCharacter(1, 1));
        test.placeCharacter(2, 1);
        assertEquals(TicTacToe.Character.O, test.getCharacter(2, 1));
    }
	
	@Test
	public void testMarkOInBottomLeftCorner() {
	   TicTacToe test = new TicTacToe();
       test.placeCharacter(2,0);
       assertEquals(TicTacToe.Character.X, test.getCharacter(2,0));
   

		
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToe test = new TicTacToe();
		test.placeCharacter(0,0);
		assertEquals(false, test.slotClearOrFilled(0,0));
		
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe test = new TicTacToe();
		test.placeCharacter(0,0);
		assertEquals(TicTacToe.Character.EMPTY, test.userHasWonSituations());
		assertFalse(test.tieSituation());
		
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe test = new TicTacToe();
		test.grid[0][0] = TicTacToe.Character.X;
		test.grid[0][1] = TicTacToe.Character.X;
		test.grid[0][2] = TicTacToe.Character.X;
		assertEquals(TicTacToe.Character.X, test.userHasWonSituations());
		

		
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe test = new TicTacToe();
		test.grid[0][0] = TicTacToe.Character.X;
		test.grid[0][1] = TicTacToe.Character.X; 
		test.grid[0][2] = TicTacToe.Character.O;
		test.grid[1][0] = TicTacToe.Character.O;
		test.grid[1][1] = TicTacToe.Character.O;
		test.grid[1][2] = TicTacToe.Character.X;
		test.grid[2][0] = TicTacToe.Character.X;
		test.grid[2][1] = TicTacToe.Character.X;
		test.grid[2][2] = TicTacToe.Character.O;
		assertEquals(true, test.tieSituation());
		test.grid[0][2] = TicTacToe.Character.X;
		assertEquals(false, test.tieSituation());

		
	}	
}
