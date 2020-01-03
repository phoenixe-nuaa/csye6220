import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Display extends HttpServlet {

  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    String type = req.getRequestURI();
    HttpSession session = req.getSession();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    out.println("<html><head>");

    // add to cart
    if (req.getParameter("add") != null) {
      if (session.getAttribute("map") == null) {
        session.setAttribute("map", map);
        out.println("new");
      }
      else {
        map = (HashMap<String, Integer>)session.getAttribute("map");
        out.println("old");
      }

      String title = "The following item has been added to your shopping cart successfully";
      out.println("<h4 align=\"center\">" + title + "</h4></head>");
      out.println("<body>");

      String[] items = req.getParameterValues("item");
      for (String item : items) {
        out.println("<p align=\"center\">" + item + "</p>");
        if (map.get(item) == null) {
          map.put(item, 1);
          // out.println("put");
        }
        else {
          Integer num = map.get(item);
          num++;
          map.put(item, num);
          // out.println("add");
        }
      }
      session.setAttribute("map", new HashMap<String, Integer>(map));
      out.println("<p align=\"center\"><a href=\"?type=cart\">View Cart</a></p>");
    }

    // view cart
    else if (req.getParameter("type") != null) {
        if (session.getAttribute("map") == null) {
          out.println("Your Cart is empty");
        }
        else {
          map = (HashMap<String, Integer>)session.getAttribute("map");
          String title = "These items are in your cart:";
          out.println("<h4 align=\"center\">" + title + "</h4></head>");
          out.println("<body>");
          out.println("<form class=\"content\" action=\"store\" method=\"post\">");

          Set<String> keys = map.keySet();
          Iterator<String> iter = keys.iterator();

          HashMap<String, Integer> newmap = new HashMap<>();
          while (iter.hasNext()) {
            String key = iter.next();
            Integer num = map.get(key);
            if (num != 0) {
              newmap.put(key, num);
              out.println(num + "  " + key + "<input type = \"number\" name=\"" + key + "\" value=\"0\"/>to remove<br>");
            }
          }
          session.setAttribute("map", newmap);
          out.println("<input type=\"submit\" name=\"remove\" value=\"Remove\">");
          out.println("</form>");
          out.println("<p align=\"center\"><a href=\"/P7/welcome.html\">Return</a></p>");
       }
     }

     // remove
     else if (req.getParameter("remove") != null) {
       map = (HashMap<String, Integer>)session.getAttribute("map");
       Enumeration<String> names = req.getParameterNames();

       String title = "The following item has been removed from your shopping cart successfully";
       out.println("<h4 align=\"center\">" + title + "</h4></head>");
       out.println("<body>");

       while (names.hasMoreElements()) {
         String name = names.nextElement();
         if (!name.equals("remove")) {
           Integer value = Integer.parseInt(req.getParameter(name));
           if (value != 0) {
             out.println("<p align=\"center\">" + value + " of " + name + "  removed</p>");
             Integer num = map.get(name);
             num -= value;
             map.put(name, num);
           }
         }
       }
       out.println("<p align=\"center\"><a href=\"/P7/store?type=cart\">View Cart</a></p>");
       session.setAttribute("map", new HashMap<String, Integer>(map));
     }
     out.println("</body></html>");
  }


  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
}
