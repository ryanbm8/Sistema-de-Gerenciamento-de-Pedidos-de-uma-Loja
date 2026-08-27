/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template cile, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Cliente;
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
public class ClienteDAO {
    protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
    public static List<Cliente> leTodos() throws Exception{
       List<Cliente> listCliente = new ArrayList<Cliente>();
        
       try{
           String sql = "SELECT * FROM Cliente";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           rs = st.executeQuery();
           
           while(rs.next()){
               Cliente c = new Cliente();
               
               
               c.setCpf(rs.getString("cpf"));
               c.setNome(rs.getString("nome"));
               c.setEmail(rs.getString("email"));
               c.setIdade(rs.getInt("idade"));
               c.setEndereco(rs.getString("endereco"));
               c.setTelefone(rs.getString("telefone"));
               c.setDataCadastro(rs.getString("dataCadastro"));
               
               
               listCliente.add(c);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listCliente;
    }
    
    public static List<Cliente> leTodosNotBetween(int n1, int n2) throws Exception{
       List<Cliente> listCliente = new ArrayList<Cliente>();
        
       try{
           String sql = "SELECT * FROM Cliente where idade not between ? and ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2, n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Cliente c = new Cliente();
     
               
               c.setCpf(rs.getString("cpf"));
               c.setNome(rs.getString("nome"));
               c.setEmail(rs.getString("email"));
               c.setIdade(rs.getInt("idade"));
               c.setEndereco(rs.getString("endereco"));
               c.setTelefone(rs.getString("telefone"));
               c.setDataCadastro(rs.getString("dataCadastro"));
               
               
               listCliente.add(c);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listCliente;
    }
    
    public static List<Cliente> leTodosLike(String n) throws Exception{
       List<Cliente> listCliente = new ArrayList<Cliente>();
        
       try{
           String sql = "SELECT * FROM Cliente where nome like ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setString(1, "%" + n + "%");
           rs = st.executeQuery();
           
           while(rs.next()){
               Cliente c = new Cliente();
               
               c.setCpf(rs.getString("cpf"));
               c.setNome(rs.getString("nome"));
               c.setEmail(rs.getString("email"));
               c.setIdade(rs.getInt("idade"));
               c.setEndereco(rs.getString("endereco"));
               c.setTelefone(rs.getString("telefone"));
               c.setDataCadastro(rs.getString("dataCadastro"));
               
               listCliente.add(c);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listCliente;
    }
    
    public static List<Cliente> leTodosIn(int n1, int n2) throws Exception{
       List<Cliente> listCliente = new ArrayList<Cliente>();
        
       try{
           String sql = "SELECT * FROM Cliente where idade in (?,?)";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2,n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Cliente c = new Cliente();
               
               c.setCpf(rs.getString("cpf"));
               c.setNome(rs.getString("nome"));
               c.setEmail(rs.getString("email"));
               c.setIdade(rs.getInt("idade"));
               c.setEndereco(rs.getString("endereco"));
               c.setTelefone(rs.getString("telefone"));
               c.setDataCadastro(rs.getString("dataCadastro"));
               
               listCliente.add(c);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listCliente;
    }
    
    public static Cliente leUm(String cpf) throws Exception{
        Cliente c = new Cliente();
        try{
            String sql = "SELECT * FROM Cliente where cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, cpf);
            
            rs = st.executeQuery();
            
            if(rs.next()){
               c.setCpf(rs.getString("cpf"));
               c.setNome(rs.getString("nome"));
               c.setEmail(rs.getString("email"));
               c.setIdade(rs.getInt("idade"));
               c.setEndereco(rs.getString("endereco"));
               c.setTelefone(rs.getString("telefone"));
               c.setDataCadastro(rs.getString("dataCadastro"));
            }
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return c;
    }
    
    public static int grava(Cliente Cliente) throws Exception{
        int ret = 0;
        try{
            String sql = "INSERT INTO Cliente(cpf,nome,idade,endereco,telefone,email, dataCadastro) VALUES (?,?,?,?,?,?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setString(1, Cliente.getCpf());
            st.setString(2, Cliente.getNome());
            st.setInt(3, Cliente.getIdade());
            st.setString(4, Cliente.getEndereco());
            st.setString(5, Cliente.getTelefone());
            st.setString(6, Cliente.getEmail());
            st.setString(7, Cliente.getDataCadastro());
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera(String nome, String cpf) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Cliente SET nome = ? where cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, nome);
            st.setString(2, cpf);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraNotIn(String data, int n1, int n2) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Cliente SET dataCadastro = ? where idade not in (?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, data);
            st.setInt(2, n1);
            st.setInt(3, n2);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraAnd(String n, int n1, String cpf) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Cliente SET nome = ? where idade = ? and cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, n);
            st.setInt(2, n1);
            st.setString(3, cpf);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    public static int exclui(String cpf) throws Exception{
        int ret = 0;
        try{
            String sql = "DELETE from Cliente where cpf = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, cpf);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
}
