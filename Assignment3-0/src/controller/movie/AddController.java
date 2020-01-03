package controller.movie;

import DAO.Database;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;

public class AddController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // get data and add to the database
        ArrayList<String> data = new ArrayList<String>();
        Enumeration parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = (String)parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            data.add(paramValue);
        }

        // display message
        ModelAndView mav = new ModelAndView("movie-message");
        try {
            Database db = Database.getInstance();
            boolean result = db.submitMovie(data);
            if (result == true) {
                mav.addObject("content", "1 Movie Added Successfully!");
//                return mav;
            }
            else {
                mav.addObject("content", "Adding Movie Fails!");
//                return mav;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mav;
    }
}
