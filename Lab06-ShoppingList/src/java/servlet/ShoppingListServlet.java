/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 504785
 */
public class ShoppingListServlet extends HttpServlet {

    //  String username;
    //String password;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
System.out.println(username);
        if (username != null || !"".equals(username)) {

            if (request.getParameter("action") != null && request.getParameter("action").equals("out")) {

                request.getSession().invalidate();

                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;

            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //System.err.println("hi");
        String username = request.getParameter("username");
        String action = request.getParameter("action");
        request.setAttribute("username", username);
        if (action.equals("register") && request.getParameter("username") != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

            return;
        }
        if (action.equals("add")) {
            HttpSession session = request.getSession();
            String add = (String) request.getParameter("item");
            ArrayList<String> item = (ArrayList) session.getAttribute("item");
            if (item == null) {
                item = (ArrayList) new ArrayList<>();
            }
            item.add(add);
            session.setAttribute("item", item);
            request.setAttribute("list", item);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;

        } else if (action.equals("delete")) {
            String delete = request.getParameter("item");
            HttpSession session = request.getSession();
            ArrayList<String> list = (ArrayList) session.getAttribute("item");
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(delete)) {
                        list.remove(i);
                    }

                }
                session.setAttribute("item", list);
                request.setAttribute("list", list);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }
    }

}
