package br.unipar.central.services;

import br.unipar.central.dao.PessoaDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.Pessoa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class PessoaService {
    
    public void validar(Pessoa pessoa) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(pessoa == null){
            throw new EntidadeNaoInformadaException("Pessoa");
        }
            
        if(pessoa.getEmail() == null || 
            pessoa.getEmail().isBlank() ||
            pessoa.getEmail().isEmpty()){
            throw new CampoNaoInformadoException("Email");
        }
        if(pessoa.getEmail().length() > 120){
            throw new TamanhoCampoInvalidoException("Email",120);
        }
    } 
    
    public List<Pessoa> findAll() throws SQLException{
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> resultado = pessoaDAO.findAll();
        
        return resultado;
    }
    
    public Pessoa findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        Pessoa retorno = pessoaDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar uma pessoa com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Pessoa pessoa)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.insert(pessoa);
        
    }
    
    public void update(Pessoa pessoa) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(pessoa);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.update(pessoa);
    
    }
    
    public void delete(int id) throws SQLException{
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.delete(id);
        
    }   
}
