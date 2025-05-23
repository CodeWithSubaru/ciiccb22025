package activities;
import static java.lang.Math.*;


public class Task9 {
		
	public static int add(int a, int b) {
		return addExact(a, b);
	}
	
	public static int subtract(int a, int b) {
		return subtractExact(a, b);
		
	}
	
	public static int multiply(int a, int b) {
		return multiplyExact(a, b);
	}
	
	public static float divide(int a, int b) {
		return floorDiv(a, b);
	}
	
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(add(a, b));
		System.out.println(subtract(a, b));
		System.out.println(multiply(a, b));
		System.out.println(divide(a, b));
	}

}
