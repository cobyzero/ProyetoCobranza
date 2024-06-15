/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.*;

/**
 *
 * @author edyne
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/cobranzas";
    private static final String USER = "root";
    private static final String PASSWORD = "infierno";

    private static Connection connection;

    public static Connection GetConnection() {
        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;

        } catch (SQLException e) {
            return null;
        }
    }
}
