/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class PriorityQueue implements QueueADT{
    private Object[] a;
    private int top, max;
    
    public PriorityQueue(){
        this(50);
    }
    public PriorityQueue(int max){
        this.max = max;
        a = new Object[max];
        top=-1;
    }
    private boolean grow(){
        int max1 = max +max/2;
        Object[] a1 = new Object[max1];
        if (a1==null) return false;
        for (int i = 0; i <=top; i++) {
            a1[i] = a[i];
        }
        a = a1;
        max = max1;
        return true;
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }
    
    public boolean isFull(){
        return (top==max-1);
    }

    @Override
    public void enqueue(Object obj) {
        if(isFull() && !grow())
            return;
        
        if(!(obj instanceof Comparable)){
            throw new IllegalArgumentException("Object must implement Comparable");
        }
        
        if(top == -1){
            a[0] = obj;
            top = 0;
            return;
        }
        
        int i = top;
        while(i>=0 && ((Comparable)obj).compareTo(a[i])>0){
            a[i+1] = a[i];
            i--;
        }
        a[i+1]=obj;
        top++;
    }
    
    @Override
    public Object dequeue() throws Exception {
        if(isEmpty()) throw new Exception("Empty Queue!");
        Object obj = a[top];
        top--;
        return obj;
    }

    @Override
    public Object front() throws Exception {
        if(isEmpty()) throw new Exception("Empty Queue!");
        return a[top];        
    }

    @Override
    public int size() {
        return top+1;
    }
}
