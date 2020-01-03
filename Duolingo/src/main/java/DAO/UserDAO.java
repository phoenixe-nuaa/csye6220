package DAO;

import POJO.UsersEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class UserDAO {

    private SessionFactory sf;
    private Session session;

    public UserDAO() {

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

    public boolean addUser(UsersEntity user) {
        boolean result = false;
        try {
            session = initialize().openSession();
            session.clear();
            Transaction tx = session.beginTransaction();
            session.save(user);
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

    public ArrayList<UsersEntity> searchUser(String keyword) {
        ArrayList<UsersEntity> result = new ArrayList<UsersEntity>();
        try {
            session = initialize().openSession();
            session.clear();
            String query;
            query = "from UsersEntity where username = :username";
            result = (ArrayList<UsersEntity>) session.createQuery(query)
                    .setParameter("username", keyword)
                    .list();
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

    public boolean updateUser(UsersEntity user) {
        boolean result = false;
        try {
            session = initialize().openSession();
            session.clear();
            Transaction tx = session.beginTransaction();
            System.out.println("user_id: "+ user.getUserId());
            session.update(user);
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

    public ArrayList<UsersEntity> getAllUsers() {
        ArrayList<UsersEntity> result = new ArrayList<UsersEntity>();
        try {
            session = initialize().openSession();
            session.clear();
            String query;
            query = "from UsersEntity";
            result = (ArrayList<UsersEntity>) session.createQuery(query)
                    .list();
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
