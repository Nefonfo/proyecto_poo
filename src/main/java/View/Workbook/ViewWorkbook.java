/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Workbook;

import Controller.WorkbookController;
import Model.User;
import Model.Workbook;
import View.User.LoginView;
import javax.swing.JOptionPane;

/**
 *
 * @author Nefonfo
 */
public class ViewWorkbook extends javax.swing.JFrame {
    private int id;
    private User user;
    private Workbook workbook;
    private final WorkbookController controller = new WorkbookController();
    /**
     * Creates new form ViewHomework
     * @param id
     * @param user
     */
    public ViewWorkbook(int id, User user) {
        this.id = id;
        this.user = user;
        initComponents();
        
        try {
            this.workbook = this.controller.get_workbook(this.id, this.user.getId());
            this.homework_name.setText(this.workbook.name);
            this.content_input.setText(this.workbook.content);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            new ViewWorkbook(this.id, this.user).setVisible(true);
            this.setVisible(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        content_input = new javax.swing.JTextArea();
        homework_name_label = new javax.swing.JLabel();
        update_button = new javax.swing.JButton();
        return_button = new javax.swing.JButton();
        homework_name = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        content_input.setColumns(20);
        content_input.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        content_input.setRows(5);
        jScrollPane1.setViewportView(content_input);

        homework_name_label.setText("Tarea:");
        homework_name_label.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N

        update_button.setText("Actualizar");
        update_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        return_button.setText("Regresar");
        return_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        homework_name.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homework_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(homework_name, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homework_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homework_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(return_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update_button, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_buttonActionPerformed
        try {
            new MyWorkbooks(this.user).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            new LoginView().setVisible(true);
        }
        this.setVisible(false);
    }//GEN-LAST:event_return_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        String message;
        if(!this.workbook.name.equals(this.homework_name.getText())) {
            try{
                message = this.controller.update_name(this.id, this.user.getId(), this.homework_name.getText());
            } catch(Exception ex) {
                message = ex.getMessage();
            }
            
            JOptionPane.showMessageDialog(this, message);
        }

        if(!this.workbook.content.equals(this.content_input.getText())) {
            try{
                message = this.controller.update_content(this.id, this.user.getId(), this.content_input.getText());
            } catch(Exception ex) {
                message = ex.getMessage();
            }
            
            JOptionPane.showMessageDialog(this, message);
        }
        
        new ViewWorkbook(this.id, this.user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_update_buttonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea content_input;
    private javax.swing.JTextField homework_name;
    private javax.swing.JLabel homework_name_label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton return_button;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
