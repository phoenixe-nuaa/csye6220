package controller;

import DAO.GradeDAO;
import POJO.GradesEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class LeaderboardController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("leaderboard");
        GradeDAO gradedao = new GradeDAO();
        ArrayList<GradesEntity> scores = gradedao.getLeaderboard();

        mav.addObject("scores", scores);
        return mav;
    }
}
