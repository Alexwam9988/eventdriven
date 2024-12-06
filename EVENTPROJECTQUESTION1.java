Creating a Java project for a school management system involves designing classes to represent different entities such as students, teachers, courses, and the school itself. Below is a simplified example of a school management system in Java. This example focuses on core functionalities and does not include features like user authentication, data persistence, or error handling for simplicity.

java
Copy code
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private int age;
    private List<Course> enrolledCourses;

    public Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Age: " + age;
    }
}

class Teacher {
    private String teacherId;
    private String name;
    private String subject;

    public Teacher(String teacherId, String name, String subject) {
        this.teacherId = teacherId;
        this.name = name;
        this.subject = subject;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Teacher ID: " + teacherId + ", Name: " + name + ", Subject: " + subject;
    }
}

class Course {
    private String courseId;
    private String courseName;
    private Teacher teacher;

    public Course(String courseId, String courseName, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Course Name: " + courseName + ", Teacher: " + teacher.getName();
    }
}

class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;

    public School() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        School school = new School();

        Teacher mathTeacher = new Teacher("T001", "John Doe", "Mathematics");
        Teacher englishTeacher = new Teacher("T002", "Jane Smith", "English");

        school.addTeacher(mathTeacher);
        school.addTeacher(englishTeacher);

        Course mathCourse = new Course("C001", "Math 101", mathTeacher);
        Course englishCourse = new Course("C002", "English 101", englishTeacher);

        school.addCourse(mathCourse);
        school.addCourse(englishCourse);

        Student student1 = new Student("S001", "Alice Johnson", 16);
        Student student2 = new Student("S002", "Bob Williams", 15);

        student1.enrollCourse(mathCourse);
        student1.enrollCourse(englishCourse);

        student2.enrollCourse(mathCourse);

        school.addStudent(student1);
        school.addStudent(student2);

        // Display information
        System.out.println("School Information:");
        System.out.println("Teachers:");
        for (Teacher teacher : school.getTeachers()) {
            System.out.println(teacher);
        }

        System.out.println("\nCourses:");
        for (Course course : school.getCourses()) {
            System.out.println(course);
        }

        System.out.println("\nStudents:");
        for (Student student : school.getStudents()) {
            System.out.println(student);
            System.out.println("Enrolled Courses:");
            for (Course course : student.getEnrolledCourses()) {
                System.out.println("- " + course.getCourseName());
            }
            System.out.println();
        }
    }
}
In a real-world scenario, you would likely want to expand this system with features like user input validation, database integration, user authentication, and more comprehensive error handling. This example is a starting point, and you can build upon it based on the specific requirements of your school management system.
