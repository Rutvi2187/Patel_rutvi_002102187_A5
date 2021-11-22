/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author MyPC1
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

   JPanel userProcessContainer;
    EcoSystem ecosystem;
    Organization deliverManOrg;
    Organization customerOrg;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, 
            EcoSystem business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.ecosystem=business;
       Organization delivOrg= (Organization)ecosystem.getDeliveryManDirectory().searchOrganization("DeliveryMan");
       
       Organization custOrg= (Organization)ecosystem.getCustomerDirectory().searchOrganization("Customer");
       
        if(delivOrg==null){
        this.deliverManOrg=(Organization)ecosystem.getDeliveryManDirectory().createOrganization(Organization.Type.DeliveryMan);
        }
        else {
            this.deliverManOrg=delivOrg;
        }
        if(custOrg==null){
        this.customerOrg=(Organization)ecosystem.getCustomerDirectory().createOrganization(Organization.Type.Customer);
        }
        else{
            this.customerOrg=custOrg;
        }
        populateTree();
    }
    
    public void populateTree(){
       // Add the code for draw your system structure shown by JTree
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        ArrayList<UserAccount> userAccountList;
        ArrayList<Organization> custOrganizationList;
        ArrayList<UserAccount> customersAccountList;
        ArrayList<Organization> delOrganizationList;
        ArrayList<UserAccount> deliveryMenUserAccountList;
        Enterprise enterprise;
        Organization organization;
        UserAccount userAccount;
        Organization organization1;
        UserAccount custUserAccount;
        Organization organization2;
        UserAccount delivUserAccount;

        DefaultMutableTreeNode enterprises = new DefaultMutableTreeNode("Enterprises/Restaurants");
         DefaultMutableTreeNode customerOrg2 = new DefaultMutableTreeNode("Customers");
         DefaultMutableTreeNode deliveryOrg2 = new DefaultMutableTreeNode("Delivery Men");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(enterprises, 0);
        root.insert(customerOrg2,1);
        root.insert(deliveryOrg2, 2);

        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        DefaultMutableTreeNode userAccountNode;
        DefaultMutableTreeNode custOrganizationNode;
        DefaultMutableTreeNode CustomersNode;
        DefaultMutableTreeNode delivOrganizationNode;
        DefaultMutableTreeNode DeliveryMenNode;
        
        //JTree.setRootVisible(false);

            enterpriseList = ecosystem.getEnterpriseDirectory().getEnterpriseList();
            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                enterprises.insert(enterpriseNode, j);

                organizationList = enterprise.getRestaurantDirectory().getOrganizationList();
                
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                    
                   userAccountList=organization.getUserAccountDirectory().getUserAccountList();
                 
                   for (int l = 0; l < userAccountList.size(); l++) {
                    userAccount = userAccountList.get(l);
                    userAccountNode = new DefaultMutableTreeNode(userAccount.getUsername());
                    organizationNode.insert(userAccountNode, l);
                   }
                }
            }
            custOrganizationList = ecosystem.getCustomerDirectory().getOrganizationList();
                
                for (int k = 0; k < custOrganizationList.size(); k++) {
                    organization1 = custOrganizationList.get(k);
                    custOrganizationNode = new DefaultMutableTreeNode(organization1.getName());
                    customerOrg2.insert(custOrganizationNode, k);
                    
                   customersAccountList=organization1.getUserAccountDirectory().getUserAccountList();
                 
                   for (int l = 0; l < customersAccountList.size(); l++) {
                    custUserAccount = customersAccountList.get(l);
                    CustomersNode = new DefaultMutableTreeNode(custUserAccount.getUsername());
                    custOrganizationNode.insert(CustomersNode, l);
                   }
                }
           delOrganizationList = ecosystem.getDeliveryManDirectory().getOrganizationList();
                
                for (int k = 0; k < delOrganizationList.size(); k++) {
                    organization2 = delOrganizationList.get(k);
                    delivOrganizationNode = new DefaultMutableTreeNode(organization2.getName());
                    deliveryOrg2.insert(delivOrganizationNode, k);
                    
                   deliveryMenUserAccountList=organization2.getUserAccountDirectory().getUserAccountList();
                 
                   for (int l = 0; l < deliveryMenUserAccountList.size(); l++) {
                    delivUserAccount = deliveryMenUserAccountList.get(l);
                    DeliveryMenNode = new DefaultMutableTreeNode(delivUserAccount.getUsername());
                    delivOrganizationNode.insert(DeliveryMenNode, l);
                   }
                }
       
        model.reload();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSelectedNode = new javax.swing.JLabel();
        btnManageNetwork = new javax.swing.JButton();
        btnManageEnterprise = new javax.swing.JButton();
        btnManageAdmin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jTree.setBackground(new java.awt.Color(188, 234, 227));
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        jSplitPane.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(211, 232, 172));

        jLabel1.setText("Selected Node:");

        lblSelectedNode.setText("<View_selected_node>");

        btnManageNetwork.setBackground(new java.awt.Color(255, 255, 255));
        btnManageNetwork.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnManageNetwork.setText("Manage Customers");
        btnManageNetwork.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageNetworkActionPerformed(evt);
            }
        });

        btnManageEnterprise.setBackground(new java.awt.Color(255, 255, 255));
        btnManageEnterprise.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnManageEnterprise.setText("Manage Restaurants");
        btnManageEnterprise.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterpriseActionPerformed(evt);
            }
        });

        btnManageAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnManageAdmin.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        btnManageAdmin.setText("Manage Deliverymen");
        btnManageAdmin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdminActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dman2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblSelectedNode))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManageAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(btnManageEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageNetwork, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSelectedNode))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnManageNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManageEnterprise)
                        .addGap(181, 181, 181)
                        .addComponent(btnManageAdmin)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnManageAdmin, btnManageEnterprise, btnManageNetwork});

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        
        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
        if(selectedNode!=null){
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged

    private void btnManageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdminActionPerformed
        ManageDeliveryMenJPanel panel = new ManageDeliveryMenJPanel(userProcessContainer,ecosystem,deliverManOrg);
        userProcessContainer.add("ManageDeliveryMenJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdminActionPerformed

    private void btnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterpriseActionPerformed
        ManageRestaurantsJPanel panel = new ManageRestaurantsJPanel(userProcessContainer,ecosystem);
        userProcessContainer.add("ManageRestaurantsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEnterpriseActionPerformed

    private void btnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageNetworkActionPerformed

        ManageCustomersJPanel panel = new ManageCustomersJPanel(userProcessContainer,ecosystem,customerOrg);
        userProcessContainer.add("ManageCustomersJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnManageNetworkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdmin;
    private javax.swing.JButton btnManageEnterprise;
    private javax.swing.JButton btnManageNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblSelectedNode;
    // End of variables declaration//GEN-END:variables
}
