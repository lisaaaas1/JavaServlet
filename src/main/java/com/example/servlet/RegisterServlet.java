package com.example.servlet;

import com.example.servlet.accounts.User;
import com.example.servlet.accounts.UsersInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if(UsersInfo.getUser(login) != null){
            req.setAttribute("error","Такой пользователь уже существует");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
        else {
            User newUser = new User(login, password, email);
            UsersInfo.addUser(newUser);

            req.getSession().setAttribute("login", login);
            resp.sendRedirect( req.getContextPath()+"/file-explorer");
        }
    }
}
