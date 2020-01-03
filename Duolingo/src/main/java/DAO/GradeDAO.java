package DAO;

import POJO.GradesEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import java.util.ArrayList;


public class GradeDAO {
    private SessionFactory sf;
    private Session session;

    public GradeDAO() {

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

    public boolean addGrade(GradesEntity grade) {
        boolean result = false;
        try {
            session = initialize().openSession();
            session.clear();
            Transaction tx = session.beginTransaction();
            session.save(grade);
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

    public boolean updateGrade(GradesEntity grade) {
        boolean result = false;
        try {
            session = initialize().openSession();
            session.clear();
            Transaction tx = session.beginTransaction();
            session.update(grade);
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

    public ArrayList<GradesEntity> searchCourse(String username, String coursename) {
        ArrayList<GradesEntity> result = new ArrayList<GradesEntity>();
        try {
            session = initialize().openSession();
            session.clear();
            String query = "from GradesEntity where username=:username and coursename=:coursename";
            Query q = session.createQuery(query);
            q.setParameter("username", username);
            q.setParameter("coursename", coursename);
            result = (ArrayList<GradesEntity>) q.list();
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

    public ArrayList<GradesEntity> getCourses(String username) {
        ArrayList<GradesEntity> result = new ArrayList<GradesEntity>();
        try {
            session = initialize().openSession();
            session.clear();
            String query = "from GradesEntity where username=:username";
            Query q = session.createQuery(query);
            q.setParameter("username", username);
            result = (ArrayList<GradesEntity>) q.list();
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

    public ArrayList<GradesEntity> getLeaderboard() {
        ArrayList<GradesEntity> result = new ArrayList<GradesEntity>();
        try {
            session = initialize().openSession();
            session.clear();
            Criteria q = session.createCriteria(GradesEntity.class);
            q.addOrder(Order.desc("score"));
            q.setMaxResults(5);
            result = (ArrayList<GradesEntity>) q.list();
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
