/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.AulaDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.CursoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.PersonalDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.UnidadDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import com.iesiliberis.crudcentroeducativo.entidades.Aula;
import com.iesiliberis.crudcentroeducativo.entidades.Curso;
import com.iesiliberis.crudcentroeducativo.entidades.Personal;
import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
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
public class frmUnidadDetalle extends javax.swing.JFrame {
    /**
     * Creates new form frmAlumnoDetalle
     */
    public frmUnidadDetalle() {
        initComponents();
        int x = 840; // Coordenada X
        int y = 380; // Coordenada Y
        setLocation(x, y);
        configTablaAula();
        cargaTablaAula();
        configTablaPersonal();
        cargaTablaPersonal();
        configTablaCurso();
        cargaTablaCurso();
        btnAceptar.setVisible(true);
        btnModificar.setVisible(false);
    }
    
    public frmUnidadDetalle(Unidad u) {
        initComponents();
        int x = 840; // Coordenada X
        int y = 380; // Coordenada Y
        setLocation(x, y);
        configTablaAula();
        cargaTablaAula();
        configTablaPersonal();
        cargaTablaPersonal();
        configTablaCurso();
        cargaTablaCurso();
        btnAceptar.setVisible(false);
        btnModificar.setVisible(true);
        
        cargaDatos(u);
    }

