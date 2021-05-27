/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.User;

import Controller.UserController;
import Model.User;
import View.Homework.MyHomeworks;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nefonfo
 */
public class ProfileView extends javax.swing.JFrame {

    private final UserController controller = new UserController();
    private User user;
    /**
     * Creates new form ProfileView
     */
    public ProfileView(int id) {
        initComponents();
        this.user = this.controller.get_user_by_id(id);
        this.welcome_label.setText(this.welcome_label.getText() + this.user.name);
        this.name_input.setText(this.user.name);
        this.email_input.setText(this.user.email);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        homework_button = new javax.swing.JButton();
        workbook_button = new javax.swing.JButton();
        exit_button = new javax.swing.JButton();
        welcome_label = new javax.swing.JLabel();
        update_button = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        email_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        cpassword_label = new javax.swing.JLabel();
        name_input = new javax.swing.JTextField();
        email_input = new javax.swing.JTextField();
        advice_label = new javax.swing.JLabel();
        password_input = new javax.swing.JPasswordField();
        cpassword_input = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        homework_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        homework_button.setText("Tareas");
        homework_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homework_buttonActionPerformed(evt);
            }
        });

        workbook_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        workbook_button.setText("Notas");

        exit_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        exit_button.setText("Salir");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homework_button, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
            .addComponent(workbook_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exit_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(homework_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(workbook_button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        welcome_label.setFont(new java.awt.Font("Leelawadee UI", 3, 18)); // NOI18N
        welcome_label.setText("Bienvenido, ");

        update_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        update_button.setText("Actualizar Información");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        name_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        name_label.setLabelFor(name_input);
        name_label.setText("Nombre del Usuario");

        email_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        email_label.setLabelFor(email_input);
        email_label.setText("Correo");

        password_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        password_label.setLabelFor(password_input);
        password_label.setText("Contraseña");

        cpassword_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        cpassword_label.setLabelFor(cpassword_input);
        cpassword_label.setText("Confirmar Contraseña");

        email_input.setToolTipText("");

        advice_label.setFont(new java.awt.Font("Leelawadee UI", 0, 10)); // NOI18N
        advice_label.setForeground(new java.awt.Color(255, 0, 0));
        advice_label.setText("* En caso de querer cambiar la contraseña, escriba la nueva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(update_button, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(email_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(name_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(name_input, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(advice_label)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(password_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(password_input, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(welcome_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cpassword_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cpassword_input, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome_label)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(name_label)
                    .addComponent(name_input, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(email_label)
                    .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(advice_label)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password_label)
                            .addComponent(password_input, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cpassword_input, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cpassword_label, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        String validation;
        String response;
        
        if(!String.valueOf(this.password_input.getPassword()).equals("")){
            validation = this.user.validate(
                    this.name_input.getText(),
                    this.email_input.getText(),
                    String.valueOf(this.password_input.getPassword()), 
                    true);
        } else {
            validation = this.user.validate(
                    this.name_input.getText(),
                    this.email_input.getText(),
                    "", 
                    false);
        }
        if(validation == null) {
            
            if(!this.name_input.getText().equals(this.user.name)) {
                response = this.controller.update_name(
                        this.user.getId(),
                        this.name_input.getText());
                JOptionPane.showMessageDialog(this, "Nombre de Usuario: " + response);
            }
            
            if(!this.email_input.getText().equals(this.user.email)) {
                response = this.controller.update_email(
                        this.user.getId(),
                        this.email_input.getText());
                JOptionPane.showMessageDialog(this, "Correo: " + response);
            }
            
            if(!String.valueOf(this.password_input.getPassword()).equals("")) {
                response = this.controller.update_password(
                        this.user.getId(),
                        String.valueOf(this.password_input.getPassword()), 
                        String.valueOf(this.cpassword_input.getPassword()));
                JOptionPane.showMessageDialog(this, "Contraseña: " + response);
            }
            
            new ProfileView(this.user.getId()).setVisible(true);
            this.setVisible(false);
            
        } else {
          JOptionPane.showMessageDialog(this, validation);
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        new WelcomeView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void homework_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homework_buttonActionPerformed
        try {
            new MyHomeworks(this.user).setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(ProfileView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_homework_buttonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advice_label;
    private javax.swing.JPasswordField cpassword_input;
    private javax.swing.JLabel cpassword_label;
    private javax.swing.JTextField email_input;
    private javax.swing.JLabel email_label;
    private javax.swing.JButton exit_button;
    private javax.swing.JButton homework_button;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField name_input;
    private javax.swing.JLabel name_label;
    private javax.swing.JPasswordField password_input;
    private javax.swing.JLabel password_label;
    private javax.swing.JButton update_button;
    private javax.swing.JLabel welcome_label;
    private javax.swing.JButton workbook_button;
    // End of variables declaration//GEN-END:variables
}
