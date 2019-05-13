/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Signatures;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author adfaj
 */
public class SigCalculatorShell {
    SimilarityCalculator simCalc;
    
    private final String searchDirectory = "Books";
    private final String writeDirectory = "Books";
    private final String signatureFile = "signatures.txt";

    public SigCalculatorShell() {
        simCalc = new SimilarityCalculator(populateAuthors());
    }
    
    public void use() {
        String answer = "";
        Scanner input = new Scanner(System.in);
        boolean analyzingBooks = false;
        
        //Master loop.
        do {
            System.out.printf("Analyze some books? Y/N?%n");
            do {
                answer = input.nextLine();
            } while(!"Y".equals(answer) && !"N".equals(answer));
            
            analyzingBooks = "Y".equals(answer);
            
            if(analyzingBooks == true){
                System.out.printf("Author name? %n");
                answer = input.nextLine();
                
                Author requestedAuthor = new Author();
                requestedAuthor.setName(answer);
                List<List<String>> newBooks = new ArrayList();
                boolean analyzed = false;
                
                for(Author writer : simCalc.getAuthors()){
                    if(writer.getName() == answer){
                        analyzed = true;
                        requestedAuthor = writer;
                    }
                }
                
                do {
                    System.out.printf("Text file? %n");
                    answer = input.nextLine();
                    if(!"STOP".equals(answer)) {
                        List<String> newBook = readFile(searchDirectory + "/" + answer);
                        newBooks.add(newBook);
                    }
                } while(!"STOP".equals(answer));
                
                System.out.printf("Calculating... %n");
                simCalc.analyzeAuthor(requestedAuthor, newBooks);
                
                if(!analyzed) {
                    simCalc.addAuthor(requestedAuthor);
                    updateSignatureFile(requestedAuthor);
                }
                else {
                    writeSignatureFile(simCalc.getAuthors());
                }
                
                System.out.printf("Done! %n");
            }
                
        } while(analyzingBooks);
        
        boolean identifyingAuthor = false;
        
        do {
            System.out.printf("Identify an author? Y/N?%n");
            do {
                answer = input.nextLine();
            } while(!"Y".equals(answer) && !"N".equals(answer));
            
            if("N".equals(answer))
                identifyingAuthor = false;
            else if ("Y".equals(answer)) {
                identifyingAuthor = true;
            }
            
            if(identifyingAuthor == true){
                System.out.printf("Text file? %n");
                answer = input.nextLine();
                
                List<String> unknownBook = readFile(searchDirectory + "/" + answer);
                
                Author trueAuthor = simCalc.identifyAuthor(unknownBook);
                
                System.out.printf("The author is %s. %n", trueAuthor.getName());
            }
                
        } while(identifyingAuthor);
        
        System.out.printf("Bye!%n");
    }
    
    public List<Author> populateAuthors() {
        List<Author> authors = new ArrayList();
        
        if(new File(searchDirectory, signatureFile).exists()) {
            List<String> rawAuthorText = readFile(searchDirectory + "/" + signatureFile);

            for (String authorText : rawAuthorText) {
                Author currentAuthor = new Author(authorText);
                authors.add(currentAuthor);
            }
        }
        
        return authors;
    }
    
    public List<String> readFile(String fileName) {
        List<String> readLines = new ArrayList();
        try (Stream<String> fileLines = Files.lines(Paths.get(fileName))) {
            readLines = fileLines.collect(Collectors.toList());
        }
        catch (IOException ex){
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return readLines;
    }
    
    public void writeFile(String fileName, List<String> writeLines) {
        Charset chars = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), chars)) {
            for (String line : writeLines) {
                writer.write(line);
            }
        } catch (IOException ex) {
            System.err.format("IOException: %s%n", ex);
        }
    }
    
    public void updateFile(String fileName, List<String> writeLines) {
        Charset chars = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), chars, StandardOpenOption.APPEND)) {
            for (String line : writeLines) {
                writer.append(line);
            }
        } catch (IOException ex) {
            System.err.format("IOException: %s%n", ex);
        }
    }
    
    public void writeSignatureFile(List<Author> authors) {
        List<String> rawAuthorText = new ArrayList();
        for (Author author : authors) {
            rawAuthorText.add(author.toString());
        }
        
        writeFile(searchDirectory + "/" + signatureFile, rawAuthorText);
    }
    
    public void updateSignatureFile(Author author) {
        List<String> rawAuthorText = new ArrayList();
        rawAuthorText.add(author.toString());
        
        updateFile(searchDirectory + "/" + signatureFile, rawAuthorText);
    }
}
