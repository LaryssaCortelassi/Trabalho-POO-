package br.unipar.central.services;

import br.unipar.central.dao.EnderecoDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.Endereco;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class EnderecoService {
    
    public void validar(Endereco endereco) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{

        if(endereco == null){
            throw new EntidadeNaoInformadaException("Endereco");
        }
            
        if(endereco.getLogradouro() == null || 
            endereco.getLogradouro().isBlank() ||
            endereco.getLogradouro().isEmpty()){
            throw new CampoNaoInformadoException("Logradouro");
        }       
        if(endereco.getLogradouro().length() > 120){
            throw new TamanhoCampoInvalidoException("Logradouro",120);
        }
        
        if(endereco.getBairro() == null || 
            endereco.getBairro().isBlank() ||
            endereco.getBairro().isEmpty()){
            throw new CampoNaoInformadoException("Bairro");
        }       
        if(endereco.getBairro().length() > 120){
            throw new TamanhoCampoInvalidoException("Bairro",120);
        }
        
        if(endereco.getComplemento() == null ||
                endereco.getComplemento().isBlank() ||
                endereco.getComplemento().isEmpty()){
            throw new CampoNaoInformadoException("Complemento");
        }
        if(endereco.getComplemento().length() > 20){
            throw new TamanhoCampoInvalidoException("Complemento", 20);
        }
        
        if(endereco.getNumero() == null ||
                endereco.getNumero().isBlank() ||
                endereco.getNumero().isEmpty()){
            throw new CampoNaoInformadoException("Numero");
        }
        if(endereco.getNumero().length() > 10){
            throw new TamanhoCampoInvalidoException("Numero", 10);
        }
        
        if(endereco.getCep() == null ||
                endereco.getCep().isBlank() ||
                endereco.getCep().isEmpty()){
            throw new CampoNaoInformadoException("Cep");
        }
        if(endereco.getCep().length() > 10){
            throw new TamanhoCampoInvalidoException("Cep", 10);
        } 
    }
    
    public List<Endereco> findAll() throws SQLException{
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        List<Endereco> resultado = enderecoDAO.findAll();
        
        return resultado;
    }
    
    public Endereco findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        
        Endereco retorno = enderecoDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um endereco com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Endereco endereco)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);
        
    }
    
    public void update(Endereco endereco) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(endereco);
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.update(endereco);
    
    }
    
    public void delete(int id) throws SQLException{
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.delete(id);
        
    }  
}
