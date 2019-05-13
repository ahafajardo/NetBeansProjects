/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Signatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author adfaj
 */
public class Tokenizer {

    private final String WORDDELIMITER = "(\\s+|\\s*,\\t+|\\n)";
    private final String SENTENCEDELIMITER = "[!?.]";
    private final String PHRASEDELIMITER = "\\p{Punct}+";
    
    private String collapsedString;
    
    private List<String> original;
    private List<String> sentences;
    private List<String> phrases;
    private List<String> words;
    
    public Tokenizer() {
        collapsedString = "";
    }
    
    public void setUp(List<String> input) {
        original = input;
        collapseToString(input);
        tokenize();
    }

    public String getCollapsedString() {
        return collapsedString;
    }

    public List<String> getOriginal() {
        return original;
    }

    public List<String> getPhrases() {
        return phrases;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public List<String> getWords() {
        return words;
    }
    
    
    
    public void collapseToString(List<String> input) {
        String output = "";
        for(String line : input){
            output += line;
        }
        
        collapsedString = output.toLowerCase();
    }
    
    public void tokenize() {
        String input = collapsedString;
        
        sentences = Arrays.asList(input.split(SENTENCEDELIMITER));
        
        for(String sentence : sentences) {
            words = Arrays.asList(sentence.split(WORDDELIMITER));
        }
        
        for(String sentence : sentences) {
            phrases = Arrays.asList(sentence.split(PHRASEDELIMITER));
        }
        
        
    }

}
