package Eleicao;

import static Eleicao.Servidor.candidatos;
import static Eleicao.Servidor.votacaoImpl;
import implementacoes.VotacaoImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorApuracao {

    static int portaApuracao = 8081;

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            //IsEvenImpl x = new IsEvenImpl();
            String objNameServ = "rmi://localhost:" + portaApuracao + "/server";

            System.out.println("Registrando o objeto no RMIRegistry...");
            LocateRegistry.createRegistry(portaApuracao);

            votacaoImpl = new VotacaoImpl(candidatos);

            Naming.rebind(objNameServ, votacaoImpl);
            //Naming.rebind(objName, x);

            System.out.println("Aguardando Clientes na porta " + portaApuracao + "!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
