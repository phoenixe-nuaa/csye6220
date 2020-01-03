import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class PrintImage extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("image/jpeg");
    String fileName = req.getRequestURI();
    String location = getServletContext().getInitParameter("upload.location") + fileName;
    ServletOutputStream out = resp.getOutputStream();
    FileInputStream fin = new FileInputStream(location);
    BufferedInputStream bin = new BufferedInputStream(fin);
    BufferedOutputStream bout = new BufferedOutputStream(out);
    int ch = 0;
    while((ch=bin.read())!=-1)
    {
      bout.write(ch);
    }
    bin.close();
    fin.close();
    bout.close();
    out.close();
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
}
