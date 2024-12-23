package rough;

public class AbstractRunner {

	public static void main(String[] args) {
		 
		Shape  c = new Circle("Red", 5);
		System.out.println(c.info());
		 
		  c = new Square("Red", 5);
		System.out.println(c.info());
		
		
		Shapes  e  = new Circles("Red", 5);
		System.out.println(e.info());
		
		e  = new Squares("Red", 5);
		System.out.println(e.info());
        System.out.println(e.print());
         
        Shapes.printMethod();
	}

}
