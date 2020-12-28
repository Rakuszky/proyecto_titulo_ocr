package Login;

import conexionSQL.conexionMysql;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rakuszky
 */
public class login extends javax.swing.JFrame {

    conexionMysql cc = new conexionMysql();
    Connection con = cc.conexion();
    
    public login() {
        initComponents();
    }

    public void validarAcceso(){
        int resultado = 0;
        
        try {
            String usuario = txtUserLogin.getText();
            String pass = String.valueOf(txtPassLogin.getPassword());
            
            String sql = "select * from usuarios where usuario = '"+usuario+"' and clave = '"+pass+"'";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                resultado = 1;
                if (resultado == 1){
                    sistema form = new sistema();
                    form.setVisible(true);
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error en el acceso, vuelva a intentarlo");
            }
            
        } catch (HeadlessException | SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error en el acceso" + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etiquetaPassLogin = new javax.swing.JLabel();
        etiquetaUserLogin = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtUserLogin = new javax.swing.JTextField();
        txtPassLogin = new javax.swing.JPasswordField();
        imgLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acceso de Operador");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaPassLogin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaPassLogin.setText("Contraseña:");
        jPanel1.add(etiquetaPassLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        etiquetaUserLogin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaUserLogin.setText("Usuario:");
        jPanel1.add(etiquetaUserLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        btnLogin.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        txtUserLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(txtUserLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 230, 30));

        txtPassLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(txtPassLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 230, 30));

        imgLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario_icono.png"))); // NOI18N
        jPanel1.add(imgLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 80, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        validarAcceso();
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel etiquetaPassLogin;
    private javax.swing.JLabel etiquetaUserLogin;
    private javax.swing.JLabel imgLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassLogin;
    private javax.swing.JTextField txtUserLogin;
    // End of variables declaration//GEN-END:variables
}
