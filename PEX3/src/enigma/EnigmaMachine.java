/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adfaj
 */
public class EnigmaMachine {
    CipherWheel cipher;
    SubstitutionCipher plugBoard;
    SubstitutionCipher reflector;
    List<String> file;

    public EnigmaMachine() {
    }

    public EnigmaMachine(CipherWheel cipher, SubstitutionCipher plugBoard, SubstitutionCipher reflector, List<String> file) {
        this.cipher = cipher;
        this.plugBoard = plugBoard;
        this.reflector = reflector;
        this.file = file;
    }
    
    public List<String> code() {
        List<String> output = new ArrayList<>();
        for(String line : file) {
            String currentLine = "";
            line = convertNumbers(line);
            
            for(char letter : line.toCharArray()) {
                boolean isUppercase = Character.isUpperCase(letter);
                System.out.println("Encrypt: " + letter);
                char codedChar = plugBoard.substitute(Character.toUpperCase(letter));
                System.out.println("After first plug: " + codedChar);
                codedChar = cipher.code(codedChar);
                System.out.println("Reflect: " + codedChar);
                codedChar = reflector.substitute(codedChar);
                System.out.println("Reflected Char: " + codedChar);
                codedChar = cipher.decode(codedChar);
                System.out.println("Char to plug: " + codedChar);
                codedChar = plugBoard.substitute(codedChar);
                System.out.println("After last plug: " + codedChar);
                
                if(Character.isLetter(letter) || letter == ' ' || letter == '.')
                    cipher.turnRotorForward();
                
                if(!isUppercase)
                    codedChar = Character.toLowerCase(codedChar);
                
                currentLine += String.valueOf(codedChar);
            }
            
            output.add(currentLine);
        }
        
        return output;
    }
    
    public String convertNumbers (String originalText) {
        String result;
        result = originalText.replace("0", "Zero");
        result = result.replace("1", "One");
        result = result.replace("2", "Two");
        result = result.replace("3", "Three");
        result = result.replace("4", "Four");
        result = result.replace("5", "Five");
        result = result.replace("6", "Six");
        result = result.replace("7", "Seven");
        result = result.replace("8", "Eight");
        result = result.replace("9", "Nine");
        return result;
    }
}
