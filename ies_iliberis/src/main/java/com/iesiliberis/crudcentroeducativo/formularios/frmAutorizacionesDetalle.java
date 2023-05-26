/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.AulaDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.AutorizacionesDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.AutorizadoDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import com.iesiliberis.crudcentroeducativo.entidades.Aula;
import com.iesiliberis.crudcentroeducativo.entidades.Autorizaciones;
import com.iesiliberis.crudcentroeducativo.entidades.Autorizado;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raul AG
 */
public class frmAutorizacionesDetalle extends javax.swing.JFrame {
    /**
     * Creates new form frmAlumnoDetalle
     */
    public frmAutorizacionesDetalle() {
        initComponents();
        int x = 940; // Coordenada X
        int y = 380; // Coordenada Y
        setLocation(x, y);
        configTablaAlumnos();
        cargaTablaAlumnos();
        
        configTablaAutorizados();
        cargaTablaAutorizados();
        
        btnAceptar.setVisible(true);
        btnModificar.setVisible(false);
    }
    
    public frmAutorizacionesDetalle(Autorizaciones a) {
        initComponents();
        int x = 940; // Coordenada X
        int y = 380; // Coordenada Y
        setLocation(x, y);
        configTablaAlumnos();
        cargaTablaAlumnos();
        
        btnAceptar.setVisible(false);
        btnModificar.setVisible(true);
        
        cargaDatos(a);
    }
    
    private void configTablaAutorizados(){ 
    
        String col[]={"ID","NOMBRE","PARENTESTO"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtAutorizados.setModel(modelo);
        jtAutorizados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    
    }

    private void cargaTablaAutorizados(){
        DefaultTableModel modelo=(DefaultTableModel)jtAutorizados.getModel();
        
        AutorizadoDaoImp autorizadoControler=AutorizadoDaoImp.getInstance();
        String[] fila=new String[3];
        
        modelo.setNumRows(0);
        try{
            List<Autorizado> lst=autorizadoControler.getAll();
            
            for( Autorizado aut :lst){
                fila[0]=""+aut.getId();
                fila[1]=""+aut.getNombre();
                fila[2]=""+aut.getParentesto();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtAutorizados.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    private void configTablaAlumnos(){ 
    
     String col[]={"ID","DNI","NOMBRE"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtAlumnos.setModel(modelo);
        jtAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   
    }
    
    private void cargaTablaAlumnos(){
        DefaultTableModel modelo=(DefaultTableModel)jtAlumnos.getModel();
        
        AlumnoDaoImp alumControler=AlumnoDaoImp.getInstance();
        String[] fila=new String[3];
        
        modelo.setNumRows(0);
        try{
            List<Alumno> lst=alumControler.getAll();
            
            for( Alumno alum :lst){
                fila[0]=""+alum.getId();
                fila[1]=""+alum.getDni();
                fila[2]=""+alum.getNombre();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtAlumnos.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }

    private void cargaDatos(Autorizaciones a) {
        
        AutorizacionesDaoImp adi = AutorizacionesDaoImp.getInstance();
        
        try {
            Autorizaciones autorizaciones = adi.getByIdAlumno(a.getIdalumno());

            AlumnoDaoImp alum = AlumnoDaoImp.getInstance();
            Alumno alumno = alum.getById(autorizaciones.getIdalumno());
            
            AutorizadoDaoImp autor = AutorizadoDaoImp.getInstance();
            Autorizado autorizado = autor.getById(autorizaciones.getIdautorizado());
            
            txtidAlumno.setText(alumno.getDni());
            txtidAutorizado.setText(autorizado.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(frmAutorizacionesDetalle.class.getName()).log(Level.SEVERE, null, ex);
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
        txtidAlumno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidAutorizado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAutorizados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de autorizaciones");
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Detalle Autorizaciones");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 17, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 35));

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, 35));

        txtidAlumno.setEditable(false);
        txtidAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(txtidAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 151, 71, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Alumno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 129, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID Autorizado");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 129, -1, -1));

        txtidAutorizado.setEditable(false);
        jPanel1.add(txtidAutorizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 151, 130, -1));

        jtAutorizados.setModel(new javax.swing.table.DefaultTableModel(
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
        jtAutorizados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAutorizadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAutorizados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 190, 180));

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtAlumnos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, 180));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alumnos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Autorizados");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidAlumnoActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        
        try {
            Object valor = jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0);
            String strvalor = (String) valor;
            int idalumno = Integer.valueOf(strvalor);
            
            Object valor1 = jtAutorizados.getValueAt(jtAutorizados.getSelectedRow(), 0);
            String strvalor1 = (String) valor1;
            int idautorizado = Integer.valueOf(strvalor1);
           
            AutorizacionesDaoImp adi = AutorizacionesDaoImp.getInstance();
            Autorizaciones a = new Autorizaciones();

            a.setIdalumno(idalumno);
            a.setIdautorizado(idautorizado);

            try {
                adi.add(a);
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
           
            Object valor = jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0);
            String strvalor = (String) valor;
            int idalumno = Integer.valueOf(strvalor);
            
            Object valor1 = jtAutorizados.getValueAt(jtAutorizados.getSelectedRow(), 0);
            String strvalor1 = (String) valor1;
            int idautorizado = Integer.valueOf(strvalor1);
           
            AutorizacionesDaoImp adi = AutorizacionesDaoImp.getInstance();
            Autorizaciones a = new Autorizaciones();

            a.setIdalumno(idalumno);
            a.setIdautorizado(idautorizado);

            try {
                adi.update(a);
                JOptionPane.showMessageDialog(this, "Autorizacion modificada");
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se han rellenado todos los campos.");
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
        // TODO add your handling code here:
        Object valor = jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 1);
        String strvalor = (String) valor;
        txtidAlumno.setText(strvalor);
    }//GEN-LAST:event_jtAlumnosMouseClicked

    private void jtAutorizadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAutorizadosMouseClicked
        // TODO add your handling code here:
        Object valor = jtAutorizados.getValueAt(jtAutorizados.getSelectedRow(), 1);
        String strvalor = (String) valor;
        txtidAutorizado.setText(strvalor);
    }//GEN-LAST:event_jtAutorizadosMouseClicked

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
            java.util.logging.Logger.getLogger(frmAutorizacionesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAutorizacionesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAutorizacionesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAutorizacionesDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAutorizacionesDetalle().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTable jtAutorizados;
    private javax.swing.JTextField txtidAlumno;
    private javax.swing.JTextField txtidAutorizado;
    // End of variables declaration//GEN-END:variables
}
