/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.entity;

import java.util.Objects;

/**
 *
 * @author ACER
 */
public class Produk {
    
    private int id;
    private String kode_barang;
    private String nama_barang;
    private String kategori;
    private int jumlah;
    private String ukuran;
    private int harga;

    public Produk(int id, String kode_barang, String nama_barang, String kategori, int jumlah, String ukuran, int harga) {
        this.id = id;
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.ukuran = ukuran;
        this.harga = harga;
    }


    public Produk() {
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.kode_barang);
        hash = 11 * hash + Objects.hashCode(this.nama_barang);
        hash = 11 * hash + Objects.hashCode(this.kategori);
        hash = 11 * hash + this.jumlah;
        hash = 11 * hash + Objects.hashCode(this.ukuran);
        hash = 11 * hash + this.harga;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produk other = (Produk) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.jumlah != other.jumlah) {
            return false;
        }
        if (this.harga != other.harga) {
            return false;
        }
        if (!Objects.equals(this.kode_barang, other.kode_barang)) {
            return false;
        }
        if (!Objects.equals(this.nama_barang, other.nama_barang)) {
            return false;
        }
        if (!Objects.equals(this.kategori, other.kategori)) {
            return false;
        }
        if (!Objects.equals(this.ukuran, other.ukuran)) {
            return false;
        }
        return true;
    }
    
    

    

    
   
   
    
}
