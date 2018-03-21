package demo;

public class testclass {
//create the function which accepts two inputs one is int and string..no return.. get the input and printit
	//create three functions which has same name diffrent arguments
	//changing the class name to method name - constructor
	//if the class name and method same that will be called constructor
	//if there are no arguments and return type it will run the dafult consturctor
	
	
	public static void main(String[] args) {
		
		testclass tc = new testclass();
		testclass("xyz", 123);
		testclass("abc","def");
		testclass(123,456);
	
	}
	public static void testclass(String obj1, int obj2) {
	
		try {
			
			System.out.println("String value is "  + obj1 + " Integer value is " + obj2);
		}catch (Exception e) {
			e.getMessage();
		}}
		
		public static void testclass(String obj1, String obj3) {
			
			try {
				
				System.out.println("String value is " +obj1+" String value is " +obj3);
			}catch (Exception e) {
				e.getMessage();
			}	
		
		
	}

public static void testclass(int obj4, int obj5) {
	
	try {
		
		System.out.println("Integer value is " +obj4+" Interger value is " +obj5);
	}catch (Exception e) {
		e.getMessage();
	}	
}
	
	public  testclass() {
		try {
			System.out.println("constructor");
		}catch (Exception e) {
			e.getMessage();
	}

}}
