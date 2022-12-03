public class ObjectDemo{
	public static void change(Customer customerA, String newName){
		customerA.setName(newName);
		System.out.print("\nIn change(), customerA:\n");
		System.out.println(customerA);
	}
	
	public static void changeOther(Customer customerB, String newName){
		customerB=new Customer(customerB);
		customerB.setName(newName);
		System.out.print("\nIn changeOther(), customerB:\n");
		System.out.println(customerB);	
	}
	
	public static void main(String[] args){
		Customer customer1=new Customer("Harry Potter", "(250) 123-4567", "123 Bogus Rd, London, BC B9D 8W1");
		System.out.println("In Main, customer1 is:\n"+customer1);
		
		change(customer1, "Mary Smith");
		System.out.print("\nIn main, after change(), customer1:\n");
		System.out.println(customer1);
		
		changeOther(customer1, "Sorting Hat");
		System.out.print("\nIn main, after changeOther(), customer1:\n");
		System.out.println(customer1);
	}
}
