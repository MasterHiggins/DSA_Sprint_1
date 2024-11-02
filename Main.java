import java.util.Scanner;

public class Main {
    private static User[] users = new User[10];  //Fixed size array for storing users
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  //Consume newline

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    viewTasks(scanner);
                    break;
                case 5:
                    return;  //Exit the program
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createUser(Scanner scanner) {
        if (userCount >= users.length) {
            System.out.println("User limit reached.");
            return;
        }
        System.out.println("Enter username:");
        String name = scanner.nextLine();
        users[userCount++] = new User(name);
        System.out.println("User " + name + " created.");
    }

    private static void addTask(Scanner scanner) {
        System.out.println("Enter username:");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null) {
            System.out.println("Enter task description:");
            String description = scanner.nextLine();
            user.addTask(description);
            System.out.println("Task added.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.println("Enter username:");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null) {
            System.out.println("Enter task description to mark as completed:");
            String description = scanner.nextLine();
            user.markTaskAsCompleted(description);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void viewTasks(Scanner scanner) {
        System.out.println("Enter username:");
        String name = scanner.nextLine();
        User user = findUser(name);
        if (user != null) {
            user.printTasks();
        } else {
            System.out.println("User not found.");
        }
    }

    private static User findUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }
}
