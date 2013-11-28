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
public class Text {
    protected ArrayList<Sentence> sentences; 
    
    public Text(String allText){
        makeSentencesFromText(allText);
    }
    
    protected void makeSentencesFromText(String text){
        int pointer = 0;
        while(pointer < text.length()){
            String sentence = new String();
            while (text.charAt(pointer) != '.' || text.charAt(pointer) != '!' || text.charAt(pointer) != '?'){
                sentence += text.charAt(pointer);
                pointer++;
            }
            sentence += text.charAt(pointer);
            sentences.add(new Sentence(sentence));
        }
    }
}
