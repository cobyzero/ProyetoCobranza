/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import Configuracion.Conexion;
import Interfaces.InterfaceCuentasPorCobrar;
import Modelo.CuentaPorCobrar;
import Procesos.Mensajes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author edyne
 */
public class DAO_CuentasPorCobrar implements InterfaceCuentasPorCobrar {

    @Override
    public void AgregarCuentaPorCobrar(CuentaPorCobrar cuenta) {

        String sql = "INSERT INTO cuentas_por_cobrar (ID_CLIENTE, MONTO, FECHA_EMISION, FECHA_VENCIMIENTO, ESTADO) VALUES ( ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.HacerConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cuenta.getIdCliente());
            pstmt.setBigDecimal(2, BigDecimal.valueOf(cuenta.getMonto()));
            pstmt.setDate(3, Date.valueOf(cuenta.getFechaEmision()));
            pstmt.setDate(4, Date.valueOf(cuenta.getFechaVencimiento()));
            pstmt.setString(5, cuenta.getEstado());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR no se puede insertar.." + ex);
        }
    }

    @Override
    public void ActualizarCuentaPorCobrar(CuentaPorCobrar cat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuentaPorCobrar BuscarCuentaPorCobrar(int idcat) {

        CuentaPorCobrar cat = null;
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "select * from cuentas_por_cobrar where ID_CUENTA=?;");
            ps.setInt(1, idcat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cat = new CuentaPorCobrar();
                cat.setIdCuenta(rs.getInt(1));
                cat.setIdCliente(rs.getInt(2));
                cat.setMonto(rs.getDouble(3));
                cat.setFechaEmision(rs.getDate(4).toString());
                cat.setFechaVencimiento(rs.getDate(5).toString());
                cat.setEstado(rs.getString(6));
            }
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR no se puede recuperar"
                    + " cuenta por cobrar " + ex);
        }
        return cat;

    }

    @Override
    public void EliminarCuentaPorCobrar(int idcat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CuentaPorCobrar> ListarCuentaPorCobrar() {
        String consulta = "select * from cuentas_por_cobrar";
        ArrayList<CuentaPorCobrar> Lista = new ArrayList();
        try {
            Connection con = Conexion.HacerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                CuentaPorCobrar cat = new CuentaPorCobrar();
                cat.setIdCuenta(rs.getInt(1));
                cat.setIdCliente(rs.getInt(2));
                cat.setMonto(rs.getDouble(3));
                cat.setFechaEmision(rs.getDate(4).toString());
                cat.setFechaVencimiento(rs.getDate(5).toString());
                cat.setEstado(rs.getString(6));
                Lista.add(cat);
            }//fin del while
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR no se puede recuperar..." + ex);
        }
        return Lista;
    }

}
