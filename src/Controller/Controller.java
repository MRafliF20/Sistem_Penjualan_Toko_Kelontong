/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.*;
import Model.*;
import Database.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MRafliF
 */
public class Controller {
    
    Koneksi koneksi;
    ArrayList<Barang> arrBarang;
    ArrayList<Jenis_Barang> arrJenis_Barang;
    ArrayList<Transaksi> arrTransaksi;

    public Controller() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrBarang = new ArrayList<>();
        this.arrJenis_Barang = new ArrayList<>();
        this.arrTransaksi = new ArrayList<>();
    }
    public ArrayList<Barang> getDataBarang() throws SQLException {
        arrBarang.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM BARANG JOIN JENIS_BARANG ON BARANG.ID_JENIS_BARANG = JENIS_BARANG.ID_JENIS_BARANG");
            while(rs.next()) {
                Jenis_Barang jenis_barang = new Jenis_Barang();
                jenis_barang.setId_Jenis_Barang(rs.getInt("ID_JENIS_BARANG"));
                jenis_barang.setNama_Jenis_Barang(rs.getString("NAMA_JENIS_BARANG"));
                
                Barang barang = new Barang();
                barang.setId_Barang(rs.getInt("ID_BARANG"));
                barang.setJenis_barang(jenis_barang);
                barang.setNama_Barang(rs.getString("NAMA_BARANG"));
                barang.setHarga(rs.getInt("HARGA"));
                barang.setStock(rs.getInt("STOCK"));
                
                arrBarang.add(barang);
            }
        return arrBarang;
    }
    public ArrayList<Jenis_Barang> getDataJenisBarang() throws SQLException {
        arrJenis_Barang.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM JENIS_BARANG");
            while(rs.next()) {
                Jenis_Barang jenis_barang = new Jenis_Barang();
                jenis_barang.setId_Jenis_Barang(rs.getInt("ID_JENIS_BARANG"));
                jenis_barang.setNama_Jenis_Barang(rs.getString("NAMA_JENIS_BARANG"));
                
                arrJenis_Barang.add(jenis_barang);
            }
        return arrJenis_Barang;
    }
    public ArrayList<Transaksi> getDataTransaksi() throws SQLException {
        arrTransaksi.clear();
        ResultSet rs = koneksi.GetData("SELECT * FROM TRANSAKSI");
            while(rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setId_Transaksi(rs.getInt("ID_TRANSAKSI"));
                transaksi.setJumlah_Pembelian(rs.getInt("JUMLAH_PEMBELIAN"));
                transaksi.setTotal_Harga(rs.getInt("TOTAL_HARGA"));
                transaksi.setBayar(rs.getInt("BAYAR"));
                transaksi.setKembali(rs.getInt("KEMBALI"));
                
        ResultSet rsDetail_Transaksi = koneksi.GetData("SELECT * FROM DETAIL_PEMESANAN JOIN BARANG ON DETAIL_PEMESANAN.ID_BARANG = BARANG.ID_BARANG JOIN JENIS_BARANG ON BARANG.ID_JENIS_BARANG = JENIS_BARANG.ID_JENIS_BARANG WHERE DETAIL_PEMESANAN.ID_TRANSAKSI = " + rs.getString("ID_TRANSAKSI"));
            ArrayList<Detail_Transaksi> dp = new ArrayList<>();
            while(rsDetail_Transaksi.next()) {
                Jenis_Barang jenis = new Jenis_Barang();
                jenis.setId_Jenis_Barang(rsDetail_Transaksi.getInt("ID_JENIS_BARANG"));
                jenis.setNama_Jenis_Barang(rsDetail_Transaksi.getString("NAMA_JENIS_BARANG"));
                
                Barang B = new Barang();
                B.setId_Barang(rsDetail_Transaksi.getInt("ID_BARANG"));
                B.setJenis_barang(jenis);
                B.setNama_Barang(rsDetail_Transaksi.getString("NAMA_BARANG"));
                B.setHarga(rsDetail_Transaksi.getInt("HARGA"));
                B.setStock(rsDetail_Transaksi.getInt("STOCK"));
                
                Detail_Transaksi detail_transaksi = new Detail_Transaksi();
                detail_transaksi.setBarang(B);
                detail_transaksi.setJumlah(rsDetail_Transaksi.getInt("JUMLAH"));
                
                dp.add(detail_transaksi);
            }
            transaksi.setArrDetail_Transaksi(dp);
            arrTransaksi.add(transaksi);
            }    
        return arrTransaksi;
    }
    public void insertTransaksi(Transaksi transaksi) {
        try {
            koneksi.ManipulasiData("INSERT INTO TRANSAKSI VALUES (ID_TRANSAKSI.NEXTVAL, " + transaksi.getJumlah_Pembelian() + "," + transaksi.getTotal_Harga() + ","+ transaksi.getBayar() + "," + transaksi.getKembali() + ")");
            ResultSet rs = koneksi.GetData("SELECT ID_TRANSAKSI.CURRVAL FROM DUAL");
            System.out.println(rs);
            rs.next();
            int Id_Transaksi = rs.getInt("CURRVAL");
            for(Detail_Transaksi p : transaksi.getArrDetail_Transaksi()) {
                koneksi.ManipulasiData("INSERT INTO DETAIL_PEMESANAN VALUES (" + Id_Transaksi
                                       + "," + p.getBarang().getId_Barang() + "," + p.getJumlah() + ")");
                koneksi.ManipulasiData("UPDATE BARANG SET STOCK = STOCK - " + p.getJumlah()
                                       + "WHERE ID_BARANG = " + p.getBarang().getId_Barang());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void insertJenisBarang(Jenis_Barang jenis_Barang) {
        try {
            koneksi.ManipulasiData("INSERT INTO JENIS_BARANG VALUES (ID_JENIS_BARANG.NEXTVAL, '" + jenis_Barang.getNama_Jenis_Barang() + "')");
            ResultSet rs = koneksi.GetData("SELECT ID_JENIS_BARANG.CURRVAL FROM DUAL");
            System.out.println(rs);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    public void deleteJenisBarang(Jenis_Barang jenis_Barang) {
        koneksi.ManipulasiData("DELETE FROM JENIS_BARANG WHERE ID_JENIS_BARANG = " + jenis_Barang.getId_Jenis_Barang());
    }
    public void insertBarang(Barang barang) {
        try {
            koneksi.ManipulasiData("INSERT INTO BARANG VALUES (ID_BARANG.NEXTVAL, " + barang.getJenis_barang().getId_Jenis_Barang()+ ",'" + barang.getNama_Barang()+ "'," + barang.getHarga() + "," + barang.getStock() + ")");
            ResultSet rs = koneksi.GetData("SELECT ID_BARANG.CURRVAL FROM DUAL");
            System.out.println(rs);
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateBarang(Barang barang, int Stock, int Harga) {
        koneksi.ManipulasiData("UPDATE BARANG SET HARGA = " + Harga + ",STOCK = " + Stock + "WHERE ID_BARANG = " + barang.getId_Barang());
    }
    public void deleteBarang(Barang barang) {
        koneksi.ManipulasiData("DELETE FROM BARANG WHERE ID_BARANG = " + barang.getId_Barang());
    }
}
