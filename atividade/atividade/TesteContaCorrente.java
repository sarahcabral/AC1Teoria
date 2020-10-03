package atividade;

import java.util.ArrayList;
import java.util.Scanner;


public class TesteContaCorrente 
{
    public static void main(final String[] args) {

        ArrayList<ContaCorrente> clientes = new ArrayList<ContaCorrente>();
        
        int op, c = 16000, a;
        Scanner s = new Scanner(System.in);
        do
        {
            System.out.println("\n[1] Cadastrar nova conta corrente");
            System.out.println("[2] Depositar numa conta corrente");
            System.out.println("[3] Sacar dinheiro");
            System.out.println("[4] Checar Saldo");
            System.out.println("[5] Total de saldo do Banco");
            System.out.println("[6] Sair\n");

            op = (Integer.parseInt(s.nextLine()));

            switch(op)
            {
                case 1:
                    ContaCorrente cont = new ContaCorrente();
                    cont.setIdConta(c++);
                    cont.setSaldo(0);
                    cont.setLimEspecial(2000);
                    System.out.println("\nNome completo: ");
                    cont.setNome(s.nextLine());
                    System.out.println("Id da sua conta corrente: "+ cont.getIdConta());
                    System.out.println("Saldo: "+ cont.getSaldo());
                    System.out.println("Limite Especial: "+ cont.getLimEspecial());
                    clientes.add(cont);
                    break;
                case 2:
                    System.out.println("\nId da conta para Deposito: ");
                    a = (Integer.parseInt(s.nextLine()));
                    deposita(a, clientes, s);
                    break;
                case 3:
                    System.out.println("\nId da conta para Saque: ");
                    a = (Integer.parseInt(s.nextLine()));
                    saque(a, clientes, s);
                    break;
                case 4:
                    System.out.println("Id da conta para consulta: ");
                    a = (Integer.parseInt(s.nextLine()));
                    consulta(a, clientes);
                    break;
                case 5:
                    if(c==16000)
                    {
                        System.out.println("Nenhuma conta corrente cadrastada");
                        break;
                    }                
                    somatorio(clientes);
                    break;
            }
            
        }while(op != 6);
        
        s.close();

    }

    private static void somatorio(ArrayList<ContaCorrente> clientes) {
        double soma=0;
        int i=0;

        System.out.println("----Somatorio do Saldo----");
        System.out.println("\n-clientes que não usaram o limite especial-");
        for(ContaCorrente contaa : clientes)
        {
            if(contaa.getLimEspecial() == 2000)
            {
                soma += contaa.getSaldo();
                i++;
            }
        }
        System.out.println("\nSaldo total: " + soma);
        if(i==0)
        {
            System.out.println("Todos os clientes utilizaram o Limite Especial");
        }
    }

    private static void consulta(int t, ArrayList<ContaCorrente> clientes) {
        
        for(ContaCorrente contaa : clientes)
        {
            if(contaa.getIdConta() == t)
            {
                System.out.println("\nSaldo: "+ contaa.getSaldo());
                System.out.println("\nLimite Especial: " + contaa.getLimEspecial());
                return;
            }
        }
        System.out.println("\n----Conta não encontrada - Operação cancelada");
        return;
    }

    public static void deposita(int t, ArrayList<ContaCorrente> clientes, Scanner n) {
        double aux;

        for(ContaCorrente contaa : clientes)
        {
            if(contaa.getIdConta() == t)
            {
                System.out.println("Qual valor deseja depositar: ");
                aux = (Double.parseDouble(n.nextLine()));   //Não considera a hipotese do usuaria inserir um valor negativo
                contaa.getSaldo();
                if((contaa.getSaldo()+aux)<=0)
                {
                    contaa.setLimEspecial(contaa.getLimEspecial()+aux);
                }
                else if((contaa.getSaldo()+aux)>0){
                    contaa.setLimEspecial(2000);
                }
                contaa.setSaldo(contaa.getSaldo()+aux);
                System.out.println("Deposito feito com sucesso!");
                return;
            }
        }
        System.out.println("\n----Conta não encontrada - Operação Cancelada");
        return;
    }

    public static void saque(int t, ArrayList<ContaCorrente> clientes, Scanner n) {
        double aux, b, c;
        int a;

        for(ContaCorrente contaa : clientes)
        {
            if(contaa.getIdConta() == t)
            {
                System.out.println("Qual valor deseja sacar: ");
                aux = (Double.parseDouble(n.nextLine()));   //Não considera a hipotese do usuaria inserir um valor negativo
                a = ver_saldo(aux, contaa);
                switch(a)
                {
                    case 1:
                        contaa.setSaldo(contaa.getSaldo()-aux);
                        System.out.println("Saque feito com sucesso!");
                        System.out.println(contaa.getSaldo());
                        break;
                    case 2:
                        System.out.println("Limite insufuciente!");
                        break;
                    case 3:
                        b = contaa.getLimEspecial();
                        c = contaa.getSaldo();
                        contaa.setSaldo(c-aux);
                        contaa.setLimEspecial(c+b-aux);
                        System.out.println("Saque feito com sucesso!");
                        break;
                    
                }
                return;
            }
        }
        System.out.println("\n----Conta não encontrada - Operação cancelada");
        return;
    }
    public static int ver_saldo(Double valor, ContaCorrente c) {
        int a = 0;
        if((c.getSaldo()-valor) >= 0)
            a = 1;      //Utiliza somente o saldo
        else if((c.getSaldo() - valor + c.getLimEspecial()) < 0)
            a = 2;      //Não permetido
        else if((c.getSaldo() - valor + c.getLimEspecial())>=0)
            a = 3;      //Utiliza o Limite Especial
        System.out.println(a);
        return a;
    }

}
