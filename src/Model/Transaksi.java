/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

/**
 *
 * @author MRafliF
 */
public class Transaksi {
    
    private Integer Id_Transaksi;
    private Integer Jumlah_Pembelian;
    private Integer Total_Harga;
    private Integer Bayar;
    private Integer Kembali;
    private ArrayList<Detail_Transaksi> arrDetail_Transaksi;

    public Integer getId_Transaksi() {
        return Id_Transaksi;
    }

    public void setId_Transaksi(Integer Id_Transaksi) {
        this.Id_Transaksi = Id_Transaksi;
    }

    public Integer getJumlah_Pembelian() {
        return Jumlah_Pembelian;
    }

    public void setJumlah_Pembelian(Integer Jumlah_Pembelian) {
        this.Jumlah_Pembelian = Jumlah_Pembelian;
    }

    public Integer getTotal_Harga() {
        return Total_Harga;
    }

    public void setTotal_Harga(Integer Total_Harga) {
        this.Total_Harga = Total_Harga;
    }

    public Integer getBayar() {
        return Bayar;
    }

    public void setBayar(Integer Bayar) {
        this.Bayar = Bayar;
    }

    public Integer getKembali() {
        return Kembali;
    }

    public void setKembali(Integer Kembali) {
        this.Kembali = Kembali;
    }

    public ArrayList<Detail_Transaksi> getArrDetail_Transaksi() {
        return arrDetail_Transaksi;
    }

    public void setArrDetail_Transaksi(ArrayList<Detail_Transaksi> arrDetail_Transaksi) {
        this.arrDetail_Transaksi = arrDetail_Transaksi;
    }
    
    
    
}
