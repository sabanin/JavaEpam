/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Евгений
 */
public class SAXParserRunner {
    public static void main(String[] args) {
        try{
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            BankHandler handler = new BankHandler(); 
            parser.parse("bank.xml", handler);
            System.out.println(handler.getBank().toString());
        } 
        catch (IOException ex){
            System.out.println("Cannot read file");
        }
        catch (ParserConfigurationException ex){
            System.out.println("Error in Parser Configuration");
        } 
        catch (SAXException ex){
            System.out.println("Error in SAX");
        }
    }
}
