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
public class Text {
    protected List<Sentence> sentences; 
    
    public Text(String allText){
        sentences = new ArrayList<Sentence>();
        parceText(allText);
    }
    
    protected void parceText(String text){
        int pointer = 0;
        while(pointer < text.length()){
            String sentence = new String();
            while (pointer < text.length() && !(text.charAt(pointer) == '.' ||text.charAt(pointer) == '!' ||text.charAt(pointer) == '?')){
                sentence += text.charAt(pointer);
                pointer++;
            }
            if (pointer < text.length()){
                sentence += text.charAt(pointer);
            }
            if (!sentence.isEmpty()){
                sentences.add(new Sentence(sentence));
            }
            pointer++;
        }
    }
    
    public void reverseWordsInText(){
        for (Sentence sent : sentences){
           sent.reverseFirstAndLast();
        }
    }
    
    @Override
    public String toString(){
        StringBuffer result = new StringBuffer();
        for (Sentence sent : sentences){
            result.append(sent.toString());
        }
        return result.toString();
    }
}
