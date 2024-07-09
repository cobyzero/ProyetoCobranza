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

        if (this.ExisteClienteConCuentaDeCobro(cuenta.getIdCliente())) {
            Mensajes.MostrarTexto("El cliente ya tiene una cuenta de cobro");
            return;
        }   

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
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement st = con.prepareStatement(
                    "update cuentas_por_cobrar set MONTO=?, FECHA_EMISION=?, FECHA_VENCIMIENTO=?, ESTADO=? where ID_CUENTA=?;");
            st.setBigDecimal(1, BigDecimal.valueOf(cat.getMonto()));
            st.setDate(2, Date.valueOf(cat.getFechaEmision()));
            st.setDate(3, Date.valueOf(cat.getFechaVencimiento()));
            st.setString(4, cat.getEstado());

            st.setInt(5, cat.getIdCuenta());
            st.executeUpdate();
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR: no se puede actualizar.." + ex);
        }
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
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "update cuentas_por_cobrar set estado='INACTIVO' where id_cuenta=?;");
            ps.setInt(1, idcat);
            ps.executeUpdate();
        } catch (Exception ex) {
            Mensajes.MostrarTexto("ERROR no se puede eliminar " + ex);
        }
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

    @Override
    public boolean ExisteClienteConCuentaDeCobro(int idCliente) {
        try {
            Connection con = Conexion.HacerConexion();
            PreparedStatement ps = con.prepareStatement(
                    "select * from cuentas_por_cobrar where ID_CLIENTE=?;");
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Mensajes.MostrarTexto("ERROR no se puede recuperar"
                    + " cuenta por cobrar " + ex);
        }
        return false;
    }

    @Override
    public ArrayList<CuentaPorCobrar> FiltrarLista(double monto) {
        ArrayList<CuentaPorCobrar> Lista = new ArrayList();
        try {
            Connection con = Conexion.HacerConexion();

            PreparedStatement st = con.prepareStatement("select * from cuentas_por_cobrar where MONTO >= ?;");

            st.setDouble(1, monto);
            ResultSet rs = st.executeQuery();

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
