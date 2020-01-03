import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.Enumeration;

public class Survey extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    String title = "Your children's names are:";
    out.println("<html><head><title>title</title></head>");
    out.println("<h4 align=\"center\">" + title + "</h4>");
    // out.println("<table align=\"center\" border=\"1\">");
    Enumeration names = req.getParameterNames();
    while (names.hasMoreElements()) {
      String name = (String) names.nextElement();
      if (name.equals("submit")) {
        continue;
      }
      else {
        // out.println("<tr><td>" + name);
        out.println(req.getParameter(name) + "<br>");
      }
    }
    out.println("</body></html>");
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
}
