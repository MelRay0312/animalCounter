package animalCounter;

import javax.swing.*;

public class Alligator extends Animal implements Countable {
	
	public Alligator() {
		this.count = 0;
	}
	
	@Override
	public void incrementCount() {
		this.count += 1;
		
		if (this.count == 0) {
			JOptionPane.showMessageDialog(null, "No alligators now so the sheep are safe");
		}
	}

}
