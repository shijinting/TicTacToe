import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TicTacToe extends JPanel{
	private JButton buttons[]; 
	private JButton button;
	private int alternate = 0;
	private AIPlayerLookup aiLookup;
	final static int COUNT = 9;
	Panel panel = new Panel();
    Dimension dimen = new Dimension(100, 100);
    
	public TicTacToe() {
		buttons = new JButton[9];		
		setLayout(new GridLayout(3,3));
		initGraphic();
	}
	
	private void initGraphic() {
		for(int i = 0; i < COUNT; i++){
			button = new JButton("");
			buttons[i] = button;
			buttons[i].addActionListener(new buttonListener());
            add(buttons[i]);
		}
		aiLookup = new AIPlayerLookup(buttons);
	}
	
	public void resetButtons() {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("");
        }
    }
	
	public class buttonListener implements ActionListener {
		private String winningPlayer;
        public void actionPerformed(ActionEvent e) {
            
            JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
            if(alternate%2 == 0) {
            	if(buttonClicked.getText().equals("")){
            		buttonClicked.setText("O");
            		aiLookup.move(alternate % 2);
            		alternate++;
            	}
            }
            else{
            	if(buttonClicked.getText().equals("")){
            		buttonClicked.setText("X");
            		alternate++;
            	}
            	//AI Player starts here
            }
            
            if(checkForWin() == true) {
            	if (this.winningPlayer.equals("X")) {
            		JOptionPane.showConfirmDialog(null, "Sorry you lose!");
            	} else {
            		JOptionPane.showConfirmDialog(null, "You win!");
            	}
            	alternate = 0;
                resetButtons();
            } else {
            	boolean consistEmpty = false;
            	for(int i = 0; i < COUNT; i++) {
            		if(buttons[i].getText().equals("")){
            			consistEmpty = true;
            		}
            	}
            	
            	if(!consistEmpty) {
            		JOptionPane.showConfirmDialog(null, "Draw! No one won!");
            		alternate = 0;
            		resetButtons();
            	} else {
                    if (alternate % 2 == 1) {
                    	aiLookup.move(alternate % 2);
                    }
            	}
            }
        }
        
        public boolean checkForWin() {
        	int i = 0, ltrDiagonalCount = 4, verticalCount = 3, rtlDiagonalCount = 2;
            /**   Reference: the button array is arranged like this as the board
             *      0 | 1 | 2
             *      3 | 4 | 5
             *      6 | 7 | 8
             */
            //horizontal win check
        	for(int j = 0; j < verticalCount; j ++){
        		if( checkAdjacent(i,i + 1) && checkAdjacent(i + 1, i + 1 * 2) ) //no need to put " == true" because the default check is for true
                    return true;
                //vertical win check
        		if( checkAdjacent(j,j + verticalCount) && checkAdjacent(j + verticalCount, j + (verticalCount*2)) ) //no need to put " == true" because the default check is for true
                    return true;
        		i += verticalCount;
        	}
            i = 0;
            
            //diagonal win check
        	if( checkAdjacent(i, ltrDiagonalCount) && checkAdjacent(ltrDiagonalCount, i + (ltrDiagonalCount*2)) ) //no need to put " == true" because the default check is for true
                return true;
        	
        	i = i + rtlDiagonalCount;
        	if( checkAdjacent(i,i + rtlDiagonalCount) && checkAdjacent(i + rtlDiagonalCount, i + (i + rtlDiagonalCount*2)) ) //no need to put " == true" because the default check is for true
                return true;
            else 
                return false;
        }
        
        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") ){
            	setWinningPlayer(buttons[a].getText());
            	return true;
            }
            else
                return false;
        }

		private void setWinningPlayer(String text) {
			this.winningPlayer = text;
		}
        
    }
}
