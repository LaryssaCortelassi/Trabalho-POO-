package br.unipar.central.services;

import br.unipar.central.dao.AgenciaDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.Agencia;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class AgenciaService {
    
    public void validar(Agencia agencia) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(agencia == null){
            throw new EntidadeNaoInformadaException("Agencia");
        }
        
        if(agencia.getCodigo() == null ||
                agencia.getCodigo().isBlank() ||
                agencia.getCodigo().isEmpty()){
            throw new CampoNaoInformadoException("Codigo");
        }
        if(agencia.getCodigo().length() > 10){
            throw new TamanhoCampoInvalidoException("Codigo", 10);
        }

        if(agencia.getRazaoSocial() == null ||
                agencia.getRazaoSocial().isBlank() ||
                agencia.getRazaoSocial().isEmpty()){
            throw new CampoNaoInformadoException("RazaoSocial");
        }
        if(agencia.getRazaoSocial().length() > 120){
            throw new TamanhoCampoInvalidoException("RazaoSocial",120);
        }
        
        if(agencia.getCnpj() == null ||
                agencia.getCnpj().isBlank() ||
                agencia.getCnpj().isEmpty()){
            throw new CampoNaoInformadoException("Cnpj");
        }
        if(agencia.getCnpj().length() > 20){
            throw new TamanhoCampoInvalidoException("Cnpj",20);
        }

    }
    
    public List<Agencia> findAll() throws SQLException{
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        List<Agencia> resultado = agenciaDAO.findAll();
        
        return resultado;
    }
    
    public Agencia findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        
        Agencia retorno = agenciaDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um agencia com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Agencia agencia)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.insert(agencia);
        
    }
    
    public void update(Agencia agencia) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(agencia);
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.update(agencia);
    
    }
    
    public void delete(int id) throws SQLException{
        
        AgenciaDAO agenciaDAO = new AgenciaDAO();
        agenciaDAO.delete(id);
        
    }
}
