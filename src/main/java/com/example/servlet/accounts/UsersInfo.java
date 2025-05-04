package com.example.servlet.accounts;

import com.example.servlet.database.DBManager;


import java.sql.*;

import com.example.servlet.database.HibernateManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersInfo {

    public static void addUser(User user) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }

        /* String sql = "INSERT INTO users (login, password, email) VALUES (?, ?, ?)";

        try (Connection conn = DBManager.getConnection();

             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } */

    }

    public static User getUser(String login) {
        try (Session session = HibernateManager.getSessionFactory().openSession()) {
            return session.get(User.class, login);
        }
        /* String sql = "SELECT login, password, email FROM users WHERE login = ?";


        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; */
    }

    public static boolean validateUser(String login, String password){
        User user = getUser(login);
        return user != null && user.getPassword().equals(password);
    }
}
