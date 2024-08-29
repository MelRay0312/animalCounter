package animalCounter;

public abstract class Animal {
	protected int count;
	
	public void resetCount() {
		this.count = 0;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public abstract void incrementCount();

}
