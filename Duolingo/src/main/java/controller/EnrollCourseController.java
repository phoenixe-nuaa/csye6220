package controller;

import DAO.CourseDAO;
import DAO.UserDAO;
import POJO.CoursesEntity;
import POJO.UsersEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Set;

@Transactional
public class EnrollCourseController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("all-courses-enroll");

        HttpSession session = request.getSession();
        UsersEntity user = (UsersEntity) session.getAttribute("user");

        CourseDAO coursedao = new CourseDAO();
        String[] courses_to_enrolled = request.getParameterValues("courses");
        ArrayList<CoursesEntity> courses = new ArrayList<CoursesEntity>();

        for (String item: courses_to_enrolled) {
            CoursesEntity course = coursedao.searchCourse("coursename", item).get(0);
            courses.add(course);
        }

        UserDAO userdao = new UserDAO();
        Set<CoursesEntity> data = user.getCourses();

        for (CoursesEntity course: courses) {
            data.add(course);
        }
        boolean result = userdao.updateUser(user);
        mav.addObject("content", true);
        return mav;
    }
}
