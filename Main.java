package GUI2;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("catch")
public class Main extends JFrame {
    // GUI class for the Student Management System, providing a window with buttons for managing students and subjects.
    private StudentManagementSystem system = new StudentManagementSystem();
    private JTextArea area = new JTextArea();

    public Main() {
        // Initializes the GUI window, text area for displaying information, and buttons with their event handlers.
        // Set up the main window properties: title, size, close operation, and layout.
        setTitle("Student Management System - BAUT 2026");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and configure the text area for displaying student information and results.
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.BOLD, 16));
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
        b1.addActionListener(e -> onAddStudent());
        b2.addActionListener(e -> onAddSubject());
        b3.addActionListener(e -> onShowStudentInfo());
        b4.addActionListener(e -> onCalculateGPA());
        b5.addActionListener(e -> onShowAllStudents());
        b6.addActionListener(e -> onDeleteStudent());
        b7.addActionListener(e -> onUpdateStudent());
        b8.addActionListener(e -> onRemoveSubject());
        b9.addActionListener(e -> onHighestGPA());
        b10.addActionListener(e -> onGradeToLetter());
        b11.addActionListener(e -> System.exit(0));
    }

    // Helper to read integer input safely via dialog
    // Returns null if user cancels or enters invalid number.
    private Integer promptInt(String message) {
        try {
            String input = JOptionPane.showInputDialog(message);
            if (input == null || input.trim().isEmpty()) return null;
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            showError("Invalid number");
            return null;
        }
    }

    // Helper to read string input via dialog and trim whitespace.
    // Returns null for cancel or empty text.
    private String promptString(String message) {
        String input = JOptionPane.showInputDialog(message);
        if (input == null || input.trim().isEmpty()) return null;
        return input.trim();
    }

    private void showError(String text) {
        JOptionPane.showMessageDialog(this, text, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void appendLine(String text) {
        area.append(text + "\n");
    }

    // Action handler for Add Student button.
    // Reads ID/Name/Major with validation and then attempts to add student.
    // StudentManagementSystem ensures ID uniqueness.
    private void onAddStudent() {
        Integer id = promptInt("Enter Student ID:");
        if (id == null) return;
        String name = promptString("Enter Name:");
        if (name == null) return;
        String major = promptString("Enter Major:");
        if (major == null) return;

        if (system.addStudent(new Student(id, name, major))) {
            appendLine("✅ Student Added: " + name);
        } else {
            showError("Student ID already exists! Please use a different ID.");
        }
    }

    // Action handler for Add Subject button.
    // Finds student by ID then adds validated subject data.
    private void onAddSubject() {
        Integer id = promptInt("Enter Student ID:");
        if (id == null) return;
        Student s = system.searchStudent(id);
        if (s == null) { showError("Student not found!"); return; }

        String sub = promptString("Subject Name:");
        if (sub == null) return;
        Integer hrs = promptInt("Credit Hours:");
        if (hrs == null) return;

        String gradeInput = JOptionPane.showInputDialog("Grade (0-100):");
        if (gradeInput == null || gradeInput.trim().isEmpty()) return;
        double gr;
        try {
            gr = Double.parseDouble(gradeInput.trim());
        } catch (NumberFormatException ex) {
            showError("Invalid grade");
            return;
        }
        if (gr < 0 || gr > 100) { showError("Grade must be 0-100"); return; }

        s.addSubject(new Subject(sub, hrs, gr));
        appendLine("✅ Subject added to " + s.getName());
    }

    // Action handler for Student Info button.
    // Displays selected student's profile and subjects in text area.
    private void onShowStudentInfo() {
        Integer id = promptInt("Enter Student ID:");
        if (id == null) return;
        Student s = system.searchStudent(id);
        if (s == null) { showError("Student not found!"); return; }

        area.setText("--- Student Details ---\n");
        area.append("ID: " + s.getId() + "\nName: " + s.getName() + "\nMajor: " + s.getMajor() + "\n");
        area.append("GPA: " + String.format("%.2f", s.calculateGPA()) + "\n");
        area.append("--- Subjects (Name, CreditHours, Grade) ---\n");
        if (s.getSubjects().isEmpty()) {
            area.append("No subjects found for this student.\n");
        } else {
            for (Subject sub : s.getSubjects()) {
                area.append("* " + sub.getName() + " | Credits: " + sub.getCreditHours() + " | Grade: " + sub.getGrade() + "\n");
            }
        }
    }

    private void onCalculateGPA() {
        Integer id = promptInt("Enter Student ID:");
        if (id == null) return;
        Student s = system.searchStudent(id);
        if (s == null) { showError("Student not found!"); return; }
        appendLine("⭐ GPA for " + s.getName() + " is: " + String.format("%.2f", s.calculateGPA()));
    }

    private void onShowAllStudents() {
        area.setText("--- All Students ---\n");
        for (Student s : system.getAllStudents()) {
            area.append("- " + s.getName() + " (ID: " + s.getId() + ")\n");
        }
    }

    private void onDeleteStudent() {
        Integer id = promptInt("Enter Student ID to delete:");
        if (id == null) return;
        if (system.removeStudent(id)) {
            appendLine("🗑️ Student removed: ID " + id);
        } else {
            showError("Student not found for deletion.");
        }
    }

    private void onUpdateStudent() {
        Integer id = promptInt("Enter Student ID to update:");
        if (id == null) return;
        Student s = system.searchStudent(id);
        if (s == null) { showError("Student not found to update."); return; }

        String newName = JOptionPane.showInputDialog(this, "Enter new name:", s.getName());
        String newMajor = JOptionPane.showInputDialog(this, "Enter new major:", s.getMajor());
        if (newName == null || newName.trim().isEmpty() || newMajor == null || newMajor.trim().isEmpty()) {
            showError("Name and major cannot be empty.");
            return;
        }

        if (system.updateStudent(id, newName.trim(), newMajor.trim())) {
            appendLine("✏️ Student updated: ID " + id + " (" + newName + ")");
        } else {
            showError("Failed to update student.");
        }
    }

    private void onRemoveSubject() {
        Integer id = promptInt("Enter Student ID:");
        if (id == null) return;
        Student s = system.searchStudent(id);
        if (s == null) { showError("Student not found!"); return; }

        StringBuilder list = new StringBuilder("Subjects:\n");
        for (int i = 0; i < s.getSubjects().size(); i++) {
            list.append((i + 1)).append(". ").append(s.getSubjects().get(i).getSubjectName()).append("\n");
        }

        Integer choice = promptInt(list + "Enter subject number to remove:");
        if (choice == null || choice < 1 || choice > s.getSubjects().size()) {
            showError("Invalid subject number!");
            return;
        }

        if (s.removeSubject(choice - 1)) {
            appendLine("✅ Subject removed for ID: " + id);
        } else {
            showError("Invalid subject number!");
        }
    }

    private void onHighestGPA() {
        Student top = system.getHighestGPAStudent();
        if (top == null) {
            appendLine("No students in the system.");
            return;
        }
        appendLine("🏆 Student with Highest GPA:\nName: " + top.getName() + " | GPA: " + String.format("%.2f", top.calculateGPA()));
    }

    private void onGradeToLetter() {
        String gradeInput = JOptionPane.showInputDialog("Enter numeric grade:");
        if (gradeInput == null || gradeInput.trim().isEmpty()) return;
        try {
            double grade = Double.parseDouble(gradeInput.trim());
            String letter = Student.convertToLetter(grade);
            JOptionPane.showMessageDialog(this, "Letter Grade: " + letter);
        } catch (NumberFormatException ex) {
            showError("Invalid Input!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
