package br.unipar.central.services;

import br.unipar.central.dao.PessoaFisicaDAO;
import br.unipar.central.exception.CampoNaoInformadoException;
import br.unipar.central.exception.EntidadeNaoInformadaException;
import br.unipar.central.exception.TamanhoCampoInvalidoException;
import br.unipar.central.models.PessoaFisica;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Beatr
 */
public class PessoaFisicaService {
    
    public void validar(PessoaFisica pessoaFisica) throws EntidadeNaoInformadaException, CampoNaoInformadoException, TamanhoCampoInvalidoException{
        
        if(pessoaFisica == null){
            throw new EntidadeNaoInformadaException("PessoaFisica");
        }
            
        if(pessoaFisica.getNome() == null || 
            pessoaFisica.getNome().isBlank() ||
            pessoaFisica.getNome().isEmpty()){
            throw new CampoNaoInformadoException("Nome");
        }       
        if(pessoaFisica.getNome().length() > 120){
            throw new TamanhoCampoInvalidoException("Nome",120);
        }
        
        if(pessoaFisica.getCpf() == null || 
            pessoaFisica.getCpf().isBlank() ||
            pessoaFisica.getCpf().isEmpty()){
            throw new CampoNaoInformadoException("Cpf");
        }        
        if(pessoaFisica.getCpf().length() > 20){
            throw new TamanhoCampoInvalidoException("Cpf",20);
        }
        
        if(pessoaFisica.getRg() == null || 
            pessoaFisica.getRg().isBlank() ||
            pessoaFisica.getRg().isEmpty()){
            throw new CampoNaoInformadoException("Rg");
        }        
        if(pessoaFisica.getRg().length() > 20){
            throw new TamanhoCampoInvalidoException("Rg",20);
        }
        
        if(pessoaFisica.getDataNascimento() == null ||
           new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pessoaFisica.getDataNascimento()).isBlank() ||
           new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pessoaFisica.getDataNascimento()).isEmpty()){
            throw new CampoNaoInformadoException("DtNascimento");
        } 
    }
    
    public List<PessoaFisica> findAll() throws SQLException{
        
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        List<PessoaFisica> resultado = pessoaFisicaDAO.findAll();
        
        return resultado;
    }
    
    public PessoaFisica findById(int id) throws SQLException, TamanhoCampoInvalidoException, Exception{
        
        if(id <= 0)
            throw new TamanhoCampoInvalidoException("id", 1);
        
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        
        PessoaFisica retorno = pessoaFisicaDAO.findById(id);
        
        if(retorno == null)
            throw new Exception("Não foi possível encontrar uma pessoaFisica com o id " + id + " informado.");
        
        return retorno;
        
    }
    
    public void insert(PessoaFisica pessoaFisica)throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.insert(pessoaFisica);
        
    }
    
    public void update(PessoaFisica pessoaFisica) throws SQLException, 
            EntidadeNaoInformadaException, 
            CampoNaoInformadoException, 
            TamanhoCampoInvalidoException{
        
        validar(pessoaFisica);
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.update(pessoaFisica);
    
    }
    
    public void delete(int id) throws SQLException{
        
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        pessoaFisicaDAO.delete(id);
        
    }   
}
