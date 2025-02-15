public class TaskList {
    private TaskNode head;  //Head of the linked list

    private static class TaskNode {
        Task task;
        TaskNode next;

        TaskNode(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    public TaskList() {
        head = null;
    }

    //Add a new task to the linked list
    public void addTask(String description) {
        Task newTask = new Task(description);
        TaskNode newNode = new TaskNode(newTask);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    //Mark a task as completed
    public void markTaskAsCompleted(String description) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markAsCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    //Print all tasks
    public void printTasks() {
        TaskNode current = head;
        if (current == null) {
            System.out.println("No tasks.");
            return;
        }
        while (current != null) {
            System.out.println(current.task.toString());
            current = current.next;
        }
    }
}
