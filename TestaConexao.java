/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaConexao;

import persistencia.GerenteDeConexao;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class TestaConexao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(GerenteDeConexao.getConnection());
    }
    
}
