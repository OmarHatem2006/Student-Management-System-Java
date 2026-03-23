package GUI2;
// Represents a subject taken by a student, including name, credit hours, and grade.
public class Subject {
    private String subjectName;
    private int creditHours;
    private double grade;

    // Constructor to initialize a subject with name, credit hours, and grade.
    public Subject(String subjectName, int creditHours, double grade) {
        this.subjectName = subjectName;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    // Getters for subject properties.
    public String getSubjectName() { return subjectName; }
    public int getCreditHours() { return creditHours; }
    public double getGrade() { return grade; }
}