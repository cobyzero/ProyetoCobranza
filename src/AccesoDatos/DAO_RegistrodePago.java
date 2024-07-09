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
import java.util.ArrayList;
import java.sql.*;

public class DAO_RegistrodePago implements RegistroPagos{

    @Override
    public void AgregarRegistroPago(RegistroPago registro) {
         

        String sql = "INSERT INTO cuentas_por_cobrar (ID_CLIENTE, MONTO, FECHA_EMISION, FECHA_VENCIMIENTO, ESTADO) VALUES ( ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.HacerConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, registro.getIdCliente());
            pstmt.setBigDecimal(2, BigDecimal.valueOf(registro.getMonto()));
            pstmt.setDate(3, Date.valueOf(registro.getFechaPago()));
            pstmt.setString(4, registro.getMetodoPago());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR no se puede insertar.." + ex);
        }
    }

    @Override
    public void ActualizarRegistroPago(RegistroPago registro) {
          try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement st = con.prepareStatement(
                    "UPDATE pagos SET ID_CLIENTE=?, FECHA_PAGO=?, METODO_PAGO=?, MONTO=?, ESTADO=? WHERE ID_PAGO=?;");
            st.setInt(1, registro.getIdCliente());
            st.setDate(2, Date.valueOf(registro.getFechaPago()));
            st.setString(3, registro.getMetodoPago());
            st.setBigDecimal(4, BigDecimal.valueOf(registro.getMonto()));
            st.setString(5, registro.getEstado());
            st.setInt(6, registro.getIdPago());
            st.executeUpdate();
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR: no se puede actualizar.." + ex);
        }
    }

    @Override
    public RegistroPago BuscarRegistroPago(int idRegistro) {
        RegistroPago registro = null;
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pagos WHERE ID_PAGO=?;");
            ps.setInt(1, idRegistro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                registro = new RegistroPago();
                registro.setIdPago(rs.getInt("ID_PAGO"));
                registro.setIdCliente(rs.getInt("ID_CLIENTE"));
                registro.setFechaPago(rs.getDate("FECHA_PAGO").toString());
                registro.setMetodoPago(rs.getString("METODO_PAGO"));
                registro.setMonto(rs.getDouble("MONTO"));
                registro.setEstado(rs.getString("ESTADO"));
            }
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR no se puede recuperar pago " + ex);
        }
        return registro;
    }

    @Override
    public void EliminarRegistroPago(int idRegistro) {
 try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE pagos SET ESTADO='INACTIVO' WHERE ID_PAGO=?;");
            ps.setInt(1, idRegistro);
            ps.executeUpdate();
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR no se puede eliminar " + ex);
        }    }

    @Override
    public ArrayList<RegistroPago> ListarRegistrosPago() {
 String consulta = "SELECT * FROM pagos";
        ArrayList<RegistroPago> lista = new ArrayList<>();
        try {
            Connection con = Conexion.HacerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                RegistroPago registro = new RegistroPago();
                registro.setIdPago(rs.getInt("ID_PAGO"));
                registro.setIdCliente(rs.getInt("ID_CLIENTE"));
                registro.setFechaPago(rs.getDate("FECHA_PAGO").toString());
                registro.setMetodoPago(rs.getString("METODO_PAGO"));
                registro.setMonto(rs.getDouble("MONTO"));
                registro.setEstado(rs.getString("ESTADO"));
                lista.add(registro);
            }
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR no se puede recuperar..." + ex);
        }
        return lista;
    }    }

