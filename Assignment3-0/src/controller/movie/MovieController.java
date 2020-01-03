package controller.movie;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieController extends AbstractController {

    public MovieController() {

    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String url = httpServletRequest.getRequestURI();
//        if (url.equals("/movie")) {
//            return new ModelAndView("movie-welcome");
//        }
//        else return null;
        // main page
        if (request.getMethod().equals("GET")) {
            return new ModelAndView("movie-welcome");
        }

        // dispatch to add/browse
        else if (request.getMethod().equals("POST")) {
            if (request.getParameter("category").equals("add")) {
                return new ModelAndView("movie-add");
            }
            else if (request.getParameter("category").equals("browse")) {
                return new ModelAndView("movie-search");
            }
            else return null;
        }
        else return null;
    }

}
