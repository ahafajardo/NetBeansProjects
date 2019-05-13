/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericPairs;

/**
 *
 * @author adfaj
 */
public class GenericPair <T> {
    private T first;
    private T second;
    
    GenericPair(T f, T s) {
        this.first = f;
        this.second = s;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
    
    public void swap() {
        T temp = first;
        first = second;
        second = temp;
    }

    @Override
    public String toString() {
        return "("+first+", "+second+")";
    }
    
    
}
