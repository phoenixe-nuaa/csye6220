package neu.edu.csye6220.p7;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class  Controller extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String add = request.getParameter("add");
        String remove = request.getParameter("remove");
        String base_dir = "/WEB-INF/views/";
        String viewFile = null;
        HttpSession session = request.getSession();

        // add to cart
        if (add != null) {
            ArrayList<String> list = new ArrayList<>();
            HashMap<String, Integer> cart = new HashMap<>();
            if (session.getAttribute("cart") == null) {
                session.setAttribute("cart", cart);
//                System.out.println("new");
            }
            else {
                cart = (HashMap<String, Integer>) session.getAttribute("cart");
//                System.out.println("old");
            }
            String[] itemsSelected = request.getParameterValues("item");
//            System.out.println("len's: " + itemsSelected.length);
            for (String item: itemsSelected) {
                System.out.println(item);
                if (cart.get(item) == null) {
//                    System.out.println("put");
                    cart.put(item, 1);
                }
                else {
                    Integer num = cart.get(item);
                    num++;
                    cart.put(item, num);
                }
                list.add(item);
            }
            request.setAttribute("added", list);
            session.setAttribute("cart", cart);
            viewFile = "message_add.jsp";
        }
        // remove functionality
        else if (remove != null) {
            HashMap<String, Integer> cart = (HashMap<String, Integer>)session.getAttribute("cart");
            Enumeration<String> names = request.getParameterNames();
            HashMap<String, Integer> toRemove = new HashMap<>();

            while (names.hasMoreElements()) {
                String name = names.nextElement();
                if (!name.equals("remove")) {
                    Integer value = Integer.parseInt(request.getParameter(name));
                    if (value != 0) {
                        Integer num = cart.get(name);
                        num -= value;
                        cart.put(name, num);
                        toRemove.put(name, value);
                    }
                }
            }
            session.setAttribute("map", new HashMap<String, Integer>());
            request.setAttribute("removed", toRemove);
            viewFile = "message_remove.jsp";
        }
        // view cart
        else if (type.equals("cart")) {
            HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
            if (cart == null) {
                System.out.println("Empty");
                session.setAttribute("cart", null);
            }
            else {
                Set<String> keys = cart.keySet();
                Iterator<String> iter = keys.iterator();

                HashMap<String, Integer> newCart = new HashMap<>();
                while (iter.hasNext()) {
                    String key = iter.next();
                    Integer num = cart.get(key);
                    if (num != 0) {
                        newCart.put(key, num);
                    }
                }
                session.setAttribute("cart", newCart);
            }
            viewFile = "cart.jsp";
        }
        // load page
        else {
            Model model = new Model();
            ArrayList<String> items = new ArrayList<>();
            if (type.equals("book")) {
                items = initialize("Book", 3);
            }
            if (type.equals("music")) {
                items = initialize("CD", 3);
            }
            if (type.equals("computers")) {
                items = initialize("Laptop", 3);
            }
            viewFile = "shop.jsp";
            model.setItem(items);
            request.setAttribute("items", model);
        }
        RequestDispatcher rd = request.getRequestDispatcher(base_dir + viewFile);
        rd.forward(request, response);
    }

    // initialize the page
    public ArrayList<String> initialize(String prefix, Integer num) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < num + 1; i++) {
            String str = prefix + " " + i;
            list.add(str);
        }
        return list;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
