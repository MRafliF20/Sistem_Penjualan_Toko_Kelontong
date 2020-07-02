/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MRafliF
 */
public class Barang {

    private Integer Id_Barang;
    private String Nama_Barang;
    private Integer Harga;
    private Integer Stock;
    private Jenis_Barang jenis_barang;

    public Integer getId_Barang() {
        return Id_Barang;
    }

    public void setId_Barang(Integer Id_Barang) {
        this.Id_Barang = Id_Barang;
    }

    public String getNama_Barang() {
        return Nama_Barang;
    }

    public void setNama_Barang(String Nama_Barang) {
        this.Nama_Barang = Nama_Barang;
    }

    public Integer getHarga() {
        return Harga;
    }

    public void setHarga(Integer Harga) {
        this.Harga = Harga;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }

    public Jenis_Barang getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(Jenis_Barang jenis_barang) {
        this.jenis_barang = jenis_barang;
    }
    
    
}
