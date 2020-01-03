package controller;

import DAO.UserDAO;
import POJO.UsersEntity;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("POST")) {
            UsersEntity user = new UsersEntity();
            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setUpassword(request.getParameter("password"));
            user.setAge(Integer.parseInt(request.getParameter("age")));
            user.setGender(request.getParameter("gender"));
            user.setCountry(request.getParameter("country"));
            user.setLocation(request.getParameter("location"));

            ModelAndView mav = new ModelAndView("register-result");
            UserDAO userdao = new UserDAO();
            boolean result = userdao.addUser(user);
            if (result) {
                mav.addObject("content", true);
            } else {
                mav.addObject("content", false);
            }

            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("nuaaphoenixe@gmail.com", "CJL941002cjl"));
            email.setSSLOnConnect(true);
            email.setFrom("nuaaphoenixe@gmail.com");
            email.setSubject("Welcome");
            email.setMsg("Hello, " + request.getParameter("username") + ". Welcome to Duolingo!!!");
            email.addTo(request.getParameter("email"));
            email.send();
            return mav;
        }
        else if (request.getMethod().equals("GET")) {
            ModelAndView mav = new ModelAndView("register");
            return mav;
        }
        else return null;
    }
}
