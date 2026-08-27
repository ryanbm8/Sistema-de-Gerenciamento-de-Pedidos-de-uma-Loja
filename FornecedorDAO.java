/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class FornecedorDAO {
    protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
    public static List<Fornecedor> leTodos() throws Exception{
       List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();
        
       try{
           String sql = "SELECT * FROM Fornecedor";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           rs = st.executeQuery();
           
           while(rs.next()){
               Fornecedor f = new Fornecedor();
               
               f.setCnpj(rs.getString("cnpj"));
               f.setNome(rs.getString("nome"));
               f.setNumeroContrato(rs.getInt("numeroContrato"));
               
               listFornecedor.add(f);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listFornecedor;
    }
    
    public static List<Fornecedor> leTodosNotBetween(int n1, int n2) throws Exception{
       List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();
        
       try{
           String sql = "SELECT * FROM Fornecedor where numeroContrato not between ? and ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2, n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Fornecedor f = new Fornecedor();
     
               f.setCnpj(rs.getString("cnpj"));
               f.setNome(rs.getString("nome"));
               f.setNumeroContrato(rs.getInt("numeroContrato"));
               
               listFornecedor.add(f);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listFornecedor;
    }
    
    public static List<Fornecedor> leTodosLike(String n) throws Exception{
       List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();
        
       try{
           String sql = "SELECT * FROM Fornecedor where nome like ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setString(1, "%" + n + "%");
           rs = st.executeQuery();
           
           while(rs.next()){
               Fornecedor f = new Fornecedor();
               
               f.setCnpj(rs.getString("cnpj"));
               f.setNome(rs.getString("nome"));
               f.setNumeroContrato(rs.getInt("numeroContrato"));
               
               listFornecedor.add(f);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listFornecedor;
    }
    
    public static List<Fornecedor> leTodosIn(int n1, int n2) throws Exception{
       List<Fornecedor> listFornecedor = new ArrayList<Fornecedor>();
        
       try{
           String sql = "SELECT * FROM Fornecedor where numeroContrato in (?,?)";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2,n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Fornecedor f = new Fornecedor();
               
               f.setCnpj(rs.getString("cnpj"));
               f.setNome(rs.getString("nome"));
               f.setNumeroContrato(rs.getInt("numeroContrato"));
               
               listFornecedor.add(f);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listFornecedor;
    }
    
    public static Fornecedor leUm(String cnpj) throws Exception{
        Fornecedor f = new Fornecedor();
        try{
            String sql = "SELECT * FROM Fornecedor where cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cnpj);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                f.setCnpj(rs.getString("cnpj"));
                f.setNome(rs.getString("nome"));
                f.setNumeroContrato(rs.getInt("numeroContrato"));
            }
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return f;
    }
    
    public static int grava(Fornecedor fornecedor) throws Exception{
        int ret = 0;
        try{
            String sql = "INSERT INTO Fornecedor(cnpj,nome, numeroContrato) VALUES (?,?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, fornecedor.getCnpj());
            st.setString(2, fornecedor.getNome());
            st.setInt(3, fornecedor.getNumeroContrato());
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera(String nome, String cnpj) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Fornecedor SET nome = ? where cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, nome);
            st.setString(2, cnpj);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraNotIn(String nome, int n1, int n2) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Fornecedor SET nome = ? where numeroContrato not in (?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, nome);
            st.setInt(2, n1);
            st.setInt(3, n2);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraAnd(String n, int n1, String cnpj) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Fornecedor SET nome = ? where numeroContrato = ? and cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, n);
            st.setInt(2, n1);
            st.setString(3, cnpj);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    public static int exclui(String cnpj) throws Exception{
        int ret = 0;
        try{
            String sql = "DELETE from Fornecedor where cnpj = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, cnpj);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
}
