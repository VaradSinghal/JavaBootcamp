import java.util.*;

class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public String toString() {
        return subjectCode + " - " + subjectName + " (" + credits + " credits) | Instructor: " + instructor;
    }
}

class Student {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks; 
    private double gpa;

    private static int totalStudents = 0;
    private static String schoolName = "Springfield High";
    private static String[] gradingScale = {"A", "B", "C", "D", "F"};
    private static double passPercentage = 40.0;

    public Student(String studentId, String studentName, String className, String[] subjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length][];
        for (int i = 0; i < subjects.length; i++) {
            marks[i] = new double[0];
        }
        this.gpa = 0.0;
        totalStudents++;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getClassName() {
        return className;
    }

    public double getGpa() {
        return gpa;
    }

    public void addMarks(String subject, double mark) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subject)) {
                double[] oldMarks = marks[i];
                double[] newMarks = Arrays.copyOf(oldMarks, oldMarks.length + 1);
                newMarks[newMarks.length - 1] = mark;
                marks[i] = newMarks;
                return;
            }
        }
        System.out.println("Subject not found for " + studentName);
    }

    public void calculateGPA() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i].length > 0) {
                double avg = Arrays.stream(marks[i]).average().orElse(0.0);
                total += avg;
                count++;
            }
        }
        gpa = (count > 0) ? (total / count) / 20.0 : 0.0; // scale GPA to 0-5
    }

    public void generateReportCard() {
        System.out.println("\n--- Report Card ---");
        System.out.println("School: " + schoolName);
        System.out.println("Student: " + studentName + " (" + studentId + ")");
        System.out.println("Class: " + className);
        for (int i = 0; i < subjects.length; i++) {
            double avg = Arrays.stream(marks[i]).average().orElse(0.0);
            String grade = getGrade(avg);
            System.out.println(subjects[i] + " - Avg: " + avg + " Grade: " + grade);
        }
        System.out.println("GPA: " + gpa);
        System.out.println("Promotion Eligibility: " + (checkPromotionEligibility() ? "Eligible" : "Not Eligible"));
        System.out.println("-------------------\n");
    }

    public boolean checkPromotionEligibility() {
        for (int i = 0; i < subjects.length; i++) {
            double avg = Arrays.stream(marks[i]).average().orElse(0.0);
            if (avg < passPercentage) {
                return false;
            }
        }
        return true;
    }

    private String getGrade(double avg) {
        if (avg >= 85) return gradingScale[0];
        else if (avg >= 70) return gradingScale[1];
        else if (avg >= 55) return gradingScale[2];
        else if (avg >= 40) return gradingScale[3];
        else return gradingScale[4];
    }

    public static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }

    public static double calculateClassAverage(Student[] students) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            total += s.getGpa();
            count++;
        }
        return count > 0 ? total / count : 0.0;
    }

    public static List<Student> getTopPerformers(Student[] students, int count) {
        List<Student> list = new ArrayList<>(Arrays.asList(students));
        list.sort((a, b) -> Double.compare(b.getGpa(), a.getGpa()));
        return list.subList(0, Math.min(count, list.size()));
    }

    public static void generateSchoolReport(Student[] students) {
        System.out.println("\n--- School Report (" + schoolName + ") ---");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Average GPA: " + calculateClassAverage(students));
        List<Student> top3 = getTopPerformers(students, 3);
        System.out.println("Top Performers:");
        for (Student s : top3) {
            System.out.println(s.getStudentName() + " | GPA: " + s.getGpa());
        }
        System.out.println("----------------------------\n");
    }
}

public class StudentGradeSystemMain {
    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};

        Student s1 = new Student("S001", "Alice", "10A", subjects);
        Student s2 = new Student("S002", "Bob", "10A", subjects);
        Student s3 = new Student("S003", "Charlie", "10B", subjects);

        s1.addMarks("Math", 90);
        s1.addMarks("Science", 80);
        s1.addMarks("English", 85);

        s2.addMarks("Math", 60);
        s2.addMarks("Science", 55);
        s2.addMarks("English", 70);

        s3.addMarks("Math", 40);
        s3.addMarks("Science", 45);
        s3.addMarks("English", 50);

        s1.calculateGPA();
        s2.calculateGPA();
        s3.calculateGPA();

        s1.generateReportCard();
        s2.generateReportCard();
        s3.generateReportCard();

        Student[] allStudents = {s1, s2, s3};
        Student.generateSchoolReport(allStudents);
    }
}
