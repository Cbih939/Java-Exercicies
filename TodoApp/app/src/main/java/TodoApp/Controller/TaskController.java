/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
to edit this template
 */
package TodoApp.Controller;

import TodoApp.Model.Task;
import TodoApp.Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cbih9
 */
public class TaskController {
    // salvando dados do banco 
    public void save (Task task){
        String sql = "INSERT INTO tasks ("
                + "idProject,"
                + "name,"
                + "description," 
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException("Erro ao salvar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    // atualizando dados do banco 
    public void update(Task task){
        String sql = "UPDATE tasks SET "
                + "idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "completed = ?, "
                + "notes = ?, "
                + "deadline = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?"; 
        Connection connection = null;
        PreparedStatement statement = null;
        try{
    // estabelecendo a conex�o com o banco de dados        
            connection = ConnectionFactory.getConnection();
    // preparando a query         
            statement = connection.prepareStatement(sql);
    // setando os valores de statement         
            statement.setInt(1, task.getIdProject());
            statement.setString(2,task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
    // executando a query        
            statement.execute();           
        }catch(SQLException ex){
           throw new RuntimeException("Erro ao atualizar a tarefa"
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    // Apresentando lista
    public List<Task> getAll(int idProject){
        String sql = "SELECT * FROM task WHERE idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
    // cria��o de uma lista de tarefas 
        List<Task> tasks = new ArrayList<Task>();
        try{        
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
    // setando valor que corresponde ao filtro de busca        
            statement.setInt(1, idProject);
    // valor retornado pela execu��o da query        
            resultSet = statement.executeQuery();
    // enquanto houver valores a serem percorridos no meu resultSet        
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                tasks.add(task);          
            }
        }catch(SQLException ex){   
            throw new RuntimeException("Erro ao criar a lista de tarefa" 
                    + ex.getMessage(), ex);
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
    //lista de tarefas que foi criada e carregada do banco de dados
        return tasks;
    }  
        // removendo dados do banco 
    public void removeById(int TaskId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
    // cria��o da conex�o com o banco de dados        
           connection = ConnectionFactory.getConnection();
    // preparando a query       
           statement = connection.prepareStatement(sql);
    // setando os valores       
           statement.setInt(1, TaskId);
    // executando a query        
           statement.execute(); 
        } catch (SQLException ex){
           throw new RuntimeException("Erro ao deletar a tarefa"); 
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
