package controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LearnController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("POST")) {
            String courseName = request.getParameter("courseName");
            ModelAndView mav = null;
            if (courseName.equals("Basics 1")) {
                mav = new ModelAndView("basics1");
            }
            else if (courseName.equals("Basics 2")) {
                mav = new ModelAndView("basics2");
            }
            else if (courseName.equals("Greetings")) {
                mav = new ModelAndView("greetings");
            }
            return mav;
        }
        else return null;
    }
}
