/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.service;

import com.myshopdata.entity.Kategori;
import com.myshopdata.error.kategoriException;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface kategoriDao {
 
        
    public void insertKategori(Kategori kategori) throws kategoriException;
    
    public void deleteKategori(String kategori) throws kategoriException;
    
    public List<Kategori> selectAllKategori() throws kategoriException;
}
