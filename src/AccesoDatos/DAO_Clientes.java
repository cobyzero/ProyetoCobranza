/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Configuracion.Conexion;
import Interfaces.InterfaceClientes;
import Modelo.Cliente;
import Procesos.Mensajes;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author edyne
 */
public class DAO_Clientes implements InterfaceClientes {
    
    @Override
    public ArrayList<Cliente> ListarClientes() {
        
        String consulta = "select * from clientes";
        ArrayList<Cliente> Lista = new ArrayList();
        try {
            Connection con = Conexion.HacerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                Cliente cat = new Cliente();
                cat.setIdCliente(rs.getInt(1));
                cat.setNombre(rs.getString(2));
                cat.setRuc(rs.getString(3));
                cat.setDireccion(rs.getString(4));
                cat.setTelefono(rs.getString(5));
                cat.setEmail(rs.getString(6));
                cat.setContacto(rs.getString(7));
                Lista.add(cat);
            }//fin del while
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR no se puede recuperar..." + ex);
        }
        return Lista;
        
    }
    
}
