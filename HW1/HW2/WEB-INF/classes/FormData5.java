import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*10, maxRequestSize=1024*1024*50)

public class FormData5 extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    InputStream inputStream = null;
    Part filePart = req.getPart("photo");
    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
    String base_loc = getServletContext().getInitParameter("upload.location");
    String sub_loc = getServletContext().getInitParameter("sub.location");
    File uploads = new File(base_loc + sub_loc);
    File file = new File(uploads, fileName);
    try (InputStream fileContent = filePart.getInputStream()) {
      Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    String title = "Hello, here is the summary of your info";
    String source = sub_loc + fileName;
    out.println("<html><head><title>title</title></head>");
    out.println("<h1 align=\"center\">" + title + "</h1>");
    out.println("<table align=\"center\" border=\"1\">");
    out.println("<th><th>Details");
    Map<String,String[]> map = req.getParameterMap();
    Set keys = map.keySet();
    Iterator it = keys.iterator();
    while (it.hasNext()) {
      String key             = (String)it.next();
      String[] value         = map.get(key);
      out.println("<tr><td>" + key);
      out.println("    <td>" + String.join(", ", value));
    }
    out.println("<tr><td>photo<th><img src=\"" + source + "\" alt=\"not found\">");
    out.println("</table></body></html>");
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
}
