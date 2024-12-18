package ss10_array_list.service;

import ss10_array_list.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements ITeacherService {
    private List<Teacher> teacherList;

    public TeacherService() {
        teacherList = new ArrayList<Teacher>();
        teacherList.add(new Teacher(1, "Nguyễn Thị A", "Math", 900.0));
        teacherList.add(new Teacher(2, "Nguyễn Thị B", "Geometry", 800.0));
        teacherList.add(new Teacher(3, "Nguyễn Thị C", "Chemistry", 500.0));
    }


    @Override
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherList;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacher.getId() == teacherList.get(i).getId()) {
                teacherList.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == id) {
                teacherList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Teacher getTeacherById(int id) {
        for (Teacher teacher : teacherList) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }
}
