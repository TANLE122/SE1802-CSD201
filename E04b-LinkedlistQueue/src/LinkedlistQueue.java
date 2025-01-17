/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class LinkedlistQueue implements QueueADT{
    private Node head, tail;

    public LinkedlistQueue() {
        head = tail= null;
    }
    
    @Override
    public void clear() {
        head = tail= null;
    }

    @Override
    public boolean isEmpty() {
        return head ==null;                
    }

    @Override
    public void enqueue(Object obj) {
        if(isEmpty()){
            head = tail = new Node(obj);
        }else{
            tail.next = new Node(obj);
            tail = tail.next;
        }
    }

    @Override
    public Object dequeue() throws Exception {
        if (isEmpty()) throw new Exception();
        
        Object obj = head.info;
        head = head.next;
        if(head==null) tail=null;
        
        return obj;
    }

    @Override
    public Object front() throws Exception {
        if (isEmpty()) throw new Exception();
        
        Object obj = head.info;
        return obj;
    }

    @Override
    public int size() {
        // to do
        return;
    }
    
}
