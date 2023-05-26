/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.MatriculaDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.UnidadDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import com.iesiliberis.crudcentroeducativo.entidades.Matricula;
import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
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
public class frmMatriculaDetalle extends javax.swing.JFrame {
    /**
     * Creates new form frmAlumnoDetalle
     */
    public frmMatriculaDetalle() {
        initComponents();
        int x = 840; // Coordenada X
        int y = 350; // Coordenada Y
        setLocation(x, y);
        txtfMatricula.setText(String.valueOf(LocalDate.now()));
        btnAceptar.setVisible(true);
        btnModificar.setVisible(false);
        configTablaAlumnos();
        cargaTablaAlumnos();
        configTablaUnidad();
        cargaTablaUnidad();
        
    }
    
    public frmMatriculaDetalle(Matricula m) {
        initComponents();
        int x = 840; // Coordenada X
        int y = 350; // Coordenada Y
        setLocation(x, y);
        btnAceptar.setVisible(false);
        btnModificar.setVisible(true);
        configTablaAlumnos();
        cargaTablaAlumnos();
        configTablaUnidad();
        cargaTablaUnidad();
        cargaDatos(m);
        txtfMatricula.setEditable(true);
    }
    
    private void configTablaAlumnos(){ 
    
        String col[]={"ID","DNI","NOMBRE","APELLIDOS","FECHA NACIMIENTO"};
        
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
        String[] fila=new String[5];
        
        modelo.setNumRows(0);
        try{
            List<Alumno> lst=alumControler.getAll();
            
            for( Alumno alum :lst){
                fila[0]=""+alum.getId();
                fila[1]=""+alum.getDni();
                fila[2]=""+alum.getNombre();
                fila[3]=""+alum.getApellido1()+ " " + alum.getApellido2();
                fila[4]=""+alum.getFnacimiento();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtAlumnos.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    private void configTablaUnidad(){ 
    
        String col[]={"ID","CODIGO","NOMBRE"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtUnidades.setModel(modelo);
        jtUnidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);      
}

    private void cargaTablaUnidad(){
        DefaultTableModel modelo=(DefaultTableModel)jtUnidades.getModel();
        
        UnidadDaoImp unidadControler=UnidadDaoImp.getInstance();
        String[] fila=new String[3];
        
        modelo.setNumRows(0);
        try{
            List<Unidad> lst=unidadControler.getAll();
            
            for( Unidad uni :lst){
                fila[0]=""+uni.getId();
                fila[1]=""+uni.getCodigo();
                fila[2]=""+uni.getNombre();
                
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtUnidades.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    private void cargaDatos(Matricula m) {
        
        MatriculaDaoImp mdi = MatriculaDaoImp.getInstance();
        
        try {
            Matricula matricula = mdi.getById(m.getIdmatricula());

            AlumnoDaoImp adi = AlumnoDaoImp.getInstance();
            Alumno alum = adi.getById(matricula.getIdalumno());
            
            UnidadDaoImp udi = UnidadDaoImp.getInstance();
            Unidad uni = udi.getById(matricula.getIdunidad());
            
            txtId.setText(String.valueOf(matricula.getIdmatricula()));
            txtUnidad.setText(uni.getCodigo());
            txtidAlumno.setText(alum.getDni());
            
            txtDescripcion.setText(matricula.getDescripcion());
            txtfMatricula.setText(String.valueOf(matricula.getfMatricula()));
            txtfBaja.setText(String.valueOf(matricula.getfBaja()));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(frmMatriculaDetalle.class.getName()).log(Level.SEVERE, null, ex);
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
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfMatricula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtfBaja = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUnidades = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtidAlumno = new javax.swing.JTextField();
        txtUnidad = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de matriculas");
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Detalle Matricula");
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
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 20, -1));

        txtId.setEditable(false);
        txtId.setFocusable(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 40, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 220, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripcion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, -1));

        txtfMatricula.setEditable(false);
        txtfMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfMatriculaActionPerformed(evt);
            }
        });
        jPanel1.add(txtfMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 79, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Matricula");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha Baja");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));
        jPanel1.add(txtfBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 88, -1));

        jtUnidades.setModel(new javax.swing.table.DefaultTableModel(
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
        jtUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUnidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUnidades);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 270, 220));

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAlumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtAlumnos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 370, 220));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alumnos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unidades");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Unidad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Alumno");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        txtidAlumno.setEditable(false);
        txtidAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(txtidAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        txtUnidad.setEditable(false);
        jPanel1.add(txtUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtfMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfMatriculaActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        // TODO add your handling code here:
        
        MatriculaDaoImp mdi = MatriculaDaoImp.getInstance();
        
        try {
            Matricula m = new Matricula();
            
            Object valor = jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0);
            String strValor = (String) valor;
            int idalum = Integer.parseInt(strValor);
            
            Object valor1 = jtUnidades.getValueAt(jtUnidades.getSelectedRow(), 0);
            String strValor1 = (String) valor1;
            int idunid = Integer.parseInt(strValor1);
            
            m.setIdalumno(idalum);
            m.setIdunidad(idunid);
            m.setDescripcion(txtDescripcion.getText());
            
            if (txtfBaja.getText().equalsIgnoreCase("null")) {
                m.setfBaja(null);
            } else {
                m.setfBaja(Date.valueOf(txtfBaja.getText()));
            }
            
            m.setfMatricula(Date.valueOf(txtfMatricula.getText()));
            
            try {
                mdi.add(m);
                JOptionPane.showMessageDialog(this, "Matricula añadida correctamente.");
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
            
            Object valor = jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0);
            String strValor = (String) valor;
            int idalum = Integer.parseInt(strValor);
            int idalumno = Integer.valueOf(idalum);
            
            Object valor1 = jtUnidades.getValueAt(jtUnidades.getSelectedRow(), 0);
            String strValor1 = (String) valor1;
            int iduni = Integer.parseInt(strValor1);
            int idunidad = Integer.valueOf(iduni);
            
            Date fmatricula = Date.valueOf(txtfMatricula.getText());
            Date fbaja;
            if (txtfBaja.getText().equalsIgnoreCase("null")) {
                fbaja = null;
            } else {
                fbaja = Date.valueOf(txtfBaja.getText());
            }
            
            String descripcion = txtDescripcion.getText();
            
            MatriculaDaoImp mdi = MatriculaDaoImp.getInstance();
            Matricula m = new Matricula();

            m.setIdmatricula(id);
            m.setIdunidad(idunidad);
            m.setIdalumno(idalumno);
            m.setDescripcion(descripcion);
            m.setfMatricula(fmatricula);
            m.setfBaja(fbaja);

            try {
                mdi.update(m);
                JOptionPane.showMessageDialog(this, "Matricula modificada");
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se han rellenado todos los campos." + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void txtidAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidAlumnoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtidAlumnoActionPerformed

    private void jtAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAlumnosMouseClicked
        // TODO add your handling code here:
        Object id = jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 1);
        
        txtidAlumno.setText((String) id);
    }//GEN-LAST:event_jtAlumnosMouseClicked

    private void jtUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUnidadesMouseClicked
        // TODO add your handling code here:
        Object id = jtUnidades.getValueAt(jtUnidades.getSelectedRow(), 1);
        
        txtUnidad.setText((String) id);
    }//GEN-LAST:event_jtUnidadesMouseClicked

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
            java.util.logging.Logger.getLogger(frmMatriculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMatriculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMatriculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMatriculaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMatriculaDetalle().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtAlumnos;
    private javax.swing.JTable jtUnidades;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUnidad;
    private javax.swing.JTextField txtfBaja;
    private javax.swing.JTextField txtfMatricula;
    private javax.swing.JTextField txtidAlumno;
    // End of variables declaration//GEN-END:variables
}
