/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author navjo
 */
public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();            
            String action = request.getParameter("action");
            String username = (String) session.getAttribute("username");
            
            if (action != null && action.equals("logout")){
                session.invalidate();
                session = request.getSession();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            
            if (username != null){
                session.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            
            String action = request.getParameter("action");
            String username = request.getParameter("username");
            String item = request.getParameter("item");
            
            ArrayList<String> shoppingList;
            
            if (session.getAttribute("shoppingList") == null) {
                shoppingList = new ArrayList();
            } 
            else {
                shoppingList = (ArrayList) session.getAttribute("shoppingList");
            }

            switch (action) {
                case "register":
                    session.setAttribute("username", username);
                    response.sendRedirect("ShoppingList");
                    break;

                case "add":
                    shoppingList.add(item);
                    session.setAttribute("shoppingList", shoppingList);
                    response.sendRedirect("ShoppingList");
                    break;

                case "delete":
                shoppingList.remove(item);
                    session.setAttribute("shoppingList", shoppingList);
                    response.sendRedirect("ShoppingList");
                    break;
            }
        
    }
}

