
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentDataEntry {
    public static void main(String[] args) {
        List<Student> studentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student data or type 'quit' to finish:");

        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equals("quit")) {
                break;
            }

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("GPA: ");
            double GPA = Double.parseDouble(scanner.nextLine());

            Student student = new Student(name, address, GPA);
            studentList.add(student);
        }

        // Sort the student list by name
        Collections.sort(studentList);

        // Write the student data to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("student_data.txt"))) {
            for (Student student : studentList) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Student data has been written to student_data.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
