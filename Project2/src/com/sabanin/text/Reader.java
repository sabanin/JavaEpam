/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Евгений
 */
public class Reader {
    public String read(String filePath){
        String text = new String();
        try 
        {
            FileInputStream inFile = new FileInputStream(filePath);
            byte[] str = new byte[inFile.available()];            
            inFile.read(str);
            text = new String(str);
        } 
        catch (FileNotFoundException e1) {
            System.out.println("Файл не найден");
        }
        catch (IOException ex){
            System.out.println("IO Exception");
        }
        return text;
    }
    
}
