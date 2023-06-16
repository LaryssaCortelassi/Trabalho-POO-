package br.unipar.central.models;

/**
 *
 * @author Laly
 */
public class Banco extends Abstract{
    
    private String nome;

    public Banco() {
    }

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Banco{" + "id=" + getId() + "nome=" + nome + ", ra=" + getRa() + '}';
    }    
}
