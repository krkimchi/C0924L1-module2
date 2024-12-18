package ss10_array_list.service;

import ss10_array_list.model.Teacher;

import java.util.List;

public interface ITeacherService {
    void addTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(int id);
    Teacher getTeacherById(int id);
}
