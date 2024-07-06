/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Configuracion.Conexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User901-DOCENTE
 */
public class FrmClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCategorias
     */
    public FrmClientes() {
        initComponents();
    }

    public void ActualizarTablas() {
        try {
            Connection conn = Conexion.HacerConexion();
            if (conn != null) {
                String sql = "SELECT * FROM CLIENTES";
                var ne = conn.prepareStatement(sql);

                var ex = ne.executeQuery();

                while (ex.next()) {
                    Cliente ce = new Cliente();

                    ce.setIdCliente(ex.getInt(1));
                    ce.setNombre(ex.getString(2));
                    ce.setRuc(ex.getString(3));
                    ce.setDireccion(ex.getString(4));
                    ce.setTelefono(ex.getString(5));
                    ce.setContacto(ex.getString(6));
                }

                
 
             } else {
                System.out.println("Error de conexión a la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
           
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtContacto = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRO CUENTAS POR COBRAR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConsultar.setBackground(new java.awt.Color(51, 0, 153));
        btnConsultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("CONSULTAR");
        jPanel1.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 150, 40));

        btnActualizar.setBackground(new java.awt.Color(51, 0, 153));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 150, 40));

        btnEliminar.setBackground(new java.awt.Color(51, 0, 153));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 150, 40));

        btnAgregar.setBackground(new java.awt.Color(51, 0, 153));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 150, 40));

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 240, 60));

        txtRuc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RUC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 240, 60));

        txtContacto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTACTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });
        jPanel1.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 240, 60));

        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIRECCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, 60));

        txtTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TELEFONO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 240, 60));

        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CORREO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 240, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 590));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 650, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombre.getText();
        String ruc = txtRuc.getText();
        String direccion = txtDireccion.getText();
        String telefono = txtTelefono.getText();
        String email = txtCorreo.getText();
        String contacto = txtContacto.getText();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.HacerConexion();
            if (conn != null) {
                String sql = "INSERT INTO clientes (nombre, ruc,  direccion, telefono, email, contacto) VALUES (?, ?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nombre);
                stmt.setString(2, ruc);
                stmt.setString(3, direccion);
                stmt.setString(4, telefono);
                stmt.setString(5, email);
                stmt.setString(6, contacto);

                stmt.executeUpdate();
                System.out.println("Cliente guardado: " + nombre + " " + ruc);
            } else {
                System.out.println("Error de conexión a la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnConsultar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblDatos;
    public javax.swing.JTextField txtContacto;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtRuc;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}