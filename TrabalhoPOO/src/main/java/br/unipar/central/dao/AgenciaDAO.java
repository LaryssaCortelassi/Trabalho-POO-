package br.unipar.central.dao;

import br.unipar.central.models.Agencia;
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
public class AgenciaDAO {
    
    private static final String INSERT = 
    "INSERT INTO agencia(id, codigo, digito, razaosocial, cnpj, ra, banco_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
    
    private static final String FIND_BY_ID = 
    "SELECT id, codigo, digito, razaosocial, cnpj, ra, banco_id FROM agencia WHERE id = ? ";
    
    private static final String FIND_ALL = 
    "SELECT id, codigo, digito, razaosocial, cnpj, ra , banco_id FROM agencia ";
    
    private static final String UPDATE = 
    "UPDATE agencia SET codigo = ?, digito = ?, razaosocial = ?, cnpj = ?, ra = ?, banco_id = ? WHERE ID = ?";
    
    private static final String DELETE_BY_ID = 
    "DELETE FROM agencia WHERE id = ?";
    
    public List<Agencia> findAll() throws SQLException{
        ArrayList<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{          
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){                
                Agencia agencia = new Agencia();
                
                agencia.setId(rs.getInt("ID"));
                agencia.setRa(rs.getString("RA"));
                agencia.setCodigo(rs.getString("CODIGO"));
                agencia.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                agencia.setCnpj(rs.getString("CNPJ"));
                agencia.setBanco(new BancoDAO().findById(rs.getInt("BANCO_ID")));
                
                retorno.add(agencia);   
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
    
    public Agencia findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Agencia retorno = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Agencia(); 
               
               retorno.setId(rs.getInt("ID"));
               retorno.setRa(rs.getString("RA"));
               retorno.setCodigo(rs.getString("CODIGO"));
               retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
               retorno.setCnpj(rs.getString("CNPJ"));
               retorno.setBanco(new BancoDAO().findById(rs.getInt("BANCO_ID")));
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
    
    public void insert(Agencia agencia) throws SQLException {

        Connection conn = null; // conecção BDD
        PreparedStatement pstmt = null; // enviar comandos

        try {

            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getDigito());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getCnpj());
            pstmt.setString(6, agencia.getRa());
            pstmt.setInt(7, agencia.getBanco().getId());

            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public void update(Agencia agencia) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getRa());
            pstmt.setString(3, agencia.getCodigo());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getCnpj());
            pstmt.setInt(6, agencia.getBanco().getId());
            
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
