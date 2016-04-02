/*
 * JFrameRubik.java
 * Modificado por IA 2010
 * Interfaz Grafica
 */
package rubik.grafico;

import java.util.Vector;
import rubik.busqueda.BusquedaAnchuraG;
import rubik.busqueda.FactoriaEstrategias;
import rubik.busqueda.Operador;
import rubik.busqueda.Problema;
import rubik.modelo.Cubo;
import rubik.modelo.EstadoRubik;
import rubik.modelo.Movimiento;
import rubik.modelo.OperadorRubik;

public class JFrameRubik extends javax.swing.JFrame {

    /** Creates new form JFrameRubik */
    public JFrameRubik() {
        initComponents();
    }

    private void bloquearComponentes() {
        btDesordenar.setEnabled(false);
        btInicializar.setEnabled(false);
        btMover.setEnabled(false);
        btResolver.setEnabled(false);
        jPanelRubik.setEnabled(false);
    }

    private void desbloquearComponentes() {
        btDesordenar.setEnabled(true);
        btInicializar.setEnabled(true);
        btMover.setEnabled(true);
        btResolver.setEnabled(true);
        jPanelRubik.setEnabled(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc=" C�digo Generado  ">//GEN-BEGIN:initComponents
    private void initComponents() {
        PanelBotones = new javax.swing.JPanel();
        jPanelRubik = new rubik.grafico.JPanelRubik();
        textDesordenar = new javax.swing.JTextField();
        btDesordenar = new javax.swing.JButton();
        spinPasos = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        btResolver = new javax.swing.JButton();
        btMover = new javax.swing.JButton();
        btInicializar = new javax.swing.JButton();
        SeleccionEstrategia = new javax.swing.JComboBox();
        textMover = new javax.swing.JTextField();
        textResolver = new javax.swing.JTextField();
        btAplicar = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        labelSemilla = new javax.swing.JLabel();
        selecionSemilla = new javax.swing.JTextField();

        setTitle("DEMO RUBIK");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        jPanelRubik.setFont(new java.awt.Font("Tahoma", 0, 12));

        textDesordenar.setEditable(false);

        btDesordenar.setText("Desordenar");
        btDesordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesordenarActionPerformed(evt);
            }
        });

        spinPasos.setValue(2);

        jLabel1.setText("Pasos:");

        btResolver.setText("Resolver");
        btResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResolverActionPerformed(evt);
            }
        });

        btMover.setText("Mover");
        btMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoverActionPerformed(evt);
            }
        });

        btInicializar.setText("Inicializar cubo");
        btInicializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInicializarActionPerformed(evt);
            }
        });

        SeleccionEstrategia.setMaximumRowCount(7);
        SeleccionEstrategia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "B\u00fasqueda Anchura en \u00c1rbol", "B\u00fasqueda Costo Uniforme en \u00c1rbol", "B\u00fasqueda Profundidad en \u00c1rbol", "B\u00fasqueda Anchura en Grafo", "B\u00fasqueda Costo Uniforme en Grafo", "B\u00fasqueda Profundidad en Grafo", "B\u00fasqueda Profundidad Interactiva en Grafo" }));
        SeleccionEstrategia.setSelectedIndex(3);

        textResolver.setEditable(false);

        btAplicar.setText("Aplicar");
        btAplicar.setEnabled(false);
        btAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAplicarActionPerformed(evt);
            }
        });

        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        labelSemilla.setText("Semilla:");

        selecionSemilla.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        selecionSemilla.setText("62144");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelRubik, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textResolver, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                                            .addComponent(textMover, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(274, 274, 274)
                                        .addComponent(btInicializar)
                                        .addGap(10, 10, 10)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btMover, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(btSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(btAplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SeleccionEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(labelSemilla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selecionSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btDesordenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinPasos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDesordenar, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btDesordenar)
                            .addComponent(textDesordenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelRubik, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinPasos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SeleccionEstrategia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSemilla)
                            .addComponent(selecionSemilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btResolver)
                            .addComponent(textResolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAplicar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btMover)
                            .addComponent(textMover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btInicializar)
                            .addComponent(btSalir))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAplicar, btSalir, spinPasos, textDesordenar, textMover, textResolver});

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btDesordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesordenarActionPerformed
    String movimientos = desordenarCubo(((Integer) spinPasos.getValue()).intValue());
    textDesordenar.setText(movimientos);
    textResolver.setText("");    
    btAplicar.setEnabled(false);
}//GEN-LAST:event_btDesordenarActionPerformed


private void btResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResolverActionPerformed
    Runnable hiloBuscador = new Runnable() {
        public void run() {
            bloquearComponentes();
            String solucion ="";
            solucion = resolverCubo(jPanelRubik.getCubo());
            desbloquearComponentes();
            textResolver.setText(solucion);
            textDesordenar.setText("");
            if (!solucion.equals("")) {
                btAplicar.setEnabled(true);
            }
        }
    };
    new Thread(hiloBuscador).start();
}//GEN-LAST:event_btResolverActionPerformed

