/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class MyQueue {

    private java.util.LinkedList<Object> items;

    public MyQueue() {
        items = new java.util.LinkedList<>();
    }

    public void enqueue(Object item) {
        items.addLast(item);
    }

    public Object dequeue() {
        return items.removeFirst();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
