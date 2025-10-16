import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    public static class Task{
        public String description;
        public boolean done;

        public Task(String description){
            this.description=description;
            this.done=false;
        }
        public String getDescription(){
            return description;
        }
        public boolean isDone(){
            return done;
        }
        public void markAsDone(){
            this.done=true;
        }
    }
    private List<Task> tasks;

    public TaskManager(){
        this.tasks=new ArrayList<>();
    }

    public void addTask(String description){
        tasks.add(new Task(description));
    }
    public void markAsDone(String description){
        for(Task task:tasks){
            if(task.getDescription().equals(description)){
                task.markAsDone();
                break;
            }
        }
    }

    public List<Task> getTasks() {
        return (List<Task>)(List<?>) new ArrayList<>(this.tasks) ;
    }
    public List<Task> getPendingTasks(){
        return this.tasks.stream().filter(task -> !task.isDone()).collect(Collectors.toList());
    }
}
