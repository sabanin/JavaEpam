/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabanin.text;

import java.util.ArrayList;
import java.util.List;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author Евгений
 */
public class Sentence {
    protected List<PartOfSentence> partsOfSentence;
    
    public Sentence(String text){
        partsOfSentence = new ArrayList<PartOfSentence>();
        parceSentence(text);
    }
    
    protected void parceSentence(String text){
        int pointer = 0;
        while (pointer < text.length()){
            String word = new String();
            while (pointer < text.length() && !(text.charAt(pointer) == ' ' || text.charAt(pointer) == ',' 
                    || text.charAt(pointer) == ':' || text.charAt(pointer) == ';'
                    || text.charAt(pointer) == '-' || text.charAt(pointer) == '.'
                    ||text.charAt(pointer) == '!' ||text.charAt(pointer) == '?')){
                word += text.charAt(pointer);
                pointer++;
            }
            if (!word.isEmpty()){
                partsOfSentence.add(new Word(word));
            }
            if (pointer < text.length()) {
                 partsOfSentence.add(new Punctuation(text.charAt(pointer)));
            }
            pointer++;
        }
    }
    public void reverseFirstAndLast(){
        try{
            PartOfSentence buffer;
            int pFirst = 0;
            int pLast = partsOfSentence.size()-1;
            PartOfSentence first = partsOfSentence.get(pFirst);
            PartOfSentence last = partsOfSentence.get(pLast);
            while (!first.isWord()){
                pFirst++;
                first = partsOfSentence.get(pFirst);
            }
            while (!last.isWord()){
                pLast--;
                last = partsOfSentence.get(pLast);
            }
            partsOfSentence.set(pFirst, last);
            partsOfSentence.set(pLast, first);
        } catch (IndexOutOfBoundsException ex){
            System.out.println("Sentence has no words");
        }
    }
    
    @Override
    public String toString(){
        StringBuffer result = new StringBuffer();
        for (PartOfSentence part : partsOfSentence){
            result.append(part.toString());
        }
        return result.toString();
    }
}
