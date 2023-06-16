package br.unipar.central.dao;

import br.unipar.central.models.PessoaJuridica;
import br.unipar.central.util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laly
 */
public class PessoaJuridicaDAO {
    
    private static final String INSERT = 
    "INSERT INTO pessoajuridica(razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id) VALUES(?, ?, ?, ?, ?)";
    
    private static final String FIND_BY_ID = 
    "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica WHERE cnpj = ? ";

    private static final String FIND_ALL = 
    "SELECT razaosocial, cnpj, cnaeprincipal, fantasia, pessoa_id FROM pessoajuridica ";
    
    private static final String UPDATE = 
    "UPDATE pessoajuridica SET razaosocial = ?, cnaeprincipal = ?, fantasia = ?, pessoa_id = ? WHERE cnpj = ?";

    private static final String DELETE_BY_ID = 
    "DELETE FROM pessoajuridica WHERE cnpj = ?";
    
     public List<PessoaJuridica> findAll() throws SQLException {
        
        ArrayList<PessoaJuridica> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = new DataBase().getConnection();
            
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                
                pessoaJuridica.setCnpj(rs.getString("CNPJ"));
                pessoaJuridica.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                pessoaJuridica.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
                pessoaJuridica.setFantasia(rs.getString("FANTASIA"));
                pessoaJuridica.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                
                retorno.add(pessoaJuridica);
                
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null) 
                conn.close();
        }
        
        return retorno;
        
    }
    
    public PessoaJuridica findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PessoaJuridica retorno = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                retorno = new PessoaJuridica();
                retorno.setCnpj(rs.getString("CNPJ"));
                retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                retorno.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
                retorno.setFantasia(rs.getString("FANTASIA"));
                retorno.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
            
        }
        
        return retorno;
        
    }
    
    public void insert(PessoaJuridica pessoaJuridica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pessoaJuridica.getCnpj());
            pstmt.setString(2, pessoaJuridica.getRazaoSocial());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(5, pessoaJuridica.getPessoa().getId());
            
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(PessoaJuridica pessoaJuridica) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pessoaJuridica.getCnpj());
            pstmt.setString(2, pessoaJuridica.getRazaoSocial());
            pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
            pstmt.setString(4, pessoaJuridica.getFantasia());
            pstmt.setInt(4, pessoaJuridica.getPessoa().getId());
            
            pstmt.executeUpdate();
            
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    
    public void delete(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        
    }
}
