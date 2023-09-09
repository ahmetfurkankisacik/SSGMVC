package com.tpe.repository;

import com.tpe.domain.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {
    void saveTeacher(Teacher teacher);

    List<Teacher> getAllTeachers();

    Optional<Teacher>findById(Long id);

    void deleteTeacher(Long id);
}
