package br.unipar.central.models;

/**
 *
 * @author Laly
 */
public class Pessoa extends Abstract{
    
    private String email;

    public Pessoa() {
    }

    public Pessoa(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + getId() + "email=" + email + ", ra=" + getRa() + '}';
    }
}
