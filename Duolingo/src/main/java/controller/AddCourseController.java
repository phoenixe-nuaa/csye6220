package controller;

import DAO.CourseDAO;
import POJO.CoursesEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCourseController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("POST")) {
            CoursesEntity course = new CoursesEntity();
            course.setCoursename(request.getParameter("coursename"));
            course.setWhichlanguage(request.getParameter("language"));
            course.setWhichlevel(Integer.parseInt(request.getParameter("level")));

            ModelAndView mav = new ModelAndView("add-course-result");
            try {
                CourseDAO coursedao = new CourseDAO();
                boolean result = coursedao.addCourse(course);
                if (result) {
                    mav.addObject("content", true);
                } else {
                    mav.addObject("content", false);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return mav;
        }
        else if (request.getMethod().equals("GET")) {
            ModelAndView mav = new ModelAndView("add-courses");
            return mav;
        } else return null;
    }
}
