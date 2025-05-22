import java.util.*;

public class HomeManagementSystem {

    static class FamilyMember {
        String name;
        int age;
        String relation;

        FamilyMember(String name, int age, String relation) {
            this.name = name;
            this.age = age;
            this.relation = relation;
        }
    }

    static class Expense {
        String title;
        double amount;

        Expense(String title, double amount) {
            this.title = title;
            this.amount = amount;
        }
    }

    static class Task {
        String taskName;

        Task(String taskName) {
            this.taskName = taskName;
        }
    }

    static ArrayList<FamilyMember> familyList = new ArrayList<>();
    static ArrayList<Expense> expenseList = new ArrayList<>();
    static ArrayList<Task> taskList = new ArrayList<>();

    public static void addFamilyMember(Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter relation: ");
        String relation = sc.nextLine();

        familyList.add(new FamilyMember(name, age, relation));
        System.out.println("✅ Family member added.\n");
    }

    public static void viewFamilyMembers() {
        if (familyList.isEmpty()) {
            System.out.println("❗ No family members.\n");
            return;
        }
        System.out.println("--- Family Members ---");
        for (FamilyMember m : familyList) {
            System.out.println(m.name + " | Age: " + m.age + " | Relation: " + m.relation);
        }
        System.out.println();
    }

    public static void addExpense(Scanner sc) {
        System.out.print("Enter expense title: ");
        String title = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble(); sc.nextLine();

        expenseList.add(new Expense(title, amount));
        System.out.println("✅ Expense added.\n");
    }

    public static void viewExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("❗ No expenses.\n");
            return;
        }
        double total = 0;
        System.out.println("--- Expenses ---");
        for (Expense e : expenseList) {
            System.out.println(e.title + " - ₹" + e.amount);
            total += e.amount;
        }
        System.out.println("Total: ₹" + total + "\n");
    }

    public static void addTask(Scanner sc) {
        System.out.print("Enter task name: ");
        String taskName = sc.nextLine();
        taskList.add(new Task(taskName));
        System.out.println("✅ Task added.\n");
    }

    public static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("❗ No tasks.\n");
            return;
        }
        System.out.println("--- Tasks ---");
        int i = 1;
        for (Task t : taskList) {
            System.out.println(i++ + ". " + t.taskName);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Home Management System ---");
            System.out.println("1. Add Family Member");
            System.out.println("2. View Family Members");
            System.out.println("3. Add Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. Add Task");
            System.out.println("6. View Tasks");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt(); sc.nextLine(); // clear input buffer
            switch (choice) {
                case 1: addFamilyMember(sc); break;
                case 2: viewFamilyMembers(); break;
                case 3: addExpense(sc); break;
                case 4: viewExpenses(); break;
                case 5: addTask(sc); break;
                case 6: viewTasks(); break;
                case 7: System.out.println("👋 Exit. Thank you!"); return;
                default: System.out.println("❌ Invalid option.\n");
            }
        }
    }
}
