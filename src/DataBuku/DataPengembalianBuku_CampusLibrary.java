/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DataBuku;

import Member.*;
import Conection.Connectionc;
import static DataBuku.DataPinjamBuku_CampusLibrary.con;
import static DataBuku.DataPinjamBuku_CampusLibrary.id;
import static DataBuku.DataPinjamBuku_CampusLibrary.stm;
import Login.Login_CampusLibrary;
import java.sql.*;
import REGISTER.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
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
    public static DefaultComboBoxModel dm;
    public static int id;
    Connectionc connection = new Connectionc();
    /**
     * Creates new form Register_CampusLibrary
     */
//    public void search(){
//        tb = new DefaultTableModel();
//        tb.addColumn("id_anggota");
//        tb.addColumn("NIM");
//        tb.addColumn("nama_anggota");
//        tb.addColumn("kelas");
//        tb.addColumn("tempat_lahir");
//        tb.addColumn("tanggal_lahir");
//        Member_Table.setModel(tb);
//        String text = search_textfield.getText();
//        
//        try{
//            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
//            stm = con.createStatement();
//            res=stm.executeQuery("SELECT * FROM data_anggota WHERE nama_anggota LIKE '%"+text+"%'");
//            while(res.next()){
//            tb.addRow(new Object[] {
//                res.getString(1),
//                res.getString(2),
//                res.getString(3),
//                res.getString(4),
//                res.getString(5),
//                res.getString(6),
//            });
//        }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,"Failed "  + e);
//        }
//        
//    }
//    public void updateData(){
//            String SQL = "UPDATE data_anggota SET "
//                    + "NIM='"+nim_textfield.getText()+"',"
//                    + "nama_anggota='"+nama_textfield.getText()+"',kelas='"+kelas_combobox.getSelectedItem().toString()+"',"
//                    + "tempat_lahir='"+tempatlahir_textfield.getText()+"',"
//                    + "tanggal_lahir='"+tanggallahir_textfield.getText()+"' "
//                    + "WHERE id_anggota='"+id_textfield.getText()+"'";
//        try{
//            stm.execute(SQL);
//            showTable();
//        }catch(Exception e){
//                JOptionPane.showMessageDialog(null,"Failed "  + e);
//        }
//    }
//        public void createData(){
//            String SQL = "INSERT INTO data_anggota (NIM,nama_anggota,kelas,tempat_lahir,tanggal_lahir) "
//                    + "VALUES('"+nim_textfield.getText()+"','"+nama_textfield.getText()+"','"+kelas_combobox.getSelectedItem().toString()+"',"
//                    + "'"+tempatlahir_textfield.getText()+"','"+tanggallahir_textfield.getText()+"')";
//        try{
//            stm.execute(SQL);
//            showTable();
//        }catch(Exception e){
//                JOptionPane.showMessageDialog(null,"Failed "  + e);
//        }
//    }
    
