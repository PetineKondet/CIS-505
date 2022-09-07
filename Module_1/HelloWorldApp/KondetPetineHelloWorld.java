/*  
    
    
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all
        rights reserved.
    
    Modified by Kondet Petine 2022
 
*/
public class KondetPetineHelloWorld {
 
    public static void myName(String firstName, String lastName) 
    {
       // String firstName = "Petine";
       // String lastName = "Kondet";
        String fullName = firstName + lastName;
        System.out.println("Hello World From "+ fullName);

        System.out.println(String.format("Hello World from %s %s", firstName, lastName));
    } // end myName
    public static void main(String[] args) 
    {
       myName(firstName:"Petine",lastName:"Kondet"); // Call the myName() method 
    } // end main
} // end KondetPetineHelloWorld 
