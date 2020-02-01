/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.view;

import com.myshopdata.database.MSDdb;
import com.myshopdata.entity.Kategori;
import com.myshopdata.error.kategoriException;
import com.myshopdata.service.kategoriDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author ACER
 */
public class MyShopData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, kategoriException{
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                loginView view;
                try {
                    view = new loginView();
                    view.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MyShopData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });  
    }
    
}
