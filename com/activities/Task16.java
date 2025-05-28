package activities;

public class Task16 {
	public static void main(String[] args) {
		var gorilla = new Gorilla();
		System.out.println("Time to eat: " + gorilla.feed(true));
		gorilla.groom();
		gorilla.pet();
		gorilla.cage();
	}
}

interface Animal {
	boolean feed(boolean timeToEat);
	void groom();
	void pet();
	void cage();
}

class Gorilla implements Animal {
	
	@Override
	public boolean feed(boolean timeToEat) {
		return timeToEat;
	}
	
	@Override
	public void groom() {
		System.out.println("lather, rinse, repeat");
	}
	
	@Override
	public void pet() {
		System.out.println("pet at your own risk");
	}
	
	@Override
	public void cage() {
		System.out.println("put gorilla into cage");
	}
}
