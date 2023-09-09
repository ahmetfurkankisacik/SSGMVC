package com.tpe.service;

import com.tpe.domain.Teacher;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.saveTeacher(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        Teacher teacher =teacherRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Teacher not found with id : "+id));
        return teacher;
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteTeacher(id);
    }
}
