/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TodoApp;

import TodoApp.Util.ConnectionFactory;
import java.sql.Connection;

public class App {
    public String getGreeting() {
        return "";
    }

    public static void main(String[] args) {
        Connection c = ConnectionFactory.getConnection();
        
        ConnectionFactory.closeConnection(c);
    }
}
