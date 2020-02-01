/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.model;

import com.myshopdata.entity.Produk;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class TabelProdukModel extends AbstractTableModel {

    private List<Produk> list = new ArrayList<Produk>();

    public void setList(List<Produk> list) {
        this.list = list;
    }

    public boolean add(Produk e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getColumnCount() - 1, getRowCount() - 1);

        }
    }

    public Produk get(int index) {
        return list.get(index);
    }

    public Produk set(int index, Produk element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Produk remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public String getColumnName(int column) {
    
        switch(column){
            case 0 : return "ID";
            case 1 : return "Kode_Barang";
            case 2 : return "Nama_Barang";
            case 3 : return "Kategori";
            case 4 : return "Jumlah";
            case 5 : return "Ukuran";
            case 6 : return "Harga";
            default: return null;
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
    
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
         switch(columnIndex){
            case 0 : return list.get(rowIndex).getId();
            case 1 : return list.get(rowIndex).getKode_barang();
            case 2 : return list.get(rowIndex).getNama_barang();
            case 3 : return list.get(rowIndex).getKategori();
            case 4 : return list.get(rowIndex).getJumlah();
            case 5 : return list.get(rowIndex).getUkuran();
            case 6 : return list.get(rowIndex).getHarga();
            default: return null;
        }
    }

}
