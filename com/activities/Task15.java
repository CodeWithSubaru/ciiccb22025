package activities;

import java.lang.Math;

interface Shape {
	double calculateArea();
	double calculatePerimeter();
}

abstract class AbstractShape implements Shape {
	String color;
	
	public AbstractShape(String color) {
		this.color = color;
	}
	
	@Override
	public abstract double calculateArea();
	
	@Override
	public abstract double calculatePerimeter();
}

class Circle extends AbstractShape {
	private final double radius;
	
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {
		return Math.PI * radius * radius;
	}
	
	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}
	
	@Override
	public String toString() {
		return "Circle{" +
				       "color='" + color + '\'' +
				       ", radius=" + radius +
				       '}';
	}
}

class Rectangle extends AbstractShape {
	private final double length;
	private final double width;
	
	public Rectangle(String color, double length, double width) {
		super(color);
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double calculateArea() {
		return length * width;
	}
	
	@Override
	public double calculatePerimeter() {
		return 2 * (length + width);
	}
	
	@Override
	public String toString() {
		return "Rectangle{" +
				       "color='" + color + '\'' +
				       ", length=" + length +
				       ", width=" + width +
				       '}';
	}
}

public class Task15 {
	public static void main(String[] args) {
		
		for (Shape shape: new Shape[]{
				new Circle("Blue", 10.0),
				new Rectangle("Orange", 10.0, 6.0)}
		) {
			System.out.printf("\n%s\n", shape);
			System.out.printf("Area: %.2f \n", shape.calculateArea());
			System.out.printf("Perimeter: %.2f \n", shape.calculatePerimeter());
		}
	}
	
}
