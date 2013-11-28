/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.text;

/**
 *
 * @author Евгений
 */
public class Project2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reader reader= new Reader();
        Text text = new Text(reader.read("text.txt"));
        // TODO code application logic here
    }
}
