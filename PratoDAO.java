/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Prato;
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
public class PratoDAO {
    protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
    public static List<Prato> leTodos() throws Exception{
       List<Prato> listPrato = new ArrayList<Prato>();
        
       try{
           String sql = "SELECT * FROM Prato";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           rs = st.executeQuery();
           
           while(rs.next()){
               Prato p = new Prato();
               
               p.setCodigo(rs.getInt("codigo"));
               p.setNome(rs.getString("nome"));
               p.setPreco(rs.getFloat("preco"));
               p.setDescricao(rs.getString("descricao"));
               p.setTipo(rs.getString("tipo"));
               p.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               listPrato.add(p);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listPrato;
    }
    
    public static List<Prato> leTodosNotBetween(int n1, int n2) throws Exception{
       List<Prato> listPrato = new ArrayList<Prato>();
        
       try{
           String sql = "SELECT * FROM Prato where codigo not between ? and ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2, n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Prato p = new Prato();
     
               p.setCodigo(rs.getInt("codigo"));
               p.setNome(rs.getString("nome"));
               p.setPreco(rs.getFloat("preco"));
               p.setDescricao(rs.getString("descricao"));
               p.setTipo(rs.getString("tipo"));
               p.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               
               listPrato.add(p);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listPrato;
    }
    
    public static List<Prato> leTodosLike(String n) throws Exception{
       List<Prato> listPrato = new ArrayList<Prato>();
        
       try{
           String sql = "SELECT * FROM Prato where nome like ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setString(1, "%" + n + "%");
           rs = st.executeQuery();
           
           while(rs.next()){
               Prato p = new Prato();
     
               
               p.setCodigo(rs.getInt("codigo"));
               p.setNome(rs.getString("nome"));
               p.setPreco(rs.getFloat("preco"));
               p.setDescricao(rs.getString("descricao"));
               p.setTipo(rs.getString("tipo"));
               p.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               listPrato.add(p);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listPrato;
    }
    
    public static List<Prato> leTodosIn(int n1, int n2) throws Exception{
       List<Prato> listPrato = new ArrayList<Prato>();
        
       try{
           String sql = "SELECT * FROM Prato where codigo in (?,?)";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2,n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Prato p = new Prato();
     
               
               p.setCodigo(rs.getInt("codigo"));
               p.setNome(rs.getString("nome"));
               p.setPreco(rs.getFloat("preco"));
               p.setDescricao(rs.getString("descricao"));
               p.setTipo(rs.getString("tipo"));
               p.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               listPrato.add(p);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listPrato;
    }
    
    public static Prato leUm(int codigo) throws Exception{
        Prato p = new Prato();
        try{
            String sql = "SELECT * FROM Prato where codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigo);
            
            rs = st.executeQuery();
            
            if(rs.next()){

               p.setCodigo(rs.getInt("codigo"));
               p.setNome(rs.getString("nome"));
               p.setPreco(rs.getFloat("preco"));
               p.setDescricao(rs.getString("descricao"));
               p.setTipo(rs.getString("tipo"));
               p.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
            }
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return p;
    }
    
    public static int grava(Prato Prato) throws Exception{
        int ret = 0;
        try{
            String sql = "INSERT INTO Prato(codigo, nome, preco, descricao, tipo, Fornecedor_cnpj)"
                    + "VALUES (?,?,?,?,?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Prato.getCodigo());
            st.setString(2, Prato.getNome());
            st.setFloat(3, Prato.getPreco());
            st.setString(4, Prato.getDescricao());
            st.setString(5, Prato.getTipo());
            st.setString(6, Prato.getFornecedor().getCnpj());
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera(String nome, int codigo) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Prato SET nome = ? where codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, nome);
            st.setInt(2, codigo);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraNotIn(String descricao, int n1, int n2) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Prato SET descricao = ? where codigo not in (?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, descricao);
            st.setInt(2, n1);
            st.setInt(3, n2);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraAnd(String n, String nome, int codigo) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Prato SET tipo = ? where nome = ? and codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, n);
            st.setString(2, nome);
            st.setInt(3, codigo);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    public static int exclui(int codigo) throws Exception{
        int ret = 0;
        try{
            String sql = "DELETE from Prato where codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setInt(1, codigo);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
}

