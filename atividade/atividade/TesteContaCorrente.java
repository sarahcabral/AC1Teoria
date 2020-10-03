package atividade;

import java.util.ArrayList;
import java.util.Scanner;

public class TesteContaCorrente 
{
    public static void main(final String[] args) {

        ArrayList<ContaCorrente> clientes = new ArrayList<ContaCorrente>();

        int op = 0, c = 16000, a, i=0;
        Scanner s = new Scanner(System.in);
        do
        {
            System.out.println(i++ + " Esse");
            System.out.println("\n[1] Cadastrar nova conta corrente");
            System.out.println("[2] Depositar numa conta corrente");
            System.out.println("[3] Sacar dinheiro");
            System.out.println("[4] Checar Saldo");
            System.out.println("[5] Total de saldo do Banco");
            System.out.println("[6] Sair");

            op = (Integer.parseInt(s.nextLine()));
            System.out.println("opop");

            switch(op)
            {
                case 1:
                    ContaCorrente cont = new ContaCorrente();
                    cont.setIdConta(c++);
                    cont.setSaldo(0);
                    System.out.println("\nNome completo: ");
                    cont.setNome(s.nextLine());
                    System.out.println("Quanto de Limite Especial: ");
                    cont.setLimEspecial(Double.parseDouble(s.nextLine()));
                    clientes.add(cont);
                    break;
                case 2:
                    System.out.println("\nConta para Deposito: ");
                    a = (Integer.parseInt(s.nextLine()));
                    verifica(a, clientes);
                    System.out.println("cheguei");
                    break;

            }
            System.out.println(op);
            
        }while(op != 6);
        
        s.close();

    }


    public static void verifica(int t, ArrayList<ContaCorrente> clientes) {
        double aux;
        int a=0;
        Scanner n = new Scanner(System.in);
        for(ContaCorrente contaa : clientes)
        {
            if(contaa.getIdConta() == t)
            {
                System.out.println("Qual valor deseja depositar: ");
                aux = (Double.parseDouble(n.nextLine()));   //Não considera a hipotese do usuaria inserir um valor negativo
                contaa.setSaldo(contaa.getSaldo()+aux);
                a=1;
                System.out.println("Deposito feito com sucesso!");
            }
        }
        if(a==0)
        {
            System.out.println("\n----Conta não encontrada, tente novamente mais tarde");
        }
        n.close();
    }

}


