package Lecture.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void showStudent(String name) {
        if (repo.containsKey(name)) {
            Student student = repo.get(name);

            StringBuilder info = new StringBuilder(String.format("%s is %s years old.", student.getName(), student.getAge()));

            getInfoByGrade(student, info);

            System.out.println(info.toString());
        }

    }

    private void getInfoByGrade(Student student, StringBuilder info) {
        if (student.getGrade() >= 5.00) {
            info.append(" Excellent student.");
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            info.append(" Average student.");
        } else {
            info.append(" Very nice person.");
        }
    }

    public void createStudent(String name, int age, double grade) {
        if (!repo.containsKey(name)) {
            Student student = new Student(name, age, grade);
            repo.put(name, student);
        }
    }
}
