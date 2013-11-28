/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.text;

import java.util.ArrayList;

/**
 *
 * @author Евгений
 */
public class Sentence {
    protected ArrayList<Word> words;
    protected ArrayList<Punctuation> stops;
    
    public Sentence(String text){
        parceSentence(text);
    }
    
    protected void parceSentence(String text){
        int pointer = 0;
        while (pointer < text.length()){
            String word = new String();
            while (text.charAt(pointer) != ' ' || text.charAt(pointer) != ',' 
                    || text.charAt(pointer) != ':' || text.charAt(pointer) != ';'
                    || text.charAt(pointer) != '-'){
                word += text.charAt(pointer);
                pointer++;
            }
            stops.add(new Punctuation(text.charAt(pointer)));
            words.add(new Word(word));
        }
    }
}
