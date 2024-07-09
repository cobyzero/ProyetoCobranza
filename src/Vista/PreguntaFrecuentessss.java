package Vista;


public class PreguntaFrecuentessss extends javax.swing.JInternalFrame {

    private String[] preguntas;
    private String[] respuestas;
    private int preguntaActual;
    public PreguntaFrecuentessss() {
      initComponents();
        initPreguntasRespuestas();
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
        TXTPREGUNTAS.setText("Pregunta: " + preguntas[preguntaActual] + "\n\nRespuesta: " + respuestas[preguntaActual]);
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
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TXTPREGUNTAS = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TXTPREGUNTAS.setColumns(20);
        TXTPREGUNTAS.setRows(5);
        jScrollPane1.setViewportView(TXTPREGUNTAS);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 840, 260));

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 170, 40));

        jButton2.setText("Anterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 170, 40));

        btnsiguiente.setText("Siguientes");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnsiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 170, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mostrarPreguntaAnterior();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed
mostrarPreguntaSiguiente();        // TODO add your handling code here:
    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TXTPREGUNTAS;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
