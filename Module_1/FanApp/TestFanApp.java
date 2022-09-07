/*
Create a new file named TestFanApp with a main() method to test the Fan class. Create
two instances of the Fan class, one using the default constructor and the other using the
argument constructor. For the second argument constructor, use the classes constants to
set the speed. Display the objects by invoking the classes toString() method. 

By Petine Kondet
*/

public class TestFanApp {  
	public static void main(String[] args) {
  
	  Fan fan1 = new Fan();
	  Fan fan2= new Fan(true,Fan.FAST,15.0,"Red");
	  
	  System.out.println(fan1.toString());
	  System.out.println(fan2.toString());
	}
  }
