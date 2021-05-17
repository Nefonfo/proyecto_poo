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
public class RecoverStep1 extends javax.swing.JFrame {

    private final UserController controller = new UserController();
    /**
     * Creates new form RecoverStep1
     */
    public RecoverStep1() {
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

        name_label = new javax.swing.JLabel();
        email_label = new javax.swing.JLabel();
        name_input = new javax.swing.JTextField();
        email_input = new javax.swing.JTextField();
        recover_button = new javax.swing.JButton();
        return_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        name_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        name_label.setLabelFor(name_input);
        name_label.setText("Nombre del Usuario");

        email_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        email_label.setLabelFor(email_label);
        email_label.setText("Correo");

        name_input.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        email_input.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N

        recover_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        recover_button.setText("Recuperar");
        recover_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recover_buttonActionPerformed(evt);
            }
        });

        return_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        return_button.setText("Regresar");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recover_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(email_label)
                                .addGap(113, 113, 113)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name_input, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(email_input))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(name_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recover_button, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(return_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_buttonActionPerformed
        new LoginView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_return_buttonActionPerformed

    private void recover_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recover_buttonActionPerformed
        boolean can_recover = this.controller.recover_password(
                                this.name_input.getText(),
                                this.email_input.getText());
        
        if(can_recover){
            new RecoverStep2(
                    this.controller.get_user_by_name(this.name_input.getText()).getId()
            ).setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario y/o email incorrectos");
        }
    }//GEN-LAST:event_recover_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(RecoverStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecoverStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecoverStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecoverStep1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecoverStep1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email_input;
    private javax.swing.JLabel email_label;
    private javax.swing.JTextField name_input;
    private javax.swing.JLabel name_label;
    private javax.swing.JButton recover_button;
    private javax.swing.JButton return_button;
    // End of variables declaration//GEN-END:variables
}
