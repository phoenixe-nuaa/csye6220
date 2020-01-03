package controller.movie;

import DAO.MovieDAO;
import POJO.MoviesEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // get data and add to the database
        MoviesEntity data = new MoviesEntity();
        data.setTitle(request.getParameter("title"));
        data.setActor(request.getParameter("actor"));
        data.setActress(request.getParameter("actress"));
        data.setGenre(request.getParameter("genre"));
        data.setYear(Integer.valueOf(request.getParameter("year")));

        // display message
        ModelAndView mav = new ModelAndView("movie-message");
        try {
            MovieDAO moviedao = new MovieDAO();
            boolean result = moviedao.addMovie(data);
            if (result) {
                mav.addObject("content", "1 Movie Added Successfully!");
            }
            else {
                mav.addObject("content", "Adding Movie Fails!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mav;
    }
}
