/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class GerenteDeConexao {
protected static GerenteDeConexao connect;

public static GerenteDeConexao getInstance() {

if (connect == null) {

return connect = new GerenteDeConexao();

} else {

return connect;


}

}

protected static String driver = "com.mysql.jdbc.Driver";

protected static String conexao = "jdbc:mysql://localhost:3306/projetojavaa2ryanb3e";

protected static String user = "root";

protected static String password = "";

public static Connection getConnection() throws ClassNotFoundException, SQLException {

Class.forName(driver);

return DriverManager.getConnection(conexao,user,password);


}
}