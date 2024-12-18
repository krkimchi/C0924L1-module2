package ss10_array_list.service;

import ss10_array_list.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {
    private List<Student> studentList;

    public StudentService() {
        studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Nguyễn Văn A", 20, "Hà Nội"));
        studentList.add(new Student(2, "Nguyễn Văn B", 20, "Đà Nẵng"));
        studentList.add(new Student(3, "Nguyễn Văn C", 20, "Hà Nội"));
    }


    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == student.getId()) {
                studentList.set(i, student);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student getStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
