package animalCounter;

public class Sheep extends Animal implements Countable {
	
	public Sheep() {
		this.count = 0;
	}
	
	@Override
	public void incrementCount() {
		this.count += 2;
	}

}
