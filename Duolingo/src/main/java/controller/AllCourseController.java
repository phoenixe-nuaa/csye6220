package controller;

import DAO.CourseDAO;
import POJO.CoursesEntity;
import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Set;

public class AllCourseController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("POST")) {
            ModelAndView mav = new ModelAndView("all-courses-result");
            HttpSession session = request.getSession();
            UsersEntity user = (UsersEntity) session.getAttribute("user");
            Set<CoursesEntity> courses = user.getCourses();
            ArrayList<CoursesEntity> courses_enrolled = new ArrayList<CoursesEntity>();

            for (CoursesEntity c: courses) {
                courses_enrolled.add(c);
            }
            CourseDAO coursedao = new CourseDAO();
            ArrayList<CoursesEntity> all_courses = coursedao.searchCourse("language", request.getParameter("language"));
            all_courses.removeAll(courses_enrolled);

            mav.addObject("data", all_courses);
            if (all_courses.isEmpty()) {
                mav.addObject("result", true);
            }
            else mav.addObject("result", false);
            return mav;
        }
        else if (request.getMethod().equals("GET")) {
            ModelAndView mav = new ModelAndView("all-courses");
            return mav;
        }
        else return null;
    }
}
