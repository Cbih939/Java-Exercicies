/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
to edit this template
 */
package TodoApp.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cbih9
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConnection(){
    // fazendo o tratamento de dados
        try{
    // carregando o driver para dentro da minha aplica��o
            Class.forName(DRIVER);
    //fazendo conex�o com o banco de dados, seguindo os parametros passados
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex){
            throw new RuntimeException("Erro na conex�o com o banco de dados", 
                    ex);
        }
    }
    
    public static void closeConnection (Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        } catch (Exception ex){
            throw new RuntimeException("Erro ao fechar a conex�o " 
                    + "com o banco de dados", ex);
        }
    }
    
    public static void closeConnection (Connection connection, 
            PreparedStatement statement){
        try{
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
        } catch (Exception ex){
            throw new RuntimeException("Erro ao fechar a conex�o " 
                    + "com o banco de dados", ex);
        }
    }
    
    public static void closeConnection (Connection connection, 
            PreparedStatement statement, ResultSet resultSet){
        try{
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        } catch (Exception ex){
            throw new RuntimeException("Erro ao fechar a conex�o " 
                    + "com o banco de dados", ex);
        }
    }
}
