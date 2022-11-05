package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CandidatoInterface extends Remote {
	public String getNome() throws RemoteException;
	public void setNome(String nome) throws RemoteException;
	public int getNumero() throws RemoteException;
	public void setNumero(int numero) throws RemoteException;
}
