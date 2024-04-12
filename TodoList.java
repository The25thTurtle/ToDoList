import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
  private ArrayList<String> tasks; // ArrayList to store tasks
  // Constructor to initialize the tasks ArrayList
  public TodoList() {
    tasks = new ArrayList<>();
  }
  // Method to add a task to the list
  public void addTask(String task) {
    tasks.add(task);
  }
  // Method to remove a task from the list by index
  public void removeTask(int index) {
    if (index >= 0 && index < tasks.size()) {
      tasks.remove(index);
    }
    else {
      System.out.println("Invalid Task.");
    }
}
// Method to move a task from one position to another
public void moveTask(int currentTask, int newTask) {
  if (currentTask >= 0 && currentTask < tasks.size() && 
      newTask >= 0 && newTask < tasks.size()) {
      String task = tasks.remove(currentTask);
      tasks.add(newTask, task);
  }
  else {
    System.out.println("Invalid Task.");
    }
}
// Method to display tasks in the list
public void displayTasks() {
  if(tasks.isEmpty()) {
    System.out.println("No tasks in the list.");
  }
  else {
    System.out.print("Tasks:");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.print((i+1) + ". " + tasks.get(i));
    }
  }
}

  public static void main(String[] args) {
    TodoList todoList = new TodoList(); // Create an instance of TodoList
    Scanner input = new Scanner(System.in);
    boolean exit = false;
    // Main menu loop
    while(!exit) {
      System.out.println("\nTodo List Menu:");
      System.out.println("1. Add Task");
      System.out.println("2. Remove Task");
      System.out.println("3. Move Task");
      System.out.println("4. Display Tasks");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      int choice = input.nextInt();
      input.nextLine();

      // Perform actions based on user's choice
      if (choice == 1) {
        System.out.print("Enter the task to add: ");
        String taskToAdd = input.nextLine();
        todoList.addTask(taskToAdd);
      }
      else if (choice == 2) {
        System.out.print("Enter the task to remove: ");
        int taskToRemove = input.nextInt();
        todoList.removeTask(taskToRemove - 1);
    }
      else if (choice == 3) {
        System.out.print("Enter the current task to move: ");
        int currentTask = input.nextInt();
        System.out.print("Enter the new task position: ");
        int newTask = input.nextInt();
        todoList.moveTask(currentTask - 1, newTask - 1);
      }
      else if (choice == 4) {
        todoList.displayTasks();
      }
      else if (choice == 5) {
        exit = true;
        System.out.println("Goodbye!");
        System.out.println("Exiting...");
      }
      else {
        System.out.println("Invalid choice. Please try again.");
      }
    }
    input.close(); // Close the Scanner
  }
}
