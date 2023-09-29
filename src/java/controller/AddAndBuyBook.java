/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author ADMIN
 */
public class AddAndBuyBook extends HttpServlet {

    BookDAO bookdao = new BookDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Book> list ;
        //get action
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                if (session.getAttribute("listBookBuy") == null) {
                    list = new ArrayList<>();
                } else {
                    list = (List<Book>) session.getAttribute("listBookBuy");
                }
                //get id
                String id = request.getParameter("id");
                Book book = bookdao.getBookByID(id);
                list.add(book);
                session.setAttribute("listBookBuy", list);
                request.setAttribute("listBook", bookdao.getList());
                request.getRequestDispatcher("listbookForUser.jsp").forward(request, response);
                break;

            case "buy":
                if (session.getAttribute("listBookBuy") == null) {
                    request.getRequestDispatcher("listbookForUser.jsp").forward(request, response);
                } else {
                    list = (List<Book>) session.getAttribute("listBookBuy");
                }
                String[] listbook = request.getParameterValues("choosebook");
          session.removeAttribute("listBookBuy");
//                session.setAttribute("listBookBuy", remoteCheckBook(listbook, (List<Book>) session.getAttribute("listBookBuy")));
                request.setAttribute("listBook", bookdao.getList());
                request.getRequestDispatcher("listbookForUser.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

//    private List<Book> remoteCheckBook(String[] listbook, List<Book> list) {
//        for (Book book : list) {
//            for (int i = 0; i <= listbook.length; i++) {
//                if (book.getName().equals(listbook[i])) {
//                    list.remove(book);
//                }
//            }
//        }
//        return list;
//    }

}
