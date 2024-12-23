package rough;

public class Squares implements Shapes {
    
	String color;
	double side;
	
	public Squares( String color, double side) {
		this.color = color;
		this.side= side;
		
	}
	
	@Override
	public double area() {
	 
		return  Math.pow(side,2);
	}

	@Override
	public String info() {
		 
		return "Area is " + area();
	}
	
}