//    public void deleteData(){
//        int baris = Member_Table.getSelectedRow();
//        if (baris != -1) {
//            String id = Member_Table.getValueAt(baris, 0).toString();
//            String SQL = "DELETE FROM data_anggota WHERE id_anggota ='"+id+"'";
//            try{
//             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
//             stm = con.createStatement();
//             stm.executeUpdate(SQL);   
//             showTable();
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null,"Failed "  + e);
//            }
//            }
////            if (status==1) {
////                JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
////                                showTable();
////            } else {
////                JOptionPane.showMessageDialog(this, "Data gagal dihapus", "Gagal", JOptionPane.WARNING_MESSAGE);
////
////            }
////        } else {
////            JOptionPane.showMessageDialog(this, "Pilih Baris Data Terlebih dahulu", "Error", JOptionPane.WARNING_MESSAGE);
////        }
//    }
    public void showCombobox(){
        dm=new DefaultComboBoxModel();
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT id_buku,judul_buku FROM data_buku");
            while(res.next()){
            dm.addElement(res.getString(2));
        }
            kelas_combobox.setModel(dm);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
        
    }
    public void showData(){
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT * FROM data_buku where judul_buku='"+kelas_combobox.getSelectedItem().toString()+"'");
            while(res.next()){
            id=Integer.parseInt(res.getString(1));
            penerbit_textfield.setText(res.getString(3));
            pengarang_textfield.setText(res.getString(4));
            tahunterbit_textfield.setText(res.getString(5));
            kategori_textfield.setText(res.getString(6));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
    }
        public void pengembalian(){
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            String SQL = "UPDATE data_peminjambuku SET "
                    + "status='"+"Sudah Dikembalikan"+"',"
                    + "tgl_pengembalian='"+java.time.LocalDate.now()+"' "
                    + "WHERE username='"+Login_CampusLibrary.usm+"' AND id_buku="+id;
            stm.execute(SQL);
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
        showCombobox();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        kelas_combobox.addItemListener(event -> {
        // The item affected by the event.
        String item = (String) event.getItem();
        if (event.getStateChange() == ItemEvent.SELECTED) {
            showData();
        }
        if (event.getStateChange() == ItemEvent.DESELECTED) {
//            showData();
         
        }
        });
//        kelas_combobox.addItemListener ((ItemListener) new ActionListener () {
//        public void actionPerformed(ActionEvent e) {
//        kelas_combobox.getSelectedItem().toString();
//        jLabel3.setText(kelas_combobox.getSelectedItem().toString());
//      }
//});
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
        update_button = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kelas_combobox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        penerbit_textfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pengarang_textfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tahunterbit_textfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        kategori_textfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(131, 191, 221));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Centaur", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PENGEMBALIAN BUKU");

        update_button.setBackground(new java.awt.Color(204, 204, 204));
        update_button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update_button.setForeground(new java.awt.Color(51, 51, 51));
        update_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/back (1).png"))); // NOI18N
        update_button.setText("KEMBALI");
        update_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update_button.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/book (1) (2).png"))); // NOI18N
        jButton3.setText(" KEMBALIKAN BUKU");
        jButton3.setActionCommand("");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo ccit (2).png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(243, 243, 223));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("JUDUL BUKU");
        jLabel3.setPreferredSize(new java.awt.Dimension(72, 29));

        kelas_combobox.setBackground(new java.awt.Color(255, 255, 255));
        kelas_combobox.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        kelas_combobox.setForeground(new java.awt.Color(0, 0, 0));
        kelas_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "2wd1", "2wd2", "2wd3" }));
        kelas_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas_comboboxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PENERBIT");

        penerbit_textfield.setEditable(false);
        penerbit_textfield.setBackground(new java.awt.Color(255, 255, 255));
        penerbit_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        penerbit_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PENGARANG");

        pengarang_textfield.setEditable(false);
        pengarang_textfield.setBackground(new java.awt.Color(255, 255, 255));
        pengarang_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        pengarang_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TAHUN TERBIT");

        tahunterbit_textfield.setEditable(false);
        tahunterbit_textfield.setBackground(new java.awt.Color(255, 255, 255));
        tahunterbit_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        tahunterbit_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("KATEGORI");

        kategori_textfield.setEditable(false);
        kategori_textfield.setBackground(new java.awt.Color(255, 255, 255));
        kategori_textfield.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        kategori_textfield.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        kategori_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategori_textfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kategori_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tahunterbit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pengarang_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(penerbit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(kelas_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penerbit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pengarang_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tahunterbit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kategori_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(306, Short.MAX_VALUE))
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
//        updateData();
    }//GEN-LAST:event_update_buttonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        pengembalian();
//        createData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void kategori_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategori_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategori_textfieldActionPerformed

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
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField kategori_textfield;
    private javax.swing.JComboBox<String> kelas_combobox;
    private javax.swing.JTextField penerbit_textfield;
    private javax.swing.JTextField pengarang_textfield;
    private javax.swing.JTextField tahunterbit_textfield;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
