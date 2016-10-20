import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class AIPlayerLookup {
	 
	   private JButton buttons[];
	   // Constructor
	   public AIPlayerLookup(JButton buttons[]) {
	      this.buttons = buttons;
	   }
	   
	   // Move step
	   public void move(int player) {
		  int[] moveResult = minmax(4, player);
		  if(player == 0) {
			  System.out.println("Player moved");
		  }else{
			  System.out.println("result: " + moveResult[1]);
			  buttons[moveResult[1]].doClick();
			  System.out.println("Computer moved");
		  }
	   }
	   
	private int[] minmax(int depth, int player) {
		  // Generate possible next moves in a List of button number.
	      List<Integer> nextMoves = generateMoves();
	 
	      // Computer is maximizing; while player is minimizing
	      int bestScore = (player == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	      int currentScore;
	      int bestMove = -1;
	      
	      if (nextMoves.isEmpty() || depth == 0) {
	         // Gameover or depth reached, evaluate score
	         bestScore = evaluate();
	      } else {
	         for (int move : nextMoves) {
	            // Try this move for the current "player"
	            if (player == 0) {  // Computer is maximizing
	            	buttons[move].setText("X");
	               currentScore = minmax(depth - 1, 1)[0];
	               if (currentScore > bestScore) {
	                  bestScore = currentScore;
	                  bestMove = move;
	               }
	            } else {  // Player is minimizing 
	               buttons[move].setText("O");
	               currentScore = minmax(depth - 1, 0)[0];
	               if (currentScore < bestScore) {
	                  bestScore = currentScore;
	                  bestMove = move;
	               }
	            }
	            // Undo move
	            buttons[move].setText("");
	         }
	      }
	      return new int[] {bestScore, bestMove};
	   }
	   
	private int evaluate() {
		int score = 0;
	      // Evaluate score for each of the 8 lines (3 rows, 3 columns, 2 diagonals)
	      score += evaluateLine(0, 1, 2);  // row 0
	      score += evaluateLine(3, 4, 5);  // row 1
	      score += evaluateLine(6, 7, 8);  // row 2
	      score += evaluateLine(0, 3, 6);  // col 0
	      score += evaluateLine(1, 4, 7);  // col 1
	      score += evaluateLine(2, 5, 8);  // col 2
	      score += evaluateLine(0, 4, 8);  // diagonal
	      score += evaluateLine(2, 4, 6);  // alternate diagonal
		return score;
	}

	private int evaluateLine(int firstBtn, int secondBtn, int thirdBtn) {
		int score = 0;
		 
	      // First button
	      if (buttons[firstBtn].getText().equals("X")) {
	         score = 1;
	      } else if (buttons[firstBtn].getText().equals("O")) {
	         score = -1;
	      }
	 
	      // Second button
	      if (buttons[secondBtn].getText().equals("X")) {
	         if (score == 1) {   // First button is X
	            score = 10;
	         } else if (score == -1) {  // First button is O
	            return 0;
	         } else {  // First button is empty
	            score = 1;
	         }
	      } else if (buttons[secondBtn].getText().equals("O")) {
	         if (score == -1) { // First button is O
	            score = -10;
	         } else if (score == 1) { // First button is X
	            return 0;
	         } else {  // First button is empty
	            score = -1;
	         }
	      }
	 
	      // Third button
	      if (buttons[thirdBtn].getText().equals("X")) {
	         if (score > 0) {  // First button and/or second button is X
	            score *= 10;
	         } else if (score < 0) {  // First button and/or second button is O
	            return 0;
	         } else {  // First button and second button is empty
	            score = 1;
	         }
	      } else if (buttons[thirdBtn].getText().equals("O")) {
	         if (score < 0) {  // First button and/or second button is O
	            score *= 10;
	         } else if (score > 1) {  // First button and/or second button is X
	            return 0;
	         } else {  // First button and second button is empty
	            score = -1;
	         }
	      }
	      return score;
	}

	private List<Integer> generateMoves() {
	      List<Integer> nextMoves = new ArrayList<Integer>(); // Allocate List
	 
	      // Search for empty button and add to the List
	      for(int i = 0; i < 9; i++) {
	    	 if(buttons[i].getText().equals("")){
	    		 nextMoves.add(i);
	    	 }
	      }
	      return nextMoves;
	   }
	}