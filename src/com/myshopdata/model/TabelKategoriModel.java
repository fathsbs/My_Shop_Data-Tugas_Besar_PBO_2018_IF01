/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.model;

import com.myshopdata.entity.Kategori;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class TabelKategoriModel extends AbstractTableModel{
    private List<Kategori> list = new ArrayList<Kategori>();

    public void setList(List<Kategori> list) {
        this.list = list;
    }

    public boolean add(Kategori e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getColumnCount() - 1, getRowCount() - 1);

        }
    }

    public Kategori get(int index) {
        return list.get(index);
    }

    public Kategori set(int index, Kategori element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Kategori remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : return "Kategori";
            default: return null;
        }
    }
    
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){
            case 0 : return list.get(rowIndex).getKategori();
            default: return null;
        }
    }
}
