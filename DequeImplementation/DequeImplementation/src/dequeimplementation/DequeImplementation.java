/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dequeimplementation;

/**
 *
 * @author sturner
 */
public class DequeImplementation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        
        ad.enqueueFront(3);
        ad.enqueueFront(3);
        ad.dequeueRear();
        ad.dequeueRear();
        
        int i = 0;
        while(!ad.isFull()){
            ad.enqueueRear(i);
            i++;
        }
        while(!ad.isEmpty()){
            System.out.println(ad.dequeueRear());
        }
    }
    
}
