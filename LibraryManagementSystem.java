import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Book data
    static ArrayList<Integer> bookId = new ArrayList<>();
    static ArrayList<String> bookName = new ArrayList<>();
    static ArrayList<Boolean> issued = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // ===== MAIN METHOD (DO NOT CHANGE) =====
    public static void main(String[] args) {1

        // sample books
        bookId.add(1);
        bookName.add("Java Programming");
        issued.add(false);

        bookId.add(2);
        bookName.add("Data Structures");
        issued.add(false);

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    System.out.println("Thank you! Program Ended.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ===== ADMIN MODULE =====
    static void adminMenu() {
        System.out.print("Enter Admin Password: ");
        String pass = sc.next();

        if (!pass.equals("admin")) {
            System.out.println("Wrong password!");
            return;
        }

        while (true) {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            if (ch == 1) addBook();
            else if (ch == 2) viewBooks();
            else if (ch == 3) deleteBook();
            else if (ch == 4) return;
            else System.out.println("Invalid choice!");
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        bookId.add(id);
        bookName.add(name);
        issued.add(false);

        System.out.println("Book added successfully!");
    }

    static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < bookId.size(); i++) {
            if (bookId.get(i) == id) {
                bookId.remove(i);
                bookName.remove(i);
                issued.remove(i);
                System.out.println("Book deleted!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // ===== USER MODULE =====
    static void userMenu() {
        while (true) {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            if (ch == 1) viewBooks();
            else if (ch == 2) issueBook();
            else if (ch == 3) returnBook();
            else if (ch == 4) return;
            else System.out.println("Invalid choice!");
        }
    }

    static void viewBooks() {
        System.out.println("\n--- BOOK LIST ---");
        for (int i = 0; i < bookId.size(); i++) {
            System.out.println(
                bookId.get(i) + " | " +
                bookName.get(i) + " | Issued: " +
                issued.get(i)
            );
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (int i = 0; i < bookId.size(); i++) {
            if (bookId.get(i) == id && !issued.get(i)) {
                issued.set(i, true);
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (int i = 0; i < bookId.size(); i++) {
            if (bookId.get(i) == id && issued.get(i)) {
                issued.set(i, false);
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid return!");
    }
}
