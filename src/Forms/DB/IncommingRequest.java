/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms.DB;

import Blood_Bank.BloodStocks;
import Blood_Bank.BpRequest;
import Blood_Bank.HgetBpacket;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kasun Dhananjaya
 */
public class IncommingRequest extends javax.swing.JFrame {

    private Component frame;

    /**
     * Creates new form IncommingRequest
     */
    public IncommingRequest() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Rtable = new javax.swing.JTable();
        AcceptBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BgPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Blood Type", "Number 0f Packets", "Request Type"
            }
        ));
        Rtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Rtable);
        if (Rtable.getColumnModel().getColumnCount() > 0) {
            Rtable.getColumnModel().getColumn(2).setPreferredWidth(150);
            Rtable.getColumnModel().getColumn(2).setMaxWidth(130);
        }

        AcceptBtn.setText("Accept");
        AcceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(BackBtn)
                .addGap(80, 80, 80)
                .addComponent(RefreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AcceptBtn)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcceptBtn)
                    .addComponent(RefreshBtn)
                    .addComponent(BackBtn))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 219, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,140
        ));

        jPanel3.setBackground(new java.awt.Color(153, 255, 255,70));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Blood Packet Request");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Ubuntu Mono", 1, 72)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BLOOD BANK SYSTEM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(141, 141, 141))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 170));

        BgPanel.setBackground(new java.awt.Color(153, 255, 255,35));
        BgPanel.setPreferredSize(new java.awt.Dimension(900, 750));
        BgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(BgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 510));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/kasun/Documents/JAVA Project/NewFolder/BloodBankSystem/src/Forms/Images/page2withnurse.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AcceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptBtnActionPerformed
        // TODO add your handling code here:
        
        BpRequest bpr = new BpRequest();
        BloodStocks bs = new BloodStocks();
        HgetBpacket HGP = new HgetBpacket();
        String RID;
        RID= Rtable.getModel().getValueAt(Rtable.getSelectedRow(), 0).toString();
        String Rtype = Rtable.getModel().getValueAt(Rtable.getSelectedRow(), 3).toString();
        String Btpe=Rtable.getModel().getValueAt(Rtable.getSelectedRow(), 1).toString();
        
        
        int count= Integer.parseInt(Rtable.getModel().getValueAt(Rtable.getSelectedRow(), 2).toString());
        try {
            int bcount=HGP.getCount(Btpe) ;
            if(count<bcount){
            while(count!=0){
            bs.setBID(Btpe);
            String BID= bs.getBID();
            bs.setDID(BID);
            String DID= bs.getDID();
            bs.AcceptingRequest(BID);
            bs.IssuesBp(RID, Rtype, BID,DID);
            bpr.AcceptRequest(RID);
            HGP.UpdateStockTable();
            count--;
            }JOptionPane.showMessageDialog(frame, "Request Accepted");
            }
            else
            {
               JOptionPane.showMessageDialog(frame, "Need More "+Btpe+" Blood Pakect\nCall To Dorner And Collect More Blood Packets"); 
            }
            clearTable();
            Table();
            Rtable.setRowSelectionInterval(0, 0);
            HGP.FillBloodStock(Btpe);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IncommingRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IncommingRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AcceptBtnActionPerformed

    public void FirstRowSelected(){}
    public void Table()
    {
                BpRequest Bpr=new BpRequest();
        
        int i=0;
        try {
            DefaultTableModel model=(DefaultTableModel) Rtable.getModel();
            Bpr.getRequstDetails();
            while(i<Bpr.getLength())
            {
            model.addRow(new Object[]{Bpr.getValues(i, 0),Bpr.getValues(i, 1),Bpr.getValues(i, 2),Bpr.getValues(i, 3)});
            i++;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IncommingRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IncommingRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        clearTable();
        Table();
        Rtable.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_formWindowActivated
    public void clearTable()
{
    DefaultTableModel dm = (DefaultTableModel) Rtable.getModel();
    dm.getDataVector().removeAllElements();
    revalidate();
}
    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        // TODO add your handling code here:
        clearTable();
        Table();
        Rtable.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        AdminO Ao=new AdminO();
        Ao.show();
        dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void RtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RtableMouseClicked
        // TODO add your handling code here:
        String Rtype=Rtable.getModel().getValueAt(0, 3).toString();
        if(Rtype.equals("Emergency")||Rtype.equals("Urgent"))
        {
            Component frame = null;
        JOptionPane.showMessageDialog(frame, "Firstly You Should Accpet \n\nEmergency\nUrgent");
        Rtable.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_RtableMouseClicked

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
            java.util.logging.Logger.getLogger(IncommingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IncommingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IncommingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IncommingRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncommingRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptBtn;
    private javax.swing.JButton BackBtn;
    private javax.swing.JPanel BgPanel;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JTable Rtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
