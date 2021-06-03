/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Homework;

import Controller.HomeworkController;
import Model.Homework;
import Model.User;
import View.User.ProfileView;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Nefonfo
 */
public class MyHomeworks extends javax.swing.JFrame {

    private final User user;
    private final List<Homework> hws;
    
    private final HomeworkController controller = new HomeworkController();
    /**
     * Creates new form MyHomeworks
     * @param user
     * @throws java.lang.Exception
     */
    
    public MyHomeworks(User user) throws Exception {
        initComponents();
        this.user = user;
        this.title_label.setText(this.title_label.getText() + this.user.name);
        this.cleanJList();
        this.hws = this.controller.get_all_user_homeworks(this.user.getId());
        hws.forEach(homework -> {
            this.fillModel(
                    "TAREA"+
                            " - "
                            +homework.name+
                            " - EXPIRA EN: "
                            +ChronoUnit.DAYS.between(
                                    new Date().toInstant(),
                                    homework.getExpires().toInstant()
                            )+
                            "dias"
            );
        });  
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
        homework_list = new javax.swing.JList<>();
        title_label = new javax.swing.JLabel();
        return_button = new javax.swing.JButton();
        select_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        create_button = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homework_list.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        homework_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(homework_list);

        title_label.setFont(new java.awt.Font("Leelawadee UI", 3, 18)); // NOI18N
        title_label.setText("Las tareas de: ");

        return_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        return_button.setText("Regresar");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        select_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        select_button.setText("Ver más");
        select_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_buttonActionPerformed(evt);
            }
        });

        delete_button.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        delete_button.setText("Borrar");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        create_button.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        create_button.setText("Crear Tarea");
        create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(select_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(create_button, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(return_button)
                    .addComponent(create_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(select_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_buttonActionPerformed
        new ProfileView(user.getId()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_return_buttonActionPerformed

    private void select_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_buttonActionPerformed

        if(this.homework_list.getSelectedIndex() >= 0){
            new ViewHomework(this.hws.get(this.homework_list.getSelectedIndex()).getId(), this.user).setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna tarea");
        }
    }//GEN-LAST:event_select_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        int index = this.homework_list.getSelectedIndex();
        if(index >= 0) {
            int delete = JOptionPane.showConfirmDialog(
                    this, 
                    "Deseas eliminar:",
                    this.hws.get(index).name,
                    JOptionPane.YES_NO_OPTION
            );
            
            if(delete == 0) {
                try {
                    String result = this.controller.delete_hw(this.hws.get(index).getId(), this.user.getId());
                    JOptionPane.showMessageDialog(this, result);
                    new MyHomeworks(user).setVisible(true);
                    this.setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(MyHomeworks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_buttonActionPerformed
        new CreateHomework(this.user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_create_buttonActionPerformed

    public DefaultListModel cleanJList() {
        DefaultListModel model = new DefaultListModel();
        
        this.homework_list.setModel(model);
        
        return model;
    }
    
    public DefaultListModel fillModel(String data) {
        DefaultListModel model = (DefaultListModel) homework_list.getModel();
        model.addElement(data);
        
        return model;
    }
    
    
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton create_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JList<String> homework_list;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton return_button;
    private javax.swing.JButton select_button;
    private javax.swing.JLabel title_label;
    // End of variables declaration//GEN-END:variables
}
