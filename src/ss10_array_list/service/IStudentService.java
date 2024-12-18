package ss10_array_list.service;

import ss10_array_list.model.Student;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    boolean updateStudent(Student student);
    boolean deleteStudent(int id);
    Student getStudentById(int id);
}
