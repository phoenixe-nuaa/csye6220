package DAO;

import POJO.MoviesEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class MovieDAO {

    private SessionFactory sf;
    private Session session;

    public MovieDAO() {

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

    public boolean addMovie(MoviesEntity movie) {
        boolean result = false;
        try {
            session = initialize().openSession();
            session.clear();
            Transaction tx = session.beginTransaction();
            session.save(movie);
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

    public ArrayList<MoviesEntity> searchMovie(String type, String keyword) {
        ArrayList<MoviesEntity> result = new ArrayList<MoviesEntity>();
        try {
            session = initialize().openSession();
            session.clear();
            String query;
            if (type.equals("title")) {
                query = "from MoviesEntity where title = :title";
                result = (ArrayList<MoviesEntity>) session.createQuery(query)
                        .setParameter("title", keyword)
                        .list();
            }
            else if (type.equals("actor")) {
                query = "from MoviesEntity where actor = :actor";
                result = (ArrayList<MoviesEntity>) session.createQuery(query)
                        .setParameter("actor", keyword)
                        .list();
            }
            else if (type.equals("actress")) {
                query = "from MoviesEntity where actress = :actress";
                result = (ArrayList<MoviesEntity>) session.createQuery(query)
                        .setParameter("actress", keyword)
                        .list();
            }
            else if (type.equals("genre")) {
                query = "from MoviesEntity where genre = :genre";
                result = (ArrayList<MoviesEntity>) session.createQuery(query)
                        .setParameter("genre", keyword)
                        .list();
            }
            else if (type.equals("year")) {
                query = "from MoviesEntity where year = :year";
                result = (ArrayList<MoviesEntity>) session.createQuery(query)
                        .setParameter("year", Integer.parseInt(keyword))
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
