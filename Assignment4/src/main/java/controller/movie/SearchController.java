package controller.movie;

import DAO.MovieDAO;
import POJO.MoviesEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SearchController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Get into search section!");
        System.out.println("request received successfully");
        String type = request.getParameter("type");
        String keyword = request.getParameter("keyword");
        ModelAndView mav = new ModelAndView("movie-result");
        try {
            MovieDAO moviedao = new MovieDAO();
            ArrayList<MoviesEntity> result = moviedao.searchMovie(type, keyword);
            System.out.println(type + ", " +  keyword);
            mav.addObject("data", result);
            mav.addObject("type", type);
            System.out.println("Searching Database Successfully! ");
        } catch (Exception e) {
            System.out.println("Searching Database Fails! " + e.getMessage());
            e.printStackTrace();
        }
        return mav;
    }
}
