import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToe extends JFrame{
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	public TicTacToe() {
		initGraphic();
	}
	
	private void btn1ActionPerformed(ActionEvent e) {
		
	}
	
	private void btn2ActionPerformed(ActionEvent e) {
		
	}
	
	private void btn3ActionPerformed(ActionEvent e) {
		
	}

	private void btn4ActionPerformed(ActionEvent e) {
		
	}
	
	private void btn5ActionPerformed(ActionEvent e) {
		
	}
	
	private void btn6ActionPerformed(ActionEvent e) {
		
	}
	
	private void btn7ActionPerformed(ActionEvent e) {
		
	}
	
	private void btn8ActionPerformed(ActionEvent e) {
		
	}
	
	private void btn9ActionPerformed(ActionEvent e) {
		
	}
	
	private void initGraphic() {
		btn1 = new JButton("");
		btn2 = new JButton("");
		btn3 = new JButton("");
		btn4 = new JButton("");
		btn5 = new JButton("");
		btn6 = new JButton("");
		btn7 = new JButton("");
		btn8 = new JButton("");
		btn9 = new JButton("");
		
		setTitle("Tic Tac Toe");
		Container contentPane = getContentPane();
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn1ActionPerformed(e);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn2ActionPerformed(e);
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn3ActionPerformed(e);
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn4ActionPerformed(e);
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn5ActionPerformed(e);
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn6ActionPerformed(e);
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn7ActionPerformed(e);
			}
		});
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn8ActionPerformed(e);
			}
		});
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				btn9ActionPerformed(e);
			}
		});
	}
}
