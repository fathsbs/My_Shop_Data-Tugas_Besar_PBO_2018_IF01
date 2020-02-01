/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.database;

import com.myshopdata.impl.KategoriDaoImpl;
import com.myshopdata.impl.ProdukDaoImpl;
import com.myshopdata.service.kategoriDao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import com.myshopdata.service.produkDao;

/**
 *
 * @author ACER
 */
public class MSDdb {
    
    private static Connection connection;
    private static produkDao produkDao;
    private static kategoriDao kategoriDao;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null) {
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/myshopdatadb");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        
        
        return connection;
    }
    
    public static produkDao getProdukDao() throws SQLException{
        if (produkDao==null) {
            produkDao = new ProdukDaoImpl(getConnection());
        }       
        
        return produkDao;
    }
    
    public static kategoriDao getKategoriDao() throws SQLException{
        if (kategoriDao==null) {
            kategoriDao = new KategoriDaoImpl(getConnection());
        }
    
        return kategoriDao;
    }
}
