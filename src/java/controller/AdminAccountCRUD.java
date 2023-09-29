/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ADMIN
 */
public class AdminAccountCRUD extends HttpServlet {

  
AccountDAO dao =new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //get action
       String action = request.getParameter("action");
        switch (action) {
            case "add":
                String username  = request.getParameter("username");
                String password  = request.getParameter("password");
                int role = Integer.parseInt(request.getParameter("role"));
                dao.AddAccountFromAddmin(username,password,role);
                request.setAttribute("listAccount", dao.getList());
                request.getRequestDispatcher("ForAdmin.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    
}
