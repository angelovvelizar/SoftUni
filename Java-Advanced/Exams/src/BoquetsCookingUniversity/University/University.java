package BoquetsCookingUniversity.University;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (students.size() < capacity && !students.contains(student)) {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else if (students.contains(student)) {
            return "Student is already in the university";
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream().filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append("==Student: First Name = ").append(student.getFirstName())
                    .append(", Last Name = ")
                    .append(student.getLastName())
                    .append(", Best Subject = ")
                    .append(student.getBestSubject())
                    .append("\n");
        }

        return sb.toString();
    }


}
