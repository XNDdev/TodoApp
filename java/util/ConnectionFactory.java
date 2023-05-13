// @author XNDev

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Passa os parametros para conexao com o banco de dados e trata possiveis erros
public class ConnectionFactory {

// jdbc, A conexao entre java e banco de dados e nao vem no conjunto padrao de configuracoes * configurar no gradle
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    public static final String URL = "jdbc:mysql://localhost:3306/todo app";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);//Especifica e carrega o driver
            return DriverManager.getConnection(URL, USER, PASS);//Conecta de acordo com os parametros
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao com o banco de dados", ex);
        }
    }
//Fecha a conexao
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar a conexao com o banco de dados", ex);
        }
    }
// E possivel ter 2 metodos com o mesmo nome se os parametros forem diferentes, neste caso foi o parametro *statement
    
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexao com o banco de dados", ex);
        }
    }
   
     public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
             if (resultSet != null) {
                resultSet.close();
            }            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexao com o banco de dados", ex);
        }
    }
}
