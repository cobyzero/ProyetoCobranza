/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import AccesoDatos.DAO_RegistrodePago;
import AccesoDatos.DAO_Clientes;
import Modelo.Pago;
import Procesos.Mensajes;
import Procesos.ProcesoRegistroPago;
import Vista.FrmRegistroPagos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroPagos implements ActionListener {
    
    private FrmRegistroPagos vista;
    private DAO_RegistrodePago dao;
    private DAO_Clientes dao_clientes;

    private int idPago;
    public RegistroPagos(FrmRegistroPagos _vista) {
        this.vista = _vista;

        dao = new DAO_RegistrodePago();
        dao_clientes = new DAO_Clientes();
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        ProcesoRegistroPago.Cargar(this.vista, dao_clientes.ListarClientes());
        ProcesoRegistroPago.MostrarEnTabla(this.vista, dao.ListarRegistrosPago());
        ProcesoRegistroPago.Presentacion(this.vista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            dao.AgregarPago(RegistroPagos.LeerPago(vista, dao_clientes.ListarClientes()));
            ProcesoRegistroPago.LimpiarEntradas(vista);
            ProcesoRegistroPago.MostrarEnTabla(vista, dao.ListarPagos());
        }
        if (e.getSource() == vista.btnConsultar) {
            idPago = Mensajes.Leer("Ingrese la ID a buscar");
            Pago pago = dao.BuscarPago(idPago);
            if (pago == null) {
                Mensajes.MostrarTexto("El ID " + idPago + " no existe");
            } else {
                for (int i = 0; i < dao_clientes.ListarClientes().size(); i++) {
                    if (dao_clientes.ListarClientes().get(i).getIdCliente() == idPago) {
                        vista.cbxidcuenta.setSelectedIndex(i);
                    }
                }

                vista.txtMonto.setText(String.valueOf(pago.getMonto()));
                vista.txtFechaPago.setText(pago.getFechaPago());
                vista.txtMetodoPago.setText(pago.getMetodoPago());
                vista.chActivo.setSelected(pago.getEstado().equals("ACTIVO"));

                vista.txtMonto.requestFocus();
            }
        }//fin consultar
        if (e.getSource() == vista.btnActualizar) {

            Pago pago = ProcesosPagos.LeerPago(vista, dao_clientes.ListarClientes());
            pago.setIdPago(idPago);
            dao.ActualizarPago(pago);
            ProcesosPagos.LimpiarEntradas(vista);
            Mensajes.MostrarTexto("Datos actualizados!!!!!");
            ProcesosPagos.MostrarEnTabla(vista, dao.ListarPagos());
        }//fin actualizar
        if (e.getSource() == vista.btnEliminar) {
            int resp = Mensajes.Preguntar("Confirmar!!!!",
                    "Desea eliminar el ID " + idPago + " ? ");
            if (resp == 0) {// elijo OK
                dao.EliminarPago(idPago);
                ProcesosPagos.LimpiarEntradas(vista);
                Mensajes.MostrarTexto("Registro eliminado!!!!!");
                ProcesosPagos.MostrarEnTabla(vista, dao.ListarPagos());
            }
        }
    }
    
}
