package controller;

import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainpageController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // main page
        HttpSession session = request.getSession();
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        String username = user.getUsername();
        ModelAndView mav = new ModelAndView("mainpage");
        if (username.equals("jialin")) {
            mav.addObject("category", 4);
        }
        else mav.addObject("category", 3);
        mav.addObject("username", username);
        return mav;
    }

}
