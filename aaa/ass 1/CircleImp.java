import java.rmi.*;
import java.rmi.server.*;

public class CircleImp extends UnicastRemoteObject implements CircleInterface{
    
    public CircleImp()throws RemoteException{

    }
    public double area(int radius) throws RemoteException{
        double pi = 3.14;
        return pi*radius*radius;
    }
    public double perimeter(int radius) throws RemoteException{
        double pi = 3.14;
        return pi*2*radius;
    }
}
