package br.unipar.central.services;

import br.unipar.central.dao.EstadoDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.Estado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class EstadoService {
    
    public void validar(Estado estado) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(estado == null){
            throw new EntidadeNaoInformadaException("Estado");
        }
        
        if(estado.getNome() == null || 
            estado.getNome().isBlank() ||
            estado.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        }
        if(estado.getNome().length() > 58){
            throw new TamanhoCampoInvalidoException("Nome",58);
        }  
        
        if(estado.getSigla() == null ||
                estado.getSigla().isBlank() ||
                estado.getSigla().isEmpty()){
            throw new CampoNaoInformadoException("Sigla");
        }
        if(estado.getSigla().length() > 2){
            throw new TamanhoCampoInvalidoException("Sigla", 2);
        } 
    }
    
    public List<Estado> findAll() throws SQLException{
        
        EstadoDAO estadoDAO = new EstadoDAO();
        List<Estado> resultado = estadoDAO.findAll();
        
        return resultado;
    }
    
    public Estado findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        EstadoDAO estadoDAO = new EstadoDAO();
        
        Estado retorno = estadoDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um estado com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Estado estado)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.insert(estado);
        
    }
    
    public void update(Estado estado) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(estado);
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.update(estado);
    
    }
    
    public void delete(int id) throws SQLException{
        
        EstadoDAO estadoDAO = new EstadoDAO();
        estadoDAO.delete(id);
        
    }   
}

