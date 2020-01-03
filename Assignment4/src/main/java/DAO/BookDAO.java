package DAO;

import POJO.BooksEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class BookDAO {
    private SessionFactory sf;
    private Session session;

    public BookDAO() {

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

    public boolean addBook(ArrayList<BooksEntity> books) {
        boolean result = false;
        try {
            session = initialize().openSession();
            session.clear();
            Transaction tx = session.beginTransaction();
            for (BooksEntity book: books) {
                session.save(book);
            }
            tx.commit();
            result = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                session.getTransaction().rollback();
            } catch (Exception ex) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (Exception ex) {
                ex.printStackTrace();;
            }
        }
        return result;
    }
}
