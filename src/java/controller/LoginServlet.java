/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ADMIN
 */
public class LoginServlet extends HttpServlet {

    AccountDAO dao = new AccountDAO();
    BookDAO bookdao = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (dao.checkAcc(username, password) == null) {
            request.setAttribute("notification", "Username or password notvalid");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            switch (dao.getRole(username)) {
                case 1:
                    request.setAttribute("listBook", bookdao.getList());
                    request.setAttribute("listAccount", dao.getList());
                    request.getRequestDispatcher("ForAdmin.jsp").forward(request, response);
                    break;
                case 2:
                    request.setAttribute("listBook", bookdao.getList());
                    request.getRequestDispatcher("listbookForUser.jsp").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }

        }

    }

}
