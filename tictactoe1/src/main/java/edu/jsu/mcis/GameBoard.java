package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameBoard extends JFrame  {
  private JButton[][] button = new JButton[3][3];
	TicTacToe guiBoard= new TicTacToe();
  

  public GameBoard() {
    setupBoard();
  }

  private void setupBoard() {
	new TicTacToe();
    JFrame mainBoard = new JFrame("Tic-Tac-Toe");
    mainBoard.setSize(300,300);
    mainBoard.setLayout(new GridLayout(3, 3));
    mainBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    int place = 1;
    for (int row = 0; row < 3; row++) {
      for (int column = 0; column < 3; column++) {
        button[row][column] = new JButton("");
        button[row][column].setName(Integer.toString(place));
        button[row][column].addActionListener(new ButtonListener(row, column));
        button[row][column].setFont(new Font("", Font.PLAIN, 55));
        mainBoard.add(button[row][column]);
        place+= 1;
      }
    }
    mainBoard.setVisible(true);
  }

  private class ButtonListener implements ActionListener {
    private int row;
    private int col;

    public ButtonListener(int r, int c) {
      row = r;
      col = c;
    }

    public void actionPerformed(ActionEvent e) {
      buttonPress(row, col);
    }
  }
  


  public void buttonPress (int row, int col) {
    guiBoard.placeCharacter(row, col);
	
      if (guiBoard.getCharacter(row, col) == TicTacToe.Character.X) {
        button[row][col].setLabel("X");
		
      }
      else if (guiBoard.getCharacter(row, col) == TicTacToe.Character.O) {
        button[row][col].setLabel("O");
		
      }
    if (guiBoard.userHasWonSituations() == TicTacToe.Character.X){
		int delay=50;
        ActionListener task = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            }
        };
		Timer myTimer= new Timer(delay, task);
		myTimer.setRepeats(false);
		myTimer.start();
    }
    else if (guiBoard.userHasWonSituations() == TicTacToe.Character.O) {
		int delay=50;
        ActionListener task = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            
          }
        };
		Timer myTimer= new Timer(delay, task);
		myTimer.setRepeats(false);
		myTimer.start();
    }
    if (guiBoard.tieSituation()) {
		int delay=50;
        ActionListener task = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            
          }
        };
		Timer myTimer= new Timer(delay, task);
		myTimer.setRepeats(false);
		myTimer.start();
    }
	
  }
  
  public static void main(String[] args) {
	GameBoard tictactoe= new GameBoard();
	}
	
}

