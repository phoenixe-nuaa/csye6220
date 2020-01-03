package controller;

import DAO.CourseDAO;
import POJO.CoursesEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SearchCourseController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("POST")) {
            ModelAndView mav = new ModelAndView("search-courses-result");

            CourseDAO coursedao = new CourseDAO();
            String type = request.getParameter("type");
            ArrayList<CoursesEntity> courses = coursedao.searchCourse(type, request.getParameter("keyword"));

            mav.addObject("data", courses);
            return mav;
        }
        else if (request.getMethod().equals("GET")) {
            ModelAndView mav = new ModelAndView("search-courses");
            return mav;
        }
        else return null;
    }
}
