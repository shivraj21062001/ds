import java.rmi.*;

public interface CircleInterface extends Remote{
    public double area(int radius) throws RemoteException;
    public double perimeter(int radius) throws RemoteException;
}