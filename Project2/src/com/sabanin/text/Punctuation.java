/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.text;

/**
 *
 * @author Евгений
 */
public class Punctuation implements PartOfSentence{
    protected Character stop;
    
    public Punctuation(char stop){
        this.stop = stop;
    }
    
    @Override
    public boolean isWord(){
        return false;
    }
    
    @Override
    public String toString(){
        return stop.toString();
    }
}
