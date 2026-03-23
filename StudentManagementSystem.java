package GUI2;
import java.util.ArrayList;

public class StudentManagementSystem {
    // Manages a collection of students, providing methods to add, search, remove, and update students.
    private ArrayList<Student> students = new ArrayList<>(); // Manage students [cite: 53]

    // Adds a student if the ID is unique, returns true if added successfully.
    public boolean addStudent(Student s) {
        if (searchStudent(s.getId()) != null) {
            return false; // duplicate ID not allowed
        }
        students.add(s); // Feature 1 [cite: 55, 77]
        return true;
    }

    // Searches for a student by ID, returns the student or null if not found.
    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s; // Search feature [cite: 56]
        }
        return null; // Student not found [cite: 198]
    }

    // Removes a student by ID, returns true if removed successfully.
    public boolean removeStudent(int id) {
        Student s = searchStudent(id);
        if (s == null) return false;
        students.remove(s);
        return true;
    }

    // Updates a student's name and major by ID, returns true if updated successfully.
    public boolean updateStudent(int id, String newName, String newMajor) {
        Student s = searchStudent(id);
        if (s == null) return false;
        if (newName != null && !newName.trim().isEmpty()) s.setName(newName);
        if (newMajor != null && !newMajor.trim().isEmpty()) s.setMajor(newMajor);
        return true;
    }

    // Returns the list of all students.
    public ArrayList<Student> getAllStudents() {
        return students;
    }
    
    // Finds and returns the student with the highest GPA, or null if no students.
    public Student getHighestGPAStudent() {
        if (students.isEmpty()) return null;
    
        Student highest = students.get(0);
        for (Student s : students) {
        if (s.calculateGPA() > highest.calculateGPA()) {
            highest = s;
        }
    }
        return highest;
    }
}