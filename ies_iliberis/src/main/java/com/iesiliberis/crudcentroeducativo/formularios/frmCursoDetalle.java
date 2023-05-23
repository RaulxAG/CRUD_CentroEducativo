/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.CursoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import com.iesiliberis.crudcentroeducativo.entidades.Curso;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul AG
 */
public class frmCursoDetalle extends javax.swing.JFrame {
    /**
     * Creates new form frmAlumnoDetalle
     */
    public frmCursoDetalle() {
        initComponents();
        int x = 940; // Coordenada X
        int y = 380; // Coordenada Y
        setLocation(x, y);
        
        btnAceptar.setVisible(true);
        btnModificar.setVisible(false);
    }
    
    public frmCursoDetalle(Curso c) {
        initComponents();
        int x = 940; // Coordenada X
        int y = 380; // Coordenada Y
        setLocation(x, y);
        
        btnAceptar.setVisible(false);
        btnModificar.setVisible(true);
        
        cargaDatos(c);
    }

    private void cargaDatos(Curso c) {
        
        CursoDaoImp cdi = CursoDaoImp.getInstance();
        
        try {
            Curso curso = cdi.getById(c.getId());

            txtId.setText(String.valueOf(curso.getId()));
            txtCodigo.setText(curso.getCodigo());
            txtNombre.setText(curso.getNombre());
            txtObservaciones.setText(curso.getObservaciones());
            txtIdCursoaca.setText(String.valueOf(curso.getIdcursoacademico()));
            
        } catch (SQLException ex) {
            Logger.getLogger(frmCursoDetalle.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdCursoaca = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de cursos");
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Detalle Curso");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 17, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, 35));

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 35));

        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("id.");
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 58, -1, -1));

        txtId.setEditable(false);
        txtId.setFocusable(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 80, 34, -1));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 151, 71, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 129, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 129, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 151, 300, -1));

        txtObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionesActionPerformed(evt);
            }
        });
        jPanel1.add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 213, 79, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Observaciones");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 191, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("id. curso academico");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));
        jPanel1.add(txtIdCursoaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 88, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacionesActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        
        try {
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String observaciones = txtObservaciones.getText();
            String idcursoaca = txtIdCursoaca.getText();
            String fecha = txtObservaciones.getText();
        
            CursoDaoImp cdi = CursoDaoImp.getInstance();
            Curso c = new Curso();

            c.setCodigo(codigo);
            c.setNombre(nombre);
            c.setObservaciones(observaciones);
            c.setIdcursoacademico(Integer.valueOf(idcursoaca));
            
            try {
                cdi.add(c);
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se han rellenado todos los campos.");
        }
        
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
       try {
            int id = Integer.valueOf(txtId.getText());
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String observaciones = txtObservaciones.getText();
            int idcursoacademico = Integer.valueOf(txtIdCursoaca.getText());
            
            CursoDaoImp cdi = CursoDaoImp.getInstance();
            Curso c = new Curso();

            c.setId(id);
            c.setCodigo(codigo);
            c.setNombre(nombre);
            c.setObservaciones(observaciones);
            c.setIdcursoacademico(idcursoacademico);
            
            try {
                cdi.update(c);
                JOptionPane.showMessageDialog(this, "Usuario modificado");
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se han rellenado todos los campos.");
        }
    }//GEN-LAST:event_btnModificarMouseClicked

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
            java.util.logging.Logger.getLogger(frmCursoDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCursoDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCursoDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCursoDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCursoDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCursoaca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
