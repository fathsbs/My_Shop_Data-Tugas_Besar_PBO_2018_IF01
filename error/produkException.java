/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myshopdata.error;

/**
 *
 * @author ACER
 */
public class produkException extends Exception {

    /**
     * Creates a new instance of <code>produkException</code> without detail
     * message.
     */
    public produkException() {
    }

    /**
     * Constructs an instance of <code>produkException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public produkException(String msg) {
        super(msg);
    }
}
