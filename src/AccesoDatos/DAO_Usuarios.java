/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Conexion.Conexion;
import Modelos.Usuario;
import java.sql.*;

/**
 *
 * @author edyne
 */
public class DAO_Usuarios {

    public static Usuario Login(String usuario, String contrasena) {

        try {
            var connection = Conexion.GetConnection();
            var sql = "SELECT * FROM USUARIOS WHERE USERNAME=? AND PASSWORD=?";

            var sf = connection.prepareStatement(sql);

            sf.setString(1, usuario);
            sf.setString(2, contrasena);

            var query = sf.executeQuery();

            while (query.next()) {
                var us = new Usuario(
                        query.getInt("ID_USUARIO"),
                        query.getString("NOMBRE"),
                        query.getString("USERNAME"),
                        query.getString("PASSWORD"),
                        query.getString("ROL")
                );

                return us;
            }

            return null;
        } catch (SQLException e) {
            return null;
        }

    }
}
