package br.unipar.central.dao;

import br.unipar.central.models.Cidade;
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
public class CidadeDAO {
    
    private static final String INSERT = 
    "INSERT INTO cidade(id, nome, ra, estado_id) VALUES(?, ?, ?, ?)";
    
    private static final String FIND_BY_ID = 
    "SELECT id, nome, ra, estado_id FROM cidade WHERE id = ?";

    private static final String FIND_ALL = 
    "SELECT id, nome, ra, estado_id FROM cidade";
    
    private static final String UPDATE = 
    "UPDATE cidade SET nome = ?, RA = ?, estado_id = ? WHERE ID = ?";

    private static final String DELETE_BY_ID = 
    "DELETE FROM cidade WHERE id = ?";
    
    public List<Cidade> findAll() throws SQLException{
        
        ArrayList<Cidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setRa(rs.getString("RA"));
                cidade.setEstado(new EstadoDAO().findById(rs.getInt("ESTADO_ID")));
                
                retorno.add(cidade);
                
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
    
    public Cidade findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Cidade retorno = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Cidade();
               retorno.setId(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setRa(
                       rs.getString("RA"));
               retorno.setEstado(
                       new EstadoDAO().findById(rs.getInt("ESTADO_ID")));
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
    
    public void insert(Cidade cidade) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.setInt(4, cidade.getEstado().getId());
            
            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
    }
    
    public void update(Cidade cidade) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.setInt(4, cidade.getEstado().getId());
            
            
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
