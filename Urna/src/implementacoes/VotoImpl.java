package implementacoes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VotoImpl extends UnicastRemoteObject {

    private static final long serialVersionUID = 1L;

    private CandidatoImpl candidato;
    private String identificador;

    public VotoImpl(String identificador, CandidatoImpl candidato) throws RemoteException {
        super();
        this.candidato = candidato;
        this.identificador = identificador;

    }

    public CandidatoImpl getCandidato() {
        return candidato;
    }

    public String getIdentificador() {
        return identificador;
    }
}
