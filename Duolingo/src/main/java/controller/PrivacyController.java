package controller;

import DAO.UserDAO;
import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivacyController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            return new ModelAndView("privacy");
        }
        else if (request.getMethod().equals("POST")) {
            HttpSession session = request.getSession();
            ModelAndView mav = new ModelAndView("privacy-result");
            UserDAO userdao = new UserDAO();
            UsersEntity user = (UsersEntity) session.getAttribute("user");

            if (user.getUpassword().equals(request.getParameter("oldPassword"))) {
                user.setUpassword(request.getParameter("newPassword"));
                userdao.updateUser(user);
                mav.addObject("category", 1);
                mav.addObject("content", "Password is updated!");
            }
            else {
                mav.addObject("content", "Old Password does not match, please re-enter...");
                mav.addObject("category", 3);
            }
            return mav;
        }
        else return null;
    }
}
