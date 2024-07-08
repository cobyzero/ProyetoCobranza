package Vista;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Pool
 */
public class PreguntasFrecuentes extends javax.swing.JFrame {

     private JTextArea txtPreguntasRespuestas;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnCerrar;

    private String[] preguntas;
    private String[] respuestas;
    private int preguntaActual;
    public PreguntasFrecuentes() {
        initComponents();
        initComponentss();
        initPreguntasRespuestas();
    }
private void initComponentss() {
        setTitle("Preguntas Frecuentes");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtPreguntasRespuestas = new JTextArea();
        txtPreguntasRespuestas.setEditable(false);

        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnCerrar = new JButton("Cerrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnCerrar);

        JScrollPane scrollPane = new JScrollPane(txtPreguntasRespuestas);

        add(scrollPane, "Center");
        add(panelBotones, "South");

        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPreguntaAnterior();
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPreguntaSiguiente();
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void initPreguntasRespuestas() {
        preguntas = new String[]{
            "¿Cómo puedo realizar un pago?",
            "¿Cuál es el horario de atención?",
            "¿Dónde puedo encontrar más información?"
        };

        respuestas = new String[]{
            "Puede realizar un pago a través de nuestra plataforma en línea o visitando nuestras oficinas.",
            "Nuestro horario de atención es de lunes a viernes, de 9 AM a 6 PM.",
            "Puede encontrar más información contactándonos directamente al '+51 907 899 752 Abal Salazar Sebastian Guillermo' O '+51 926 711 538 Sanchez Avalos Jean Pool'."
                
        };

        preguntaActual = 0;
        mostrarPregunta();
    }

    private void mostrarPregunta() {
        txtPreguntasRespuestas.setText("Pregunta: " + preguntas[preguntaActual] + "\n\nRespuesta: " + respuestas[preguntaActual]);
    }

    private void mostrarPreguntaAnterior() {
        if (preguntaActual > 0) {
            preguntaActual--;
            mostrarPregunta();
        }
    }

    private void mostrarPreguntaSiguiente() {
        if (preguntaActual < preguntas.length - 1) {
            preguntaActual++;
            mostrarPregunta();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

