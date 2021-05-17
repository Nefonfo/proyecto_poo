/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.User;

import Controller.UserController;
import javax.swing.JOptionPane;

/**
 *
 * @author Nefonfo
 */
public class RegisterView extends javax.swing.JFrame {

    private final UserController controller = new UserController();
    
    /**
     * Creates new form Register
     */
    
    public RegisterView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register_button = new javax.swing.JButton();
        return_button = new javax.swing.JButton();
        email_input = new javax.swing.JTextField();
        user_input = new javax.swing.JTextField();
        cpassword_input = new javax.swing.JPasswordField();
        password_input = new javax.swing.JPasswordField();
        user_label = new javax.swing.JLabel();
        email_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        cpassword_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        register_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        register_button.setText("Registrarse");
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });

        return_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        return_button.setText("Regresar");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        email_input.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        user_input.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        cpassword_input.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        password_input.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        user_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        user_label.setLabelFor(user_input);
        user_label.setText("Usuario (alfanumérico de 8-50 caracteres)");

        email_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        email_label.setLabelFor(email_input);
        email_label.setText("Correo");

        password_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        password_label.setLabelFor(password_input);
        password_label.setText("Contraseña");

        cpassword_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        cpassword_label.setLabelFor(cpassword_input);
        cpassword_label.setText("Confirmar Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpassword_label)
                            .addComponent(user_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpassword_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(password_input)
                                .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(email_label, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(user_label, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(register_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user_input, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(password_label)
                        .addGap(19, 19, 19)
                        .addComponent(password_input, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(register_button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(cpassword_label)
                .addGap(18, 18, 18)
                .addComponent(cpassword_input, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_buttonActionPerformed
        new WelcomeView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_return_buttonActionPerformed

    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
        String response = this.controller.register(
                this.user_input.getText(),
                this.email_input.getText(),
                String.valueOf(this.password_input.getPassword()),
                String.valueOf(this.cpassword_input.getPassword())
        );
        
        JOptionPane.showMessageDialog(this, response);
        
        if(response.equals("Registrado Exitosamente")) {
            this.return_buttonActionPerformed(evt);
        }
    }//GEN-LAST:event_register_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField cpassword_input;
    private javax.swing.JLabel cpassword_label;
    private javax.swing.JTextField email_input;
    private javax.swing.JLabel email_label;
    private javax.swing.JPasswordField password_input;
    private javax.swing.JLabel password_label;
    private javax.swing.JButton register_button;
    private javax.swing.JButton return_button;
    private javax.swing.JTextField user_input;
    private javax.swing.JLabel user_label;
    // End of variables declaration//GEN-END:variables
}
