import javax.swing.JButton;

public class LineEvaluator {
	private int score, firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn;
	private JButton buttons[];
	public LineEvaluator(JButton buttons[], int firstBtn, int secondBtn, int thirdBtn) {
		this.score = 0;
		this.buttons = buttons;
		this.firstBtn = firstBtn;
		this.secondBtn = secondBtn;
		this.thirdBtn = thirdBtn;
	}
	
	public LineEvaluator(JButton buttons[], int firstBtn, int secondBtn, int thirdBtn, int fourthBtn) {
		this.score = 0;
		this.buttons = buttons;
		this.firstBtn = firstBtn;
		this.secondBtn = secondBtn;
		this.thirdBtn = thirdBtn;
		this.fourthBtn = fourthBtn;
	}
	
	public LineEvaluator(JButton buttons[], int firstBtn, int secondBtn, int thirdBtn, int fourthBtn, int fifthBtn) {
		this.score = 0;
		this.buttons = buttons;
		this.firstBtn = firstBtn;
		this.secondBtn = secondBtn;
		this.thirdBtn = thirdBtn;
		this.fourthBtn = fourthBtn;
		this.fifthBtn = fifthBtn;
	}
	
	public int evaluateLineSize3() {
		// First button
		if (buttons[firstBtn].getText().equals("X")) {
		     score = 1;
		} else if (buttons[firstBtn].getText().equals("O")) {
		     score = -1;
		}
	 
	    // Second button
	    if (buttons[secondBtn].getText().equals("X")) {
	    	if (score == 1) {   // First button is X
	            score = 10;
	        } else if (score == -1) {  // First button is O
	        	return 0;
	        } else {  // First button is empty
	            score = 1;
	        }
	    } else if (buttons[secondBtn].getText().equals("O")) {
	    	if (score == -1) { // First button is O
	            score = -10;
	        } else if (score == 1) { // First button is X
	            return 0;
	        } else {  // First button is empty
	            score = -1;
	        }
	    }
	 
	    // Third button
	    if (buttons[thirdBtn].getText().equals("X")) {
	    	if (score > 0) {  // First button and/or second button is X
	            score *= 10;
	        } else if (score < 0) {  // First button and/or second button is O
	            return 0;
	        } else {  // First button and second button is empty
	            score = 1;
	        }
	    } else if (buttons[thirdBtn].getText().equals("O")) {
	        if (score < 0) {  // First button and/or second button is O
	            score *= 10;
	        } else if (score > 1) {  // First button and/or second button is X
	        	return 0;
	        } else {  // First button and second button is empty
	            score = -1;
	        }
	    }
	    return score;
	}
	
	public int evaluateLineSize4() {
		// First button
		if (buttons[firstBtn].getText().equals("X")) {
		     score = 1;
		} else if (buttons[firstBtn].getText().equals("O")) {
		     score = -1;
		}
	 
	    // Second button
	    if (buttons[secondBtn].getText().equals("X")) {
	    	if (score == 1) {   // First button is X
	            score = 10;
	        } else if (score == -1) {  // First button is O
	        	return 0;
	        } else {  // First button is empty
	            score = 1;
	        }
	    } else if (buttons[secondBtn].getText().equals("O")) {
	    	if (score == -1) { // First button is O
	            score = -10;
	        } else if (score == 1) { // First button is X
	            return 0;
	        } else {  // First button is empty
	            score = -1;
	        }
	    }
	 
	    // Third button
	    if (buttons[thirdBtn].getText().equals("X")) {
	    	if (score > 0) {  // First button and/or second button is X
	            score *= 10;
	        } else if (score < 0) {  // First button and/or second button is O
	            return 0;
	        } else {  // First button and second button is empty
	            score = 1;
	        }
	    } else if (buttons[thirdBtn].getText().equals("O")) {
	        if (score < 0) {  // First button and/or second button is O
	            score *= 10;
	        } else if (score > 1) {  // First button and/or second button is X
	        	return 0;
	        } else {  // First button and second button is empty
	            score = -1;
	        }
	    }
	    
	    // Fourth button
	    if (buttons[fourthBtn].getText().equals("X")) {
	    	if (score > 0) {  // First button and/or second button is X
	            score *= 100;
	        } else if (score < 0) {  // First button and/or second button is O
	            return 0;
	        } else {  // First button and second button is empty
	            score = 1;
	        }
	    } else if (buttons[fourthBtn].getText().equals("O")) {
	        if (score < 0) {  // First button and/or second button is O
	            score *= 100;
	        } else if (score > 1) {  // First button and/or second button is X
	        	return 0;
	        } else {  // First button and second button is empty
	            score = -1;
	        }
	    }
	    return score;
	}
	
	public int evaluateLineSize5() {
		// First button
		if (buttons[firstBtn].getText().equals("X")) {
		     score = 1;
		} else if (buttons[firstBtn].getText().equals("O")) {
		     score = -1;
		}
	 
	    // Second button
	    if (buttons[secondBtn].getText().equals("X")) {
	    	if (score == 1) {   // First button is X
	            score = 10;
	        } else if (score == -1) {  // First button is O
	        	return 0;
	        } else {  // First button is empty
	            score = 1;
	        }
	    } else if (buttons[secondBtn].getText().equals("O")) {
	    	if (score == -1) { // First button is O
	            score = -10;
	        } else if (score == 1) { // First button is X
	            return 0;
	        } else {  // First button is empty
	            score = -1;
	        }
	    }
	 
	    // Third button
	    if (buttons[thirdBtn].getText().equals("X")) {
	    	if (score > 0) {  // First button and/or second button is X
	            score *= 10;
	        } else if (score < 0) {  // First button and/or second button is O
	            return 0;
	        } else {  // First button and second button is empty
	            score = 1;
	        }
	    } else if (buttons[thirdBtn].getText().equals("O")) {
	        if (score < 0) {  // First button and/or second button is O
	            score *= 10;
	        } else if (score > 1) {  // First button and/or second button is X
	        	return 0;
	        } else {  // First button and second button is empty
	            score = -1;
	        }
	    }
	    
	    // Fourth button
	    if (buttons[fourthBtn].getText().equals("X")) {
	    	if (score > 0) {  // First button and/or second button is X
	            score *= 100;
	        } else if (score < 0) {  // First button and/or second button is O
	            return 0;
	        } else {  // First button and second button is empty
	            score = 1;
	        }
	    } else if (buttons[fourthBtn].getText().equals("O")) {
	        if (score < 0) {  // First button and/or second button is O
	            score *= 100;
	        } else if (score > 1) {  // First button and/or second button is X
	        	return 0;
	        } else {  // First button and second button is empty
	            score = -1;
	        }
	    }
	    
	    // Fifth button
	    if (buttons[fifthBtn].getText().equals("X")) {
	    	if (score > 0) {  // First button and/or second button is X
	            score *= 1000;
	        } else if (score < 0) {  // First button and/or second button is O
	            return 0;
	        } else {  // First button and second button is empty
	            score = 1;
	        }
	    } else if (buttons[fifthBtn].getText().equals("O")) {
	        if (score < 0) {  // First button and/or second button is O
	            score *= 1000;
	        } else if (score > 1) {  // First button and/or second button is X
	        	return 0;
	        } else {  // First button and second button is empty
	            score = -1;
	        }
	    }
	    return score;
	}
}
