package controller;

import DAO.CsvDAO;
import DAO.ExcelDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ExcelController extends AbstractController {

    public ExcelController () {

    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ArrayList<ArrayList<String>> store = new ExcelDAO().getExcel();
        ModelAndView mav = new ModelAndView("readExcel", "store", store);
        return mav;
    }
}
