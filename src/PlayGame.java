
public class PlayGame {
	public static boolean playerTurn = true;
	public static boolean playerWon = false;
	public static boolean computerWon = false;
	
	public static TicTacToe board = new TicTacToe();
	public static void main(String[] args) {
		if(board.isVisible() == false) {
			board.setVisible(true);
		}

	}
	
	public static void checkWinStatus() {
		if(board.getBtn1().getText().equals("O")) {
			if(board.getBtn4().getText().equals("O")){
				if(board.getBtn7().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn1().getText().equals("O")) {
			if(board.getBtn5().getText().equals("O")){
				if(board.getBtn9().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn1().getText().equals("O")) {
			if(board.getBtn2().getText().equals("O")){
				if(board.getBtn3().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn2().getText().equals("O")) {
			if(board.getBtn5().getText().equals("O")){
				if(board.getBtn8().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn3().getText().equals("O")) {
			if(board.getBtn5().getText().equals("O")){
				if(board.getBtn7().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn3().getText().equals("O")) {
			if(board.getBtn6().getText().equals("O")){
				if(board.getBtn9().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn4().getText().equals("O")) {
			if(board.getBtn5().getText().equals("O")){
				if(board.getBtn6().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn7().getText().equals("O")) {
			if(board.getBtn8().getText().equals("O")){
				if(board.getBtn9().getText().equals("O")){
					playerWon = true;
					computerWon = false;
					System.out.println("Player won!");
				}
			}
		}
		
		if(board.getBtn1().getText().equals("X")) {
			if(board.getBtn4().getText().equals("X")){
				if(board.getBtn7().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
		
		if(board.getBtn1().getText().equals("X")) {
			if(board.getBtn5().getText().equals("X")){
				if(board.getBtn9().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
		
		if(board.getBtn1().getText().equals("X")) {
			if(board.getBtn2().getText().equals("X")){
				if(board.getBtn3().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
		
		if(board.getBtn2().getText().equals("X")) {
			if(board.getBtn5().getText().equals("X")){
				if(board.getBtn8().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
		
		if(board.getBtn3().getText().equals("X")) {
			if(board.getBtn5().getText().equals("X")){
				if(board.getBtn7().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
		
		if(board.getBtn3().getText().equals("X")) {
			if(board.getBtn6().getText().equals("X")){
				if(board.getBtn9().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
		
		if(board.getBtn4().getText().equals("X")) {
			if(board.getBtn5().getText().equals("X")){
				if(board.getBtn6().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
		
		if(board.getBtn7().getText().equals("X")) {
			if(board.getBtn8().getText().equals("X")){
				if(board.getBtn9().getText().equals("X")){
					playerWon = false;
					computerWon = true;
					System.out.println("Computer won!");
				}
			}
		}
	}

}
