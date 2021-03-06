/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.ABMAbuelo;

import Controlador.ControladorABMAbuelos.ControladorABMAbuelos;
import Controlador.DTO.DTOAbuelo;
import Controlador.DTO.DTOPersonal;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Maxi
 */
public class PantallaPrincipalABMAbuelos extends javax.swing.JDialog {
ControladorABMAbuelos controlador;
DefaultTableModel modelo;
List<byte[]> listaImagenes;
    /**
     * Creates new form PantallaPrincipalABMAbuelos
     */
    public PantallaPrincipalABMAbuelos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.controlador = new ControladorABMAbuelos();
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = (DefaultTableModel) jTable1.getModel();
        llenarTabla();
        
        
    }
    
    public void refrescar(JDialog ventana){
        if(ventana.isVisible()){
            refrescar(ventana);
        }else{
            llenarTabla();
        }
    }
    
        public void llenarTabla(){
        modelo.setRowCount(0);
        List<DTOAbuelo> listaPersonal = controlador.buscar();
        listaImagenes = new ArrayList<>();
 
        for(DTOAbuelo abuelo : listaPersonal){
            listaImagenes.add(abuelo.getFoto());
            modelo.addRow(new Object[]{abuelo.getId(),abuelo.getNombre(),abuelo.getApellido(),abuelo.getDni(),abuelo.getEdad(),abuelo.getPeso(),abuelo.getTalla(),abuelo.getFechadeNacimiento(),abuelo.getFechaAlta()});
            
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

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro de abuelos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 40));

        jButton1.setText("Dar Alta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 130, 70));

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 140, 60));

        jButton3.setText("Dar Baja");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 140, 60));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seleccione un abuelo para modificar o dar de baja");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1020, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro abuelo", "Nombre", "Apellido", "DNI", "Edad", "Peso", "Talla", "Fecha de nacimiento", "Fecha dado de alta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(12);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(10);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1000, 360));

        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 710, -1, -1));

        jButton5.setText("Consultar abuelos dados de baja");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 700, 270, 40));

        jLabel4.setText("Registrar nuevo abuelo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, 160, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/silueta.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel6.setText("Foto");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jButton6.setText("Refrescar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, -1, -1));

        jButton7.setText("Consultar Obra social del abuelo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 270, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/fondoAbmAbuelos.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1017, 756));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       AltaAbuelo i = new AltaAbuelo(null,true,controlador);
       i.setVisible(true);
       refrescar(i);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        byte[] imagenbyte = listaImagenes.get(i);
        
        BufferedImage img = null;
        try{
           
          img = ImageIO.read(new ByteArrayInputStream(imagenbyte));
          Image imagen = img;
          imagen = imagen.getScaledInstance(130, 130, imagen.SCALE_DEFAULT);
          jLabel5.setIcon(new ImageIcon(imagen));
        }catch(IOException e){
            System.out.println("error");
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        HistorialDadosDeBaja i = new HistorialDadosDeBaja(null,true);
        i.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Long idSeleccionado = Long.parseLong(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString());
        ObraSocialAbuelo i = new ObraSocialAbuelo(null,true,controlador,idSeleccionado);
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int j = jTable1.getSelectedRow();
    if(j>-1){   
       SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
       DTOAbuelo dto = new DTOAbuelo();
       dto.setId(Long.parseLong(modelo.getValueAt(jTable1.getSelectedRow(), 0).toString()));
       dto.setApellido(modelo.getValueAt(jTable1.getSelectedRow(), 2).toString());
       dto.setNombre(modelo.getValueAt(jTable1.getSelectedRow(), 1).toString());
       dto.setDni(modelo.getValueAt(jTable1.getSelectedRow(), 3).toString());
       String fechaNacimiento = modelo.getValueAt(jTable1.getSelectedRow(), 7).toString();
    try {
        dto.setFechadeNacimiento(formateador.parse(fechaNacimiento));
    } catch (ParseException ex) {
        Logger.getLogger(PantallaPrincipalABMAbuelos.class.getName()).log(Level.SEVERE, null, ex);
    }
       dto.setPeso(Double.parseDouble(modelo.getValueAt(jTable1.getSelectedRow(), 5).toString()));
       dto.setTalla(Double.parseDouble(modelo.getValueAt(jTable1.getSelectedRow(), 6).toString()));
       dto.setFoto(listaImagenes.get(jTable1.getSelectedRow()));
       ModificarAbuelo i = new ModificarAbuelo(null,true,controlador,dto);
       i.setVisible(true);
       refrescar(i);
       
    }else{
       JOptionPane.showMessageDialog(null, "Seleccione un abuelo por favor", "Error", 0);

    }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        llenarTabla();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       int resp = JOptionPane.showConfirmDialog(null, "¿Desea dar de baja este abuelo?", "Alerta!", 0);
        if(resp == 0){
            String respuesta = JOptionPane.showInputDialog(null, "Escriba el motivo de la baja");
            if(respuesta != null){
            if(controlador.iniciarBaja(Long.parseLong(modelo.getValueAt(jTable1.getSelectedRow(),0).toString()),respuesta)){
            JOptionPane.showMessageDialog(null, "El abuelo se dio de baja exitosamente", "Exito", 1);
            llenarTabla();  
            }

        }else{
            
            JOptionPane.showMessageDialog(null, "Hubo un error al dar de baja, verifique el sistema", "Error", 0);
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipalABMAbuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalABMAbuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalABMAbuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipalABMAbuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaPrincipalABMAbuelos dialog = new PantallaPrincipalABMAbuelos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
