/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author adfaj
 */
public class SubstitutionCipher {
    private char[] inputChars;
    private char[] outputChars;

    public SubstitutionCipher(String settings) {
        char[] iChars = new char[settings.length() / 2];
        char[] oChars = new char[settings.length() / 2];
        int i = 0;
        int j = 0;
        int k = 0;
        for(char letter : settings.toCharArray()) {
            if(i % 2 == 0 || i == 0){
                iChars[j] = letter;
                j++;
            }
            else {
                oChars[k] = letter;
                k++;
            }
            i++;
        }
        this.inputChars = iChars;
        this.outputChars = oChars;
        
        System.out.println(iChars);
        System.out.println(oChars);
    }
    
    public SubstitutionCipher(char[] inputChars, char[] outputChars) {
        this.inputChars = inputChars;
        this.outputChars = outputChars;
    }

    public char[] getInputChars() {
        return inputChars;
    }

    public char[] getOutputChars() {
        return outputChars;
    }

    public void setInputChars(char[] inputChars) {
        this.inputChars = inputChars;
    }

    public void setOutputChars(char[] outputChars) {
        this.outputChars = outputChars;
    }
    
    public char substitute(char message) {
        int index = 0;
        char result = Character.MIN_VALUE;
        
        if(Character.isLetter(message) || message == ' ' || message == '.') {
            for(char letter : inputChars) {

                    if(letter == message) {
                        result = outputChars[index];
                        return result;
                    }

                index++;
            }
        }
        
        if(Character.isLetter(message) || message == ' ' || message == '.') {
            index = 0;
            for(char letter : outputChars) {

                    if(letter == message) {
                        result = inputChars[index];
                        return result;
                    }

                index++;
            }
        }
        
        return message;
    }
    
    public char restore(char message) {
        int index = 0;
        char result;
        
        if(Character.isLetter(message) || message == ' ' || message == '.') {
            for(char letter : outputChars) {

                    if(letter == message) {
                        result = inputChars[index];
                        return result;
                    }

                index++;
            }
        }
        
        return message;
    }
}
