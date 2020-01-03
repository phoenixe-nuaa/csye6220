package controller.book;

import org.apache.velocity.VelocityContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookController extends AbstractController {

    public BookController() {

    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // main page
        if (request.getMethod().equals("GET")) {
            return new ModelAndView("book-welcome");
        }

        // dispatch to add
        else if (request.getMethod().equals("POST")) {
            ModelAndView mav = new ModelAndView("book-add");
            int num = Integer.parseInt(request.getParameter("number"));
//            VelocityContext context = new VelocityContext();
//            context.put("num", num);
            mav.addObject("num", num);
            return mav;
        }
        else return null;
    }

}