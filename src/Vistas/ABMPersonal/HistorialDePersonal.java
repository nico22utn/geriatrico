/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.ABMPersonal;

import Controlador.ControladorABMPersonal.ControladorABMPersonal;
import Controlador.DTO.DTOPersonal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maxi
 */
public class HistorialDePersonal extends javax.swing.JDialog {
ControladorABMPersonal controlador;
DefaultTableModel modelo;
    /**
     * Creates new form HistorialDePersonal
     */
    public HistorialDePersonal(java.awt.Frame parent, boolean modal,ControladorABMPersonal controlador) {
        super(parent, modal);
        this.controlador = controlador;
        initComponents();
        modelo = (DefaultTableModel) jTable1.getModel();
        this.setLocationRelativeTo(null);
        llenarTabla();
    }
    
                    public void llenarTabla(){
        modelo.setRowCount(0);
        List<DTOPersonal> listaPersonal = controlador.buscar();
        Object[] objeto = new Object[9];
        
        for(DTOPersonal personal : listaPersonal){
            if(personal.getFechaBaja()!=null){
            objeto[0] = personal.getId();
            objeto[1] = personal.getNombrePersonal();
            objeto[2] = personal.getApellidoPersonal();
            objeto[3] = personal.getDni();
            objeto[4] = personal.getNombreArea();
            objeto[5] = personal.getNombreRol();
            if(personal.getListaEspecialidad().size() > 1){
                
                objeto[6] = unirString(personal,(personal.getListaEspecialidad().size()-1));
            }else{
                if(personal.getListaEspecialidad().size() == 0){
                 objeto[6] = "Ninguno";   
                }else{
                 objeto[6] = personal.getListaEspecialidad().get(0).getNombreEspecializacion();   
                }
                 

                        }
            objeto[7] = personal.getFechaAlta();
            objeto[8] = personal.getFechaBaja();
            
            
            modelo.addRow(objeto);
                     }
            
                 }
                }
                    
                    
             public String unirString(DTOPersonal personal,int i){
             String nombreEspecialidad = "";
             if(i < 0){
                 return nombreEspecialidad;
             }else{
               nombreEspecialidad = personal.getListaEspecialidad().get(i).getNombreEspecializacion() + ", " + unirString(personal,(i-1)) ;
               return nombreEspecialidad;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Historial de personal dados de baja");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Nombre", "Apellido", "DNI", "Area", "Rol asignado", "Especialidad", "Fecha dado de alta", "Fecha dado de baja"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Dar de alta nuevamente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Long idPersonal = Long.parseLong(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        if(controlador.darAltaNuevamente(idPersonal)){
            JOptionPane.showMessageDialog(null, "El personal se dio de alta nuevamente exitosamente", "Exito", 1);
            llenarTabla();
        }else{
            
            JOptionPane.showMessageDialog(null, "Hubo un error al dar de alta, verifique el sistema", "Error", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(HistorialDePersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialDePersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialDePersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialDePersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
