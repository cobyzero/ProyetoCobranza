/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import AccesoDatos.DAO_CuentasPorCobrar;
import Procesos.ProcesosCuentasPorCobrar;
import Procesos.ProcesosHistorial;
import Vista.FrmHistorial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author edyne
 */
public class HistorialControlador implements ActionListener {

    private FrmHistorial vista;
    private DAO_CuentasPorCobrar daoCuentasPorCobrar;

    public HistorialControlador(FrmHistorial _vista) {
        this.vista = _vista;
        daoCuentasPorCobrar = new DAO_CuentasPorCobrar();

        vista.btnFiltrar.addActionListener(this);
        vista.btnPdf.addActionListener(this);
        ProcesosHistorial.Presentacion(vista);
        ProcesosHistorial.MostrarEnTabla(vista, daoCuentasPorCobrar.ListarCuentaPorCobrar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnFiltrar) {
            if (vista.txtAmount.getText().isEmpty()) {
                var lista = daoCuentasPorCobrar.ListarCuentaPorCobrar();
                ProcesosHistorial.MostrarEnTabla(vista, lista);
            } else {

                var lista = daoCuentasPorCobrar.FiltrarLista(Double.parseDouble(vista.txtAmount.getText()));
                ProcesosHistorial.MostrarEnTabla(vista, lista);
            }

        }
        if (e.getSource() == vista.btnPdf) {
            LocalDateTime fechaHoraActual = LocalDateTime.now();

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String fechaHoraFormateada = fechaHoraActual.format(formato);
            if (vista.txtAmount.getText().isEmpty()) {

                var lista = daoCuentasPorCobrar.ListarCuentaPorCobrar();
                ProcesosHistorial.ExportarAPDF("REPORTE_CUENTAS_POR_COBRAR" + fechaHoraFormateada + ".pdf", lista);

            } else {

                var lista = daoCuentasPorCobrar.FiltrarLista(Double.parseDouble(vista.txtAmount.getText()));
                ProcesosHistorial.ExportarAPDF("REPORTE_CUENTAS_POR_COBRAR" + fechaHoraFormateada + ".pdf", lista);

            }

        }

    }

}
