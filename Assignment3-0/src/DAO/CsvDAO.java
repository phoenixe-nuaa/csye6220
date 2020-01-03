package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CsvDAO {

    public ArrayList<ArrayList<String>> getCSV(String filename) {
        ArrayList<ArrayList<String>> orderIDs = new ArrayList<>();
        try {
            // Load the driver.
            Class.forName("org.relique.jdbc.csv.CsvDriver");

            // Create a connection. CSV file is in D:
            Connection conn = DriverManager.getConnection("jdbc:relique:csv:C:");

            // Create a Statement object to execute the query with.
            Statement stmt = conn.createStatement();

            // Select columns from SalesOrder.csv
            String SQL_QUERY = "SELECT SalesOrderID, SalesOrderNumber, PurchaseOrderNumber FROM " + filename;
            ResultSet rs = stmt.executeQuery(SQL_QUERY);

            // loop through rs
            while(rs.next()) {
//                int id = rs.getInt(1);
                ArrayList<String> data = new ArrayList<>();
                String id = rs.getString("SalesOrderID");
                String num = rs.getString("SalesOrderNumber");
                String ponum = rs.getString("PurchaseOrderNumber");
                data.add(id);
                data.add(num);
                data.add(ponum);
                orderIDs.add(data);
            }

            // Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }
//        System.out.println("data got");

        return orderIDs;
    }
}
