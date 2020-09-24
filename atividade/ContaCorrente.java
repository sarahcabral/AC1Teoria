package atividade;

public class ContaCorrente {
    private int idConta;
    private double saldo;
    private double limEspecial;
    private String nome;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(final int idConta) {
        this.idConta = idConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(final double saldo) {
        this.saldo = saldo;
    }

    public double getLimEspecial() {
        return limEspecial;
    }

    public void setLimEspecial(final double limEspecial) {
        this.limEspecial = limEspecial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "ContaCorrente [idConta=" + idConta + ", limEspecial=" + limEspecial + ", nome=" + nome + ", saldo="
                + saldo + "]";
    }
}
