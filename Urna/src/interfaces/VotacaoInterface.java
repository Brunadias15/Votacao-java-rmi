package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import implementacoes.CandidatoImpl;


public interface VotacaoInterface extends Remote {
	public List<CandidatoImpl> listarCandidatos() throws RemoteException;
	public int salvarVoto(int posicao) throws RemoteException;
	public int buscarCandidato(String numero) throws RemoteException;
	public void apuracao() throws RemoteException;
}
