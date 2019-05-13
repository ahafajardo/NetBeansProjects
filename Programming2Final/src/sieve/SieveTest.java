/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sieve;

import java.util.ArrayList;

/**
 *
 * @author adfaj
 */
public class SieveTest {
    public static void main(String[] args) {
        boolean finished = false;
        int currentNumber = 2;
        ArrayList<Integer> primes = new ArrayList<Integer>();
        
        for(int i = 2; i < 201; i++) {
            primes.add(i);
        }
        
        int j = 0;
        
        while(!finished) {
            System.out.println(primes);
            
            if (currentNumber != primes.get(primes.size() - 1)) {
                for(int i = 0; i < primes.size(); i++) {
                    if(primes.get(i) % currentNumber == 0 && currentNumber != primes.get(i))
                        primes.remove(i);
                }
                j++;
                currentNumber = primes.get(j);
            }
            else
                finished = true;
        }
        
        System.out.println("Prime Numbers = " + primes);
    }
}
