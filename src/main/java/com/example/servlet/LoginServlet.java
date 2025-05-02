package com.example.servlet;

import com.example.servlet.accounts.User;
import com.example.servlet.accounts.UsersInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("login") != null){
            resp.sendRedirect(req.getContextPath() + "/file-explorer");
            return;
        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        // создаем сессию
        if(UsersInfo.validateUser(login, password)){
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            resp.sendRedirect(req.getContextPath() + "/file-explorer");
        }
        else {
            req.setAttribute("error", "Неверное имя пользователя");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
