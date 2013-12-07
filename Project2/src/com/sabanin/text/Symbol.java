/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.text;

/**
 *
 * @author Евгений
 */
public class Symbol {
    protected Character symbol;
    
    Symbol (char symbol){
        this.symbol = symbol;
    }
    
    @Override
    public String toString(){
        return symbol.toString();
    }
}
