/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.controller;


import com.myshopdata.error.kategoriException;
import com.myshopdata.model.modelmyShopdata;
import com.myshopdata.view.AboutView;
import com.myshopdata.view.homeView;
import com.myshopdata.view.kategoriView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class msdController {

    private modelmyShopdata model;

    public void setModel(modelmyShopdata model) {
        this.model = model;
    }

    public void resetProduk(homeView view) {
        model.resetProduk();
    }
    
    public void resetKategori(kategoriView view){
        model.resetKategori();
    }
    
    public void insertProduk(homeView view) {
        String kode_barang = view.getTxtkode().getText();
        String nama_barang = view.getTxtnamabarang().getText();
        String kategori = (String) view.getCbkategori().getSelectedItem();
        int jumlah = Integer.parseInt(view.getTxtjumlah().getText());
        String ukuran = (String) view.getCbukuran().getSelectedItem();
        int harga = Integer.parseInt(view.getTxtharga().getText());

        if (kode_barang.equals("")) {
            JOptionPane.showMessageDialog(view, "Kode Barang Tidak Boleh Kosong");
        } else if (nama_barang.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        } else if (kode_barang.length() > 5) {
            JOptionPane.showMessageDialog(view, "Kode Barang tidak boleh lebih dari 5 Karakter");
        } else if (nama_barang.length() >255) {
            JOptionPane.showMessageDialog(view, "Nama Barang tidak boleh lebih dari 255 Karakter");
        } else {
            model.setKode_barang(kode_barang);
            model.setNama_barang(nama_barang);
            model.setKategori(kategori);
            model.setJumlah(jumlah);
            model.setUkuran(ukuran);
            model.setHarga(harga);

            try {
                model.insertProduk();
                JOptionPane.showMessageDialog(view, "Produk Berhasil Ditambahkan");
                model.resetProduk();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
        }

    }
    
    public void updateProduk(homeView view){        
        Integer id = Integer.parseInt(view.getTxtid().getText());
        
        String kode_barang = view.getTxtkode().getText();
        String nama_barang = view.getTxtnamabarang().getText();
        String kategori = (String) view.getCbkategori().getSelectedItem();
        int jumlah = Integer.parseInt(view.getTxtjumlah().getText());
        String ukuran = (String) view.getCbukuran().getSelectedItem();
        int harga = Integer.parseInt(view.getTxtharga().getText());
        
        if (kode_barang.equals(0)) {
            JOptionPane.showMessageDialog(view, "Kode Barang Tidak Boleh Kosong");
        } else if (kode_barang.length() > 5) {
            JOptionPane.showMessageDialog(view, "Nama Barang tidak boleh lebih dari 255 Karakter");
        } else if (nama_barang.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        } else {
            model.setId(id);
            model.setKode_barang(kode_barang);
            model.setNama_barang(nama_barang);
            model.setKategori(kategori);
            model.setJumlah(jumlah);
            model.setUkuran(ukuran);
            model.setHarga(harga);

            try {
                model.updateProduk();
                JOptionPane.showMessageDialog(view, "Produk Berhasil Diupdate");
                model.resetProduk();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
            }
        }
        
    
    
    }
    
    public void deleteProduk(homeView view){
        
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus ?") == JOptionPane.OK_OPTION) {
            String kode_barang = view.getTxtkode().getText();
            model.setKode_barang(kode_barang);
            
            try {
                model.deleteProduk();
                JOptionPane.showMessageDialog(view, "Produk Berhasil Di hapus");
                model.resetProduk();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
        }
        }
    
    }
    
    
    public void insertKategori(kategoriView view){
        String kategori = view.getTxtKategori().getText();
        
        if (kategori.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Tidak Boleh Kosong");
        } else {
            
            model.setKategori1(kategori);

            try {
                model.insertKategori();
                JOptionPane.showMessageDialog(view, "Kategori Berhasil Ditambahkan");
                model.resetKategori();
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", e.getMessage()});
            }
        }
          
        
    }
    
    public void deleteKategori(kategoriView view){
        if (view.getTabelKategori().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan seleksi baris data yang akan di hapus");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(view, "Anda Yakin Akan Menghapus ?") == JOptionPane.OK_OPTION) {
            String Kategori = view.getTxtKategori().getText();
            model.setKategori1(Kategori);
            
            try {
                model.deleteKategori();
                JOptionPane.showMessageDialog(view, "Produk Berhasil Di hapus");
                model.resetKategori();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di database dengan pesan", throwable.getMessage()});
        }
        }
    }
    public void btnSignIn(homeView home) {
        home.setVisible(true);

    }

    public void btnHome(homeView home) {
        home.setVisible(true);

    }

    public void btnAbout() {
        AboutView about = new AboutView();
        about.setVisible(true);
    }

    public void btnKategori() throws SQLException, kategoriException {
        kategoriView kategori = new kategoriView();
        kategori.loadDatabase();
        kategori.setVisible(true);
    }

}
