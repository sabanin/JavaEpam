/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.DataFormatException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Евгений
 */
public class BankHandler extends DefaultHandler{
    
    protected Bank bankDeposites;
    protected String currentTag;
    protected BankDeposite currentDeposite;
    protected boolean currentDataValidation;
    
    public BankHandler(){
        bankDeposites = new Bank();
        currentTag = new String();
    }
    
    public Bank getDeposites(){
        return bankDeposites; 
    }
    
    @Override
    public void startDocument(){
        System.out.println("SAX Parser START");
    }
    
    @Override
    public void endDocument(){
        System.out.println("SAX Parser FINISH");
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        currentTag = qName.toLowerCase();
        if (currentTag.equals("bankdeposit")){
            currentDeposite = new BankDeposite();
            currentDeposite.setDepositeId(new BigDecimal(attributes.getValue(0)));
            currentDataValidation = true;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName){
        currentTag = qName.toLowerCase();
        if (currentTag.equals("bankdeposit")&&currentDataValidation){
            bankDeposites.addBankDeposit(currentDeposite);
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length){
        String contant = new String(ch, start, length);
        try{
        if (!contant.trim().isEmpty()){
        switch(currentTag){
            case "name" : 
                currentDeposite.setName(contant); 
                break;
            case "country" :
                currentDeposite.setCountry(contant);
                break;
            case "type" :
                currentDeposite.setType(contant);
                break;
            case "depositor" :
                currentDeposite.setDepositor(contant);
                break;
            case "accountid" :
                currentDeposite.setAccountId(new BigDecimal(contant));
                break;
            case "amountondeposit" :
                currentDeposite.setAmountOnDeposit(new BigDecimal(contant));
                break;
            case "profitability" :
                currentDeposite.setProfitability(contant);
                break;
            case "date" :
                Calendar date = parseDate(contant);
                currentDeposite.setDate(date);
                break;
        }
        }
        } catch (NumberFormatException ex){
            currentDataValidation = false;
            System.out.println("Data in deposite №"+currentDeposite.getDepositeId()+" is invalid");
        }
    }

    private Calendar parseDate(String contant){
            String[] dateFields = contant.split("-");
            Integer year = new Integer(dateFields[2]);
            Integer month = new Integer(dateFields[1]);
            Integer day = new Integer(dateFields[0]);
            return new GregorianCalendar(year.intValue(), month.intValue(), day.intValue());
    }
    
    public Bank getBank(){
        return bankDeposites;
    }
}
