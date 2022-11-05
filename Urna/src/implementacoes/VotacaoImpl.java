package implementacoes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import interfaces.VotacaoInterface;
import java.net.InetAddress;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VotacaoImpl extends UnicastRemoteObject implements VotacaoInterface {

    private static final long serialVersionUID = 1L;
    private List<CandidatoImpl> candidatos;
    private List<VotoImpl> votos = new ArrayList<>();
    private Map<Integer, Integer> quantidade = new HashMap<>();
    int totalVotos = 0;
    int pos = 0;

    public VotacaoImpl(List<CandidatoImpl> candidatos) throws RemoteException {
        super();
        this.candidatos = candidatos;
    }

    @Override
    public List<CandidatoImpl> listarCandidatos() throws RemoteException {
        return this.candidatos;
    }

    @Override
    public int salvarVoto(int posicao) throws RemoteException {

        String ip = null;
        String[] ips = new String[10];

        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (java.net.UnknownHostException ex) {

            Logger.getLogger(VotacaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        ips[pos] = ip;

        if (totalVotos < 1) {
            this.votos.add(new VotoImpl("123", this.candidatos.get(posicao)));
            totalVotos++;
            pos++;
            return posicao;

        } else {
            for (int i = 0; i <= totalVotos; i++) {
                if (ip != null) {
                    System.out.println("voto não confirmado por que esse ip já votou");

                    return 0;
                } else {
                    this.votos.add(new VotoImpl("123", this.candidatos.get(posicao)));
                    totalVotos++;
                    pos++;
                    return posicao;
                }
            }
        }
        return 0;
    }

    @Override
    public void apuracao() {

        this.votos.forEach(voto -> {
            int count = (int) votos.stream().filter(p -> p.getCandidato().equals(voto.getCandidato())).count();
            quantidade.put(voto.getCandidato().getNumero(), count);
        });

        final String format = "O candidato %d possui %d votos";
        final Set<Integer> chaves = quantidade.keySet();
        System.out.println("Apuração dos votos");
        for (final Integer chave : chaves) {
            System.out.println(String.format(format, chave, quantidade.get(chave)));
            float porcentagem;

            porcentagem = (float) ((quantidade.get(chave) * 100 / totalVotos));

            System.out.println(porcentagem + " %");
        }
    }

    @Override
    public int buscarCandidato(String numero) throws RemoteException {
        for (int i = 0; i < this.candidatos.size(); i++) {
            if (this.candidatos.get(i).getNumero() == Integer.parseInt(numero)) {
                return this.salvarVoto(i);
            }
        }

        return -1;
    }

}
