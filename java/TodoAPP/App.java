// @author XNDev

package TodoAPP;

import controller.TaskController;
import model.Task;
import model.Project;
import controller.ProjectController;
import java.sql.Connection;
import util.ConnectionFactory;

public class App {
    
    public static void main(String[] args) throws ClassNotFoundException {
   Connection c = ConnectionFactory.getConnection();
   
ProjectController projectController = new ProjectController();
Project project = new Project();


project.setName("Novo nome");
projectController.update(project);

projectController.save(project);

List<Project>projects = projectController.getAll();
System.out.println("Total de projetos: "+ projects.size());
ConnectionFactory.closeConnection(c);

TaskController taskController = new TaskController();

Task task = new Task();
task.setIdProject(2);
task.setName("Projeto teste");
task.setDescription("description");
task.setNotes("semnotas");
task.setIsCompleted(false);

taskController.save(task);

 
    }
}
