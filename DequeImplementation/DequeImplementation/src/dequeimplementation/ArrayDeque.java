/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dequeimplementation;

import ch04.queues.DequeInterface;
import ch04.queues.QueueOverflowException;
import ch04.queues.QueueUnderflowException;

/**
 *
 * @author sturner
 */
public class ArrayDeque<T> implements DequeInterface<T>{
    //Fields
    private T[] innerArray;
    private int front;
    private int back;
    private int numElements;
    //Constructor
    public ArrayDeque(){
        innerArray = (T[]) new Object[100];
        front = 0;  //represents the index of the first element of the array
        back = innerArray.length - 1;  //represents the index of the last element in the array
        numElements = 0;
    }
    //Methods

    @Override
    //pushes an element to the front of the structure
    public void enqueueFront(T element) throws QueueOverflowException {
        if(isFull()) throw new QueueOverflowException();
        else {
            if(front == 0) front = innerArray.length - 1;  //wrap front around array if necessary
            else front--;  //when adding to the front, move it to the "left" of the innerArray
            innerArray[front] = element;
            numElements++;
        }
    }

    @Override
    //pushes an element to the rear of the structure
    public void enqueueRear(T element) throws QueueOverflowException {
        if(isFull()) throw new QueueOverflowException();
        else {
            back = (back + 1) % innerArray.length;  //wrap back around array if necessary, when adding to th eback move it to the "right" of the innerArray
            innerArray[back] = element;
            numElements++;
        }
    }

    @Override
    //removes and returns an element from the front of the structure
    public T dequeueFront() throws QueueUnderflowException {
        if(isEmpty()) throw new QueueUnderflowException();
        else {
            T temp = innerArray[front];  //get the element from the current front
            innerArray[front] = null;  //nullify the front element
            front = (front + 1) % innerArray.length;  //move the front to the next taken spot, i.e. move it to the "right" of the innerArray
            numElements--;
            return temp;
        }
    }

    @Override
    //removes and returns an alement from the rear of the structure
    public T dequeueRear() throws QueueUnderflowException {
        if(isEmpty()) throw new QueueUnderflowException();
        else {
            T temp = innerArray[back];  //get the element from the current back
            innerArray[back] = null;  //nullify the back element
            if(back == 0) back = innerArray.length - 1;  //wrap if necessary
            else back--;  //move the back to the next taken spot, i.e. move it to the "left" of the innerArray
            numElements--;
            return temp;
        }
    }

    @Override
    public boolean isFull() {
        return numElements == innerArray.length;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public int size() {
        return numElements;
    }
}
