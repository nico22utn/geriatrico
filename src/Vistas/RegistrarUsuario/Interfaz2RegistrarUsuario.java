/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.RegistrarUsuario;

import Controlador.ControladorRegistrarUsuario.ControladorRegistrarUsuario;
import Vistas.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxi
 */
public class Interfaz2RegistrarUsuario extends javax.swing.JFrame {
private String dniPersonal;
private ControladorRegistrarUsuario controlador;
    /**
     * Creates new form Interfaz2RegistrarUsuario
     */
    public Interfaz2RegistrarUsuario(String dniPersonal,ControladorRegistrarUsuario controlador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.dniPersonal = dniPersonal;
        this.controlador = controlador;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textNombreUsuario = new javax.swing.JTextField();
        textPassword1 = new javax.swing.JPasswordField();
        textPassword2 = new javax.swing.JPasswordField();
        botonRegistrarse = new javax.swing.JButton();
        botonVolverMenuPrincipal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel2.setText("Registrar");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel3.setText("Por favor rellene los siguiente campos para registrarse en el sistema.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel4.setText("Nombre de usuario: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 20));

        jLabel5.setText("Contraseña: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 20));

        jLabel6.setText("Repetir Contraseña: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, 20));

        textNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(textNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 160, -1));

        textPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPassword1ActionPerformed(evt);
            }
        });
        getContentPane().add(textPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 160, -1));
        getContentPane().add(textPassword2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 160, -1));

        botonRegistrarse.setText("Registrarse");
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(botonRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        botonVolverMenuPrincipal.setText("Volver al menu principal");
        botonVolverMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(botonVolverMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/imagenes/background-1591227_960_720.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPassword1ActionPerformed

    private void botonVolverMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverMenuPrincipalActionPerformed
        Login i = new Login();
        i.setVisible(true);
        this.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_botonVolverMenuPrincipalActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarseActionPerformed
        String nombreUsuario = textNombreUsuario.getText();
        String password1 = textPassword1.getText();
        String password2 = textPassword2.getText();
        if(password1.equals(password2)){
          if(controlador.inciarAlta(nombreUsuario, password1, dniPersonal)){
              JOptionPane.showMessageDialog(null, "Se ha registrado su usuario en el sistema con exito", "Exito", 1);
              Login i = new Login();
              this.setVisible(false);
              i.setVisible(true);
              this.dispose();
          }else{
              JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, seleccione otro por favor.", "Error", 0);
          }
            
        }else{
            JOptionPane.showMessageDialog(null, "las contraseñas no coinciden, ingrse nuevamente", "Error", 0);
        }
        
    }//GEN-LAST:event_botonRegistrarseActionPerformed

    private void textNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz2RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz2RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz2RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz2RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JButton botonVolverMenuPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textNombreUsuario;
    private javax.swing.JPasswordField textPassword1;
    private javax.swing.JPasswordField textPassword2;
    // End of variables declaration//GEN-END:variables
}
