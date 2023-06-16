package br.unipar.central.services;


import br.unipar.central.dao.BancoDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.Banco;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class BancoService {
    
    public void validar(Banco banco) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(banco == null){
            throw new EntidadeNaoInformadaException("Banco");
        }
        if(banco.getNome() == null ||
                banco.getNome().isBlank() ||
                banco.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        } 
        if(!(banco.getNome().length() == 120)){
            throw new TamanhoCampoInvalidoException("Nome", 120);
        }
    }  
    
    
    public List<Banco> findAll() throws SQLException{
        
        BancoDAO bancoDAO = new BancoDAO();
        List<Banco> resultado = bancoDAO.findAll();
        
        return resultado;
    }
    
    public Banco findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        BancoDAO bancoDAO = new BancoDAO();
        
        Banco retorno = bancoDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar um banco com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(Banco banco)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.insert(banco);
        
    }
    
    public void update(Banco banco) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(banco);
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.update(banco);
    
    }
    
    public void delete(int id) throws SQLException{
        
        BancoDAO bancoDAO = new BancoDAO();
        bancoDAO.delete(id);
        
    }
}
