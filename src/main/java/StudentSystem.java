import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    private static ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a command: create, read, update, delete, or quit");
            String command = scanner.nextLine();

            if (command.equals("create")) {
                createStudent(scanner);
            } else if (command.equals("read")) {
                readStudent(scanner);
            } else if (command.equals("update")) {
                updateStudent(scanner);
            } else if (command.equals("delete")) {
                deleteStudent(scanner);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    private static void createStudent(Scanner scanner) {
        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter student id:");
        int id = scanner.nextInt();

        System.out.println("Enter student grade:");
        double grade = scanner.nextDouble();

        Student student = new Student(name, id, grade);
        students.add(student);
    }

    private static void readStudent(Scanner scanner) {
        System.out.println("Enter student id:");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Name: " + student.getName());
                System.out.println("Grade: " + student.getGrade());
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void updateStudent(Scanner scanner) {
        System.out.println("Enter student id:");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Enter new student name:");
                String name = scanner.nextLine();

                System.out.println("Enter new student grade:");
                double grade = scanner.nextDouble();

                student.setName(name);
                student.setGrade(grade);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("Enter student id:");
        int id = scanner.nextInt();

        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }
}