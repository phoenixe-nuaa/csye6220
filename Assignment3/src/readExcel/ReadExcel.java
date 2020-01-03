package readExcel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcel extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ArrayList<String>> store = new ArrayList<>();
        String file = "/Dropbox/csye6220/Assignment3/src/readExcel/store.xls";

        try {
            FileInputStream excel = new FileInputStream(new File(System.getProperty("user.home"), file));
            HSSFWorkbook workbook = new HSSFWorkbook(excel);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();

            // each row
            while (rowIterator.hasNext()) {
//            for (int i = 0; i < 10; i++) {
                ArrayList<String> data = new ArrayList<String>();
                Row row = rowIterator.next();
                DataFormatter dataFormatter = new DataFormatter();
                Iterator<Cell> cellIterator = row.cellIterator();
                // each column
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    data.add(cellValue);
                }
                store.add(data);
//                i++;
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }

        request.setAttribute("store", store);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/readExcel.jsp");
        rd.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
