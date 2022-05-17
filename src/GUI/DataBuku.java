/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Conection.Connectionc;
import java.sql.*;
import java.text.*;
import java.awt.print.*; 
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ACER
 */
public class DataBuku extends javax.swing.JFrame {
    public static Connection con;
    public static Statement stm;
    public static ResultSet res;
    public static DefaultTableModel tb;
    public static int id;
    Connectionc connection = new Connectionc();
    /**
     * Creates new form Register_CampusLibrary
     */
    public void search(){
        tb = new DefaultTableModel();
        tb.addColumn("id_buku");
        tb.addColumn("judul_buku");
        tb.addColumn("penerbit");
        tb.addColumn("pengarang");
        tb.addColumn("tahun_penerbit");
        tb.addColumn("kategori");
        tb.addColumn("stok");
        Book_Table.setModel(tb);
        String text = search_textfield.getText();
        
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT * FROM data_buku WHERE judul_buku LIKE '%"+text+"%'");
            while(res.next()){
            tb.addRow(new Object[] {
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
                res.getString(7),
            });
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
        
    }
    public void updateData(){
            String SQL = "UPDATE data_buku SET "
                    + "judul_buku='"+judul_textfield.getText()+"',"
                    + "penerbit='"+penerbit_textfield.getText()+"',pengarang='"+pengarang_textfield.getText()+"',"
                    + "tahun_penerbit='"+tahunterbit_textfield.getText()+"',"
                    + "kategori='"+kategori_combobox.getSelectedItem().toString()+"',"
                    + "stok='"+Integer.parseInt(stok_textfield.getText())+"' "
                    + "WHERE id_buku='"+id_textfield.getText()+"'";
        try{
            stm.execute(SQL);
            showTable();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
    }
        public void createData(){
            String SQL = "INSERT INTO data_buku (judul_buku,penerbit,pengarang,tahun_penerbit,kategori,stok) "
                    + "VALUES('"+judul_textfield.getText()+"','"+penerbit_textfield.getText()+"','"+pengarang_textfield.getText()+"',"
                    + "'"+tahunterbit_textfield.getText()+"','"+kategori_combobox.getSelectedItem().toString()+"','"+stok_textfield.getText()+"')";
        try{
            stm.execute(SQL);
            showTable();
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
    }
    
    public void deleteData(){
        int baris = Book_Table.getSelectedRow();
        if (baris != -1) {
            String id = Book_Table.getValueAt(baris, 0).toString();
            String SQL = "DELETE FROM data_buku WHERE id_buku ='"+id+"'";
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
//        } else {lu 
//            JOptionPane.showMessageDialog(this, "Pilih Baris Data Terlebih dahulu", "Error", JOptionPane.WARNING_MESSAGE);
//        }
    }
    public void showTable(){
        tb = new DefaultTableModel();
        tb.addColumn("id_buku");
        tb.addColumn("judul_buku");
        tb.addColumn("penerbit");
        tb.addColumn("pengarang");
        tb.addColumn("tahun_penerbit");
        tb.addColumn("kategori");
        tb.addColumn("stok");
        Book_Table.setModel(tb);
        
        
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_library","root","");
            stm = con.createStatement();
            res=stm.executeQuery("SELECT * FROM data_buku");
            while(res.next()){
            tb.addRow(new Object[] {
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4),
                res.getString(5),
                res.getString(6),
                res.getString(7),
            });
            id=Integer.parseInt(res.getString(1))+1;
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed "  + e);
        }
        
    }

    /**
     *
     */
    public DataBuku() {
        initComponents();
        connection.setKoneksi();
        showTable();
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        id_textfield.setText(id+"");
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
        judul_textfield = new javax.swing.JTextField();
        delete_button = new javax.swing.JButton();
        penerbit_textfield = new javax.swing.JTextField();
        update_button = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Book_Table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tahunterbit_textfield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        search_textfield = new javax.swing.JTextField();
        kategori_combobox = new javax.swing.JComboBox<>();
        pengarang_textfield = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        stok_textfield = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        id_textfield = new javax.swing.JLabel();
        print_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(131, 191, 221));
        jPanel1.setPreferredSize(new java.awt.Dimension(1154, 754));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Centaur", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA BUKU");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Judul Buku");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID");
        jLabel3.setPreferredSize(new java.awt.Dimension(72, 29));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Penerbit");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Pengarang");

