/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.formularios;

import com.iesiliberis.crudcentroeducativo.controladorDAO.AlumnoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.AulaDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.CursoDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.PersonalDaoImp;
import com.iesiliberis.crudcentroeducativo.controladorDAO.UnidadDaoImp;
import com.iesiliberis.crudcentroeducativo.entidades.Alumno;
import com.iesiliberis.crudcentroeducativo.entidades.Unidad;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sergio
 */
public class frmInternoUnidad extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmInternoAlumnos
     */
    public frmInternoUnidad() {
        initComponents();
        configTabla();
        cargaTabla();
    }

     private void configTabla(){ 
    
     String col[]={"ID","CODIGO","NOMBRE","OBSERVACIONES","CURSO","TUTOR","AULA"};
        
        DefaultTableModel modelo=new DefaultTableModel(col,0){
        
              @Override
              public boolean isCellEditable(int row, int column){
                  return false;
              }
        
        };
        
        jtUnidades.setModel(modelo);
        jtUnidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
        //configuro evento valor cambiado...
/*        jtCursos.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            System.out.println(jtCursos.getValueAt(jtCursos.getSelectedRow(), 0).toString());
            setCampos();
        }
    });
  */      
}
   
   
    private void cargaTabla(){
        DefaultTableModel modelo=(DefaultTableModel)jtUnidades.getModel();
        
        UnidadDaoImp unidadControler=UnidadDaoImp.getInstance();
        CursoDaoImp cdi = CursoDaoImp.getInstance();
        AulaDaoImp adi = AulaDaoImp.getInstance();
        PersonalDaoImp pdi = PersonalDaoImp.getInstance();
        String[] fila=new String[7];
        
        modelo.setNumRows(0);
        try{
            List<Unidad> lst=unidadControler.getAll();
            
            for( Unidad uni :lst){
                fila[0]=""+uni.getId();
                fila[1]=""+uni.getCodigo();
                fila[2]=""+uni.getNombre();
                fila[3]=""+uni.getObservaciones();
                fila[4]=""+cdi.getById(uni.getIdcurso()).getNombre();
                fila[5]=""+pdi.getById(uni.getIdtutor()).getNombre();
                fila[6]=""+adi.getById(uni.getIdaula()).getCodigo();
                
                modelo.addRow(fila);
            }
            //selecciono la primera fila
           jtUnidades.setRowSelectionInterval(0,0); 
           
        }catch(Exception e){
            System.out.println("Error:"+e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUnidades = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Unidades");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnAdd.setText("Añadir");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Unidades");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(13, 13, 13))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUnidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUnidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUnidades);

        btnActualizar.setText("Actualizar");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(52, 52, 52))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            DefaultTableModel modelo=(DefaultTableModel) jtUnidades.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<TableModel>(modelo);

            jtUnidades.setRowSorter(trSorter);

            if (txtBuscar.getText().length()==0) {
                trSorter.setRowFilter(null);
            }else{
                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
            }

        }

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jtUnidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUnidadesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==2){
            // System.out.println("Doble click.....");
            //Cargar el detalle de un alumno
            /*JDialog frame=new JDialog(this,"Detalle Alumno",true);

            jpAlumnoDetalle panel=new jpAlumnoDetalle();

            int idseleccion=Integer.parseInt(jtAlumnos.getValueAt(jtAlumnos.getSelectedRow(), 0).toString());

            panel.CargaDetalle(idseleccion);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
*/
        }
    }//GEN-LAST:event_jtUnidadesMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        frmUnidadDetalle formunidad = new frmUnidadDetalle();
        
        formunidad.setVisible(true);       
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
        
        Object valor = jtUnidades.getValueAt(jtUnidades.getSelectedRow(), 0);
        String strValor = (String) valor;
        int id = Integer.parseInt(strValor);
        
        if (jtUnidades.getSelectedRow() != -1) { // Verifica si se ha seleccionado una fila
        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar la fila seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            UnidadDaoImp udi = UnidadDaoImp.getInstance();
            
            try {
                udi.delete(id);
                
                cargaTabla();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila.");
    }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:
        cargaTabla();
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        // TODO add your handling code here:
        Unidad u = new Unidad();
        
        Object valor = jtUnidades.getValueAt(jtUnidades.getSelectedRow(), 0);
        String strValor = (String) valor;
        int id = Integer.parseInt(strValor);
        
        u.setId(id);
        
        frmUnidadDetalle formunidad= new frmUnidadDetalle(u);
            
        formunidad.setVisible(true);
    }//GEN-LAST:event_btnModificarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUnidades;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
