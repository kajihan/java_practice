package dao;

import config.HibernateSession;
import dto.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
    public void addStudent(dto.Student student) {
        try (Session session = config.HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        }
    }

    public void deleteStudentById(int id) {
        try (Session session = config.HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
            }
            transaction.commit();
        }
    }

    public void updateStudent(Student student) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Student> students = session.createQuery("FROM Student", Student.class).list();
            transaction.commit();
            return students;
        }
    }

    public Student getStudentById(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
}
