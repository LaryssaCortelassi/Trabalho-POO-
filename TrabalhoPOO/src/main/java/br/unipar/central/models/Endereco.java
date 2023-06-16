package br.unipar.central.models;

/**
 *
 * @author Laly
 */
public class Endereco extends Abstract {
    
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String complemento;
    private Cidade cidade;
    private Pessoa pessoa;

    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String bairro, String cep, String complemento, Cidade cidade, Pessoa pessoa) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + getId() + "logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", complemento=" + complemento + ", ra=" + getRa() + ", cidade=" + cidade + ", pessoa=" + pessoa + '}';
    }
}
