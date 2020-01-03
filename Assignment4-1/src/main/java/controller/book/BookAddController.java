package controller.book;

import DAO.BookDAO;
import POJO.BooksEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;

public class BookAddController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // get data and add to the database
        ArrayList<BooksEntity> datalist = new ArrayList<BooksEntity>();
        Enumeration names = request.getParameterNames();
        int len = 0;
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            if (name.equals("submit")) continue;
            BooksEntity data = new BooksEntity();
            String[] values = request.getParameterValues(name);
            data.setIsbn(values[0]);
            data.setTitle(values[1]);
            data.setAuthors(values[2]);
            data.setPrice(Double.valueOf(values[3]));
            datalist.add(data);
            len++;
        }

        // display message
        ModelAndView mav = new ModelAndView("book-message");
        try {
            BookDAO db = new BookDAO();
            boolean result = db.addBook(datalist);
            if (result == true) {
                mav.addObject("content", String.valueOf(len) + " Book Added Successfully!");
            }
            else {
                mav.addObject("content", "Adding Books Fails!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mav;
    }
}

