/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import conexionSQL.conexionMysql;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rakuszky
 */
public class agregarPropietarios extends javax.swing.JFrame {

    conexionMysql cc = new conexionMysql();
    Connection con = cc.conexion();
    
    public agregarPropietarios() {
        initComponents();
    }

    public void agregaPropietarios(){
        String bd_propietarios = "insert into propietarios(patente,run,nombre,apellido,block,departamento,estacionamiento,telefono) values (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = con.prepareStatement(bd_propietarios);
            
            pst.setString(1, txtPatenteAgregar.getText());
            pst.setString(2, txtRunAgregar.getText());
            pst.setString(3, txtNombreAgregar.getText());
            pst.setString(4, txtApellidoAgregar.getText());
            pst.setString(5, txtBlockAgregar.getText());
            pst.setString(6, txtDepartamentoAgregar.getText());
            pst.setString(7, txtEstacionamientoAgregar.getText());
            pst.setString(8, txtTelefonoAgregar.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de registro " + e.getMessage());
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiquetaDepartamentoAgregar = new javax.swing.JLabel();
        etiquetaPatenteAgregar = new javax.swing.JLabel();
        etiquetaRunAgregar = new javax.swing.JLabel();
        etiquetaApellidoAgregar = new javax.swing.JLabel();
        etiquetaBlockAgregar = new javax.swing.JLabel();
        etiquetaNombreAgregar = new javax.swing.JLabel();
        etiquetaTelefonoAgregar = new javax.swing.JLabel();
        txtTelefonoAgregar = new javax.swing.JTextField();
        txtPatenteAgregar = new javax.swing.JTextField();
        txtRunAgregar = new javax.swing.JTextField();
        txtNombreAgregar = new javax.swing.JTextField();
        txtApellidoAgregar = new javax.swing.JTextField();
        txtBlockAgregar = new javax.swing.JTextField();
        txtDepartamentoAgregar = new javax.swing.JTextField();
        btnAgregarPropietario = new javax.swing.JButton();
        etiquetaTelefonoAgregar1 = new javax.swing.JLabel();
        txtEstacionamientoAgregar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Propietarios");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaDepartamentoAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaDepartamentoAgregar.setText("Departamento:");
        jPanel1.add(etiquetaDepartamentoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        etiquetaPatenteAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaPatenteAgregar.setText("Patente:");
        jPanel1.add(etiquetaPatenteAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        etiquetaRunAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaRunAgregar.setText("Run:");
        jPanel1.add(etiquetaRunAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        etiquetaApellidoAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaApellidoAgregar.setText("Apellido:");
        jPanel1.add(etiquetaApellidoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        etiquetaBlockAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaBlockAgregar.setText("Block:");
        jPanel1.add(etiquetaBlockAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        etiquetaNombreAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaNombreAgregar.setText("Nombre:");
        jPanel1.add(etiquetaNombreAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        etiquetaTelefonoAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaTelefonoAgregar.setText("Télefono:");
        jPanel1.add(etiquetaTelefonoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtTelefonoAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTelefonoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefonoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 150, -1));

        txtPatenteAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPatenteAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatenteAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtPatenteAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, -1));

        txtRunAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtRunAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRunAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtRunAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 150, -1));

        txtNombreAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtNombreAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, -1));

        txtApellidoAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtApellidoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 150, -1));

        txtBlockAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtBlockAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBlockAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBlockAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, -1));

        txtDepartamentoAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtDepartamentoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartamentoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtDepartamentoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 150, -1));

        btnAgregarPropietario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnAgregarPropietario.setText("Agregar");
        btnAgregarPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPropietarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 120, 40));

        etiquetaTelefonoAgregar1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaTelefonoAgregar1.setText("Estacionamiento:");
        jPanel1.add(etiquetaTelefonoAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        txtEstacionamientoAgregar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtEstacionamientoAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstacionamientoAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(txtEstacionamientoAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoAgregarActionPerformed

    private void txtPatenteAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatenteAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatenteAgregarActionPerformed

    private void txtRunAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRunAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRunAgregarActionPerformed

    private void txtNombreAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAgregarActionPerformed

    private void txtApellidoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoAgregarActionPerformed

    private void txtBlockAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBlockAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBlockAgregarActionPerformed

    private void txtDepartamentoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartamentoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartamentoAgregarActionPerformed

    private void txtEstacionamientoAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstacionamientoAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstacionamientoAgregarActionPerformed

    private void btnAgregarPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPropietarioActionPerformed
        agregaPropietarios();
        txtPatenteAgregar.setText(null);
        txtRunAgregar.setText(null);
        txtNombreAgregar.setText(null);
        txtApellidoAgregar.setText(null);
        txtBlockAgregar.setText(null);
        txtDepartamentoAgregar.setText(null);
        txtEstacionamientoAgregar.setText(null);
        txtTelefonoAgregar.setText(null);
    }//GEN-LAST:event_btnAgregarPropietarioActionPerformed

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
            java.util.logging.Logger.getLogger(agregarPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarPropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarPropietarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPropietario;
    private javax.swing.JLabel etiquetaApellidoAgregar;
    private javax.swing.JLabel etiquetaBlockAgregar;
    private javax.swing.JLabel etiquetaDepartamentoAgregar;
    private javax.swing.JLabel etiquetaNombreAgregar;
    private javax.swing.JLabel etiquetaPatenteAgregar;
    private javax.swing.JLabel etiquetaRunAgregar;
    private javax.swing.JLabel etiquetaTelefonoAgregar;
    private javax.swing.JLabel etiquetaTelefonoAgregar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidoAgregar;
    private javax.swing.JTextField txtBlockAgregar;
    private javax.swing.JTextField txtDepartamentoAgregar;
    private javax.swing.JTextField txtEstacionamientoAgregar;
    private javax.swing.JTextField txtNombreAgregar;
    private javax.swing.JTextField txtPatenteAgregar;
    private javax.swing.JTextField txtRunAgregar;
    private javax.swing.JTextField txtTelefonoAgregar;
    // End of variables declaration//GEN-END:variables
}
