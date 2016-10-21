import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class AIPlayerLookup {
	 
	   private JButton buttons[];
	   private int mode;
	   // Constructor
	   public AIPlayerLookup(JButton buttons[], int mode) {
	      this.buttons = buttons;
	      this.mode = mode;
	   }
	   
	   // Move step
	   public void move(int player) {
		   int[] moveResult = minmax(3, player);
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
	                  System.out.println("Max: " + bestScore);
	               }
	            } else {  // Player is minimizing 
	               buttons[move].setText("O");
	               currentScore = minmax(depth - 1, 0)[0];
	               if (currentScore < bestScore) {
	                  bestScore = currentScore;
	                  bestMove = move;
	                  System.out.println("Min: " + bestScore);
	               }
	            }
	            // Undo move
	            buttons[move].setText("");
	         }
	      }
	      return new int[] {bestScore, bestMove};
	   }
	   
	private int evaluate() {
		int score = 0, i = 0, verticalCount;
		if (mode == 1) {
			verticalCount = 3;
		      // Evaluate score for each of the 3x3 (3 rows, 3 columns, 2 diagonals)
			for(int j = 0; j < verticalCount; j ++){
	    		score += new LineEvaluator(buttons, i, i + 1, i + 1 * 2).evaluateLineSize3();
	    		score += new LineEvaluator(buttons, j, j + verticalCount, j + verticalCount * 2).evaluateLineSize3();
	    		i += verticalCount;
	    	}
			i = 0;
			System.out.println("Verticle score:" + score);
		    score += new LineEvaluator(buttons, 0, 4, 8).evaluateLineSize3();  // diagonal
		    score += new LineEvaluator(buttons, 2, 4, 6).evaluateLineSize3();  // alternate diagonal
		}else if (mode == 2) {
			verticalCount = 4;
		      // Evaluate score for each of the 4x4 (4 rows, 4 columns, 2 diagonals)
			for(int j = 0; j < verticalCount; j ++){
	    		score += new LineEvaluator(buttons, i, i + 1, i + 1 * 2, i + 1 * 3).evaluateLineSize4();
	    		score += new LineEvaluator(buttons, j, j + verticalCount, j + verticalCount * 2, j + verticalCount * 3).evaluateLineSize4();
	    		i += verticalCount;
	    	}
			i = 0;
			
		    score += new LineEvaluator(buttons, 0, 5, 10, 15).evaluateLineSize4();  // diagonal
		    score += new LineEvaluator(buttons, 3, 6, 9, 12).evaluateLineSize4();  // alternate diagonal
		}else if (mode == 3) {
			verticalCount = 5;
		      // Evaluate score for each of the 4x4 (4 rows, 4 columns, 2 diagonals)
			for(int j = 0; j < verticalCount; j ++){
	    		score += new LineEvaluator(buttons, i, i + 1, i + 1 * 2, i + 1 * 3, i + 1 * 4).evaluateLineSize5();
	    		score += new LineEvaluator(buttons, j, j + verticalCount, j + verticalCount * 2, j + verticalCount * 3, j + verticalCount * 4).evaluateLineSize5();
	    		i += verticalCount;
	    	}
			i = 0;
			
		    score += new LineEvaluator(buttons, 0, 6, 12, 18, 24).evaluateLineSize5();  // diagonal
		    score += new LineEvaluator(buttons, 4, 8, 12, 16, 20).evaluateLineSize5();  // alternate diagonal
		}
		
		return score;
	}

	private List<Integer> generateMoves() {
	      List<Integer> nextMoves = new ArrayList<Integer>(); // Allocate List
	      int count = 0;
	      if (mode == 1) {
	    	  count = 9;
	      }else if (mode == 2) {
	    	  count = 16;
	      }else if (mode == 3) {
	    	  count = 25;
	      }
	      // Search for empty button and add to the List
	      for(int i = 0; i < count; i++) {
	    	 if(buttons[i].getText().equals("")){
	    		 nextMoves.add(i);
	    	 }
	      }
	      return nextMoves;
	   }
	}