package GUI2;

import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {
    // GUI class for the Student Management System, providing a window with buttons for managing students and subjects.
    private StudentManagementSystem system = new StudentManagementSystem();
    private JTextArea area = new JTextArea();

    public StudentGUI() {
        // Initializes the GUI window, text area for displaying information, and buttons with their event handlers.
        // Set up the main window properties: title, size, close operation, and layout.
        setTitle("Student Management System - BAUT 2026");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and configure the text area for displaying student information and results.
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 13));
        add(new JScrollPane(area), BorderLayout.CENTER);

        // Create a panel for buttons arranged in a 4x2 grid layout.
        JPanel p = new JPanel(new GridLayout(4, 2, 10, 10));
        // Create buttons for various student management operations.
        JButton b1 = new JButton("1. Add Student");
        JButton b2 = new JButton("2. Add Subject");
        JButton b3 = new JButton("3. Student Info");
        JButton b4 = new JButton("4. Calculate GPA");
        JButton b5 = new JButton("5. Show All");
        JButton b6 = new JButton("6. Delete Student");
        JButton b7 = new JButton("7. Update Student");
        JButton b8 = new JButton("8. Remove Subject");
        JButton b9 = new JButton("9. Highest GPA");
        JButton b10 = new JButton("10. Grade to Letter");
        JButton b11 = new JButton("11. Exit");

        // Add buttons to the panel in order.
        p.add(b1); p.add(b2); 
        p.add(b3); p.add(b4);
        p.add(b5); p.add(b6);
        p.add(b7); p.add(b8);
        p.add(b9); p.add(b10);
        p.add(b11); 
        
        add(p, BorderLayout.SOUTH);

        // Set up action listeners for each button to handle user clicks and perform operations.

        // 1. Add Student
        b1.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID:"));
                String name = JOptionPane.showInputDialog("Enter Name:");
                if (name == null || name.trim().isEmpty()) return;
                String major = JOptionPane.showInputDialog("Enter Major:");
                boolean added = system.addStudent(new Student(id, name, major));
                if (added) {
                    area.append("✅ Student Added: " + name + "\n");
                } else {
                    JOptionPane.showMessageDialog(this, "Student ID already exists! Please use a different ID.");
                }
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Invalid ID!"); }
        });

        // 2. Add Subject
        b2.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID:"));
                Student s = system.searchStudent(id);
                if (s != null) {
                    String sub = JOptionPane.showInputDialog("Subject Name:");
                    int hrs = Integer.parseInt(JOptionPane.showInputDialog("Credit Hours:"));
                    double gr = Double.parseDouble(JOptionPane.showInputDialog("Grade (0-100):"));
                    if (gr >= 0 && gr <= 100) {
                        s.addSubject(new Subject(sub, hrs, gr));
                        area.append("✅ Subject added to " + s.getName() + "\n");
                    } else { JOptionPane.showMessageDialog(this, "Grade must be 0-100"); }
                } else { JOptionPane.showMessageDialog(this, "Student not found!"); }
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error in input!"); }
        });

        // 3. Student Information
        b3.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID:"));
                Student s = system.searchStudent(id);
                if (s != null) {
                    area.setText("--- Student Details ---\n");
                    area.append("ID: " + s.getId() + "\nName: " + s.getName() + "\nMajor: " + s.getMajor() + "\n");
                    area.append("GPA: " + String.format("%.2f", s.calculateGPA()) + "\n");
                    area.append("--- Subjects (Name, CreditHours, Grade) ---\n");
                    if (s.getSubjects().isEmpty()) {
                        area.append("No subjects found for this student.\n");
                    } else {
                        for (Subject sub : s.getSubjects()) {
                            area.append("* " + sub.getSubjectName() + " | Credits: " + sub.getCreditHours() + " | Grade: " + sub.getGrade() + "\n");
                        }
                    }
                } else { JOptionPane.showMessageDialog(this, "Student not found!"); }
            } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Invalid ID input!"); }
            catch (Exception ex) { JOptionPane.showMessageDialog(this, "Error showing student info."); }
        });

        // 4. Calculate GPA
        b4.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID:"));
                Student s = system.searchStudent(id);
                if (s != null) {
                    area.append("⭐ GPA for " + s.getName() + " is: " + String.format("%.2f", s.calculateGPA()) + "\n");
                }
            } catch (Exception ex) { }
        });

        // 5. Show all Students
        b5.addActionListener(e -> {
            area.setText("--- All Students ---\n");
            for(Student s : system.getAllStudents()) {
                area.append("- " + s.getName() + " (ID: " + s.getId() + ")\n");
            }
        });

        // 6. Delete Student
        b6.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID to delete:"));
                if (system.removeStudent(id)) {
                    area.append("🗑️ Student removed: ID " + id + "\n");
                } else {
                    JOptionPane.showMessageDialog(this, "Student not found for deletion.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID input!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error deleting student.");
            }
        });

        // 7. Update Student
        b7.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID to update:"));
                Student s = system.searchStudent(id);
                if (s != null) {
                    String newName = JOptionPane.showInputDialog(this, "Enter new name:", s.getName());
                    String newMajor = JOptionPane.showInputDialog(this, "Enter new major:", s.getMajor());
                    if (newName == null || newName.trim().isEmpty() || newMajor == null || newMajor.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Name and major cannot be empty.");
                    } else {
                        if (system.updateStudent(id, newName.trim(), newMajor.trim())) {
                            area.append("✏️ Student updated: ID " + id + " (" + newName + ")\n");
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to update student.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Student not found to update.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID input!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error updating student.");
            }
        });

        // 8. Remove Subject
        b8.addActionListener(e -> {
            try {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID:"));
                Student s = system.searchStudent(id);
                if (s != null) {
                    StringBuilder list = new StringBuilder("Subjects:\n");
                    for (int i = 0; i < s.getSubjects().size(); i++) {
                        list.append((i + 1)).append(". ").append(s.getSubjects().get(i).getSubjectName()).append("\n");
                    }
                    int choice = Integer.parseInt(JOptionPane.showInputDialog(list + "Enter subject number to remove:")) - 1;
                    if (s.removeSubject(choice)) {
                        area.append("✅ Subject removed for ID: " + id + "\n");
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid subject number!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Student not found!");
                }
            } catch (Exception ex) { area.append("Error removing subject.\n"); }
        });

        // 9. Highest GPA
        b9.addActionListener(e -> {
            Student top = system.getHighestGPAStudent();
            if (top != null) {
                area.append("🏆 Student with Highest GPA:\n");
                area.append("Name: " + top.getName() + " | GPA: " + String.format("%.2f", top.calculateGPA()) + "\n");
            } else {
                area.append("No students in the system.\n");
            }
        });

        // 10. Grade to Letter
        b10.addActionListener(e -> {
            try {
                double grade = Double.parseDouble(JOptionPane.showInputDialog("Enter numeric grade:"));
                String letter = Student.convertToLetter(grade);
                JOptionPane.showMessageDialog(this, "Letter Grade: " + letter);
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Invalid Input!"); }
        });

        // 11. Exit
        b11.addActionListener(e -> System.exit(0));
    }   


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentGUI().setVisible(true));
    }
}
