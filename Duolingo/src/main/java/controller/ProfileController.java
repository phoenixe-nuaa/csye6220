package controller;

import DAO.UserDAO;
import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ProfileController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView("profile");
        UsersEntity user = (UsersEntity) session.getAttribute("user");
        mav.addObject("userdata", user);
        return mav;
    }
}
