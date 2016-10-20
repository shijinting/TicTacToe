import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PlayGame {
	public static void main(String[] args) {
		String[] options = new String[] { "Cancel", "3x3", "4x4", "5x5" };
		int mode = JOptionPane.showOptionDialog(null, "Please choose an option", "Jin Tic Tac Toe",
		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe(mode));
        window.setBounds(300,200,300,300);
        window.setVisible(true);
	}
}
