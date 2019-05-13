/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Signatures;

/**
 *
 * @author adfaj
 */
public class Author {
    private String name;
    private int totalBooks;
    private double avgWordLength;
    private double tokenRatio;
    private double hapaxRatio;
    private double avgWordsPerSentence;
    private double complexity;
    
    public Author() {
        this.name = "";
        this.totalBooks = 0;
        this.avgWordLength = 0.0;
        this.tokenRatio = 0.0;
        this.hapaxRatio = 0.0;
        this.avgWordsPerSentence = 0.0;
        this.complexity = 0.0;
    }

    public Author(String name, int totalBooks, double avgWordLength, double tokenRatio, double hapaxRatio, double avgWordsPerSentence, double complexity) {
        this.name = name;
        this.totalBooks = totalBooks;
        this.avgWordLength = avgWordLength;
        this.tokenRatio = tokenRatio;
        this.hapaxRatio = hapaxRatio;
        this.avgWordsPerSentence = avgWordsPerSentence;
        this.complexity = complexity;
    }
    
    public Author(String authorText) {
        String[] authorProperties = authorText.split("\t");
        name = authorProperties[0];
        totalBooks = Integer.parseInt(authorProperties[1]);
        avgWordLength = Double.parseDouble(authorProperties[2]);
        tokenRatio = Double.parseDouble(authorProperties[3]);
        hapaxRatio = Double.parseDouble(authorProperties[4]);
        avgWordsPerSentence = Double.parseDouble(authorProperties[5]);
        complexity = Double.parseDouble(authorProperties[6]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public double getAvgWordLength() {
        return avgWordLength;
    }

    public void setAvgWordLength(double avgWordLength) {
        this.avgWordLength = avgWordLength;
    }

    public double getTokenRatio() {
        return tokenRatio;
    }

    public void setTokenRatio(double tokenRatio) {
        this.tokenRatio = tokenRatio;
    }

    public double getHapaxRatio() {
        return hapaxRatio;
    }

    public void setHapaxRatio(double hapaxRatio) {
        this.hapaxRatio = hapaxRatio;
    }

    public double getAvgWordsPerSentence() {
        return avgWordsPerSentence;
    }

    public void setAvgWordsPerSentence(double avgWordsPerSentence) {
        this.avgWordsPerSentence = avgWordsPerSentence;
    }

    public double getComplexity() {
        return complexity;
    }

    public void setComplexity(double complexity) {
        this.complexity = complexity;
    }

    @Override
    public String toString() {
        String output = name + "\t" + totalBooks + "\t" + avgWordLength + "\t" + tokenRatio + "\t" + hapaxRatio + "\t" + avgWordsPerSentence + "\t"
                + complexity + "\n";
        return output; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
