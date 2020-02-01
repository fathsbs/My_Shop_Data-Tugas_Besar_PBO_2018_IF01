/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.event;

import com.myshopdata.entity.Kategori;
import com.myshopdata.entity.Produk;
import com.myshopdata.model.modelmyShopdata;

/**
 *
 * @author ACER
 */
public interface MSDListener {
   
    public void onChange(modelmyShopdata model);
    
    public void onInsert (Produk produk);
    
    public void onUpdate (Produk model);
    
    public void onDelete ();
    
    public void onInsert1(Kategori kategori);
    
    public void onDeleteKategori();
}
