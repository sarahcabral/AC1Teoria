package atividade;

import java.util.ArrayList;

public class TesteContaCorrente {
    public static void main(final String[] args) {

        ArrayList<ContaCorrente> clientes = new ArrayList<ContaCorrente>();

        int op=0;
        int c = 16000;
        do
        {
            System.out.println("\n[1] Cadastrar nova conta corrente");
            System.out.println("\n[2] Depositar numa conta corrente");
            System.out.println("\n[3] Sacar dinheiro");
            System.out.println("\n[4] Checar Saldo");
            System.out.println("\n[5] Total de saldo do Banco");
            System.out.println("\n[6] Sair");

            switch(op)
            {
                case 1:
                    ContaCorrente cont = new ContaCorrente();
                    cont.setIdConta(c++);
                    cont.setSaldo(0);

                    clientes.add(cont);
                    
            }


        }while(op != 6);

    }
}
