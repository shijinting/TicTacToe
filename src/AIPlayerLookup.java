import javax.swing.JButton;

public class AIPlayerLookup {
	 
	   // Moves {row, col} in order of preferences. {0, 0} at top-left corner
	   private int[] preferredMoves = {4,0,6,2,8,3,1,7,5};
	   private JButton buttons[];
	   /** constructor */
	   public AIPlayerLookup(JButton buttons[]) {
	      this.buttons = buttons;
	   }
	 
	   /** Search for the first empty cell, according to the preferences
	    *  Assume that next move is available, i.e., not gameover
	    *  @return int[2] of {row, col}
	    */
	   public JButton move() {
	      for (int move : preferredMoves) {
	    	 if(buttons[move].getText().equals("")){
	    		 return buttons[move];
	    	 }
	      }
	      assert false : "No empty cell?!";
	      return null;
	   }
	}