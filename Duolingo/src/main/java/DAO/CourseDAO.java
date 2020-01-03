package DAO;

import POJO.CoursesEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class CourseDAO {

    private SessionFactory sf;
    private Session session;

    public CourseDAO() {

    }

    public SessionFactory initialize() {
        try {
            Configuration cfg = new Configuration();
            sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
        return sf;
    }

    public boolean addCourse(CoursesEntity course) {
        boolean result = false;
        try {
            session = initialize().openSession();
            session.clear();
            Transaction tx = session.beginTransaction();
            session.save(course);
            tx.commit();
            result = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                session.getTransaction().rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<CoursesEntity> searchCourse(String type, String keyword) {
        ArrayList<CoursesEntity> result = new ArrayList<CoursesEntity>();
        try {
            session = initialize().openSession();
            session.clear();
            String query;
            if (type.equals("language")) {
                query = "from CoursesEntity where whichlanguage = :whichlanguage";
                result = (ArrayList<CoursesEntity>) session.createQuery(query)
                        .setParameter("whichlanguage", keyword)
                        .list();
            }
            else if (type.equals("coursename")) {
                query = "from CoursesEntity where coursename = :coursename";
                result = (ArrayList<CoursesEntity>) session.createQuery(query)
                        .setParameter("coursename", keyword)
                        .list();
            }
            else if (type.equals("level")) {
                query = "from CoursesEntity where whichlevel = :whichlevel";
                result = (ArrayList<CoursesEntity>) session.createQuery(query)
                        .setParameter("whichlevel", keyword)
                        .list();
            }
            else result = null;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                session.getTransaction().rollback();
            } catch (Exception ex) {
                System.out.println("EXCEPTION: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println("EXCEPTION: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (Exception ex) {
                System.out.println("EXCEPTION: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return result;
    }
}

