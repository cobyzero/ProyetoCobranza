/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;
import Modelo.Cliente;
import Modelo.RegistroPago;
import Vista.FrmRegistroPagos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class ProcesoRegistroPago {
    /**
     * Método para mostrar la ventana de registro de pagos.
     * @param frmRegistroPagos El formulario de registro de pagos.
     */
    public static void Presentacion(FrmRegistroPagos frmRegistroPagos) {
        frmRegistroPagos.setVisible(true);
        frmRegistroPagos.setTitle("Registro de Pagos");
    }
    
    /**
     * Método para cargar los clientes disponibles en un combobox.
     * @param frmRegistroPagos El formulario de registro de pagos.
     * @param listaClientes La lista de clientes disponibles.
     */
    public static void Cargar(FrmRegistroPagos frmRegistroPagos, ArrayList<Cliente> listaClientes) {
        frmRegistroPagos.cbxidcuenta.removeAllItems();
        
        for (Cliente cliente : listaClientes) {
            frmRegistroPagos.cbxidcuenta.addItem(cliente.getNombre());
        }
    }
    
    /**
     * Método para limpiar las entradas del formulario de registro de pagos.
     * @param frmRegistroPagos El formulario de registro de pagos.
     */
    public static void LimpiarEntradas(FrmRegistroPagos frmRegistroPagos) {
        frmRegistroPagos.txtMonto.setText("");
        frmRegistroPagos.txtFechaPago.setText("");
        frmRegistroPagos.txtMetodoPago.setText("");
        frmRegistroPagos.chActivo.setSelected(false);
        
        frmRegistroPagos.txtMonto.requestFocus();
    }
    
    /**
     * Método para leer la información de pago ingresada en el formulario.
     * @param frmRegistroPagos El formulario de registro de pagos.
     * @param listaClientes La lista de clientes disponibles.
     * @return Un objeto de tipo Pago con la información ingresada.
     */
    public static RegistroPago LeerPago(FrmRegistroPagos frmRegistroPagos, ArrayList<Cliente> listaClientes) {
        RegistroPago pago = new RegistroPago();
        
        pago.setIdCliente(listaClientes.get(frmRegistroPagos.cbxidcuenta.getSelectedIndex()).getIdCliente());
        pago.setMonto(Double.parseDouble(frmRegistroPagos.txtMonto.getText()));
        pago.setFechaPago(frmRegistroPagos.txtFechaPago.getText());
        pago.setMetodoPago(frmRegistroPagos.txtMetodoPago.getText());
        pago.setEstado(frmRegistroPagos.chActivo.isSelected() ? "ACTIVO" : "INACTIVO");
        
        return pago;
    }
    
    /**
     * Método para mostrar los pagos registrados en una tabla dentro del formulario.
     * @param frmRegistroPagos El formulario de registro de pagos.
     * @param listaPagos La lista de pagos a mostrar.
     */
    public static void MostrarEnTabla(FrmRegistroPagos frmRegistroPagos, ArrayList<RegistroPago> listaPagos) {
        String titulos[] = {"ID CLIENTE", "MONTO", "FECHA PAGO", "METODO PAGO", "ESTADO"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, titulos);
        frmRegistroPagos.tblDatos.setModel(modeloTabla);
        
        for (RegistroPago pago : listaPagos) {
            modeloTabla.addRow(pago.getRegistro());
        }
    }
    
}
