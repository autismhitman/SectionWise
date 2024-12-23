package rough;

public class EmpRunner {

	public static void main(String[] args) {
	  
		Employee pemp = new PermanentEmp();
		 
		System.out.println(pemp.getSalary());
		
		Employee cemp = new ContractEmp();
		 
		System.out.println(cemp.getSalary());

	}

}
