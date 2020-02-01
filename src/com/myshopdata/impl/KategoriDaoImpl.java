/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.impl;

import com.myshopdata.entity.Kategori;
import com.myshopdata.error.kategoriException;
import com.myshopdata.service.kategoriDao;
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
public class KategoriDaoImpl implements kategoriDao{
   private Connection connection;
   
   private final String insertKategori = "insert into kategori (Kategori) values (?)";
   
   private final String deleteKategori = "delete from kategori where Kategori=?";
   
   private final String selectAll = "select * from kategori";

    public KategoriDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertKategori(Kategori kategori) throws kategoriException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertKategori, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, kategori.getKategori());
            
            statement.executeUpdate();


            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new kategoriException(e.getMessage());
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
    public void deleteKategori(String kategori) throws kategoriException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(deleteKategori);
            statement.setString(1, kategori);
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new kategoriException(e.getMessage());
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
    public List<Kategori> selectAllKategori() throws kategoriException {
        Statement statement = null;
        List<Kategori> list = new ArrayList<Kategori>();
        try {
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            Kategori kategori = null;

            while (result.next()) {
                kategori = new Kategori();
                kategori.setKategori(result.getString("Kategori"));
                list.add(kategori);
            }

            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new kategoriException(e.getMessage());
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
