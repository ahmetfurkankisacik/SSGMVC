package com.tpe.service;

import com.tpe.domain.Teacher;

import java.util.List;

public interface TeacherService {
    void saveTeacher(Teacher teacher);

    List<Teacher>getAllTeachers();

    Teacher findTeacherById(Long id);

    void deleteTeacher(Long id);

}
