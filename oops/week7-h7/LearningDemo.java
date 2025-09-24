import java.time.LocalDate;

class Course {
    protected String title;
    protected String instructor;
    protected LocalDate enrollmentDate;

    public Course(String title, String instructor, LocalDate enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    public void showProgress() {
        System.out.println("Course: " + title + " by " + instructor + " | Enrolled on: " + enrollmentDate);
    }
}

class VideoCourse extends Course {
    private int completionPercent;
    private int watchTime; 

    public VideoCourse(String title, String instructor, LocalDate enrollmentDate, int completionPercent, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.completionPercent = completionPercent;
        this.watchTime = watchTime;
    }

    @Override
    public void showProgress() {
        System.out.println("Video Course: " + title + " by " + instructor);
        System.out.println("Completion: " + completionPercent + "% | Watch time: " + watchTime + " mins");
    }
}

class InteractiveCourse extends Course {
    private int quizScore;
    private int projectsCompleted;

    public InteractiveCourse(String title, String instructor, LocalDate enrollmentDate, int quizScore, int projectsCompleted) {
        super(title, instructor, enrollmentDate);
        this.quizScore = quizScore;
        this.projectsCompleted = projectsCompleted;
    }

    @Override
    public void showProgress() {
        System.out.println("Interactive Course: " + title + " by " + instructor);
        System.out.println("Quiz Score: " + quizScore + " | Projects Completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    private int pagesRead;
    private int notesTaken;

    public ReadingCourse(String title, String instructor, LocalDate enrollmentDate, int pagesRead, int notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    @Override
    public void showProgress() {
        System.out.println("Reading Course: " + title + " by " + instructor);
        System.out.println("Pages Read: " + pagesRead + " | Notes Taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    private int examAttempts;
    private boolean certified;

    public CertificationCourse(String title, String instructor, LocalDate enrollmentDate, int examAttempts, boolean certified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = examAttempts;
        this.certified = certified;
    }

    @Override
    public void showProgress() {
        System.out.println("Certification Course: " + title + " by " + instructor);
        System.out.println("Exam Attempts: " + examAttempts + " | Certified: " + (certified ? "Yes" : "No"));
    }
}

public class LearningDemo {
    public static void main(String[] args) {
        Course[] courses = new Course[4];
        courses[0] = new VideoCourse("Java Basics", "Alice", LocalDate.of(2025, 9, 24), 70, 120);
        courses[1] = new InteractiveCourse("Python Projects", "Bob", LocalDate.of(2025, 8, 10), 85, 5);
        courses[2] = new ReadingCourse("Data Structures", "Carol", LocalDate.of(2025, 7, 15), 200, 30);
        courses[3] = new CertificationCourse("Cloud Computing", "Dave", LocalDate.of(2025, 6, 5), 2, true);

        for (Course c : courses) {
            c.showProgress();
            System.out.println();
        }
    }
}
