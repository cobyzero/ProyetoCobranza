/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.Cliente;
import Modelo.CuentaPorCobrar;
import Vista.FrmCuentasPorCobrar;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edyne
 */
public class ProcesosCuentasPorCobrar {
    
    public static void Presentacion(FrmCuentasPorCobrar fi) {
        fi.setVisible(true);
        fi.setTitle("Cuentas por Cobrar");
    }
    
    public static void Cargar(FrmCuentasPorCobrar fi, ArrayList<Cliente> lista) {
        fi.cbxCliente.removeAllItems();
        
        for (Cliente e : lista) {
            fi.cbxCliente.addItem(e.getNombre());
        }
        
    }
    
    public static void LimpiarEntradas(FrmCuentasPorCobrar fc) {
        // fc.txtIdcat.setText("");
        // fc.txtNomcat.setText("");
        // fc.txaDesc.setText("");
        // fc.txtIdcat.requestFocus();
    }//fin limpiar

    public static CuentaPorCobrar LeerCuentaPorCobrar(FrmCuentasPorCobrar fc, ArrayList<Cliente> cl) {
        CuentaPorCobrar cat = new CuentaPorCobrar();
        
        cat.setIdCliente(cl.get(fc.cbxCliente.getSelectedIndex()).getIdCliente());
        cat.setMonto(Double.parseDouble(fc.txtMonto.getText()));
        cat.setFechaEmision(fc.txtFechaEmision.getText());
        cat.setFechaVencimiento(fc.txtFechaVencimiento.getText());
        cat.setEstado(fc.chActivo.isSelected() ? "ACTIVO" : "INACTIVO");
        
        return cat;
    }
    
    public static void MostrarEnTabla(FrmCuentasPorCobrar fc,
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
