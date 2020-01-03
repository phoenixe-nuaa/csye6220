package controller;

import DAO.GradeDAO;
import POJO.GradesEntity;
import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Basics1Controller extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        String username = user.getUsername();
        if (request.getMethod().equals("POST")) {
            int point = 0;
            if (request.getParameter("question1").equals("oui")) point++;
            if (request.getParameter("question2").equals("Bonjour, je m'appelle Tom.")) point++;
            if (request.getParameter("question3").equals("bonjour")) point++;
            if (request.getParameter("question4").equals("Comment allez-vous ?")) point++;
            if (request.getParameter("question5").equals("c")) point++;
            ModelAndView mav = new ModelAndView("bascis1-result");
            GradeDAO gradedao = new GradeDAO();
            GradesEntity grade = new GradesEntity();
            grade.setUsername(username);
            grade.setCoursename("basics 1");
            grade.setScore(point);
            boolean result;
            ArrayList<GradesEntity> resultList = gradedao.searchCourse(username, "Basics 1");
            if (resultList.isEmpty()) {
                result = gradedao.addGrade(grade);
            }
            else {
                GradesEntity newgrade = resultList.get(0);
                newgrade.setScore(point);
                result = gradedao.updateGrade(newgrade);
            }
            mav.addObject("score", point);
            mav.addObject("result", result);
            return mav;
        }
        else return null;
    }
}