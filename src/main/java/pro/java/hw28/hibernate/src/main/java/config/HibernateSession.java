package config;

import dto.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize Hibernate SessionFactory: " + e.getMessage(), e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
