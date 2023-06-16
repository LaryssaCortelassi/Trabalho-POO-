package br.unipar.central.models;

import br.unipar.central.enums.TipoContaEnum;

/**
 *
 * @author Laly
 */
public class Conta extends Abstract{
    
    private String numero;
    private int digito;
    private double saldo;
    private TipoContaEnum tipoConta;
    private Agencia agencia;
    private Pessoa pessoa;

    public Conta() {
    }

    public Conta(String numero, int digito, double saldo, TipoContaEnum tipoConta, Agencia agencia, Pessoa pessoa) {
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.pessoa = pessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Conta{" + "id=" + getId() + "numero=" + numero + ", digito=" + digito + ", saldo=" + saldo + ", tipoConta=" + tipoConta + ", ra=" + getRa() + ", agencia=" + agencia + ", pessoa=" + pessoa + '}';
    }
}