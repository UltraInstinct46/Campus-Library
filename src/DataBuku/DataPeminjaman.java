/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DataBuku;

import Member.*;
import Conection.Connectionc;
import static Member.MembersData.sdf;
import static Member.MembersData.tb;
import java.sql.*;
import REGISTER.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class DataPeminjaman extends javax.swing.JFrame {
    public static Connection con;
    public static Statement stm;
    public static ResultSet res;
    public static DefaultTableModel tb;
    public static int id;
    public static SimpleDateFormat sdf;
    Connectionc connection = new Connectionc();
    /**
     * Creates new form Register_CampusLibrary
     */
    public void search(){
        tb = new DefaultTableModel();
        tb.addColumn("id_peminjam");
        tb.addColumn("username");
        tb.addColumn("id_buku");
        tb.addColumn("status");
        tb.addColumn("tgl_pinjam");
        tb.addColumn("tgl_pengembalian");
        Peminjam_Table.setModel(tb);
        String text = search_textfield.getText();
        
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT * FROM data_peminjambuku WHERE username LIKE '%"+text+"%'");
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
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datepinjam = sdf.format(tglpinjam_date.getDate());
            String datepengembalian = sdf.format(tglpengembalian_date.getDate());
            String SQL = "UPDATE data_peminjambuku SET "
                    + "username='"+username_textfield.getText()+"',"
                    + "id_buku='"+idbuku_textfield.getText()+"',"
                    + "status='"+status_combobox.getSelectedItem().toString()+"',tgl_pinjam='"+datepinjam+"',"
                    + "tgl_pengembalian='"+datepengembalian+"' "
                    + "WHERE id_peminjam='"+idpeminjam_textfield.getText()+"'";
        try{
            stm.execute(SQL);
            showTable();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
    }
//        public void createData(){
//            String SQL = "INSERT INTO data_anggota (NIM,username,nama_anggota,kelas,tempat_lahir,tanggal_lahir) "
//                    + "VALUES('"+username_textfield.getText()+"','"+idbuku_textfield.getText()+"','"+tglpinjam_textfield.getText()+"','"+status_combobox.getSelectedItem().toString()+"',"
//                    + "'"+tglpengembalian_textfield.getText()+"','"+tanggallahir_textfield.getText()+"')";
//        try{
//            stm.execute(SQL);
//            showTable();
//        }catch(Exception e){
//                JOptionPane.showMessageDialog(null,"Failed "  + e);
//        }
//    }
    
    public void deleteData(){
        int baris = Peminjam_Table.getSelectedRow();
        if (baris != -1) {
            String id = Peminjam_Table.getValueAt(baris, 0).toString();
            String SQL = "DELETE FROM data_peminjambuku WHERE id_peminjam ='"+id+"'";
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
        tb.addColumn("id_peminjam");
        tb.addColumn("username");
        tb.addColumn("id_buku");
        tb.addColumn("status");
        tb.addColumn("tgl_pinjam");
        tb.addColumn("tgl_pengembalian");
        Peminjam_Table.setModel(tb);
        
        
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT * FROM data_peminjambuku");
            while(res.next()){
            tb.addRow(new Object[] {
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
            });
            id = Integer.parseInt(res.getString(1)) + 1;
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
        
    }

    /**
     *
     */
    public DataPeminjaman() {
        initComponents();
        connection.setKoneksi();
        showTable();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        idpeminjam_textfield.setText(""+id);
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
        username_textfield = new javax.swing.JTextField();
        delete_button = new javax.swing.JButton();
        update_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Peminjam_Table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        search_textfield = new javax.swing.JTextField();
        status_combobox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idbuku_textfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        idpeminjam_textfield = new javax.swing.JLabel();
        tglpinjam_date = new com.toedter.calendar.JDateChooser();
        tglpengembalian_date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(131, 191, 221));
        jPanel1.setPreferredSize(new java.awt.Dimension(1154, 754));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Centaur", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PEMINJAM");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("USERNAME");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID");
        jLabel3.setPreferredSize(new java.awt.Dimension(72, 29));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("STATUS");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TGL PINJAM");

        username_textfield.setBackground(new java.awt.Color(255, 255, 255));

        delete_button.setBackground(new java.awt.Color(204, 204, 204));
        delete_button.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        delete_button.setForeground(new java.awt.Color(51, 51, 51));
        delete_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/delete (1).png"))); // NOI18N
        delete_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        update_button.setBackground(new java.awt.Color(204, 204, 204));
        update_button.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        update_button.setForeground(new java.awt.Color(51, 51, 51));
        update_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/updated (1).png"))); // NOI18N
        update_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        Peminjam_Table.setBackground(new java.awt.Color(255, 255, 255));
        Peminjam_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Peminjam_Table.setShowGrid(true);
        Peminjam_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Peminjam_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Peminjam_Table);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("TGL PENGEMBALIAN");

        search_textfield.setBackground(new java.awt.Color(255, 255, 255));
        search_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_textfieldActionPerformed(evt);
            }
        });
        search_textfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search_textfieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_textfieldKeyReleased(evt);
            }
        });

        status_combobox.setBackground(new java.awt.Color(255, 255, 255));
        status_combobox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        status_combobox.setForeground(new java.awt.Color(0, 0, 0));
        status_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Belum Dikembalikan", "Sudah Dikembalikan" }));
        status_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_comboboxActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo ccit (2).png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/search (2) (1).png"))); // NOI18N

        idbuku_textfield.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("ID_BUKU");

        idpeminjam_textfield.setBackground(new java.awt.Color(0, 0, 0));
        idpeminjam_textfield.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        idpeminjam_textfield.setForeground(new java.awt.Color(0, 0, 0));
        idpeminjam_textfield.setText("ID");
        idpeminjam_textfield.setPreferredSize(new java.awt.Dimension(72, 29));

        tglpinjam_date.setBackground(new java.awt.Color(255, 255, 255));
        tglpinjam_date.setForeground(new java.awt.Color(255, 255, 255));

        tglpengembalian_date.setBackground(new java.awt.Color(255, 255, 255));
        tglpengembalian_date.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(status_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idbuku_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idpeminjam_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(tglpinjam_date, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tglpengembalian_date, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 197, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGap(460, 460, 460))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(search_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idpeminjam_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idbuku_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(status_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tglpinjam_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(tglpengembalian_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(update_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_update_buttonActionPerformed

    private void status_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_status_comboboxActionPerformed

    private void Peminjam_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Peminjam_TableMouseClicked
        // TODO add your handling code here:
        int i = Peminjam_Table.getSelectedRow();
        if(i>-1){
            if(tb.getValueAt(i,3).toString().equals("Belum Dikembalikan")){
                status_combobox.setSelectedIndex(1);
            }else if(tb.getValueAt(i,3).toString().equals("Sudah Dikembalikan")){
                status_combobox.setSelectedIndex(2);
            }
            idpeminjam_textfield.setText(tb.getValueAt(i,0).toString());
            username_textfield.setText(tb.getValueAt(i,1).toString());
            idbuku_textfield.setText(tb.getValueAt(i,2).toString());
            try{
            java.util.Date datepinjam = new SimpleDateFormat("yyyy-MM-dd").parse((String)tb.getValueAt(i, 4));   
            tglpinjam_date.setDate(datepinjam);
            try{
            java.util.Date datepengembalian = new SimpleDateFormat("yyyy-MM-dd").parse((String)tb.getValueAt(i, 5));   
            tglpengembalian_date.setDate(datepengembalian);
            }catch(Exception e){
            tglpengembalian_date.setDate(null);
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_Peminjam_TableMouseClicked

    private void search_textfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_textfieldKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_search_textfieldKeyReleased

    private void search_textfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_textfieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_textfieldKeyPressed

    private void search_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_textfieldActionPerformed

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
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new DataPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Peminjam_Table;
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField idbuku_textfield;
    private javax.swing.JLabel idpeminjam_textfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search_textfield;
    private javax.swing.JComboBox<String> status_combobox;
    private com.toedter.calendar.JDateChooser tglpengembalian_date;
    private com.toedter.calendar.JDateChooser tglpinjam_date;
    private javax.swing.JButton update_button;
    private javax.swing.JTextField username_textfield;
    // End of variables declaration//GEN-END:variables
}
