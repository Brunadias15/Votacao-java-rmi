package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IsEvenInterface extends Remote {
	public boolean is_even(int x) throws RemoteException;
}