/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Bebida;
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
public class BebidaDAO {
 protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
    public static List<Bebida> leTodos() throws Exception{
       List<Bebida> listBebida = new ArrayList<Bebida>();
        
       try{
           String sql = "SELECT * FROM Bebida";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           rs = st.executeQuery();
           
           while(rs.next()){
               Bebida b = new Bebida();
               
               b.setCodigo(rs.getInt("codigo"));
               b.setNome(rs.getString("nome"));
               b.setPreco(rs.getFloat("preco"));
               b.setVolume(rs.getInt("volume"));
               b.setAlcoolica(rs.getString("alcoolica"));
               b.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               listBebida.add(b);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listBebida;
    }
    
    public static List<Bebida> leTodosNotBetween(int n1, int n2) throws Exception{
       List<Bebida> listBebida = new ArrayList<Bebida>();
        
       try{
           String sql = "SELECT * FROM Bebida where codigo not between ? and ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2, n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Bebida b = new Bebida();
     
               b.setCodigo(rs.getInt("codigo"));
               b.setNome(rs.getString("nome"));
               b.setPreco(rs.getFloat("preco"));
               b.setVolume(rs.getInt("volume"));
               b.setAlcoolica(rs.getString("alcoolica"));
               b.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               
               listBebida.add(b);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listBebida;
    }
    
    public static List<Bebida> leTodosLike(String n) throws Exception{
       List<Bebida> listBebida = new ArrayList<Bebida>();
        
       try{
           String sql = "SELECT * FROM Bebida where nome like ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setString(1, "%" + n + "%");
           rs = st.executeQuery();
           
           while(rs.next()){
               Bebida b = new Bebida();
     
               
               b.setCodigo(rs.getInt("codigo"));
               b.setNome(rs.getString("nome"));
               b.setPreco(rs.getFloat("preco"));
               b.setVolume(rs.getInt("volume"));
               b.setAlcoolica(rs.getString("alcoolica"));
               b.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               listBebida.add(b);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listBebida;
    }
    
    public static List<Bebida> leTodosIn(int n1, int n2) throws Exception{
       List<Bebida> listBebida = new ArrayList<Bebida>();
        
       try{
           String sql = "SELECT * FROM Bebida where codigo in (?,?)";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2,n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Bebida b = new Bebida();
     
               
               b.setCodigo(rs.getInt("codigo"));
               b.setNome(rs.getString("nome"));
               b.setPreco(rs.getFloat("preco"));
               b.setVolume(rs.getInt("volume"));
               b.setAlcoolica(rs.getString("alcoolica"));
               b.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               listBebida.add(b);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listBebida;
    }
    
    public static Bebida leUm(int codigo) throws Exception{
        Bebida b = new Bebida();
        try{
            String sql = "SELECT * FROM Bebida where codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigo);
            
            rs = st.executeQuery();
            
            if(rs.next()){

               b.setCodigo(rs.getInt("codigo"));
               b.setNome(rs.getString("nome"));
               b.setPreco(rs.getFloat("preco"));
               b.setVolume(rs.getInt("volume"));
               b.setAlcoolica(rs.getString("alcoolica"));
               b.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
            }
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return b;
    }
    
    public static int grava(Bebida Bebida) throws Exception{
        int ret = 0;
        try{
            String sql = "INSERT INTO Bebida(codigo, nome, preco, volume, alcoolica, Fornecedor_cnpj)"
                    + "VALUES (?,?,?,?,?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Bebida.getCodigo());
            st.setString(2, Bebida.getNome());
            st.setFloat(3, Bebida.getPreco());
            st.setInt(4, Bebida.getVolume());
            st.setString(5, Bebida.getAlcoolica());
            st.setString(6, Bebida.getFornecedor().getCnpj());
            
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
            String sql = "UPDATE Bebida SET nome = ? where codigo = ?";
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
    
    public static int alteraNotIn(String volume, int n1, int n2) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Bebida SET Volume = ? where codigo not in (?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, volume);
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
            String sql = "UPDATE Bebida SET alcoolica = ? where nome = ? and codigo = ?";
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
            String sql = "DELETE from Bebida where codigo = ?";
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
