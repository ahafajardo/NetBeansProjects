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
public class CipherWheel {
    private String innerRotor;
    private String midRotor;
    private String outerRotor;
    private int currentInner;
    private int currentMid;
    private int currentOuter;
    private int countInner;
    private int countMid;
    private int countOuter;
    
    private final String ROTOR1 = "AUNGHOVBIPWCJQXDKRY ELSZFMT.";
    private final String ROTOR2 = "O J.ETYCHMRWAFKPUZDINSXBGLQV";
    private final String ROTOR3 = "FBDHJLNPRTVXZ.ACEGI KMOQSUWY";
    private final String ROTOR4 = ".HKPDEAC WTVQMYNLXSURZOJFBGI";
    private final String ROTOR5 = "YDNGLCIQVEZRPTAOXWBMJSUH.K F";

    public CipherWheel() {
        this.innerRotor = ROTOR1;
        this.midRotor = ROTOR2;
        this.outerRotor = ROTOR3;
        this.currentInner = 0;
        this.currentMid = 0;
        this.currentOuter = 0;
        this.countInner = 0;
        this.countMid = 0;
        this.countOuter = 0;
    } 

    public CipherWheel(int inner, int mid, int outer, int currentInner, int currentMid, int currentOuter) {
        char firstChar;
        String inRotor;
        String middleRotor;
        String outRotor;
        
        switch(inner) {
            case 1:
                inRotor = ROTOR1;
                break;
            case 2:
                inRotor = ROTOR2;
                break;
            case 3:
                inRotor = ROTOR3;
                break;
            case 4:
                inRotor = ROTOR4;
                break;
            case 5:
                inRotor = ROTOR5;
                break;
            default:
                inRotor = ROTOR1;
        }
        
        switch(mid) {
            case 1:
                middleRotor = ROTOR1;
                break;
            case 2:
                middleRotor = ROTOR2;
                break;
            case 3:
                middleRotor = ROTOR3;
                break;
            case 4:
                middleRotor = ROTOR4;
                break;
            case 5:
                middleRotor = ROTOR5;
                break;
            default:
                middleRotor = ROTOR1;
        }
        
        switch(outer) {
            case 1:
                outRotor = ROTOR1;
                break;
            case 2:
                outRotor = ROTOR2;
                break;
            case 3:
                outRotor = ROTOR3;
                break;
            case 4:
                outRotor = ROTOR4;
                break;
            case 5:
                outRotor = ROTOR5;
                break;
            default:
                outRotor = ROTOR1;
        }
        
        System.out.println(inRotor);
        System.out.println(middleRotor);
        System.out.println(outRotor);
        
        if(currentInner > 0) {
            for(int i = 0; i < currentInner; i++){
                firstChar = inRotor.toCharArray()[0];
                inRotor = inRotor.substring(1, inRotor.length());
                inRotor = inRotor + String.valueOf(firstChar);
            }
        }
        if(currentMid > 0) {
            for(int i = 0; i < currentMid; i++){
                firstChar = middleRotor.toCharArray()[0];
                middleRotor = middleRotor.substring(1, middleRotor.length());
                middleRotor = middleRotor + String.valueOf(firstChar);
            }
        }
        
        if(currentOuter > 0) {
            for(int i = 0; i < currentOuter; i++){
                firstChar = outRotor.toCharArray()[0];
                outRotor = outRotor.substring(1, outRotor.length());
                outRotor = outRotor + String.valueOf(firstChar);
            }
        }
        
        this.innerRotor = inRotor;
        this.midRotor = middleRotor;
        this.outerRotor = outRotor;
        this.currentInner = currentInner;
        this.currentMid = currentMid;
        this.currentOuter = currentOuter;
        this.countInner = 0;
        this.countMid = 0;
        this.countOuter = 0;
        
        System.out.println("New Inner Setting: " + inRotor);
        System.out.println("New Middl Setting: " + middleRotor);
        System.out.println("New Outer Setting: " + outRotor);
        System.out.println(currentInner);
        System.out.println(currentMid);
        System.out.println(currentOuter);
    }

