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
	      System.out.println(bestScore + " " + bestMove);
	      return new int[] {bestScore, bestMove};
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