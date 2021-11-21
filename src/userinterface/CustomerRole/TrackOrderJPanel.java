/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Order;
import Business.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rutvi Patel
 */
public class TrackOrderJPanel extends javax.swing.JPanel {

   private JPanel userProcessContainer;
    private UserAccount userAccount;
    private EcoSystem business;
    
    public TrackOrderJPanel(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business=business;
       populateCurrentOrdersTable();
       populateOrderHistoryTable();
    }

    public void populateCurrentOrdersTable(){
        DefaultTableModel dtm = (DefaultTableModel) CurrentOrdersTable.getModel();
        dtm.setRowCount(0);
        for(Order o:business.getOrderDirectory().getOrderList())
        {
         if(o.getCustomerUserName()!=null&&o.getCustomerUserName().equals(userAccount.getUsername()) && !(o.getStatus().equals("order received")))
         {
            Object row[] = new Object[5];
            row[0] = o;
            row[1] = o.getCustomerName();
             row[2] = o.getCustomerNotes();
            row[3] = o.getStatus();
            row[4] = o.getRestaurantName();
            dtm.addRow(row);
        }
    
        }
    }
    
     public void populateOrderHistoryTable(){
        DefaultTableModel dtm = (DefaultTableModel) orderHistoryTable.getModel();
        dtm.setRowCount(0);
        for(Order o:business.getOrderDirectory().getOrderList())
        {
         if(o.getCustomerUserName()!=null&&o.getCustomerUserName().equals(userAccount.getUsername()) && o.getStatus().equals("order received"))
         {
            Object row[] = new Object[5];
            row[0] = o;
            row[1] = o.getCustomerName();
             row[2] = o.getCustomerNotes();
            row[3] = o.getStatus();
            row[4] = o.getRestaurantName();
            dtm.addRow(row);
        }
    
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        orderHistoryTable = new javax.swing.JTable();
        cancelBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CurrentOrdersTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        feedbackBtn = new javax.swing.JButton();
        feedbackTxt = new javax.swing.JTextField();
        ConfirmOrderBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(123, 56, 90));

        orderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Customer Name", "Customer Msg", "Status", "Restaurant Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderHistoryTable);

        cancelBtn.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        cancelBtn.setText("Cancel Order");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Current Orders");

        CurrentOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Customer Name", "Customer Msg", "Status", "Restaurant Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CurrentOrdersTable);

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order history");

        feedbackBtn.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        feedbackBtn.setText("Provide feedback");
        feedbackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedbackBtnActionPerformed(evt);
            }
        });

        ConfirmOrderBtn.setFont(new java.awt.Font("Perpetua Titling MT", 1, 10)); // NOI18N
        ConfirmOrderBtn.setText("Confirm if received");
        ConfirmOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmOrderBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Track Order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(cancelBtn)
                        .addGap(42, 42, 42)
                        .addComponent(ConfirmOrderBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(feedbackBtn)
                                .addGap(46, 46, 46)
                                .addComponent(feedbackTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(166, 166, 166)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel2)))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(ConfirmOrderBtn))
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feedbackBtn)
                    .addComponent(feedbackTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = CurrentOrdersTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            Order o = (Order)CurrentOrdersTable.getValueAt(selectedRow,0 );
            business.getOrderDirectory().deleteOrder(o);
            JOptionPane.showMessageDialog(null, "Order deleted successfully");
            populateCurrentOrdersTable();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void feedbackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedbackBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderHistoryTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
            Order o = (Order)orderHistoryTable.getValueAt(selectedRow,0 );
            /* if(o.getFeedback().equals("")||o.getFeedback()==null){
                JOptionPane.showMessageDialog(null, "Feedback already provided for this order.!");
                return;
            }*/
            if(feedbackTxt.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Feedback cannot be empty");
                return;
            }
            o.setFeedback(feedbackTxt.getText());
            JOptionPane.showMessageDialog(null, "Thank you for your feedback.!");
        }
    }//GEN-LAST:event_feedbackBtnActionPerformed

    private void ConfirmOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmOrderBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = CurrentOrdersTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        Order o = (Order)CurrentOrdersTable.getValueAt(selectedRow,0 );
        if (!o.getStatus().equals("delivered")) {
            JOptionPane.showMessageDialog(null, "This order is not yet delivered by us..!");
            return;
        }
        o.setStatus("order received");

        populateCurrentOrdersTable();
        populateOrderHistoryTable();

    }//GEN-LAST:event_ConfirmOrderBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmOrderBtn;
    private javax.swing.JTable CurrentOrdersTable;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton feedbackBtn;
    private javax.swing.JTextField feedbackTxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderHistoryTable;
    // End of variables declaration//GEN-END:variables
}
