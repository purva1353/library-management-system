import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, "Java Basics"));
        books.add(new Book(2, "OOP Concepts"));
        books.add(new Book(3, "Data Structures"));

        int choice;

        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Book b : books) {
                        b.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    for (Book b : books) {
                        if (b.getId() == issueId && !b.isIssued()) {
                            b.issueBook();
                            System.out.println("Book Issued Successfully!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    for (Book b : books) {
                        if (b.getId() == returnId && b.isIssued()) {
                            b.returnBook();
                            System.out.println("Book Returned Successfully!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
