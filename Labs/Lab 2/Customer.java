public class Customer{
	private String name;
	private String phone;
	private String address;
	
	public Customer(){//default constructor
		name="";
		phone="";
		address="";
	}
	
	public Customer(String name, String phone_num, String address){
		this.name=name;
		phone=phone_num;
		this.address=address;	
	}
	
	public Customer(Customer other){//copy constructor
		name=other.name;
		phone=other.phone;
		address=other.address;	
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setPhone(String newPhone){
		phone=newPhone;
	}
	
	public void setAddress(String newAddress){
		address=newAddress;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String toString(){
		return name+"\n"+phone+"\n"+address;
	}
	//assume if the name and the phone number of the customer are the same, then they are the same equal.
	public boolean equals(Customer other){
		return name.equals(other.name) && phone.equals(other.phone);
	}
	
	public static void main(String[] args){
		Customer c1=new Customer();
		Customer c2=new Customer("Harry Potter", "(250) 123-4567", "123 Bogus Rd, London, BC B9D 8W1");
		
		System.out.println("The first customer:");
		System.out.println(c1);
		System.out.println("\nThe Second customer:");
		System.out.println(c2);
		
		System.out.println("\nThe first customer after set her name, address and phone:");
		c1.setName("Mary Smith");
		System.out.println(c1.getName());
		
		c1.setAddress("888 Ring Road, Argenta, BC V0G 1B0");
		System.out.println(c1.getAddress());
		
		c1.setPhone("(250) 234-5678");
		System.out.println(c1.getPhone());
		
		System.out.println("\nCompare the two customers above:");
		if (c1.equals(c2))
			System.out.println("The two customers are the same.");
		else
			System.out.println("The two customers are different.");
			
		c1.setName(c2.getName());
		c1.setPhone(c2.getPhone());
		
		System.out.println("\nCompare the two customers after changing the first one's name and phone to the second:");
		if (c1.equals(c2))
			System.out.println("The two customers are the same.");
		else
			System.out.println("The two customers are different.");
		
		System.out.println("\nTest copy constructor:");	
		Customer c3=new Customer(c2);
		System.out.println("c3 is: \n"+c3);
	}
}