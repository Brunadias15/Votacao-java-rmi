package Eleicao;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import implementacoes.CandidatoImpl;
import implementacoes.VotacaoImpl;
import interfaces.VotacaoInterface;

public class Servidor {

    static List<CandidatoImpl> candidatos;
    static VotacaoInterface votacaoImpl;
    static int porta = 1099;
    static int portaApuracao = 8081;

    public static void main(String[] args) {
        try {

            String objNameApura = "rmi://localhost:" + portaApuracao + "/server";
            VotacaoInterface votacao = (VotacaoInterface) Naming.lookup(objNameApura);
            String objName = "rmi://localhost:" + porta + "/server";

            System.out.println("Registrando o objeto no RMIRegistry...");
            LocateRegistry.createRegistry(porta);

            // Lista de Candidatos
            candidatos = new ArrayList<>();
            candidatos.add(new CandidatoImpl(1, "1 Hulk"));
            candidatos.add(new CandidatoImpl(2, "2 Viúva Negra"));
            candidatos.add(new CandidatoImpl(3, "3 Pantera Negra"));
            candidatos.add(new CandidatoImpl(4, "4 Dr Estranho"));
            candidatos.add(new CandidatoImpl(5, "5 Homem Aranha"));
            candidatos.add(new CandidatoImpl(6, "6 Thor"));
            candidatos.add(new CandidatoImpl(7, "7 Homem de Ferro"));

            votacaoImpl = new VotacaoImpl(candidatos);

            Naming.rebind(objName, votacaoImpl);
            //Naming.rebind(objName, x);

            System.out.println("Servidor " + porta + "!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
