package br.unipar.central.dao;

import br.unipar.central.models.Endereco;
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
public class EnderecoDAO {
    
    private static final String INSERT = 
    "INSERT INTO endereco(id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_BY_ID = 
    "SELECT id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id FROM endereco WHERE id = ? ";
    
    private static final String FIND_ALL = 
    "SELECT id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id FROM endereco ";
    
    private static final String UPDATE = 
    "UPDATE endereco SET logradouro = ?, numero = ?, bairro = ?, cep = ?, complemento = ?, ra = ?, pessoa_id = ?, cidade_id = ? WHERE id = ?";

    private static final String DELETE_BY_ID = 
    "DELETE FROM endereco WHERE id = ?";
    
    public List<Endereco> findAll() throws SQLException{
        ArrayList<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{          
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){                
                Endereco endereco = new Endereco();
                
                endereco.setId(rs.getInt("ID"));
                endereco.setRa(rs.getString("RA"));
                endereco.setLogradouro(rs.getString("LOGRADOURO"));
                endereco.setNumero(rs.getString("NUMERO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setCep(rs.getString("CEP"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));    
                endereco.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                endereco.setCidade(new CidadeDAO().findById(rs.getInt("CIDADE_ID")));
               
                retorno.add(endereco);   
            }          
        }finally{            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null) 
                conn.close();       
        }   
        return retorno;
    }
    
    public Endereco findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Endereco(); 
               
               retorno.setId(rs.getInt("ID"));
               retorno.setRa(rs.getString("RA"));
               retorno.setLogradouro(rs.getString("LOGRAOUDRO"));
               retorno.setNumero(rs.getString("NUMERO"));
               retorno.setBairro(rs.getString("BAIRRO"));
               retorno.setCep(rs.getString("CEP"));
               retorno.setComplemento(rs.getString("COMPLEMENTO"));
               retorno.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
               retorno.setCidade(new CidadeDAO().findById(rs.getInt("CIDADE_ID")));
               
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
    
    public void insert(Endereco endereco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getRa());
            pstmt.setString(3, endereco.getLogradouro());
            pstmt.setString(4, endereco.getNumero());
            pstmt.setString(5, endereco.getBairro());
            pstmt.setString(6, endereco.getCep());
            pstmt.setString(7, endereco.getComplemento());
            pstmt.setInt(8, endereco.getPessoa().getId());
            pstmt.setInt(9, endereco.getCidade().getId());

            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
        
        public void update(Endereco endereco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, endereco.getId());
            pstmt.setString(2, endereco.getRa());
            pstmt.setString(3, endereco.getLogradouro());
            pstmt.setString(4, endereco.getNumero());
            pstmt.setString(5, endereco.getBairro());
            pstmt.setString(6, endereco.getCep());
            pstmt.setString(7, endereco.getComplemento());
            pstmt.setInt(8, endereco.getPessoa().getId());
            pstmt.setInt(9, endereco.getCidade().getId());
            
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
