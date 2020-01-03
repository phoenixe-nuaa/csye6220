package controller;

import POJO.CoursesEntity;
import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class MyCoursesController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        Set<CoursesEntity> courses = user.getCourses();

        ModelAndView mav = new ModelAndView("my-courses");
        mav.addObject("courses", courses);
        return mav;
    }
}
