/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Sobremesa;
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
public class SobremesaDAO {
    protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
    public static List<Sobremesa> leTodos() throws Exception{
       List<Sobremesa> listSobremesa = new ArrayList<Sobremesa>();
        
       try{
           String sql = "SELECT * FROM Sobremesa";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           rs = st.executeQuery();
           
           while(rs.next()){
               Sobremesa s = new Sobremesa();
               
               s.setCodigo(rs.getInt("codigo"));
               s.setNome(rs.getString("nome"));
               s.setPreco(rs.getFloat("preco"));
               s.setSabor(rs.getString("sabor"));
               s.setPeso(rs.getFloat("Peso"));
               s.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               listSobremesa.add(s);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listSobremesa;
    }
    
    public static List<Sobremesa> leTodosNotBetween(int n1, int n2) throws Exception{
       List<Sobremesa> listSobremesa = new ArrayList<Sobremesa>();
        
       try{
           String sql = "SELECT * FROM Sobremesa where codigo not between ? and ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2, n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Sobremesa s = new Sobremesa();
     
               s.setCodigo(rs.getInt("codigo"));
               s.setNome(rs.getString("nome"));
               s.setPreco(rs.getFloat("preco"));
               s.setSabor(rs.getString("sabor"));
               s.setPeso(rs.getFloat("Peso"));
               s.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               
               listSobremesa.add(s);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listSobremesa;
    }
    
    public static List<Sobremesa> leTodosLike(String n) throws Exception{
       List<Sobremesa> listSobremesa = new ArrayList<Sobremesa>();
        
       try{
           String sql = "SELECT * FROM Sobremesa where nome like ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setString(1, "%" + n + "%");
           rs = st.executeQuery();
           
           while(rs.next()){
               Sobremesa s = new Sobremesa();
     
               
               s.setCodigo(rs.getInt("codigo"));
               s.setNome(rs.getString("nome"));
               s.setPreco(rs.getFloat("preco"));
               s.setSabor(rs.getString("sabor"));
               s.setPeso(rs.getFloat("Peso"));
               s.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               listSobremesa.add(s);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listSobremesa;
    }
    
    public static List<Sobremesa> leTodosIn(int n1, int n2) throws Exception{
       List<Sobremesa> listSobremesa = new ArrayList<Sobremesa>();
        
       try{
           String sql = "SELECT * FROM Sobremesa where codigo in (?,?)";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2,n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Sobremesa s = new Sobremesa();
     
               
               s.setCodigo(rs.getInt("codigo"));
               s.setNome(rs.getString("nome"));
               s.setPreco(rs.getFloat("preco"));
               s.setSabor(rs.getString("sabor"));
               s.setPeso(rs.getFloat("Peso"));
               s.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
               
               listSobremesa.add(s);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listSobremesa;
    }
    
    public static Sobremesa leUm(int codigo) throws Exception{
        Sobremesa s = new Sobremesa();
        try{
            String sql = "SELECT * FROM Sobremesa where codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, codigo);
            
            rs = st.executeQuery();
            
            if(rs.next()){

               s.setCodigo(rs.getInt("codigo"));
               s.setNome(rs.getString("nome"));
               s.setPreco(rs.getFloat("preco"));
               s.setSabor(rs.getString("sabor"));
               s.setPeso(rs.getFloat("Peso"));
               s.setFornecedor(FornecedorDAO.leUm(rs.getString("Fornecedor_cnpj")));
               
            }
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return s;
    }
    
    public static int grava(Sobremesa Sobremesa) throws Exception{
        int ret = 0;
        try{
            String sql = "INSERT INTO Sobremesa(codigo, nome, preco, sabor, peso, Fornecedor_cnpj)"
                    + "VALUES (?,?,?,?,?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Sobremesa.getCodigo());
            st.setString(2, Sobremesa.getNome());
            st.setFloat(3, Sobremesa.getPreco());
            st.setString(4, Sobremesa.getSabor());
            st.setFloat(5, Sobremesa.getPeso());
            st.setString(6, Sobremesa.getFornecedor().getCnpj());
            
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
            String sql = "UPDATE Sobremesa SET nome = ? where codigo = ?";
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
    
    public static int alteraNotIn(String sabor, int n1, int n2) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Sobremesa SET sabor = ? where codigo not in (?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, sabor);
            st.setInt(2, n1);
            st.setInt(3, n2);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraAnd(float peso, String nome, int codigo) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Sobremesa SET Peso = ? where nome = ? and codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setFloat(1, peso);
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
            String sql = "DELETE from Sobremesa where codigo = ?";
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
