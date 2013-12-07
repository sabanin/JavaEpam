/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.text;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Евгений
 */
public class Word implements PartOfSentence{
    protected List<Symbol> symbols; 
    public Word(String word){
        symbols = new ArrayList<Symbol>();
        parceWord(word);
    }
    public void parceWord(String word){
        int pointer = 0;
        while(pointer < word.length()){
           symbols.add(new Symbol(word.charAt(pointer)));
           pointer++;
        }
    }

    @Override
    public boolean isWord() {
        return true;
    }
    
    @Override
    public String toString(){
        StringBuffer result = new StringBuffer();
        for (Symbol symb : symbols){
            result.append(symb.toString());
        }
        return result.toString();
    }
}
