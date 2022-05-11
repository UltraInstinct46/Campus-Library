/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DataBuku;

import Member.*;
import Conection.Connectionc;
import java.sql.*;
import REGISTER.*;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class DataPengembalianBuku_CampusLibrary extends javax.swing.JFrame {
    public static Connection con;
    public static Statement stm;
    public static ResultSet res;
    public static DefaultTableModel tb;
    Connectionc connection = new Connectionc();
    /**
     * Creates new form Register_CampusLibrary
     */
    public void search(){
        tb = new DefaultTableModel();
        tb.addColumn("id_anggota");
        tb.addColumn("NIM");
        tb.addColumn("nama_anggota");
        tb.addColumn("kelas");
        tb.addColumn("tempat_lahir");
        tb.addColumn("tanggal_lahir");
        Member_Table.setModel(tb);
        String text = search_textfield.getText();
        
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT * FROM data_anggota WHERE nama_anggota LIKE '%"+text+"%'");
            while(res.next()){
            tb.addRow(new Object[] {
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
            });
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
        
    }
    public void updateData(){
            String SQL = "UPDATE data_anggota SET "
                    + "NIM='"+nim_textfield.getText()+"',"
                    + "nama_anggota='"+nama_textfield.getText()+"',kelas='"+kelas_combobox.getSelectedItem().toString()+"',"
                    + "tempat_lahir='"+tempatlahir_textfield.getText()+"',"
                    + "tanggal_lahir='"+tanggallahir_textfield.getText()+"' "
                    + "WHERE id_anggota='"+id_textfield.getText()+"'";
        try{
            stm.execute(SQL);
            showTable();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
    }
        public void createData(){
            String SQL = "INSERT INTO data_anggota (NIM,nama_anggota,kelas,tempat_lahir,tanggal_lahir) "
                    + "VALUES('"+nim_textfield.getText()+"','"+nama_textfield.getText()+"','"+kelas_combobox.getSelectedItem().toString()+"',"
                    + "'"+tempatlahir_textfield.getText()+"','"+tanggallahir_textfield.getText()+"')";
        try{
            stm.execute(SQL);
            showTable();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
    }
    
    public void deleteData(){
        int baris = Member_Table.getSelectedRow();
        if (baris != -1) {
            String id = Member_Table.getValueAt(baris, 0).toString();
            String SQL = "DELETE FROM data_anggota WHERE id_anggota ='"+id+"'";
            try{
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
             stm = con.createStatement();
             stm.executeUpdate(SQL);   
             showTable();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
            }
            }
//            if (status==1) {
//                JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
//                                showTable();
//            } else {
//                JOptionPane.showMessageDialog(this, "Data gagal dihapus", "Gagal", JOptionPane.WARNING_MESSAGE);
//
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Pilih Baris Data Terlebih dahulu", "Error", JOptionPane.WARNING_MESSAGE);
//        }
    }
    public void showTable(){
        tb = new DefaultTableModel();
        tb.addColumn("id_anggota");
        tb.addColumn("NIM");
        tb.addColumn("nama_anggota");
        tb.addColumn("kelas");
        tb.addColumn("tempat_lahir");
        tb.addColumn("tanggal_lahir");
        Member_Table.setModel(tb);
        
        
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT * FROM data_anggota");
            while(res.next()){
            tb.addRow(new Object[] {
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
            });
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
        
    }

    /**
     *
     */
    public DataPengembalianBuku_CampusLibrary() {
        initComponents();
        connection.setKoneksi();
        showTable();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id_textfield = new javax.swing.JTextField();
        nim_textfield = new javax.swing.JTextField();
        nama_textfield = new javax.swing.JTextField();
        update_button = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tempatlahir_textfield = new javax.swing.JTextField();
        kelas_combobox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PENGEMBALIAN BUKU");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PENERBIT");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("JUDUL BUKU");
        jLabel3.setPreferredSize(new java.awt.Dimension(72, 29));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PENGARANG");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TAHUN TERBIT");

        id_textfield.setEditable(false);
        id_textfield.setBackground(new java.awt.Color(255, 255, 255));
        id_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        id_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nim_textfield.setBackground(new java.awt.Color(255, 255, 255));
        nim_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        nim_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nama_textfield.setBackground(new java.awt.Color(255, 255, 255));
        nama_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        nama_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        update_button.setBackground(new java.awt.Color(204, 204, 204));
        update_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        update_button.setForeground(new java.awt.Color(51, 51, 51));
        update_button.setText("KEMBALI");
        update_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText(" KEMBALIKAN BUKU");
        jButton3.setActionCommand("");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("KATEGORI");

        tempatlahir_textfield.setBackground(new java.awt.Color(255, 255, 255));
        tempatlahir_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        tempatlahir_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tempatlahir_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempatlahir_textfieldActionPerformed(evt);
            }
        });

        kelas_combobox.setBackground(new java.awt.Color(255, 255, 255));
        kelas_combobox.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        kelas_combobox.setForeground(new java.awt.Color(0, 0, 0));
        kelas_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2wd1", "2wd2", "2wd3" }));
        kelas_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas_comboboxActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo ccit (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tempatlahir_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nama_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nim_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(231, 231, 231))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(672, 672, 672))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(kelas_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(231, 231, 231))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kelas_combobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nim_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tempatlahir_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_update_buttonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        createData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tempatlahir_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempatlahir_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tempatlahir_textfieldActionPerformed

    private void kelas_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelas_comboboxActionPerformed

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
            java.util.logging.Logger.getLogger(DataPengembalianBuku_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPengembalianBuku_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPengembalianBuku_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPengembalianBuku_CampusLibrary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPengembalianBuku_CampusLibrary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id_textfield;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> kelas_combobox;
    private javax.swing.JTextField nama_textfield;
    private javax.swing.JTextField nim_textfield;
    private javax.swing.JTextField tempatlahir_textfield;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
