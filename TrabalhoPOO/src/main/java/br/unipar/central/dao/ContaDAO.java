package br.unipar.central.dao;

import br.unipar.central.enums.TipoContaEnum;
import br.unipar.central.models.Conta;
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
public class ContaDAO {
    
    private static final String INSERT = 
    "INSERT INTO conta(id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id) VALUES(?, ?, ?, ?, ?::INTEGER, ?, ?, ?)";

    private static final String FIND_BY_ID = 
    "SELECT id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id FROM conta WHERE id = ? ";
    
    private static final String FIND_ALL = 
    "SELECT id, numero, digito, saldo, tipo, ra, agencia_id, pessoa_id FROM conta ";

    private static final String UPDATE = 
    "UPDATE conta SET  numero = ?, digito = ?, saldo = ?, tipo = ?, ra = ?, agencia_id = ?, pessoa_id = ? WHERE id = ?";

    private static final String DELETE_BY_ID = 
    "DELETE FROM conta WHERE id = ?";
    
     public List<Conta> findAll() throws SQLException{
        ArrayList<Conta> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{          
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){                
                Conta conta = new Conta();
                
                conta.setId(rs.getInt("ID"));
                conta.setRa(rs.getString("RA"));
                conta.setNumero(rs.getString("NUMERO"));
                conta.setTipoConta(TipoContaEnum.valueOf(rs.getString("TIPO")));
                conta.setDigito(rs.getInt("DIGITO"));
                conta.setSaldo(rs.getDouble("SALDO"));
                conta.setAgencia(new AgenciaDAO().findById(rs.getInt("AGENCIA_ID")));
                conta.setPessoa(new PessoaDAO().findById(rs.getInt("PESSOA_ID")));
                
                retorno.add(conta);   
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
    
    public Conta findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Conta retorno = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Conta(); 
               
               retorno.setId(rs.getInt("ID"));
               retorno.setRa(rs.getString("RA"));
               retorno.setNumero(rs.getString("NUMERO"));
               retorno.setTipoConta(TipoContaEnum.valueOf(rs.getString("TIPO")));
               retorno.setDigito(rs.getInt("DIGITO"));
               retorno.setSaldo(rs.getDouble("SALDO"));
               retorno.setAgencia(new AgenciaDAO().findById(rs.getInt("AGENCIA_ID")));
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
    
    public void insert(Conta conta) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getRa());
            pstmt.setString(3, conta.getNumero());
            pstmt.setString(4, conta.getTipoConta().name());
            pstmt.setDouble(5, conta.getSaldo());
            pstmt.setInt(6, conta.getAgencia().getId());
            pstmt.setInt(7, conta.getPessoa().getId());

            pstmt.executeUpdate();   
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
    }
        
        public void update(Conta conta) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new DataBase().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, conta.getId());
            pstmt.setString(2, conta.getRa());
            pstmt.setString(3, conta.getNumero());
            pstmt.setString(4, conta.getTipoConta().name());
            pstmt.setDouble(5, conta.getSaldo());
            pstmt.setInt(6, conta.getAgencia().getId());
            pstmt.setInt(7, conta.getPessoa().getId());
            
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

