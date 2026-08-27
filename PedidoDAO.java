/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PedidoDAO {
    protected static Connection connection;
    protected static PreparedStatement st;
    protected static ResultSet rs;
    
    public static int grava(Pedido pedido) throws Exception{
        int ret = 0;
        try{
            String sql = "Insert into Pedido(codigo,data,status,total,Entregador_matricula,"
                    + "Cliente_cpf,Bebida_codigo,Prato_codigo,Sobremesa_codigo)"
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setInt(1, pedido.getCodigo());
            
            st.setString(2, pedido.getData());
            
            st.setString(3, pedido.getStatus());
            
            st.setFloat(4, pedido.getTotal());
            
            st.setInt(5, pedido.getEntregador().getMatricula());
            
            st.setString(6, pedido.getCliente().getCpf());
            
            st.setInt(7, pedido.getBebida().getCodigo());
            
            st.setInt(8, pedido.getPrato().getCodigo());
            
            st.setInt(9, pedido.getSobremesa().getCodigo());
            
            ret = st.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getCause());
        }
        return ret;
    }
    
    public static List<Pedido> leTodos() throws Exception{
         List<Pedido> listPedido = new ArrayList<Pedido>();
         try{
             String sql = "Select * from Pedido";
             connection = GerenteDeConexao.getConnection();
             st = connection.prepareStatement(sql);
             rs = st.executeQuery();
             
             while(rs.next()){
                Pedido p = new Pedido();
                
                p.setCodigo(rs.getInt("codigo"));
                p.setData(rs.getString("data"));
                p.setStatus(rs.getString("status"));
                p.setTotal(rs.getFloat("total"));
                p.setEntregador(EntregadorDAO.leUm(rs.getInt("Entregador_matricula")));
                p.setBebida(BebidaDAO.leUm(rs.getInt("Bebida_codigo")));
                p.setCliente(ClienteDAO.leUm(rs.getString("Cliente_cpf")));
                p.setPrato(PratoDAO.leUm(rs.getInt("Prato_codigo")));
                p.setSobremesa(SobremesaDAO.leUm(rs.getInt("Sobremesa_codigo")));
                
                listPedido.add(p);
             }
             st.close();
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
         return listPedido;
    }
    
    public static List<Pedido> leTodosIn(int n1, int n2) throws Exception{
         List<Pedido> listPedido = new ArrayList<Pedido>();
         try{
             String sql = "Select * from Pedido where codigo in (?,?)";
             connection = GerenteDeConexao.getConnection();
             st = connection.prepareStatement(sql);
             st.setInt(1, n1);
             st.setInt(2, n2);
             rs = st.executeQuery();
             
             while(rs.next()){
                Pedido p = new Pedido();
                
                p.setCodigo(rs.getInt("codigo"));
                p.setData(rs.getString("data"));
                p.setStatus(rs.getString("status"));
                p.setTotal(rs.getFloat("total"));
                p.setEntregador(EntregadorDAO.leUm(rs.getInt("Entregador_matricula")));
                p.setBebida(BebidaDAO.leUm(rs.getInt("Bebida_codigo")));
                p.setCliente(ClienteDAO.leUm(rs.getString("Cliente_cpf")));
                p.setPrato(PratoDAO.leUm(rs.getInt("Prato_codigo")));
                p.setSobremesa(SobremesaDAO.leUm(rs.getInt("Sobremesa_codigo")));
                
                listPedido.add(p);
             }
             st.close();
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
         return listPedido;
    }
    public static List<Pedido> leTodosLike(String status) throws Exception{
         List<Pedido> listPedido = new ArrayList<Pedido>();
         try{
             String sql = "Select * from Pedido where status = ?";
             connection = GerenteDeConexao.getConnection();
             st = connection.prepareStatement(sql);
             st.setString(1, status);
             rs = st.executeQuery();
             
             while(rs.next()){
                Pedido p = new Pedido();
                
                p.setCodigo(rs.getInt("codigo"));
                p.setData(rs.getString("data"));
                p.setStatus(rs.getString("status"));
                p.setTotal(rs.getFloat("total"));
                p.setEntregador(EntregadorDAO.leUm(rs.getInt("Entregador_matricula")));
                p.setBebida(BebidaDAO.leUm(rs.getInt("Bebida_codigo")));
                p.setCliente(ClienteDAO.leUm(rs.getString("Cliente_cpf")));
                p.setPrato(PratoDAO.leUm(rs.getInt("Prato_codigo")));
                p.setSobremesa(SobremesaDAO.leUm(rs.getInt("Sobremesa_codigo")));
                
                listPedido.add(p);
             }
             st.close();
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
         return listPedido;
    }
    
    public static List<Pedido> leTodosNotBetween(int n1, int n2) throws Exception{
         List<Pedido> listPedido = new ArrayList<Pedido>();
         try{
             String sql = "Select * from Pedido where codigo not between ? and ?";
             connection = GerenteDeConexao.getConnection();
             st = connection.prepareStatement(sql);
             st.setInt(1, n1);
             st.setInt(2, n2);
             rs = st.executeQuery();
             
             while(rs.next()){
                Pedido p = new Pedido();
                
                p.setCodigo(rs.getInt("codigo"));
                p.setData(rs.getString("data"));
                p.setStatus(rs.getString("status"));
                p.setTotal(rs.getFloat("total"));
                p.setEntregador(EntregadorDAO.leUm(rs.getInt("Entregador_matricula")));
                p.setBebida(BebidaDAO.leUm(rs.getInt("Bebida_codigo")));
                p.setCliente(ClienteDAO.leUm(rs.getString("Cliente_cpf")));
                p.setPrato(PratoDAO.leUm(rs.getInt("Prato_codigo")));
                p.setSobremesa(SobremesaDAO.leUm(rs.getInt("Sobremesa_codigo")));
                
                listPedido.add(p);
             }
             st.close();
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
         return listPedido;
    }
    
    public static Pedido leUm(int n)throws Exception{
        Pedido p = new Pedido();
        
        try{
            String sql = "Select * from Pedido where codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            st.setInt(1, n);
            
            rs = st.executeQuery();
            
            if(rs.next()){
                p.setCodigo(rs.getInt("codigo"));
                p.setData(rs.getString("data"));
                p.setStatus(rs.getString("status"));
                p.setTotal(rs.getFloat("total"));
                p.setEntregador(EntregadorDAO.leUm(rs.getInt("Entregador_matricula")));
                p.setBebida(BebidaDAO.leUm(rs.getInt("Bebida_codigo")));
                p.setCliente(ClienteDAO.leUm(rs.getString("Cliente_cpf")));
                p.setPrato(PratoDAO.leUm(rs.getInt("Prato_codigo")));
                p.setSobremesa(SobremesaDAO.leUm(rs.getInt("Sobremesa_codigo")));
            }
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return p;
    }
    public static int altera(String status, int codigo) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Pedido SET status = ? where codigo = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, status);
            st.setInt(2, codigo);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraNotIn(String status, int n1, int n2) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Pedido SET status = ? where codigo not in (?,?)";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, status);
            st.setInt(2, n1);
            st.setInt(3, n2);
            
            ret = st.executeUpdate();
            st.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ret;
    }
    
    public static int alteraAnd(String status, int n1, String data) throws Exception{
        int ret = 0;
        try{
            String sql = "UPDATE Pedido SET status = ? where codigo = ? and data = ?";
            connection = GerenteDeConexao.getConnection();
            st = connection.prepareStatement(sql);
            
            st.setString(1, status);
            st.setInt(2, n1);
            st.setString(3, data);
            
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
            String sql = "DELETE from Pedido where codigo = ?";
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
