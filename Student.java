package GUI2 ;
import java.util.ArrayList;

public class Student {
    // Represents a student with ID, name, major, and a list of subjects.
    private int id;
    private String name;
    private String major;
    private ArrayList<Subject> subjects; // List of subjects

    // Constructor to initialize a student with ID, name, and major.
    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.subjects = new ArrayList<>();
    }

    // Adds a subject to the student's list of subjects.
    public void addSubject(Subject subject) {
        subjects.add(subject); // Add subject to the student's list of subjects
    }

    // Calculates the GPA based on the weighted average of grades and credit hours.
    public double calculateGPA() {
        if (subjects.isEmpty()) return 0.0;
        double totalPoints = 0;
        int totalHours = 0;
        for (Subject sub : subjects) {
            totalPoints += sub.getGrade() * sub.getCreditHours();
            totalHours += sub.getCreditHours();
        }
        return (totalHours == 0) ? 0.0 : totalPoints / totalHours;
    }

    // Getters for student properties.
    public int getId() { 
        return id; }
    public String getName() { 
        return name; }
    public String getMajor() { 
        return major; }
    public ArrayList<Subject> getSubjects() { 
        return subjects; }

    // Setters for updating student name and major.
    public void setName(String name) { this.name = name; }
    public void setMajor(String major) { this.major = major; }

    // Removes a subject from the list by index, returns true if successful.
    public boolean removeSubject(int index) {
        if (index >= 0 && index < subjects.size()) {
        subjects.remove(index);
        return true;
        }
    return false;
    }

    // Converts a numeric grade to a letter grade based on standard scale.
    public static String convertToLetter(double grade) {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }
}