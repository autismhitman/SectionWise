package rough;

public class Square extends Shape{
    
	double side;
	
	public Square(String color, double side) {
		super(color);
		this.side= side;
		
	}

	@Override
	double area() {
		 
		return Math.pow(side, 2);
	}

	@Override
	String info() {
		 
		return " Area is " + area();
	}
	
	
		 
     
}
