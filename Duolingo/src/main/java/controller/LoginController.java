package controller;

import DAO.UserDAO;
import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;

public class LoginController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("POST")) {
            HttpSession session = request.getSession();
            ModelAndView mav = new ModelAndView("mainpage");
            UserDAO userdao = new UserDAO();
            ArrayList<UsersEntity> user = userdao.searchUser(request.getParameter("username"));

            if (user.equals(Collections.emptyList())) {
                mav.addObject("content", "User not found, please sign up first!");
                mav.addObject("category", 1);
            }
            else if (!request.getParameter("password").equals(user.get(0).getUpassword())) {
                mav.addObject("content", "Password not matching, please try again.");
                mav.addObject("category", 2);
            }
            else if (user.get(0).getUsername().equals("jialin")) {
                String username = user.get(0).getUsername();
                mav.addObject("username", username);
                mav.addObject("category", 4);
                session.setAttribute("user", user.get(0));
            }
            else {
                String username = user.get(0).getUsername();
                mav.addObject("username", username);
                mav.addObject("category", 3);
                session.setAttribute("user", user.get(0));
            }
            return mav;
        }
        else if (request.getMethod().equals("GET")) {
            ModelAndView mav = new ModelAndView("login");
            return mav;
        }
        else return null;
    }
}
