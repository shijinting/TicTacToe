import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class TicTacToe extends JPanel{
	private JButton buttons[]; 
	private JButton button;
	private int alternate = 0;
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
	}
	
	public void resetButtons() {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("");
        }
    }
	
	private class buttonListener implements ActionListener {
       
        public void actionPerformed(ActionEvent e) {
            
            JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
            if(alternate%2 == 0) {
            	if(buttonClicked.getText().equals("")){
            		buttonClicked.setText("X");
            	}
            }
            else{
//            	if(buttonClicked.getText().equals("")){
//            		buttonClicked.setText("O");
//            	}
            	//AI Player starts here
            }
            
            if(checkForWin() == true)
            {
                JOptionPane.showConfirmDialog(null, "Game Over.");
                resetButtons();
            }
            alternate++;
            
        }
        
        public boolean checkForWin() {
            /**   Reference: the button array is arranged like this as the board
             *      0 | 1 | 2
             *      3 | 4 | 5
             *      6 | 7 | 8
             */
            //horizontal win check
            if( checkAdjacent(0,1) && checkAdjacent(1,2) ) //no need to put " == true" because the default check is for true
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;
            
            //vertical win check
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;  
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;
            
            //diagonal win check
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;  
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else 
                return false;
            
            
        }
        
        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
        
    }
}
