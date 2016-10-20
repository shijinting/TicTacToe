import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TicTacToe extends JPanel{
	private JButton buttons[]; 
	private JButton button;
	private int alternate = 0, mode, count;
	private AIPlayerLookup aiLookup;
	final static int COUNT_SIZE_3 = 9, COUNT_SIZE_4 = 16, COUNT_SIZE_5 = 25;
	Panel panel = new Panel();
    Dimension dimen = new Dimension(100, 100);
    
	public TicTacToe(int mode) {
		this.mode = mode;
		if (mode == 1) {
			setLayout(new GridLayout(3,3));
			count = COUNT_SIZE_3;
		}else if (mode == 2) {
			setLayout(new GridLayout(4,4));
			count = COUNT_SIZE_4;
		}else if (mode == 3) {
			setLayout(new GridLayout(5,5));
			count = COUNT_SIZE_5;
		}
		buttons = new JButton[count];
		initGraphic();
	}
	
	private void initGraphic() {
		for(int i = 0; i < count; i++){
			button = new JButton("");
			buttons[i] = button;
			buttons[i].addActionListener(new buttonListener());
            add(buttons[i]);
		}
		aiLookup = new AIPlayerLookup(buttons, mode);
	}
	
	public void resetButtons() {
        for(int i = 0; i < count; i++)
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
            	for(int i = 0; i < count; i++) {
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
        	/**   Reference: the button array is arranged like this as the board
             *      0 | 1 | 2
             *      3 | 4 | 5
             *      6 | 7 | 8
             */
        	int i = 0, ltrDiagonalCount, verticalCount, rtlDiagonalCount;
        	if (mode == 1) {
        		//3x3 board
        		ltrDiagonalCount = 4;
        		verticalCount = 3;
        		rtlDiagonalCount = 2;
        		
            	for(int j = 0; j < verticalCount; j ++){
            		//horizontal win check
            		if( checkAdjacent(i,i + 1) && checkAdjacent(i + 1, i + 1 * 2) )
            			return true;
                    //vertical win check
            		if( checkAdjacent(j,j + verticalCount) && checkAdjacent(j + verticalCount, j + (verticalCount*2)) )
            			return true;
            		i += verticalCount;
            	}
                i = 0;
                
                //diagonal win check
            	if( checkAdjacent(i, ltrDiagonalCount) && checkAdjacent(ltrDiagonalCount, i + (ltrDiagonalCount*2)) )
            		return true;
            	
            	i = i + rtlDiagonalCount;
            	if( checkAdjacent(i,i + rtlDiagonalCount) && checkAdjacent(i + rtlDiagonalCount, i + (i + rtlDiagonalCount*2)) )
            		return true;
                else 
                	return false;
    		}else if (mode == 2) {
    			//4x4 board
    			ltrDiagonalCount = 5;
        		verticalCount = 4;
        		rtlDiagonalCount = 3;
            	for(int j = 0; j < verticalCount; j ++){
            		//horizontal win check
            		if( checkAdjacent(i,i + 1) && checkAdjacent(i + 1, i + 1 * 2) && checkAdjacent(i + 1 * 2, i + 1 * 3))
            			return true;
                    //vertical win check
            		if( checkAdjacent(j,j + verticalCount) && checkAdjacent(j + verticalCount, j + (verticalCount*2)) && checkAdjacent(j + (verticalCount*2), j + (verticalCount*3)))
            			return true;
            		i += verticalCount;
            	}
                i = 0;
                
                //diagonal win check
            	if( checkAdjacent(i, ltrDiagonalCount) && checkAdjacent(ltrDiagonalCount, i + (ltrDiagonalCount*2)) && checkAdjacent(i + (ltrDiagonalCount*2), i + (ltrDiagonalCount*3)))
            		return true;
            	
            	i = i + rtlDiagonalCount;
            	if( checkAdjacent(i,i + rtlDiagonalCount) && checkAdjacent(i + rtlDiagonalCount, i + (i + rtlDiagonalCount*2)) && checkAdjacent(i + (i + rtlDiagonalCount*2), i + (i + rtlDiagonalCount*3)))
            		return true;
                else 
                	return false;
    		}else if (mode == 3) {
    			// 5x5 board
    			ltrDiagonalCount = 6;
        		verticalCount = 5;
        		rtlDiagonalCount = 4;
        		for(int j = 0; j < verticalCount; j ++){
            		//horizontal win check
            		if( checkAdjacent(i,i + 1) && checkAdjacent(i + 1, i + 1 * 2) && checkAdjacent(i + 1 * 2, i + 1 * 3) && checkAdjacent(i + 1 * 3, i + 1 * 4)){
            			System.out.println(i + " " + (i+1) + " " + (i + 1 * 2) + " " + (i + 1 * 3));
            			return true;
            		}
                    //vertical win check
            		if( checkAdjacent(j,j + verticalCount) && checkAdjacent(j + verticalCount, j + (verticalCount*2)) && checkAdjacent(j + (verticalCount*2), j + (verticalCount*3)) && checkAdjacent(j + (verticalCount*3), j + (verticalCount*4)))
            			return true;
            		i += verticalCount;
            	}
                i = 0;
                
                //diagonal win check
            	if( checkAdjacent(i, ltrDiagonalCount) && checkAdjacent(ltrDiagonalCount, i + (ltrDiagonalCount*2)) && checkAdjacent(i + (ltrDiagonalCount*2), i + (ltrDiagonalCount*3)) && checkAdjacent(i + (ltrDiagonalCount*3), i + (ltrDiagonalCount*4)))
            		return true;
            	
            	i = i + rtlDiagonalCount;
            	if( checkAdjacent(i,i + rtlDiagonalCount) && checkAdjacent(i + rtlDiagonalCount, i + (i + rtlDiagonalCount*2)) && checkAdjacent(i + (i + rtlDiagonalCount*2), i + (i + rtlDiagonalCount*3)) && checkAdjacent(i + (i + rtlDiagonalCount*3), i + (i + rtlDiagonalCount*4)))
            		return true;
                else 
                	return false;
    		}
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