        judul_textfield.setBackground(new java.awt.Color(255, 255, 255));

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

        penerbit_textfield.setBackground(new java.awt.Color(255, 255, 255));

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

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/book (3) (1).png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Book_Table.setBackground(new java.awt.Color(255, 255, 255));
        Book_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Book_Table.setShowGrid(true);
        Book_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Book_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Book_Table);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tahun Penerbit");

        tahunterbit_textfield.setBackground(new java.awt.Color(255, 255, 255));
        tahunterbit_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunterbit_textfieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Kategori");
        jLabel10.setMaximumSize(new java.awt.Dimension(1154, 754));

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

        kategori_combobox.setBackground(new java.awt.Color(255, 255, 255));
        kategori_combobox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        kategori_combobox.setForeground(new java.awt.Color(0, 0, 0));
        kategori_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Fiksi", "Non Fiksi" }));
        kategori_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategori_comboboxActionPerformed(evt);
            }
        });

        pengarang_textfield.setBackground(new java.awt.Color(255, 255, 255));
        pengarang_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pengarang_textfieldActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logo ccit (2).png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/search (2) (1).png"))); // NOI18N

        stok_textfield.setBackground(new java.awt.Color(255, 255, 255));
        stok_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stok_textfieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Stok");
        jLabel12.setMaximumSize(new java.awt.Dimension(1154, 754));

        id_textfield.setBackground(new java.awt.Color(0, 0, 0));
        id_textfield.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        id_textfield.setForeground(new java.awt.Color(0, 0, 0));
        id_textfield.setText("ID");
        id_textfield.setPreferredSize(new java.awt.Dimension(72, 29));

        print_button.setBackground(new java.awt.Color(204, 204, 204));
        print_button.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        print_button.setForeground(new java.awt.Color(51, 51, 51));
        print_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/printer (1).png"))); // NOI18N
        print_button.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tahunterbit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(penerbit_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kategori_combobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(stok_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(id_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(judul_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pengarang_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 194, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(print_button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(391, 391, 391)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(search_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)
                            .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(176, 176, 176))
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
                            .addComponent(id_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judul_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(penerbit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pengarang_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tahunterbit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kategori_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stok_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(print_button, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        createData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tahunterbit_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunterbit_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunterbit_textfieldActionPerformed

    private void kategori_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategori_comboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategori_comboboxActionPerformed

    private void pengarang_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pengarang_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pengarang_textfieldActionPerformed

    private void Book_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Book_TableMouseClicked
        // TODO add your handling code here:
        int i = Book_Table.getSelectedRow();
        String kelas;
        if(i>-1){
            if(tb.getValueAt(i,3).toString().equals("Fiksi")){
                kategori_combobox.setSelectedIndex(1);
            }else if(tb.getValueAt(i,3).toString().equals("Non Fiksi")){
                kategori_combobox.setSelectedIndex(2);
            }
            id_textfield.setText(tb.getValueAt(i,0).toString());
            judul_textfield.setText(tb.getValueAt(i,1).toString());
            penerbit_textfield.setText(tb.getValueAt(i,2).toString());
            tahunterbit_textfield.setText(tb.getValueAt(i,4).toString());
            pengarang_textfield.setText(tb.getValueAt(i,5).toString());
            stok_textfield.setText(tb.getValueAt(i,6).toString());
        }
    }//GEN-LAST:event_Book_TableMouseClicked

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

    private void stok_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stok_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stok_textfieldActionPerformed

    private void print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_buttonActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Report Data Buku");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        
        try{
            Book_Table.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_print_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Book_Table;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel id_textfield;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judul_textfield;
    private javax.swing.JComboBox<String> kategori_combobox;
    private javax.swing.JTextField penerbit_textfield;
    private javax.swing.JTextField pengarang_textfield;
    private javax.swing.JButton print_button;
    private javax.swing.JTextField search_textfield;
    private javax.swing.JTextField stok_textfield;
    private javax.swing.JTextField tahunterbit_textfield;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
