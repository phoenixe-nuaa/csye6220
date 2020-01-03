package controller;

import DAO.CsvDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CsvController extends AbstractController {

    public CsvController () {

    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getMethod().equals("GET")) {
            return new ModelAndView("welcomeCSV");
        }
        String filename = request.getParameter("filename");
        ArrayList<ArrayList<String>> orderID = new CsvDAO().getCSV(filename);
        ModelAndView mav = new ModelAndView("readCSV", "orderID", orderID);
        return mav;
    }
}
