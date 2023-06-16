package br.unipar.central.services;

import br.unipar.central.dao.PessoaJuridicaDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.PessoaJuridica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class PessoaJuridicaService {
    
    public void validar(PessoaJuridica pessoaJuridica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(pessoaJuridica == null){
            throw new EntidadeNaoInformadaException("PessoaJuridica");
        }
        
        if(pessoaJuridica.getCnpj() == null || 
            pessoaJuridica.getCnpj().isBlank() ||
            pessoaJuridica.getCnpj().isEmpty()){
            throw new CampoNaoInformadoException("Cnpj");
        }
        
        if(pessoaJuridica.getCnpj().length() > 20){
            throw new TamanhoCampoInvalidoException("Cnpj",20);
        }
        
        if(pessoaJuridica.getRazaoSocial() == null || 
            pessoaJuridica.getRazaoSocial().isBlank() ||
            pessoaJuridica.getRazaoSocial().isEmpty()){
            throw new CampoNaoInformadoException("RazaoSocial");
        }
        
        if(pessoaJuridica.getRazaoSocial().length() > 120){
            throw new TamanhoCampoInvalidoException("RazaoSocial",120);
        }
        
        if(pessoaJuridica.getCnaePrincipal() == null || 
            pessoaJuridica.getCnaePrincipal().isBlank() ||
            pessoaJuridica.getCnaePrincipal().isEmpty()){
            throw new CampoNaoInformadoException("CnaePrincipal");
        }
        
        if(pessoaJuridica.getCnaePrincipal().length() > 9){
            throw new TamanhoCampoInvalidoException("CnaePrincipal",9);
        }
        
        if(pessoaJuridica.getFantasia() == null || 
            pessoaJuridica.getFantasia().isBlank() ||
            pessoaJuridica.getFantasia().isEmpty()){
            throw new CampoNaoInformadoException("Fantasia");
        }
        
        if(pessoaJuridica.getFantasia().length() > 120){
            throw new TamanhoCampoInvalidoException("Fantasia",120);
        } 
    }
    
    public List<PessoaJuridica> findAll() throws SQLException{
        
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        List<PessoaJuridica> resultado = pessoaJuridicaDAO.findAll();
        
        return resultado;
    }
    
    public PessoaJuridica findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        
        PessoaJuridica retorno = pessoaJuridicaDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um pessoaJuridica com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(PessoaJuridica pessoaJuridica)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.insert(pessoaJuridica);
        
    }
    
    public void update(PessoaJuridica pessoaJuridica) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(pessoaJuridica);
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.update(pessoaJuridica);
    
    }
    
    public void delete(int id) throws SQLException{
        
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        pessoaJuridicaDAO.delete(id);
        
    }   
}
