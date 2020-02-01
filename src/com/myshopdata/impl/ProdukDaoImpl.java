/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.impl;

import com.myshopdata.entity.Produk;
import com.myshopdata.error.produkException;
import com.myshopdata.service.produkDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class ProdukDaoImpl implements produkDao {

    private Connection connection;

    private final String insertProduk = "insert into produk (Kode_Barang, Nama_Barang, Kategori, Jumlah, Ukuran, Harga) values (?,?,?,?,?,?)";

    private final String updateProduk = "update produk set Kode_Barang=?, Nama_Barang=?,Kategori=?,Jumlah=?, Ukuran=?, Harga=?  where ID=?";

    private final String deleteProduk = "delete from produk where Kode_Barang=?";

    private final String getByKode = "select * from produk where Kode_Barang=?";

    private final String selectAll = "select * from produk";

    public ProdukDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertProduk(Produk produk) throws produkException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertProduk, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, produk.getKode_barang());
            statement.setString(2, produk.getNama_barang());
            statement.setString(3, produk.getKategori());
            statement.setInt(4, produk.getJumlah());
            statement.setString(5, produk.getUkuran());
            statement.setInt(6, produk.getHarga());

            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                produk.setKode_barang(result.getString(1));
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new produkException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void updateProduk(Produk produk) throws produkException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareCall(updateProduk);
            statement.setInt(7, produk.getId());
            statement.setString(1, produk.getKode_barang());
            statement.setString(2, produk.getNama_barang());
            statement.setString(3, produk.getKategori());
            statement.setInt(4, produk.getJumlah());
            statement.setString(5, produk.getUkuran());
            statement.setInt(6, produk.getHarga());
            
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new produkException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }

    }

    @Override
    public void deleteProduk(String Kode_Barang) throws produkException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(deleteProduk);
            statement.setString(1, Kode_Barang);
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new produkException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Produk getProduk(String Kode_Barang) throws produkException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareCall(getByKode);
            statement.setString(1, Kode_Barang);

            ResultSet result = statement.executeQuery();
            Produk produk = null;

            if (result.next()) {
                produk = new Produk();
                produk.setId(result.getInt("ID"));
                produk.setKode_barang(result.getString("Kode_Barang"));
                produk.setNama_barang(result.getString("Nama_Barang"));
                produk.setKategori(result.getString("Kategori"));
                produk.setJumlah(result.getInt("Jumlah"));
                produk.setUkuran(result.getString("Ukuran"));
                produk.setHarga(result.getInt("Harga"));
            } else {
                throw new produkException("produk dengan kode " + Kode_Barang + " tidak ditemukan");
            }
            connection.commit();
            return produk;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new produkException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }


    @Override
    public List<Produk> selectAllProduk() throws produkException {

        Statement statement = null;
        List<Produk> list = new ArrayList<Produk>();
        try {
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            Produk produk = null;

            while (result.next()) {
                produk = new Produk();
                produk.setId(result.getInt("ID"));
                produk.setKode_barang(result.getString("Kode_Barang"));
                produk.setNama_barang(result.getString("Nama_Barang"));
                produk.setKategori(result.getString("Kategori"));
                produk.setJumlah(result.getInt("Jumlah"));
                produk.setUkuran(result.getString("Ukuran"));
                produk.setHarga(result.getInt("Harga"));
                list.add(produk);
            }

            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new produkException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
