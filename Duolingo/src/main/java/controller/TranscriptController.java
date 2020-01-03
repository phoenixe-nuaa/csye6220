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

public class TranscriptController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        String username = user.getUsername();
        if (request.getMethod().equals("GET")) {
            ModelAndView mav = new ModelAndView("transcript");
            GradeDAO gradedao = new GradeDAO();
            ArrayList<GradesEntity> resultList = gradedao.getCourses(username);
            mav.addObject("result", resultList);
            return mav;
        }
        else return null;
    }
}
