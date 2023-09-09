package com.tpe.repository;

import com.tpe.domain.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveTeacher(Teacher teacher) {
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        session.saveOrUpdate(teacher);//data base'de varsa update yoksa save yapar
        tx.commit();
        session.close();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        List<Teacher> teacherList=session.createQuery("From Teacher", Teacher.class).getResultList();
        tx.commit();
        session.close();
        return teacherList;

    }

    @Override
    public Optional<Teacher> findById(Long id) {
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,id);
        Optional<Teacher>optTeacher=Optional.ofNullable(teacher);


        tx.commit();
        session.close();
        return optTeacher;
    }

    @Override
    public void deleteTeacher(Long id) {
        Session session=sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        Teacher teacher=session.get(Teacher.class,id);
        session.delete(teacher);

        tx.commit();
        session.close();
    }
}
