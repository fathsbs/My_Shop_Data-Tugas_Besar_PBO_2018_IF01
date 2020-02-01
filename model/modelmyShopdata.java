package com.myshopdata.model;

import com.myshopdata.database.MSDdb;
import com.myshopdata.entity.Kategori;
import com.myshopdata.entity.Produk;
import com.myshopdata.error.kategoriException;
import com.myshopdata.error.produkException;
import com.myshopdata.event.MSDListener;
import com.myshopdata.service.kategoriDao;
import com.myshopdata.service.produkDao;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class modelmyShopdata {

    private String username;
    private String password;

    private Integer id;
    private String kode_barang;
    private String nama_barang;
    private String kategori;
    private String kategori1;
    private Integer jumlah;
    private String ukuran;
    private Integer harga;

    private MSDListener listenermsd;

    public String getUsername() {
        return username;
    }
    
    
    public void setUsername(String username) {
        this.username = username;
        fireOnchange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        fireOnchange();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        fireOnchange();
    }
    

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
        fireOnchange();
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
        fireOnchange();
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
        fireOnchange();
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
        fireOnchange();
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
        fireOnchange();
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
        fireOnchange();
    }

    public String getKategori1() {
        return kategori1;
    }

    public void setKategori1(String kategori1) {
        this.kategori1 = kategori1;
        fireOnchange();
    }
    
    
    public MSDListener getListenermsd() {
        return listenermsd;
    }

    public void setListenermsd(MSDListener listenermsd) {
        this.listenermsd = listenermsd;
    }

    protected void fireOnchange() {
        if (listenermsd != null) {
            listenermsd.onChange(this);
        }

    }

    protected void fireOnInsert(Produk produk) {
        if (listenermsd != null) {
            listenermsd.onInsert(produk);
        }

    }

    protected void fireOnDelete() {
        if (listenermsd != null) {
            listenermsd.onDelete();
        }

    }

    protected void fireOnUpdate(Produk model) {
        if (listenermsd != null) {
            listenermsd.onUpdate(model);
        }
    }
    
    protected void fireOnInsert1(Kategori kategori){
        if (listenermsd != null) {
            listenermsd.onInsert1(kategori);
        }
    }
    
    protected void fireOnDelete1(){
        if (listenermsd != null) {
            listenermsd.onDeleteKategori();
        }
    }

    public void insertProduk() throws SQLException, produkException {
        produkDao dao = MSDdb.getProdukDao();
        Produk produk = new Produk();
        produk.setKode_barang(kode_barang);
        produk.setNama_barang(nama_barang);
        produk.setKategori(kategori);
        produk.setJumlah(jumlah);
        produk.setUkuran(ukuran);
        produk.setHarga(harga);

        dao.insertProduk(produk);
        fireOnInsert(produk);
    }

    public void updateProduk() throws SQLException, produkException {
        produkDao dao = MSDdb.getProdukDao();
        Produk produk = new Produk();
        produk.setId(id);
        produk.setKode_barang(kode_barang);
        produk.setNama_barang(nama_barang);
        produk.setKategori(kategori);
        produk.setJumlah(jumlah);
        produk.setUkuran(ukuran);
        produk.setHarga(harga);
       

        dao.updateProduk(produk);
        fireOnUpdate(produk);
    }

    public void deleteProduk() throws SQLException, produkException {
        produkDao dao = MSDdb.getProdukDao();
        dao.deleteProduk(kode_barang);


        fireOnDelete();
    }
    
    public void insertKategori() throws SQLException, kategoriException {
        kategoriDao dao = MSDdb.getKategoriDao();
        Kategori kat = new Kategori();
        kat.setKategori(kategori1);
        dao.insertKategori(kat);
        fireOnInsert1(kat);
    }
    
     public void deleteKategori() throws SQLException, kategoriException {
        kategoriDao dao = MSDdb.getKategoriDao();
        dao.deleteKategori(kategori1);
        fireOnDelete1();
    }
     
    public void resetProduk() {
        setKode_barang("");
        setNama_barang("");
        setKategori("");
        setJumlah(0);
        setUkuran("");
        setHarga(0);
    }

    public void resetKategori(){
        setKategori1("");
    }
    public void Login() {
        setUsername("");
        setPassword("");

    }
}
