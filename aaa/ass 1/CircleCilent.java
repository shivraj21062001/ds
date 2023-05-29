import java.rmi.*;
import java.util.Scanner;
public class CircleCilent {
    public static void main(String[] args){
    
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter radius :");
            int r = sc.nextInt();
            
            CircleInterface c = (CircleInterface) Naming.lookup("rmi://localhost/server");

            System.out.println("Area of Circle is "+c.area(r));
            System.out.println("Perimeter of Circle is "+c.perimeter(r));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
