package Vista;


import Configuracion.Conexion;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class aaaaa extends javax.swing.JInternalFrame {

     public JTextField nombreField;
   public JTextField apellidoField;
    public JTextField direccionField;
    public JTextField telefonoField;
    public JTextField emailField;
    public JTextField ciudadField;
    public JTextField estadoField;
    public JTextField codigoPostalField;

    public JButton guardarButton;
   public JButton cancelarButton;
    public JButton limpiarButton;
    public JButton salirButton;
    public aaaaa() {
        initComponents();
        nombreField = new JTextField();
        apellidoField = new JTextField();
        direccionField = new JTextField();
        telefonoField = new JTextField();
        emailField = new JTextField();
        ciudadField = new JTextField();
        estadoField = new JTextField();
        codigoPostalField = new JTextField();

        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");
        limpiarButton = new JButton("Limpiar");
        salirButton = new JButton("Salir");

        // Aquí agregas los componentes al frame, usando el layout que prefieras
        setLayout(new java.awt.GridLayout(9, 2)); // Por ejemplo, un GridLayout de 9 filas y 2 columnas

        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Apellido:"));
        add(apellidoField);
        add(new JLabel("Dirección:"));
        add(direccionField);
        add(new JLabel("Teléfono:"));
        add(telefonoField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Ciudad:"));
        add(ciudadField);
        add(new JLabel("Estado:"));
        add(estadoField);
        add(new JLabel("Código Postal:"));
        add(codigoPostalField);

        add(guardarButton);
        add(cancelarButton);
        add(limpiarButton);
        add(salirButton);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
    }
 private void guardarCliente() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        String email = emailField.getText();
        String ciudad = ciudadField.getText();
        String estado = estadoField.getText();
        String codigoPostal = codigoPostalField.getText();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.HacerConexion();
            if (conn != null) {
                String sql = "INSERT INTO clientes (nombre, apellido, direccion, telefono, email, ciudad, estado, codigo_postal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nombre);
                stmt.setString(2, apellido);
                stmt.setString(3, direccion);
                stmt.setString(4, telefono);
                stmt.setString(5, email);
                stmt.setString(6, ciudad);
                stmt.setString(7, estado);
                stmt.setString(8, codigoPostal);

                stmt.executeUpdate();
                System.out.println("Cliente guardado: " + nombre + " " + apellido);
            } else {
                System.out.println("Error de conexión a la base de datos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para cancelar la operación
    private void cancelar() {
        System.out.println("Operación cancelada");
    }

    // Método para limpiar los campos del formulario
    private void limpiarCampos() {
        nombreField.setText("");
        apellidoField.setText("");
        direccionField.setText("");
        telefonoField.setText("");
        emailField.setText("");
        ciudadField.setText("");
        estadoField.setText("");
        codigoPostalField.setText("");
    }

    // Método para cerrar el frame
    private void salir() {
        dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
