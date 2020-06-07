/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1.jfperez.progra1_pro_final;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josep
 */
public class Principal extends javax.swing.JFrame {
    
    /**
     * Atributo para manejo de entidades.
     */
    ManejoEntidad manejoEntidad;
    
    /**
     * Modelo de tabla de entidades.
     */
    DefaultTableModel modelEntidad;
    
    /**
     * Atributo de entidad utilizado al seleccionar de tabla.
     */
    Entidad entidad;
    
    /**
     * Indice de entidad seleccionada
     */
    Integer rowEntidad;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        modelEntidad = (DefaultTableModel) this.tblEntidades.getModel();
        manejoEntidad = new ManejoEntidad();
        manejoEntidad.listar();
        for(Entidad entidad: manejoEntidad.getEntidades()) {
            if (entidad.getIndice() != -1) {
                modelEntidad.addRow(new Object[]{entidad.getIndice(), entidad.getNombre()});            
            }
        }
    }
    
    public void limpiarEntidad() {
        this.txtNombreEntidad.setText("");
        this.entidad = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreEntidad = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEntidades = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnGuardarEntidad = new javax.swing.JButton();
        btnEliminarEntidad = new javax.swing.JButton();
        btnLimpiarEntidad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreAtributo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoDato = new javax.swing.JComboBox<>();
        txtLongitud = new javax.swing.JTextField();
        btnGuardarAtributo = new javax.swing.JButton();
        btnEliminarAtributo = new javax.swing.JButton();
        btnLimpiarAtributo = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblAtributos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardarRegistro = new javax.swing.JButton();
        btnEliminarRegistro = new javax.swing.JButton();
        btnLimpiarRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento");

        jScrollPane1.setHorizontalScrollBar(null);

        jLabel1.setText("Entidad");

        tblEntidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indice", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEntidades.getTableHeader().setReorderingAllowed(false);
        tblEntidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEntidadesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblEntidades);
        if (tblEntidades.getColumnModel().getColumnCount() > 0) {
            tblEntidades.getColumnModel().getColumn(0).setHeaderValue("Indice");
            tblEntidades.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        }

        jLabel4.setText("Nombre");

        btnGuardarEntidad.setText("Guardar");
        btnGuardarEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEntidadActionPerformed(evt);
            }
        });

        btnEliminarEntidad.setText("Eliminar");
        btnEliminarEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEntidadActionPerformed(evt);
            }
        });

        btnLimpiarEntidad.setText("Limpiar");
        btnLimpiarEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEntidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnGuardarEntidad)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarEntidad)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiarEntidad))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnGuardarEntidad)
                    .addComponent(btnEliminarEntidad)
                    .addComponent(btnLimpiarEntidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jScrollPane2.setHorizontalScrollBar(null);

        jLabel2.setText("Atributos");

        jLabel5.setText("Nombre");

        jLabel6.setText("Tipo de dato");

        jLabel7.setText("Longitud");

        cmbTipoDato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardarAtributo.setText("Guardar");

        btnEliminarAtributo.setText("Eliminar");

        btnLimpiarAtributo.setText("Limpiar");

        tblAtributos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indice", "Nombre", "Tipo", "Longitud"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblAtributos.getTableHeader().setReorderingAllowed(false);
        tblAtributos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAtributosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblAtributos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreAtributo)
                            .addComponent(cmbTipoDato, 0, 236, Short.MAX_VALUE)
                            .addComponent(txtLongitud))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardarAtributo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarAtributo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLimpiarAtributo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardarAtributo)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cmbTipoDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnEliminarAtributo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiarAtributo)))
                .addContainerGap(343, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(177, Short.MAX_VALUE)))
        );

        jScrollPane2.setViewportView(jPanel2);

        jScrollPane3.setHorizontalScrollBar(null);

        jLabel3.setText("Registros");

        btnGuardarRegistro.setText("Guardar");

        btnEliminarRegistro.setText("Eliminar");

        btnLimpiarRegistro.setText("Limpiar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(btnGuardarRegistro)
                .addGap(37, 37, 37)
                .addComponent(btnEliminarRegistro)
                .addGap(40, 40, 40)
                .addComponent(btnLimpiarRegistro)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnGuardarRegistro)
                    .addComponent(btnEliminarRegistro)
                    .addComponent(btnLimpiarRegistro))
                .addContainerGap(549, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEntidadActionPerformed
        // TODO add your handling code here:
        if (this.txtNombreEntidad.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre de entidad obligatoria");
        } else {
            if (this.txtNombreEntidad.getText().length() > Entidad.cantidadCaracteres ){
                JOptionPane.showMessageDialog(this, "Nombre de entidad debe de ser menor a 200 caracteres.");
            } else {
                if (this.entidad == null) { // registro nuevo
                    this.entidad = new Entidad();
                    this.entidad.setNombre(this.txtNombreEntidad.getText());
                    String mensaje = this.manejoEntidad.guardar(this.entidad);
                    if (this.manejoEntidad.getEntidad() != null) {
                        modelEntidad.addRow(new Object[]{this.entidad.getIndice(), this.entidad.getNombre()});
                        this.limpiarEntidad();
                    }
                    JOptionPane.showMessageDialog(this, mensaje);                    
                } else { // actualizar registro
                    this.entidad.setNombre(this.txtNombreEntidad.getText());
                    String mensaje = this.manejoEntidad.guardar(this.entidad);
                    if (this.manejoEntidad.getEntidad() != null) {
                        this.modelEntidad.setValueAt(this.txtNombreEntidad.getText(), this.rowEntidad, 1); // Nombre
                        this.limpiarEntidad();
                    }
                    JOptionPane.showMessageDialog(this, mensaje);
                    this.limpiarEntidad();
                }
            }
        }
    }//GEN-LAST:event_btnGuardarEntidadActionPerformed

    private void btnLimpiarEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEntidadActionPerformed
        // TODO add your handling code here:
        this.limpiarEntidad();
    }//GEN-LAST:event_btnLimpiarEntidadActionPerformed

    private void btnEliminarEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEntidadActionPerformed
        // TODO add your handling code here:
        String mensaje = this.manejoEntidad.eliminar(this.entidad.getIndice());
        if (this.manejoEntidad.getEntidad() != null) {
            //Eliminado correctamente
            this.modelEntidad.removeRow(this.rowEntidad);
        }
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_btnEliminarEntidadActionPerformed

    private void tblEntidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEntidadesMouseClicked
        // TODO add your handling code here:
        this.rowEntidad = this.tblEntidades.rowAtPoint(evt.getPoint());
        this.entidad = this.manejoEntidad.obtener((Integer)this.tblEntidades.getValueAt(rowEntidad,0));
        this.txtNombreEntidad.setText(this.entidad.getNombre());
    }//GEN-LAST:event_tblEntidadesMouseClicked

    private void tblAtributosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtributosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAtributosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarAtributo;
    private javax.swing.JButton btnEliminarEntidad;
    private javax.swing.JButton btnEliminarRegistro;
    private javax.swing.JButton btnGuardarAtributo;
    private javax.swing.JButton btnGuardarEntidad;
    private javax.swing.JButton btnGuardarRegistro;
    private javax.swing.JButton btnLimpiarAtributo;
    private javax.swing.JButton btnLimpiarEntidad;
    private javax.swing.JButton btnLimpiarRegistro;
    private javax.swing.JComboBox<String> cmbTipoDato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblAtributos;
    private javax.swing.JTable tblEntidades;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombreAtributo;
    private javax.swing.JTextField txtNombreEntidad;
    // End of variables declaration//GEN-END:variables
}
