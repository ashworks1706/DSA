import java.io.*;
import java.util.*;

public class Main {
    private static BST database = new BST();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Enter Database Filename: ");
        String filename = scanner.nextLine();
        
        try {
            loadDatabase(filename);
        } catch (FileNotFoundException e) {
            System.out.println("*** Error: File Not Found. ***");
            return;
        }
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1: registerNewStudent(); break;
                case 2: displayStudent(); break;
                case 3: updateStudent(); break;
                case 4: displayHighestGrade(); break;
                case 5: displayLowestGrade(); break;
                case 6: 
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
    
private static void loadDatabase(String filename) throws FileNotFoundException {
    Scanner fileScanner = new Scanner(new File(filename));
    while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        if (line.trim().isEmpty()) continue;
        String[] parts = line.split(" ");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1] + " " + parts[2];
        double grade = Double.parseDouble(parts[3]);
        database.insert(new Student(id, name, grade));
    }
    fileScanner.close();
}

    
    private static void displayMenu() {
        System.out.println("Select an action:");
        System.out.println("1. Register New Student");
        System.out.println("2. Display Existing Student Record");
        System.out.println("3. Update Existing Student Record");
        System.out.println("4. Display Student with Highest Grade");
        System.out.println("5. Display Student with Lowest Grade");
        System.out.println("6. Exit");
        System.out.print("Enter Choice #: ");
    }
    
   private static void registerNewStudent() {
    if (!scanner.hasNextInt()) return;
    System.out.print("Enter Student ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // consume newline
    
    System.out.print("Enter Student Name: ");
    if (!scanner.hasNextLine()) return;
    String name = scanner.nextLine();
    
    System.out.print("Enter Student Grade: ");
    if (!scanner.hasNextDouble()) return;
    double grade = scanner.nextDouble();
    
    database.insert(new Student(id, name, grade));
}

    private static void displayStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        
        Student student = database.search(id);
        if (student == null) {
            System.out.println("*** Error - Student ID Not Found! ***");
        } else {
            System.out.println(student);
        }
    }
    
    private static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        
        Student student = database.search(id);
        if (student == null) {
            System.out.println("*** Error - Student ID Not Found! ***");
        } else {
            System.out.println(student);
            System.out.print("Enter New Grade: ");
            double newGrade = scanner.nextDouble();
            student.setGrade(newGrade);
        }
    }
    
  private static void displayHighestGrade() {
    Student highest = database.findHighestGrade();
    if (highest == null) {
        System.out.println("No students in database");
        return;
    }
    System.out.println(highest);
}

    
    private static void displayLowestGrade() {
        Student lowest = database.findLowestGrade();
        if (lowest != null) {
            System.out.println(lowest);
        }
    }
}
