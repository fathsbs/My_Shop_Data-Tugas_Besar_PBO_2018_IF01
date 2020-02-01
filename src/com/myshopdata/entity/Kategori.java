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
public class Kategori {
    private String kategori;

    public Kategori(String kategori) {
        this.kategori = kategori;
    }

    public Kategori() {
    }
    
    

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.kategori);
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
        final Kategori other = (Kategori) obj;
        if (!Objects.equals(this.kategori, other.kategori)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
