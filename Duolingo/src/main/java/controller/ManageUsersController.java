package controller;

import DAO.UserDAO;
import POJO.UsersEntity;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ManageUsersController extends AbstractController
{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("all-users");
        UserDAO userdao = new UserDAO();
        ArrayList<UsersEntity> users = userdao.getAllUsers();
        mav.addObject("users", users);
        return mav;
    }
}
