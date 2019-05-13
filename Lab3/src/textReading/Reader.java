/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textReading;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author adfaj
 */
public class Reader {
    String fileName;
    String outputFileName;
    String output;
    List<String> lines;

    public Reader() {
        fileName = "Books/Wood.txt";
        outputFileName = "Books/NewWood.txt";
        output = "";
        lines = new ArrayList<String>();
    }
    
    public void printFileAndCounts() {
        printFile();
        int vowels = vowelCount(lines);
        int capitals = capitalCount(lines);
        System.out.printf("%nNumber of Vowels: %d%nNumber of Capital Letters: %d", vowels, capitals);
    }
    
    public void printFile() {
        readFileUsingStreams();
        lines.forEach(System.out::println);
    }
    
    public void writeFile() {
        readFileUsingStreams();
        String lineSeparator = System.getProperty("line.separator");
        
        try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
            for(String line : lines) {
                fos.write(line.getBytes());
                fos.write(lineSeparator.getBytes());
            }
            
            int vowels = vowelCount(lines);
            int capitals = capitalCount(lines);
            
            fos.write(("Number of Vowels: " + vowels).getBytes());
            fos.write(lineSeparator.getBytes());
            fos.write(("Number of Capital Letters: " + capitals).getBytes());
            fos.write(lineSeparator.getBytes());
            
            fos.flush();
            System.out.printf("%nText has been written to "
            + (new File(outputFileName)).getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readFileUsingStreams() {
        try (Stream<String> fileLines = Files.lines(Paths.get(fileName))) {
            lines = fileLines.collect(Collectors.toList());
        }
        catch (IOException ex){
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeFileBuffered() {
        Charset chars = Charset.forName("US-ASCII");
        String file = "NewRaven.txt";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file), chars)) {
            for (String line : lines) {
                writer.write(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    
    public int vowelCount(List<String> text) {
        int count = 0;
        for (String line : text) {
            for (char letter : line.toCharArray())
            {
                letter = Character.toLowerCase(letter);
                if (letter == 'a' || letter == 'e'|| letter == 'i' || letter == 'o' || letter == 'u')
                    count++;
            }
        }
        
        return count;
    }
    
    public int capitalCount(List<String> text) {
        int count = 0;
        for (String line : text) {
            for (char letter : line.toCharArray())
            {
                if (Character.isUpperCase(letter))
                    count++;
            }
        }
        
        return count;
    }
}
