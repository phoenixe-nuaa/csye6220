package DAO;

import POJO.MovieBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database db;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/moviedb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection conn = null;
    private Statement stmt = null;

    // initialize
    public static Database getInstance() throws Exception {
        if(db == null) {
            db = new Database();
        }
        return db;
    }

    // connect
    public Database() throws Exception {
        createConnection();
        this.conn.setAutoCommit(false);
    }

    public void createConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database Connects Successfully!");
            return;
        } catch (Exception e) {
            System.out.println("Create Step has Error: " + e.getMessage());
        }
    }

    // disconnect
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (Exception e) {
            System.out.println("Close Step has Error: " + e.getMessage());
        }
    }

    // add the book
    public boolean submitBook(ArrayList<ArrayList<String>> submitData){
        System.out.println("Get into Submit Section!");
        System.out.println(submitData.size());
        if (this.conn == null) {
            return false;
        }
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT into moviedb.books values (?, ?, ?, ?)");
            for (int m = 0; m < submitData.size(); m++) {
                ArrayList<String> data = (ArrayList<String>) submitData.get(m);
                ps.setString(1, data.get(0));
                System.out.println(data.get(0));
                System.out.println(data.get(1));
                System.out.println(data.get(2));
                System.out.println(data.get(3));
                ps.setString(2, data.get(1));
                ps.setString(3, data.get(2));
                ps.setFloat(4, Float.parseFloat(data.get(3)));
                ps.addBatch();
            }

            int[] count = ps.executeBatch();
            this.conn.commit();
            for (int i: count) {
                if (i == 0) {
                    this.conn.rollback();
                    return false;
                }
            }
            System.out.println("Submit Step Runs Successfully!");
        } catch (Exception e){
//            System.out.println("Submit Step has Error: " + e);
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }

    // add the movie
    public boolean submitMovie(ArrayList<String> submitData) {
        System.out.println("Get into Add Section!");
        if (this.conn == null) {
            return false;
        }
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT into moviedb.movies values (?, ?, ?, ?, ?)");
            ps.setString(1, submitData.get(0));
            ps.setString(2, submitData.get(1));
            ps.setString(3, submitData.get(2));
            ps.setString(4, submitData.get(3));
            ps.setInt(5, Integer.parseInt(submitData.get(4)));
            ps.addBatch();

            int[] count = ps.executeBatch();
            this.conn.commit();
            for (int i: count) {
                if (i == 0) {
                    this.conn.rollback();
                    return false;
                }
            }

            System.out.println("Add Section Runs Successfully!");
        } catch (Exception e){
            System.out.println("Add Section has Error: " + e.getMessage());
        }
        return true;
    }

    // get result
    public ArrayList<MovieBean> searchMovie(String type, String keyword) {

        ArrayList<MovieBean> resultData = new ArrayList<MovieBean>();
        String sql = "select * from moviedb.movies where " + type + "=\"" + keyword + "\";";
        try{
            this.stmt = this.conn.createStatement();
            ResultSet rs = this.stmt.executeQuery(sql);
            while (rs.next()) {
                MovieBean result = new MovieBean();
                result.setTitle(rs.getString("title"));
                result.setActor(rs.getString("actor"));
                result.setActress(rs.getString("actress"));
                result.setGenre(rs.getString("genre"));
                result.setYear(rs.getInt("year"));
                resultData.add(result);
            }
        } catch (Exception e){
            System.out.println("An error pop out!");
        } finally {
            return resultData;
        }

    }
}