private void btMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoverActionPerformed
    textResolver.setText("");
    textDesordenar.setText("");
    moverCubo(textMover.getText());
    btAplicar.setEnabled(false);
}//GEN-LAST:event_btMoverActionPerformed

private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
    this.salir();
}//GEN-LAST:event_btSalirActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    this.salir();
}//GEN-LAST:event_formWindowClosing

private void btInicializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInicializarActionPerformed
    inicializarCubo();
    textResolver.setText("");
    textDesordenar.setText("");
}//GEN-LAST:event_btInicializarActionPerformed

private void btAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAplicarActionPerformed
    moverCubo(textResolver.getText());
    btAplicar.setEnabled(false);
}//GEN-LAST:event_btAplicarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  new JFrameRubik().setVisible(true);
            }
        });
    }
    
     // panel de botones con: aplicar, desordenar, inicializar, mover, resolver y salir. Ademas un selector de estrategias
    // un gr�fico del cubo, una etiqueta y un campo para la semilla
    // componente JSpinner
    // cuadro de textos para desordenar, mover y resolver.

    // Declaraci�n de varibales -no modificar//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JComboBox SeleccionEstrategia;
    private javax.swing.JButton btAplicar;
    private javax.swing.JButton btDesordenar;
    private javax.swing.JButton btInicializar;
    private javax.swing.JButton btMover;
    private javax.swing.JButton btResolver;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel jLabel1;
    private rubik.grafico.JPanelRubik jPanelRubik;
    private javax.swing.JLabel labelSemilla;
    private javax.swing.JTextField selecionSemilla;
    private javax.swing.JSpinner spinPasos;
    private javax.swing.JTextField textDesordenar;
    private javax.swing.JTextField textMover;
    private javax.swing.JTextField textResolver;
    // Fin de declaraci�n de variables//GEN-END:variables

    
    
    
     // Metodo para mezclar el cubo teniendo en cuenta la semilla elegida y la cantidad de pasos, devuelve los movimientos realizados (como texto)
    private String desordenarCubo(int pasos) {
        Cubo c = jPanelRubik.getCubo();     
        int semilla = Integer.parseInt( selecionSemilla.getText() ); 
        c.rnd.setSeed(semilla); 
        Vector<Movimiento> movimientos = c.mezclar(pasos); 
        jPanelRubik.setCubo(c); 
        String strMovimientos = ""; 
        for (Movimiento m : movimientos) {
            strMovimientos = strMovimientos + m.toString() + " "; 
        }
        return (strMovimientos); 
    }

// Metodo para mover el cubo en funcion de determinados movimientos
    private void moverCubo(String text) {
        if (text != null) {
            Vector<Movimiento> movimientos = new Vector<Movimiento>();
            String[] componentes = text.split(" ");
            for (String etq : componentes) {
                // Burca id del movimiento
                for (int i = 0; i < Movimiento.etq_corta.length; i++) {
                    if (etq.equalsIgnoreCase(Movimiento.etq_corta[i])) {
                        movimientos.add(Movimiento.movimientosPosibles[i]);
                    }
                }
            }
            if (movimientos.size() > 0) {
                jPanelRubik.animarCubo(movimientos);
            }
        }
    }
    
    
     // Metodo que dado un problema (que depende del estado inicial del cubo y de la estrategia seleccionada)
    // muestra el estado inicial del cubo, luego buscas la secuencia de movimientos que llevan a la solucion
    // muestra la secuencia de acciones y resuelve el cubo aplicandolas.
    // muestra el resultado del problema (cubo armado o si no se encontro la solucion)
    // devuelve un string con los movimientos realizados
    private String resolverCubo(Cubo c) {
       Problema problema = new Problema(new EstadoRubik((c)),
                                          FactoriaEstrategias.getEstrategia(SeleccionEstrategia.getSelectedIndex()));
        System.out.println("\nCUBO INICIAL:\n" + c.toString());  
        Vector<Operador> solucion = problema.obtenerSolucion();
        System.out.println("\nSOLUCION:");
        if (solucion != null) {
            for (Operador o : solucion) {
                System.out.println("Accion: " + o.getEtiqueta() + " "); 
                OperadorRubik or = (OperadorRubik) o;
                c.mover(or.getMovimiento());
            }
            System.out.println();
            System.out.println("CUBO FINAL:\n" + c.toString());  
        } else {
            System.out.println("no se ha encontrado solucion");
        }
        String strSolucion = "";
        for (Operador o : solucion) {
            strSolucion = strSolucion + o.getEtiqueta() + " ";
        }
        return (strSolucion);
    }

    private void inicializarCubo() {
        jPanelRubik.setCubo(new Cubo());
    }

    private void salir() {
        System.exit(0);
    }
}
