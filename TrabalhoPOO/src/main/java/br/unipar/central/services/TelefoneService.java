package br.unipar.central.services;

import br.unipar.central.dao.TelefoneDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.Telefone;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class TelefoneService {
    
    public void validar(Telefone telefone) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(telefone == null){
            throw new EntidadeNaoInformadaException("Endereco");
        }
            
        if(telefone.getNumero() == null || 
            telefone.getNumero().isBlank() ||
            telefone.getNumero().isEmpty()){
            throw new CampoNaoInformadoException("Numero");
        }
        if(telefone.getNumero().length() > 11){
            throw new TamanhoCampoInvalidoException("Numero",11);
        }
        
        if(telefone.getOperadora() == null || 
            String.valueOf(telefone.getOperadora()).isBlank() ||
            String.valueOf(telefone.getOperadora()).isEmpty()){
            throw new CampoNaoInformadoException("Operadora");
        }
    }
    
    public List<Telefone> findAll() throws SQLException{
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        List<Telefone> resultado = telefoneDAO.findAll();
        
        return resultado;
    }
    
    public Telefone findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        
        Telefone retorno = telefoneDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um telefone com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Telefone telefone)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.insert(telefone);
        
    }
    
    public void update(Telefone telefone) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(telefone);
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.update(telefone);
    
    }
    
    public void delete(int id) throws SQLException{
        
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        telefoneDAO.delete(id);
        
    }    
}
