import java.util.Scanner;

public class GradeManagementSystemTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===============================================================");
        System.out.println("          Welcome To Student Grade Management System:");
        System.out.println("===============================================================");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Enter Student Information");
            System.out.println("2. Enter Course Marks");
            System.out.println("3. Calculate CGPA");
            System.out.println("4. Display Grade Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=============================================");
                    System.out.println("          Enter Student Information");
                    System.out.println("=============================================");
                    Main.Student_Info();
                    System.out.println("\nStudent information entered successfully!");
                    break;
                case 2:
                    System.out.println("======================================");
                    System.out.println("          Enter Course Marks");
                    System.out.println("======================================");
                    Main.CourseMark();
                    System.out.println("\nCourse marks entered successfully!");
                    break;
                case 3:
                    Main.Calculate_CGPA();
                    System.out.println("\nCGPA calculated successfully!");
                    break;
                case 4:
                    Main.Display_GradeReport();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}