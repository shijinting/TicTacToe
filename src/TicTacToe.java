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
	
	public void resetButtons(int reply) {
		if(reply == JOptionPane.YES_OPTION) {
			for(int i = 0; i < count; i++){
	            buttons[i].setText("");
	            System.out.println(i);
	        }
		} else {
			PlayGame.initMenu();
		}
    }
	
	public class buttonListener implements ActionListener {
		private String winningPlayer;
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
            if(alternate%2 == 0) {
            	if(buttonClicked.getText().equals("")){
            		buttonClicked.setText("O");
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
            	int reply;
            	if (this.winningPlayer.equals("X")) {
            		reply = JOptionPane.showConfirmDialog(null, "Sorry you lose!", "Do you want to play again?", JOptionPane.YES_NO_OPTION);
            	} else {
            		reply = JOptionPane.showConfirmDialog(null, "You win!", "Do you want to play again?", JOptionPane.YES_NO_OPTION);
            	}
            	alternate = 0;
                resetButtons(reply);
            } else {
            	boolean consistEmpty = false;
            	for(int i = 0; i < count; i++) {
            		if(buttons[i].getText().equals("")){
            			consistEmpty = true;
            		}
            	}
            	
            	if(!consistEmpty) {
            		int reply = JOptionPane.showConfirmDialog(null, "Draw! No one won!", "Do you want to play again?", JOptionPane.YES_NO_OPTION);
            		alternate = 0;
            		resetButtons(reply);
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
        	int i = 0, verticalCount;
        	if (mode == 1) {
        		//3x3 board
        		verticalCount = 3;
        		
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
            	if( checkAdjacent(0, 4) && checkAdjacent(4, 8) )
            		return true;
            	
            	if( checkAdjacent(2, 4) && checkAdjacent(4, 6) )
            		return true;
                else 
                	return false;
    		}else if (mode == 2) {
    			//4x4 board
        		verticalCount = 4;
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
            	if( checkAdjacent(0, 5) && checkAdjacent(5, 10) && checkAdjacent(10, 15))
            		return true;
            	
            	if( checkAdjacent(3, 6) && checkAdjacent(6, 9) && checkAdjacent(9, 12))
            		return true;
                else 
                	return false;
    		}else if (mode == 3) {
    			// 5x5 board
        		verticalCount = 5;
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
            	if( checkAdjacent(0, 6) && checkAdjacent(6, 12) && checkAdjacent(12, 18) && checkAdjacent(18, 24))
            		return true;
            	
            	if( checkAdjacent(4, 8) && checkAdjacent(8, 12) && checkAdjacent(12, 16) && checkAdjacent(16, 20))
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
