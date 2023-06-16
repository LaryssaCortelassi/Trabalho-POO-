package br.unipar.central.models;

import br.unipar.central.enums.TipoTransacaoEnum;
import java.sql.Timestamp;//É utilizada para armazenar e manipular informações de data e hora em bancos de dados relacionais.

/**
 *
 * @author Laly
 */
public class Transacao extends Abstract{
    
    private Timestamp datahora;
    private double valor;
    private TipoTransacaoEnum tipo;
    private int conta_origem;
    private int conta_destino;

    public Transacao() {
    }

    public Transacao(Timestamp datahora, double valor, TipoTransacaoEnum tipo, int conta_origem, int conta_destino) {
        this.datahora = datahora;
        this.valor = valor;
        this.tipo = tipo;
        this.conta_origem = conta_origem;
        this.conta_destino = conta_destino;
    }

    public Timestamp getDatahora() {
        return datahora;
    }

    public void setDatahora(Timestamp datahora) {
        this.datahora = datahora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }

    public int getConta_origem() {
        return conta_origem;
    }

    public void setConta_origem(int conta_origem) {
        this.conta_origem = conta_origem;
    }

    public int getConta_destino() {
        return conta_destino;
    }

    public void setConta_destino(int conta_destino) {
        this.conta_destino = conta_destino;
    }

    @Override
    public String toString() {
        return "Transacao{" + "id=" + getId() + "datahora=" + datahora + ", valor=" + valor + ", tipo=" + tipo + ", ra=" + getRa() + ", conta_origem=" + conta_origem + ", conta_destino=" + conta_destino + '}';
    }    
}
