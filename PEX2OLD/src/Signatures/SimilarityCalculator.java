/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Signatures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author adfaj
 */
public class SimilarityCalculator {
    private List<Author> authors;
    
    public SimilarityCalculator() {
        authors = new ArrayList();
    }
    
    public SimilarityCalculator(List<Author> authorList) {
        authors = authorList;
    }

    public List<Author> getAuthors() {
        return authors;
    }
    
    public void addAuthor(Author newAuthor) {
        authors.add(newAuthor);
    }
    
    public Author identifyAuthor(List<String> unknownBook) {
        double unknownBookScore = applyWeightsAndSum(calculateSignature(unknownBook));
        double authorScore = 0.0;
        double minDiff = 0.0;
        
        Author suspectedAuthor = authors.get(0);
        
        for(Author author : authors) {
            double[] authorSignature = {author.getAvgWordLength(), author.getTokenRatio(), author.getHapaxRatio(),
                                        author.getAvgWordsPerSentence(), author.getComplexity()};
            authorScore = applyWeightsAndSum(authorSignature);
            
            double difference = Math.abs(authorScore - unknownBookScore);
            
            if(difference < minDiff || authors.indexOf(author) == 0) {
                minDiff = difference;
                suspectedAuthor = author;
            }
        }
        
        return suspectedAuthor;
    }
    
    public void analyzeAuthor(Author author, List<List<String>> books) {
        double[] authorSignature = {author.getAvgWordLength(), author.getTokenRatio(), author.getHapaxRatio(),
                                        author.getAvgWordsPerSentence(), author.getComplexity()};
        
        author.setTotalBooks(books.size() + author.getTotalBooks());
        
        for (List<String> book : books){
            double[] bookSignature = calculateSignature(book);
            
            for(int i = 0; i < authorSignature.length; i++)
                authorSignature[i] = (author.getTotalBooks() * authorSignature[i]) + bookSignature[i];
        }
        
        for(int i = 0; i < authorSignature.length; i++)
            authorSignature[i] = authorSignature[i] / (author.getTotalBooks() + books.size());
        
        author.setAvgWordLength(authorSignature[0]);
        author.setTokenRatio(authorSignature[1]);
        author.setHapaxRatio(authorSignature[2]);
        author.setAvgWordsPerSentence(authorSignature[3]);
        author.setComplexity(authorSignature[4]);
    }
    
    /*
    Weights
    Avg word length : 5
    Type Token : 75
    Hapax : 100
    Words Per Sentence : 10
    Sentence Complexity : 75
    */
    
    public double applyWeightsAndSum(double[] scores) {
        double result = 0.0;
        
        if(scores.length != 5)
            return result;
        
        result += 5.0 * scores[0];
        result += 75.0 * scores[1];
        result += 100.0 * scores[2];
        result += 10.0 * scores[3];
        result += 75.0 * scores[4];
        
        return result;
    }
    
    public double[] calculateSignature(List<String> bookLines) {
        double[] criteria = new double[5];
        
        Tokenizer tokenizedBook = new Tokenizer(); 
        tokenizedBook.setUp(bookLines);
        
        criteria[0] = averageWordLength(tokenizedBook);
        criteria[1] = typeTokenRatio(tokenizedBook);
        criteria[2] = hapaxLegomanaRatio(tokenizedBook);
        criteria[3] = averageWordsPerSentence(tokenizedBook);
        criteria[4] = sentenceComplexity(tokenizedBook);
        
        return criteria;
    }
    
    public double averageWordLength(Tokenizer book) {
        List<String> words = book.getWords();
        double totalWordLength = 0.0;
        double totalWords = words.size();
        
        for(String word : words) {
            totalWordLength += word.length();
        }
        
        double average = totalWordLength / totalWords;
        
        return average;
    }
    
    public double typeTokenRatio(Tokenizer book) {
        List<String> words = book.getWords();
        double totalUniqueWords;
        double totalWords = words.size();
        
        Set<String> uniqueWords = new HashSet<>();
        
        uniqueWords.addAll(words);
        totalUniqueWords = uniqueWords.size();
        
        double ratio = totalUniqueWords / totalWords;
        
        return ratio;
    }
    
    public double hapaxLegomanaRatio(Tokenizer book) {
        List<String> words = book.getWords();
        double totalSingletonWords = 0.0;
        
        double totalWords = words.size();
        
        Set<String> duplicateWords = new HashSet<>();
        Set<String> uniqueWords = new HashSet<>();
        Set<String> singletonWords = new HashSet<>();
        
        for (String word : words) {
            if(!uniqueWords.add(word)){
                duplicateWords.add(word);
            }
        }
        
        singletonWords.addAll(uniqueWords);
        singletonWords.removeAll(duplicateWords);
        
        totalSingletonWords = singletonWords.size();
        
        double ratio = totalSingletonWords / totalWords;
        
        return ratio;
    }
    
    public double averageWordsPerSentence(Tokenizer book) {
        List<String> words = book.getWords();
        List<String> sentences = book.getSentences();
        double totalWords = words.size();
        double totalSentences = sentences.size();
        
        double average = totalWords / totalSentences;
        
        return average;
    }
    
    public double sentenceComplexity(Tokenizer book) {
        List<String> phrases = book.getPhrases();
        List<String> sentences = book.getSentences();
        double totalPhrases = phrases.size();
        double totalSentences = sentences.size();
        
        double average = totalPhrases / totalSentences;
        
        return average;
    }
}
