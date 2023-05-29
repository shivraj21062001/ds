import java.rmi.*;

public class CircleServer {
    public static void main(String[] args) {
        
        try {
            CircleImp ci = new CircleImp();

            Naming.rebind("server", ci); 


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
