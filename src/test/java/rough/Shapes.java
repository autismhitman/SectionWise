package rough;

public interface Shapes {
	
	double area();
	String info();
	
   default String print() {
	   
	   return "whats is this";
   }
   
   static void  printMethod()
   {
	   
	   System.out.println(" This is static method");
   }
}
