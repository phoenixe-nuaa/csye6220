package controller.book;

import DAO.Database;
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
        ArrayList<ArrayList<String>> submitData = new ArrayList<ArrayList<String>>();
        Enumeration names = request.getParameterNames();
        int len = 0;
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            if (name.equals("submit")) continue;
            ArrayList<String> data = new ArrayList<String>();
            String[] values = request.getParameterValues(name);
            for (int i = 0; i < values.length; i++) {
                data.add(values[i]);
            }
            submitData.add(data);
            len++;
        }
//        len--;

        // display message
        ModelAndView mav = new ModelAndView("book-message");
        try {
            Database db = Database.getInstance();
            boolean result = db.submitBook(submitData);
            if (result == true) {
                mav.addObject("content", String.valueOf(len) + " Book Added Successfully!");
//                return mav;
            }
            else {
                mav.addObject("content", "Adding Books Fails!");
//                return mav;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mav;
    }
}

