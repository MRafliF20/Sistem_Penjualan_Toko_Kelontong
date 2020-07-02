/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.HTML.Tag.DT;
/**
 *
 * @author MRafliF
 */
public class View_Transaksi extends javax.swing.JFrame {
    
    private Controller controller;
    private ArrayList<Detail_Transaksi> arrKeranjang;
    private Integer hargatotal;
    private Integer kembali;
    
    public View_Transaksi() throws SQLException{
        initComponents();
        hargatotal = 0;
        kembali =0;
        controller = new Controller();
        arrKeranjang = new ArrayList<>();
        showCBbarang();
        showTBkeranjang();
        showTotalharga();
        showTBtransaksi();
        showKembali();
        TFtotal.disable();
        TFkembalian.disable();
    }
    
    public void showCBbarang() throws SQLException{
       DefaultComboBoxModel dcbmBarang = new DefaultComboBoxModel();
       for (Barang b : controller.getDataBarang()){
           dcbmBarang.addElement(b.getNama_Barang()+" Stok (" + b.getStock()+")");
       }
        CBbarang.removeAllItems();
        CBbarang.setModel(dcbmBarang);
    }
    
    public void showTBkeranjang() throws SQLException{
        DefaultTableModel dtmkeranjang = new DefaultTableModel(new String[]{
            "Nama Barang", "Jumlah Barang","Harga Satuan"},0);
        for (Detail_Transaksi dt : arrKeranjang){
            dtmkeranjang.addRow(new String[]{
                dt.getBarang().getNama_Barang(), dt.getJumlah().toString(), dt.getBarang().getHarga().toString()
                });
        }
        TBkeranjang.setModel(dtmkeranjang);
        
    }
    
    public void showTotalharga(){
        TFtotal.setText(hargatotal.toString());
    }
    public void showKembali(){
        TFkembalian.setText(kembali.toString());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBbarang = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFjumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBkeranjang = new javax.swing.JTable();
        BTNtambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TFtotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBLtransaksi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFbayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BTNbayar = new javax.swing.JButton();
        TFkembalian = new javax.swing.JTextField();
        BTNdetail = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CBbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Barang");

        jLabel2.setText("Jumlah");

        TBkeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TBkeranjang);

        BTNtambah.setText("Tambah");
        BTNtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNtambahActionPerformed(evt);
            }
        });

        jLabel3.setText("Total ");

        TFtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFtotalActionPerformed(evt);
            }
        });

        TBLtransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TBLtransaksi);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("PEMESANAN");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("TRANSAKSI");

        jLabel6.setText("Bayar");

        jLabel7.setText("Kembalian");

        BTNbayar.setText("Bayar");
        BTNbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNbayarActionPerformed(evt);
            }
        });

        TFkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFkembalianActionPerformed(evt);
            }
        });

        BTNdetail.setText("Detail");
        BTNdetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNdetailActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("TABEL KERANJANG");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("TABEL TRANSAKSI");

        btnKeluar.setText("Keluar");
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TFjumlah)
                                        .addComponent(TFtotal)
                                        .addComponent(CBbarang, 0, 137, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(BTNtambah)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel4)))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFbayar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(61, 61, 61))
                            .addComponent(BTNbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(TFkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BTNdetail, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))))
            .addGroup(layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(TFbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(BTNbayar))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNtambah)
                            .addComponent(jLabel7)
                            .addComponent(TFkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnKeluar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BTNdetail)
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(921, 477));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTNtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNtambahActionPerformed
        try{
            Detail_Transaksi dt = new Detail_Transaksi();
            dt.setJumlah(Integer.parseInt(TFjumlah.getText()));
            dt.setBarang(controller.getDataBarang().get(CBbarang.getSelectedIndex()));
            
            hargatotal += controller.getDataBarang().get(CBbarang.getSelectedIndex()).getHarga() * Integer.parseInt(TFjumlah.getText());
            
            showTotalharga();
            arrKeranjang.add(dt);
            showTBkeranjang();
            //TFjumlah.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(View_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BTNtambahActionPerformed

    public void showTBtransaksi()throws SQLException{
        DefaultTableModel dtmTransaksi = new DefaultTableModel(new String[]{
            "Id_Transaksi","Total Item", "Harga Total"},0);
        for (Transaksi TR : controller.getDataTransaksi()){
            dtmTransaksi.addRow(new String[]{
                TR.getId_Transaksi().toString(), TR.getJumlah_Pembelian().toString(), TR.getTotal_Harga().toString()
            });
        }
        TBLtransaksi.setModel(dtmTransaksi);
    }
    private void TFtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFtotalActionPerformed
        // TODO add your handling code he
    }//GEN-LAST:event_TFtotalActionPerformed

    private void BTNbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNbayarActionPerformed
        Transaksi T = new Transaksi();
        try{
            kembali = Integer.parseInt(TFbayar.getText()) - Integer.parseInt(TFtotal.getText());
            
            T.setJumlah_Pembelian(Integer.valueOf(TFjumlah.getText()));
            T.setTotal_Harga(hargatotal);
            T.setBayar(Integer.valueOf(TFbayar.getText()));
            T.setKembali(kembali);
            T.setArrDetail_Transaksi(arrKeranjang);
            controller.insertTransaksi(T);
            showTBtransaksi();
            
            showTBkeranjang();
            showTotalharga();
            showKembali();
            hargatotal=0;
            kembali=0;
            arrKeranjang = new ArrayList<>();
            showCBbarang();
        }catch(SQLException ex){
            
        }
    }//GEN-LAST:event_BTNbayarActionPerformed

    private void TFkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFkembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFkembalianActionPerformed

    private void BTNdetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNdetailActionPerformed
        try{
            Transaksi transaksi = controller.getDataTransaksi().get(TBLtransaksi.getSelectedRow());
            String teks = "================TRANSAKSI===============\n" +
                    "Id_transaksi   : " +transaksi.getId_Transaksi()+ "\n\n" +
                    "==================PRODUK================";
            
            ArrayList<Detail_Transaksi> DT = transaksi.getArrDetail_Transaksi();
            for(int i = 0; i < DT.size(); i++){
                teks += "\n\nNama Barang : " +DT.get(i).getBarang().getNama_Barang()+ "\n" +
                        "Harga Satuan : " +DT.get(i).getBarang().getHarga()+ "\n" +
                        "Jenis Barang : " +DT.get(i).getBarang().getJenis_barang().getNama_Jenis_Barang();
            }
            JOptionPane.showMessageDialog(null,teks, null, 0);   
        }catch(SQLException re){  
        }
    }//GEN-LAST:event_BTNdetailActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNbayar;
    private javax.swing.JButton BTNdetail;
    private javax.swing.JButton BTNtambah;
    private javax.swing.JComboBox<String> CBbarang;
    private javax.swing.JTable TBLtransaksi;
    private javax.swing.JTable TBkeranjang;
    private javax.swing.JTextField TFbayar;
    private javax.swing.JTextField TFjumlah;
    private javax.swing.JTextField TFkembalian;
    private javax.swing.JTextField TFtotal;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
