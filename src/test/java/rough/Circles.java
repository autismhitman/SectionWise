package rough;

public class Circles implements Shapes {
    
	String color;
	double radius;
	
	public Circles( String color, double radius) {
		this.color = color;
		this.radius= radius;
		
	}
	
	@Override
	public double area() {
	 
		return Math.PI * Math.pow(radius,2);
	}

	@Override
	public String info() {
		 
		return "Area is " + area();
	}
	
	

}
