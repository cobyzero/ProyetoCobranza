/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import AccesoDatos.DAO_Clientes;
import AccesoDatos.DAO_CuentasPorCobrar;
import Modelo.Cliente;
import Modelo.CuentaPorCobrar;
import Procesos.Mensajes;
import Procesos.ProcesosCuentasPorCobrar;
import Vista.FrmCuentasPorCobrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author edyne
 */
public class CuentasPorCobrarControlador implements ActionListener {

    private FrmCuentasPorCobrar vista;
    private DAO_CuentasPorCobrar dao;
    private DAO_Clientes dao_clientes;

    private int idCuenta;

    public CuentasPorCobrarControlador(FrmCuentasPorCobrar _vista) {
        this.vista = _vista;

        dao = new DAO_CuentasPorCobrar();
        dao_clientes = new DAO_Clientes();
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        ProcesosCuentasPorCobrar.Cargar(this.vista, dao_clientes.ListarClientes());
        ProcesosCuentasPorCobrar.MostrarEnTabla(this.vista, dao.ListarCuentaPorCobrar());
        ProcesosCuentasPorCobrar.Presentacion(this.vista);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            dao.AgregarCuentaPorCobrar(ProcesosCuentasPorCobrar.LeerCuentaPorCobrar(vista, dao_clientes.ListarClientes()));
            ProcesosCuentasPorCobrar.LimpiarEntradas(vista);
            ProcesosCuentasPorCobrar.MostrarEnTabla(vista, dao.ListarCuentaPorCobrar());
        }
        if (e.getSource() == vista.btnConsultar) {
            idCuenta = Mensajes.Leer("Ingrese la ID a buscar");
            CuentaPorCobrar cat = dao.BuscarCuentaPorCobrar(idCuenta);
            if (cat == null) {
                Mensajes.MostrarTexto("El ID " + idCuenta + " no existe");
            } else {
                for (int i = 0; i < dao_clientes.ListarClientes().size(); i++) {
                    if (dao_clientes.ListarClientes().get(i).getIdCliente() == idCuenta) {
                        vista.cbxCliente.setSelectedIndex(i);
                    }
                }

                vista.txtMonto.setText(String.valueOf(cat.getMonto()));
                vista.txtFechaEmision.setText(cat.getFechaEmision());
                vista.txtFechaVencimiento.setText(cat.getFechaVencimiento());
                vista.chActivo.setSelected(cat.getEstado().equals("ACTIVO"));

                vista.txtMonto.requestFocus();
            }
        }//fin consultar
        if (e.getSource() == vista.btnActualizar) {
            //  DTOcategoria cat = ProcesosCategorias.LeerCat(vista);
            //  dao.ActualizarCat(cat);
            //  ProcesosCategorias.LimpiarEntradas(vista);
            //  Mensajes.MostrarTexto("Datos actualizados!!!!!");
            //  ProcesosCategorias.MostrarEnTabla(vista, dao.ListarCat());
        }//fin actualizar
        if (e.getSource() == vista.btnEliminar) {
            // int resp = Mensajes.Preguntar("Confirmar!!!!",
            //         "Desea eliminar el ID " + idcat + " ? ");
            // if (resp == 0) {// elijo OK
            //     dao.EliminarCat(idcat);
            //      ProcesosCategorias.LimpiarEntradas(vista);
            //      Mensajes.MostrarTexto("Registro eliminado!!!!!");
            //      ProcesosCategorias.MostrarEnTabla(vista, dao.ListarCat());
            //  }
        }
    }

}
