/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Configuracion.Conexion;
import Interfaces.RegistroPagos;
import Modelo.RegistroPago;
import Procesos.Mensajes;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tu_nombre
 */
public class DAO_RegistroPagos implements RegistroPagose {

    
    public void AgregarRegistroPago(RegistroPago pago) {
        String sql = "INSERT INTO registro_pago (ID_CLIENTE, FECHA_PAGO, METODO_PAGO, MONTO, ESTADO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.HacerConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pago.getIdCliente());
            pstmt.setDate(2, Date.valueOf(pago.getFechaPago()));
            pstmt.setString(3, pago.getMetodoPago());
            pstmt.setBigDecimal(4, BigDecimal.valueOf(pago.getMonto()));
            pstmt.setString(5, pago.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR: no se puede insertar el registro de pago " + ex);
        }
    }

    
    public void ActualizarRegistroPago(RegistroPago pago) {
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement st = con.prepareStatement(
                    "UPDATE registro_pago SET ID_CLIENTE=?, FECHA_PAGO=?, METODO_PAGO=?, MONTO=?, ESTADO=? WHERE ID_PAGO=?");
            st.setInt(1, pago.getIdCliente());
            st.setDate(2, Date.valueOf(pago.getFechaPago()));
            st.setString(3, pago.getMetodoPago());
            st.setBigDecimal(4, BigDecimal.valueOf(pago.getMonto()));
            st.setString(5, pago.getEstado());
            st.setInt(6, pago.getIdPago());
            st.executeUpdate();
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR: no se puede actualizar el registro de pago " + ex);
        }
    }

    public RegistroPago BuscarRegistroPago(int idPago) {
        RegistroPago pago = null;
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM registro_pago WHERE ID_PAGO=?");
            ps.setInt(1, idPago);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pago = new RegistroPago();
                pago.setIdPago(rs.getInt("ID_PAGO"));
                pago.setIdCliente(rs.getInt("ID_CLIENTE"));
                pago.setFechaPago(rs.getString("FECHA_PAGO"));
                pago.setMetodoPago(rs.getString("METODO_PAGO"));
                pago.setMonto(rs.getDouble("MONTO"));
                pago.setEstado(rs.getString("ESTADO"));
            }
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR: no se puede recuperar el registro de pago " + ex);
        }
        return pago;
    }

    public void EliminarRegistroPago(int idPago) {
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM registro_pago WHERE ID_PAGO=?");
            ps.setInt(1, idPago);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR: no se puede eliminar el registro de pago " + ex);
        }
    }

    public ArrayList<RegistroPago> ListarRegistrosPago() {
        String consulta = "SELECT * FROM registro_pago";
        ArrayList<RegistroPago> lista = new ArrayList<>();
        try {
            Connection con = Conexion.HacerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                RegistroPago pago = new RegistroPago();
                pago.setIdPago(rs.getInt("ID_PAGO"));
                pago.setIdCliente(rs.getInt("ID_CLIENTE"));
                pago.setFechaPago(rs.getString("FECHA_PAGO"));
                pago.setMetodoPago(rs.getString("METODO_PAGO"));
                pago.setMonto(rs.getDouble("MONTO"));
                pago.setEstado(rs.getString("ESTADO"));
                lista.add(pago);
            }
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR: no se puede recuperar los registros de pago " + ex);
        }
        return lista;
    }}