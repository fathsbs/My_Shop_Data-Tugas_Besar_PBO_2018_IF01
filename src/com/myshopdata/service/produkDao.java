/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.service;

import com.myshopdata.entity.Produk;
import com.myshopdata.error.produkException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface produkDao {
    
    public void insertProduk(Produk produk) throws produkException;
    public void updateProduk(Produk produk) throws produkException;
    public void deleteProduk(String Kode_Barang) throws produkException;
    public Produk getProduk (String Kode_Barang) throws produkException;
    public List<Produk> selectAllProduk() throws produkException;
    
    
}
