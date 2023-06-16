package br.unipar.central.models;

/**
 *
 * @author Laly
 */
public class PessoaJuridica{
    
    private String razaoSocial;
    private String fantasia;
    private String cnpj;
    private String cnaePrincipal;
    private Pessoa pessoa;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String razaoSocial, String fantasia, String cnpj, String cnaePrincipal, Pessoa pessoa) {
        this.razaoSocial = razaoSocial;
        this.fantasia = fantasia;
        this.cnpj = cnpj;
        this.cnaePrincipal = cnaePrincipal;
        this.pessoa = pessoa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnaePrincipal() {
        return cnaePrincipal;
    }

    public void setCnaePrincipal(String cnaePrincipal) {
        this.cnaePrincipal = cnaePrincipal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "razaoSocial=" + razaoSocial + ", fantasia=" + fantasia + ", cnpj=" + cnpj + ", cnaePrincipal=" + cnaePrincipal + ", pessoa=" + pessoa + '}';
    }
}
