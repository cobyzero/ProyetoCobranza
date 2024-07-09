/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Procesos;

import Modelo.CuentaPorCobrar;
import Vista.FrmCuentasPorCobrar;
import Vista.FrmHistorial;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edyne
 */
public class ProcesosHistorial {

    public static void Presentacion(FrmHistorial fi) {
        fi.setVisible(true);
        fi.setTitle("Historial");
    }

    public static void LimpiarEntradas(FrmCuentasPorCobrar fc) {
        // fc.txtIdcat.setText("");
        // fc.txtNomcat.setText("");
        // fc.txaDesc.setText("");
        // fc.txtIdcat.requestFocus();
    }//fin limpiar

    public static void MostrarEnTabla(FrmHistorial fc,
            ArrayList<CuentaPorCobrar> Lista) {
        String titulos[] = {"ID CLIENTE", "MONTO", "FECHA EMISION",
            "FECHA VENCIMIENTO", "ESTADO"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        fc.table.setModel(mt);
        for (int i = 0; i < Lista.size(); i++) {
            mt.addRow(Lista.get(i).Registro(i + 1));
        }
    }

    public static void ExportarAPDF(String nombreArchivo, ArrayList<CuentaPorCobrar> cuentas) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Reporte de Cuentas por Cobrar", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            PdfPTable table = new PdfPTable(6); // 6 columns
            addTableHeader(table);

            for (CuentaPorCobrar cuenta : cuentas) {
                table.addCell(String.valueOf(cuenta.getIdCuenta()));
                table.addCell(String.valueOf(cuenta.getIdCliente()));
                table.addCell(cuenta.getFechaEmision());
                table.addCell(cuenta.getFechaVencimiento());
                table.addCell(String.valueOf(cuenta.getMonto()));
                table.addCell(cuenta.getEstado());
            }

            document.add(table);

            document.close();

            JOptionPane.showMessageDialog(null, "PDF exportado exitosamente a: " + nombreArchivo);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void addTableHeader(PdfPTable table) {
        Stream.of("ID Cuenta", "ID Cliente", "Fecha Emisión", "Fecha Vencimiento", "Monto", "Estado")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

}
