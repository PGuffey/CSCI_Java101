package Shape;

	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;

	interface ComparableType<T> {
	  int compareTo(T other);
	}

	abstract class Shape implements ComparableType<Shape> {

	  public abstract double area();

	  public abstract String whatAmI();

	  @Override
	  public int compareTo(Shape other) {
	    if (this.area() < other.area()) {
	      return -1;
	    } else if (this.area() > other.area()) {
	      return 1;
	    } else {
	      return 0;
	    }
	  }
	}

	class Square extends Shape {

	  private double side;

	  public Square() {}

	  public Square(double side) {
	    this.side = side;
	  }

	  public double getSide() {
	    return side;
	  }

	  public void setSide(double side) {
	    this.side = side;
	  }

	  @Override
	  public double area() {
	    return side * side;
	  }

	  @Override
	  public String whatAmI() {
	    return "Square";
	  }
	}

	class Circle extends Shape {

	  private double radius;

	  public Circle() {}

	  public Circle(double radius) {
	    this.radius = radius;
	  }

	  public double getRadius() {
	    return radius;
	  }

	  public void setRadius(double radius) {
	    this.radius = radius;
	  }

	  @Override
	  public double area() {
	    return Math.PI * radius * radius;
	  }

	  @Override
	  public String whatAmI() {
	    return "Circle";
	  }
	}

