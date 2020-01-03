import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class MyGetHeader extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

    resp.setContentType("Text/html");
    PrintWriter out = resp.getWriter();
    String title = "Display Request Headers";
    out.println("<html><head><title>title</title></head>");
    out.println("<h1 align=\"center\">" + title + "</h1>");
    out.println("<table border=\"1\">");
    out.println("<tr bgcolor=\"#cc99ff\">");
    out.println("<th>Header Name<th>Header Value");
    Enumeration headerNames = req.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = (String) headerNames.nextElement();
      out.println("<tr><td>" + headerName);
      out.println("    <td>" + req.getHeader(headerName));
    }
      out.println("</table></body></html>");
  }

  public void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    doGet(req, resp);
 }
}
