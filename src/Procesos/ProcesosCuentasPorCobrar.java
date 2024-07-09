/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.Cliente;
import Modelo.CuentaPorCobrar;
import Vista.FrmRegistroPagos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edyne
 */
public class ProcesosCuentasPorCobrar {
    
    public static void Presentacion(FrmRegistroPagos fi) {
        fi.setVisible(true);
        fi.setTitle("Cuentas por Cobrar");
    }
    
    public static void Cargar(FrmRegistroPagos fi, ArrayList<Cliente> lista) {
        fi.cbxidcuenta.removeAllItems();
        
        for (Cliente e : lista) {
            fi.cbxidcuenta.addItem(e.getNombre());
        }
        
    }
    
    public static void LimpiarEntradas(FrmRegistroPagos fc) {
        // fc.txtIdcat.setText("");
        // fc.txtNomcat.setText("");
        // fc.txaDesc.setText("");
        // fc.txtIdcat.requestFocus();
    }//fin limpiar

    public static CuentaPorCobrar LeerCuentaPorCobrar(FrmRegistroPagos fc, ArrayList<Cliente> cl) {
        CuentaPorCobrar cat = new CuentaPorCobrar();
        
        cat.setIdCliente(cl.get(fc.cbxidcuenta.getSelectedIndex()).getIdCliente());
        cat.setMonto(Double.parseDouble(fc.txtMonto.getText()));
        cat.setFechaEmision(fc.txtFechaPago.getText());
        cat.setFechaVencimiento(fc.txtMetodoPago.getText());
        cat.setEstado(fc.chActivo.isSelected() ? "ACTIVO" : "INACTIVO");
        
        return cat;
    }
    
    public static void MostrarEnTabla(FrmRegistroPagos fc,
            ArrayList<CuentaPorCobrar> Lista) {
        String titulos[] = {"ID CLIENTE", "MONTO", "FECHA EMISION",
            "FECHA VENCIMIENTO", "ESTADO"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        fc.tblDatos.setModel(mt);
        for (int i = 0; i < Lista.size(); i++) {
            mt.addRow(Lista.get(i).Registro(i + 1));
        }
    }
}
