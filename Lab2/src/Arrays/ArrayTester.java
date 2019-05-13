/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author adfaj
 */
public class ArrayTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        
        numbers.addAll(Arrays.asList(68, 56, 22, 2, 34, 44));
        
        System.out.printf("%s%n", numbers.toString());
        
        numbers = minToFront(numbers);
        
        System.out.printf("%s%n", numbers.toString());
        
        List<String> lyrics = new ArrayList<String>();
        lyrics.add("You\'re");
        lyrics.add("a");
        lyrics.add("kid");
        lyrics.add("You\'re");
        lyrics.add("a");
        lyrics.add("squid!");
        
        System.out.printf("%s%n", lyrics.toString());
        
        lyrics = switchPairs(lyrics);
        
        System.out.printf("%s%n", lyrics.toString());
        
        List<String> rickRoll = new ArrayList<String>();
        rickRoll.add("We\'re");
        rickRoll.add("no");
        rickRoll.add("strangers");
        rickRoll.add("to");
        rickRoll.add("love...");
        
        System.out.printf("%s%n", rickRoll.toString());
        
        rickRoll = switchPairs(rickRoll);
        
        System.out.printf("%s%n", rickRoll.toString());
    }
    
    public static List<Integer> minToFront(List<Integer> originalList){
        int minimumValue = originalList.get(0);
        int minIndex = 0;
        
        for(int item : originalList) {
            if(item < minimumValue) {
                minimumValue = item;
                minIndex = originalList.indexOf(item);
            }
        }
        
        List<Integer> resultList = new ArrayList<Integer>();
        
        resultList.add(minimumValue);
        originalList.remove(minIndex);
        resultList.addAll(originalList);
        
        return resultList;
    }
    
    public static List<String> switchPairs(List<String> originalList) {
        String previous = "";
        
        for(int i = 0; i < originalList.size(); i++){
            if((i + 1) % 2 == 0){
                originalList.set(i - 1, originalList.get(i));
                originalList.set(i, previous);
            }
            
            previous = originalList.get(i);
        }
        
        return originalList;
    }
}
