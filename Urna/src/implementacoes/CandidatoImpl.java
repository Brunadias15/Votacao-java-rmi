package implementacoes;

import java.io.Serializable;
import java.rmi.RemoteException;

import interfaces.CandidatoInterface;

public class CandidatoImpl implements CandidatoInterface, Serializable {

    private static final long serialVersionUID = 6717433396141724642L;
    private String nome;
    private int numero;

    public CandidatoImpl(int numero, String nome) throws RemoteException {
        super();
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
