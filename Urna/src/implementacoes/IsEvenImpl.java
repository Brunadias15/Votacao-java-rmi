package implementacoes;

import java.rmi.server.UnicastRemoteObject;
import interfaces.IsEvenInterface;
import java.rmi.RemoteException;

public class IsEvenImpl extends UnicastRemoteObject implements IsEvenInterface {

    public IsEvenImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean is_even(int x) throws RemoteException {
		System.out.println("Conectado. Parâmetro enviado é " + x);
		if((x & 1) == 0) {
			return true;
		} else {
			return false;
		}	
	}
}