    private void configTablaCurso(){ 
    
        String col[]={"ID","CODIGO"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtCurso.setModel(modelo);
        jtCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   
    }
   
    private void cargaTablaCurso(){
        DefaultTableModel modelo=(DefaultTableModel)jtCurso.getModel();
        
        CursoDaoImp cursoControler=CursoDaoImp.getInstance();
        String[] fila=new String[2];
        
        modelo.setNumRows(0);
        try{
            List<Curso> lst=cursoControler.getAll();
            
            for( Curso cur :lst){
                fila[0]=""+cur.getId();
                fila[1]=""+cur.getCodigo();
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtCurso.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    private void configTablaAula(){ 
    
        String col[]={"ID","CODIGO"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtAula.setModel(modelo);
        jtAula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);     
}
   
    private void cargaTablaAula(){
        DefaultTableModel modelo=(DefaultTableModel)jtAula.getModel();
        
        AulaDaoImp aulacontroller=AulaDaoImp.getInstance();
        System.out.println(aulacontroller);
        String[] fila=new String[2];
        
        modelo.setNumRows(0);
        try{
            List<Aula> lst=aulacontroller.getAll();
            
            for( Aula a :lst){
                fila[0]=""+a.getId();
                fila[1]=""+a.getCodigo();
                
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtAula.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    private void configTablaPersonal(){ 
    
     String col[]={"ID","DNI","NOMBRE"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtPersonal.setModel(modelo);
        jtPersonal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);     
}
   
   
    private void cargaTablaPersonal(){
        DefaultTableModel modelo=(DefaultTableModel)jtPersonal.getModel();
        
        PersonalDaoImp personalControler=PersonalDaoImp.getInstance();
        String[] fila=new String[3];
        
        modelo.setNumRows(0);
        try{
            List<Personal> lst=personalControler.getAll();
            
            for( Personal pers :lst){
                fila[0]=""+pers.getId();
                fila[1]=""+pers.getDni();
                fila[2]=""+pers.getNombre();
                
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtPersonal.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
        }
    }
    
    private void cargaDatos(Unidad u) {
        
        UnidadDaoImp udi = UnidadDaoImp.getInstance();
        
        try {
            
            Unidad unidad = udi.getById(u.getId());

            CursoDaoImp cdi = CursoDaoImp.getInstance();
            Curso c = cdi.getById(unidad.getIdcurso());
            
            PersonalDaoImp pdi = PersonalDaoImp.getInstance();
            Personal p = pdi.getById(unidad.getIdtutor());
            
            AulaDaoImp adi = AulaDaoImp.getInstance();
            Aula a = adi.getById(unidad.getIdaula());
            
            txtId.setText(String.valueOf(unidad.getId()));
            txtCodigo.setText(unidad.getCodigo());
            txtNombre.setText(unidad.getNombre());
            txtObservaciones.setText(unidad.getObservaciones());
            txtIdCurso.setText(c.getCodigo());
            txtIdtutor.setText(p.getDni());
            txtIdaula.setText(a.getCodigo());
            
        } catch (SQLException ex) {
            Logger.getLogger(frmUnidadDetalle.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
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
        txtIdCurso = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdtutor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdaula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAula = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCurso = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtPersonal = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de unidades");
        setBackground(new java.awt.Color(102, 102, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Detalle Unidad");
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
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        txtId.setEditable(false);
        txtId.setFocusable(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 30, -1));

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 71, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 100, -1));

        txtObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionesActionPerformed(evt);
            }
        });
        jPanel1.add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 80, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Observaciones");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Curso");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        txtIdCurso.setEditable(false);
        jPanel1.add(txtIdCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 80, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tutor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        txtIdtutor.setEditable(false);
        jPanel1.add(txtIdtutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 80, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Aula");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        txtIdaula.setEditable(false);
        jPanel1.add(txtIdaula, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 70, -1));

        jtAula.setModel(new javax.swing.table.DefaultTableModel(
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
        jtAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAulaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAula);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 200, 140));

        jtCurso.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCursoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtCurso);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 190, 140));

        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        jtPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPersonalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtPersonal);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 190, 140));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cursos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tutores");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Aulas");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
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
            
            Object valor = jtCurso.getValueAt(jtCurso.getSelectedRow(), 0);
            String strValor = (String) valor;
            int idcurso = Integer.parseInt(strValor); 
            
            Object valor1 = jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 0);
            String strValor1 = (String) valor1;
            int idtutor = Integer.parseInt(strValor1);
            
            Object valor2 = jtAula.getValueAt(jtAula.getSelectedRow(), 0);
            String strValor2 = (String) valor2;
            int idaula = Integer.parseInt(strValor2);
            
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String observaciones = txtObservaciones.getText();
        
            UnidadDaoImp udi = UnidadDaoImp.getInstance();
            Unidad u = new Unidad();

            u.setCodigo(codigo);
            u.setNombre(nombre);
            u.setObservaciones(observaciones);
            u.setIdcurso(idcurso);
            u.setIdtutor(idtutor);
            u.setIdaula(idaula);
            
            try {
                udi.add(u);
                JOptionPane.showMessageDialog(this, "Unidad añadida");
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
            Object valor = jtCurso.getValueAt(jtCurso.getSelectedRow(), 0);
            String strValor = (String) valor;
            int idcurso = Integer.parseInt(strValor); 
            
            Object valor1 = jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 0);
            String strValor1 = (String) valor1;
            int idtutor = Integer.parseInt(strValor1);
            
            Object valor2 = jtAula.getValueAt(jtAula.getSelectedRow(), 0);
            String strValor2 = (String) valor2;
            int idaula = Integer.parseInt(strValor2);
            
            int id = Integer.valueOf(txtId.getText());
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String observaciones = txtObservaciones.getText();
            
            UnidadDaoImp udi = UnidadDaoImp.getInstance();
            Unidad u = new Unidad();

            u.setId(id);
            u.setCodigo(codigo);
            u.setNombre(nombre);
            u.setObservaciones(observaciones);
            u.setIdcurso(idcurso);
            u.setIdtutor(idtutor);
            u.setIdaula(idaula);
            
            try {
                udi.update(u);
                JOptionPane.showMessageDialog(this, "Unidad modificada");
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
//JOptionPane.showMessageDialog(this, "No se han rellenado todos los campos.");
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void jtCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCursoMouseClicked
        // TODO add your handling code here:
        Object valor = jtCurso.getValueAt(jtCurso.getSelectedRow(), 1);
        String strValor = (String) valor;
        txtIdCurso.setText(strValor);
    }//GEN-LAST:event_jtCursoMouseClicked

    private void jtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPersonalMouseClicked
        // TODO add your handling code here:
        Object valor = jtPersonal.getValueAt(jtPersonal.getSelectedRow(), 1);
        String strValor = (String) valor;
        txtIdtutor.setText(strValor);
    }//GEN-LAST:event_jtPersonalMouseClicked

    private void jtAulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAulaMouseClicked
        // TODO add your handling code here:
        Object valor = jtAula.getValueAt(jtAula.getSelectedRow(), 1);
        String strValor = (String) valor;
        txtIdaula.setText(strValor);
    }//GEN-LAST:event_jtAulaMouseClicked

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
            java.util.logging.Logger.getLogger(frmUnidadDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUnidadDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUnidadDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUnidadDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUnidadDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jtAula;
    private javax.swing.JTable jtCurso;
    private javax.swing.JTable jtPersonal;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCurso;
    private javax.swing.JTextField txtIdaula;
    private javax.swing.JTextField txtIdtutor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
