package readCSV;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ReadCSV extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ArrayList<ArrayList<String>> orderIDs = new ArrayList<>();
            String filename = request.getParameter("filename");
            System.out.println(filename);
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
                while (rs.next()) {
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
            request.setAttribute("orderID", orderIDs);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/readCSV.jsp");
            rd.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/welcomeCSV.jsp");
        rd.forward(request, response);
    }
}
