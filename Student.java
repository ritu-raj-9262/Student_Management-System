package bean;

public class Student {
    private String id;       // MongoDB _id
    private String rollno;
    private String name;
    private String email;
    private String course;
    private int marks;

    public Student() {}

    public Student(String rollno, String name, String email, String course, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    // Full constructor including ID (optional, if needed from DB)
    public Student(String id, String rollno, String name, String email, String course, int marks) {
        this.id = id;
        this.rollno = rollno;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
