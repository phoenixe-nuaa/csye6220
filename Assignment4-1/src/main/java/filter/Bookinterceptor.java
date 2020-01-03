package filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class Bookinterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        Enumeration<String> names = arg0.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String[] values = arg0.getParameterValues(name);
            for (String value: values) {
                if (HasScript(value.toLowerCase()) || judgeSQLInject(value.toLowerCase())) {
                    arg1.setContentType("text/html;charset=UTF-8");
                    arg1.getWriter().print("Detected sql or script injection, access forbidden");
                    return false;
                }
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public Boolean HasScript (String value) {
        if ( value.contains("<script>") ||  value.contains("</script>") ||
                value.contains("(?i)<script.*?>.*?<script.*?>") || value.contains("(?i)<script.*?>.*?</script.*?>") ||
                value.contains("(?i)<.*?javascript:.*?>.*?</.*?>") || value.contains("=") ||
                value.contains("#") || value.contains("--")) {
            return true;
        }
        return false;
    }

    public boolean judgeSQLInject(String value){
        if(value == null || "".equals(value)){
            return false;
        }
        String xssStr = "and|or|select|update|delete|drop|truncate";
        String[] xssArr = xssStr.split("\\|");
        for (int i = 0; i < xssArr.length; i++) {
            if (value.indexOf(xssArr[i]) > -1) {
                return true;
            }
        }
        return false;
    }
}