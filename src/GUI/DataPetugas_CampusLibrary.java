/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Conection.Connectionc;
<<<<<<< HEAD:src/GUI/DataPetugas_CampusLibrary.java
import static GUI.MembersData.id;
=======
>>>>>>> 36051f89283ac2ccc9ec22e547521733cddbefb9:src/DataPetugas/DataPetugas_CampusLibrary.java
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author LENOVO
 */
public class DataPetugas_CampusLibrary extends javax.swing.JFrame {
    public static Connection con;
    public static Statement stm;
    public static ResultSet rs;
    public static DefaultTableModel tb;
    public static int id;
    Connectionc connection = new Connectionc();
    
    /**
     * Creates new form DataPetugas_CampusLibrary
     */
    
    public void search(){
        tb = new DefaultTableModel();
        tb.addColumn("id_petugas");
        tb.addColumn("username");
        tb.addColumn("nama_petugas");
        tb.addColumn("no_telp");
        tb.addColumn("alamat");
        Admin_table.setModel(tb);
        String text = search_textfield.getText();
        
        try{
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            rs = stm.executeQuery ("SELECT * FROM data_petugas WHERE nama_petugas like'%"+text+"%'");
            while (rs.next()){
            tb.addRow(new Object[] {
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
            });
                
        }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed" +e);
        }
    
    }
    public void updateData(){
            String SQL = "UPDATE data_petugas SET "
                +"username='"+username_textfield.getText()+"',"
                +"nama_petugas='"+nama_textfield.getText()+"',"
                +"alamat='"+alamat_textfield.getText()+"',"
                +"no_telp='"+noTelp_textfield.getText()+"' "
                +"WHERE id_petugas='"+id_label.getText()+"'";
    
        try{
            stm.execute(SQL);
            showTable();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed" +e);
        }    
    }
    
    public void createData(){
            String SQL = "INSERT INTO data_petugas (nama_petugas,username,alamat,no_telp) "
                    + "VALUES('"+nama_textfield.getText()+"','"+username_textfield.getText()+"','"+alamat_textfield.getText()+"','"+noTelp_textfield.getText()+"')";
                   
        try{
            stm.execute(SQL);
            showTable();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
    }
    
    public void deleteData(){
        int baris = Admin_table.getSelectedRow();
        if (baris != -1) {
            String id = Admin_table.getValueAt(baris, 0).toString();
            String SQL = "DELETE FROM data_petugas WHERE id_petugas ='"+id+"'";
            try{
             con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
             stm = con.createStatement();
             stm.executeUpdate(SQL);   
             showTable();
             
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
            }
            }
    }
    
    /**
     *
     */
    public void showTable(){
        tb = new DefaultTableModel();
        tb.addColumn("id_petugas");
        tb.addColumn("nama_petugas");
        tb.addColumn("username");
        tb.addColumn("alamat");
        tb.addColumn("no_telp");
        Admin_table.setModel(tb);
        
        
        try{
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            rs= stm.executeQuery("SELECT * FROM data_petugas");
            while(rs.next()){
            tb.addRow(new Object[] {
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                
            });
            id=Integer.parseInt(rs.getString(1));
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
        
    }    
    
    
    
    
    public DataPetugas_CampusLibrary() {
        initComponents();
        connection.setKoneksi();
        showTable();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        id_label.setText(""+(id+1));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nama_textfield = new javax.swing.JTextField();
        alamat_textfield = new javax.swing.JTextField();
        noTelp_textfield = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        search_textfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Admin_table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        username_textfield = new javax.swing.JTextField();
        id_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));

        jPanel1.setBackground(new java.awt.Color(131, 191, 221));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo ccit (2).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Centaur", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DATA PETUGAS");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/add-user (1).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/updated (1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NAMA");

        jLabel5.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ALAMAT");

        jLabel6.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("NO TELEPON");

        nama_textfield.setBackground(new java.awt.Color(255, 255, 255));
        nama_textfield.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        nama_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        alamat_textfield.setBackground(new java.awt.Color(255, 255, 255));
        alamat_textfield.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        alamat_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        noTelp_textfield.setBackground(new java.awt.Color(255, 255, 255));
        noTelp_textfield.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        noTelp_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/delete (1).png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        search_textfield.setBackground(new java.awt.Color(255, 255, 255));
        search_textfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        search_textfield.setForeground(new java.awt.Color(0, 0, 0));
        search_textfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_textfieldKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/search (2) (1).png"))); // NOI18N

        Admin_table.setBackground(new java.awt.Color(255, 255, 255));
        Admin_table.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Admin_table.setForeground(new java.awt.Color(0, 0, 0));
        Admin_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        Admin_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Admin_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Admin_table);

        jLabel7.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("USERNAME");

        username_textfield.setBackground(new java.awt.Color(255, 255, 255));
        username_textfield.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        username_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        id_label.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        id_label.setForeground(new java.awt.Color(0, 0, 0));
        id_label.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(441, 441, 441)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_label)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nama_textfield)
                                .addComponent(alamat_textfield)
                                .addComponent(noTelp_textfield)
                                .addComponent(username_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(id_label))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(nama_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(alamat_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noTelp_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        createData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void search_textfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_textfieldKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_search_textfieldKeyReleased

    private void Admin_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Admin_tableMouseClicked
        // TODO add your handling code here:
        int i = Admin_table.getSelectedRow();{
       
            id_label.setText(tb.getValueAt(i,0).toString());
            nama_textfield.setText(tb.getValueAt(i,1).toString());
            username_textfield.setText(tb.getValueAt(i,2).toString());
            alamat_textfield.setText(tb.getValueAt(i,3).toString());
            noTelp_textfield.setText(tb.getValueAt(i,4).toString());
        }
    }//GEN-LAST:event_Admin_tableMouseClicked

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
            java.util.logging.Logger.getLogger(DataPetugas_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPetugas_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPetugas_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPetugas_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPetugas_CampusLibrary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Admin_table;
    private javax.swing.JTextField alamat_textfield;
    private javax.swing.JLabel id_label;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nama_textfield;
    private javax.swing.JTextField noTelp_textfield;
    private javax.swing.JTextField search_textfield;
    private javax.swing.JTextField username_textfield;
    // End of variables declaration//GEN-END:variables

   

    
}
