/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Entregador;
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
public class EntregadorDAO {
    protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
    public static List<Entregador> leTodos() throws Exception{
       List<Entregador> listEntregador = new ArrayList<Entregador>();
        
       try{
           String sql = "SELECT * FROM Entregador";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           rs = st.executeQuery();
           
           while(rs.next()){
               Entregador e = new Entregador();
               
               
               e.setMatricula(rs.getInt("matricula"));
               e.setNome(rs.getString("nome"));
               e.setEmail(rs.getString("email"));
               e.setEndereco(rs.getString("endereco"));
               e.setTelefone(rs.getString("telefone"));
               e.setVeiculo(rs.getString("Veiculo"));
               
               
               listEntregador.add(e);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listEntregador;
    }
    
    public static List<Entregador> leTodosNotBetween(int n1, int n2) throws Exception{
       List<Entregador> listEntregador = new ArrayList<Entregador>();
        
       try{
           String sql = "SELECT * FROM Entregador where matricula not between ? and ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2, n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Entregador e = new Entregador();
     
               
               e.setMatricula(rs.getInt("matricula"));
               e.setNome(rs.getString("nome"));
               e.setEmail(rs.getString("email"));
               e.setEndereco(rs.getString("endereco"));
               e.setTelefone(rs.getString("telefone"));
               e.setVeiculo(rs.getString("Veiculo"));
               
               
               listEntregador.add(e);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listEntregador;
    }
    
    public static List<Entregador> leTodosLike(String n) throws Exception{
       List<Entregador> listEntregador = new ArrayList<Entregador>();
        
       try{
           String sql = "SELECT * FROM Entregador where nome like ?";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setString(1, "%" + n + "%");
           rs = st.executeQuery();
           
           while(rs.next()){
               Entregador e = new Entregador();
     
               
               e.setMatricula(rs.getInt("matricula"));
               e.setNome(rs.getString("nome"));
               e.setEmail(rs.getString("email"));
               e.setEndereco(rs.getString("endereco"));
               e.setTelefone(rs.getString("telefone"));
               e.setVeiculo(rs.getString("Veiculo"));
               
               
               listEntregador.add(e);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listEntregador;
    }
    
    public static List<Entregador> leTodosIn(int n1, int n2) throws Exception{
       List<Entregador> listEntregador = new ArrayList<Entregador>();
        
       try{
           String sql = "SELECT * FROM Entregador where matricula in (?,?)";
           connection = GerenteDeConexao.getConnection();
           st = connection.prepareStatement(sql);
           st.setInt(1, n1);
           st.setInt(2,n2);
           rs = st.executeQuery();
           
           while(rs.next()){
               Entregador e = new Entregador();
     
               
               e.setMatricula(rs.getInt("matricula"));
               e.setNome(rs.getString("nome"));
               e.setEmail(rs.getString("email"));
               e.setEndereco(rs.getString("endereco"));
               e.setTelefone(rs.getString("telefone"));
               e.setVeiculo(rs.getString("Veiculo"));
               
               
               listEntregador.add(e);
           }
           st.close();
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
       return listEntregador;
    }
    
    public static Entregador leUm(int matricula) throws Exception{
        Entregador en = new Entregador();
        try{
            String sql = "SELECT * FROM Entregador where matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, matricula);
            
            rs = st.executeQuery();
            
            if(rs.next()){
               en.setMatricula(rs.getInt("matricula"));
               en.setNome(rs.getString("nome"));
               en.setEmail(rs.getString("email"));
               en.setEndereco(rs.getString("endereco"));
               en.setTelefone(rs.getString("telefone"));
               en.setVeiculo(rs.getString("Veiculo"));
            }
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return en;
    }
    
    public static int grava(Entregador Entregador) throws Exception{
        int ret = 0;
        try{
            String sql = "INSERT INTO Entregador(matricula,nome,endereco,telefone,email, Veiculo) VALUES (?,?,?,?,?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, Entregador.getMatricula());
            st.setString(2, Entregador.getNome());
            st.setString(3, Entregador.getEndereco());
            st.setString(4, Entregador.getTelefone());
            st.setString(5, Entregador.getEmail());
            st.setString(6, Entregador.getVeiculo());
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int altera(String nome, int matricula) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Entregador SET nome = ? where matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, nome);
            st.setInt(2, matricula);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraNotIn(String veiculo, int n1, int n2) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Entregador SET Veiculo = ? where matricula not in (?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, veiculo);
            st.setInt(2, n1);
            st.setInt(3, n2);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraAnd(String n, String nome, int matricula) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Entregador SET email = ? where nome = ? and matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, n);
            st.setString(2, nome);
            st.setInt(3, matricula);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    public static int exclui(int matricula) throws Exception{
        int ret = 0;
        try{
            String sql = "DELETE from Entregador where matricula = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setInt(1, matricula);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
}