    public String getInnerRotor() {
        return innerRotor;
    }

    public String getMidRotor() {
        return midRotor;
    }

    public String getOuterRotor() {
        return outerRotor;
    }

    public void setInnerRotor(String innerRotor) {
        this.innerRotor = innerRotor;
    }

    public void setMidRotor(String midRotor) {
        this.midRotor = midRotor;
    }

    public void setOuterRotor(String outerRotor) {
        this.outerRotor = outerRotor;
    }

    public int getCurrentInner() {
        return currentInner;
    }

    public int getCurrentMid() {
        return currentMid;
    }

    public int getCurrentOuter() {
        return currentOuter;
    }

    public void setCurrentInner(int currentInner) {
        this.currentInner = currentInner;
    }

    public void setCurrentMid(int currentMid) {
        this.currentMid = currentMid;
    }

    public void setCurrentOuter(int currentOuter) {
        this.currentOuter = currentOuter;
    }
    
    public void turnRotorForward() {
        char lastChar;
        
        lastChar = innerRotor.toCharArray()[innerRotor.length() - 1];
        innerRotor = innerRotor.substring(0, innerRotor.length() - 1);
        innerRotor = String.valueOf(lastChar) + innerRotor;
        setCurrentInner(currentInner + 1);
        countInner = countInner + 1;
        
        if(countInner == innerRotor.length()) {
            lastChar = midRotor.toCharArray()[midRotor.length() - 1];
            midRotor = midRotor.substring(0, midRotor.length() - 1);
            midRotor = String.valueOf(lastChar) + midRotor;
            setCurrentMid(currentMid + 1);
            countInner = 0;
            countMid = countMid + 1;
        }
        if(getCurrentInner() == innerRotor.length())
            setCurrentInner(0);
        
        if(countMid == midRotor.length()) {
            lastChar = outerRotor.toCharArray()[outerRotor.length() - 1];
            outerRotor = outerRotor.substring(0, outerRotor.length() - 1);
            outerRotor = String.valueOf(lastChar) + outerRotor;
            setCurrentOuter(currentOuter + 1);
            countMid = 0;
            countOuter = countOuter + 1;
        }
        if(countOuter == outerRotor.length())
            countOuter = 0;
        
        if(getCurrentMid() == midRotor.length())
            setCurrentMid(0);
        
        if(getCurrentOuter() == outerRotor.length()) {
            setCurrentOuter(0);
        }
        
        System.out.println("Rotated Inner Setting: " + innerRotor);
        System.out.println("Rotated Middl Setting: " + midRotor);
        System.out.println("Rotated Outer Setting: " + outerRotor);
    }
    
    public char code(char message) {
        char result = message;
        System.out.println("Cipher char: " + message);
        
        if(Character.isLetter(message) || message == ' ' || message == '.'){
            int innerIndex = innerRotor.indexOf(message);
            char outerLetter = outerRotor.charAt(innerIndex);
            System.out.println("Outer Wheel char: " + outerLetter);
            int midIndex = midRotor.indexOf(outerLetter);
            char encodedLetter = outerRotor.charAt(midIndex);
            result = encodedLetter;
        }
        
        System.out.println("End Cipher: " + result);
        return result;
    }
    
    public char decode(char message) {
        char result = message;
        System.out.println("Reverse Cipher char: " + message);
        
        if(Character.isLetter(message) || message == ' ' || message == '.'){
            int outerIndex1 = outerRotor.indexOf(message);
            char midLetter = midRotor.charAt(outerIndex1);
            System.out.println("Middl Wheel char: " + midLetter);
            int outerIndex2 = outerRotor.indexOf(midLetter);
            char encodedLetter = innerRotor.charAt(outerIndex2);
            result = encodedLetter;
        }
        
        System.out.println("End Reverse Cipher: " + result);
        return result;
    }
}
