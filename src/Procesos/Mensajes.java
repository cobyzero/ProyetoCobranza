package Procesos;

import javax.swing.JOptionPane;

public class Mensajes {

    public static void MostrarTexto(String msj) {
        JOptionPane.showMessageDialog(null, msj);
    }

    public static int Leer(String msj) {
        return Integer.parseInt(JOptionPane.showInputDialog(msj));
    }

    public static int Preguntar(String titulo, String mensaje) {
        return JOptionPane.showConfirmDialog(null,
                mensaje, titulo, JOptionPane.YES_NO_OPTION);
    }

}//fin de la clase
