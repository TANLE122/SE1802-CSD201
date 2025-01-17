/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class ArrayQueue implements QueueADT {

    private Object[] a;
    private int max;
    private int first, last;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int max) {
        this.max = max;
        a = new Object[max];
        first = last = -1;
    }

    @Override
    public void clear() {
        a = new Object[max];
        first = last = -1;
    }

    @Override
    public boolean isEmpty() {
        return (first == -1 && last == -1);
    }

    public boolean isFull() {
        return ((first == 0 && last == max - 1) || (first == last + 1));
    }

    private boolean grow() {
        int new_max = max * 2;
        Object[] temp = new Object[new_max];
        if (temp == null) {
            return false;
        }

        int k = -1;
        if (last >= first) {
            for (int i = first; i <= last; i++) {
                temp[++k] = a[i];
            }
        } else {
            // first -> max-1
            for (int i = first; i <= max - 1; i++) {
                temp[++k] = a[i];
            }
            // 0 -> last
            for (int i = 0; i <= last; i++) {
                temp[++k] = a[i];
            }
        }

        a = temp;
        first = 0;
        last = k;
        max = new_max;
        return true;
    }

    @Override
    public void enqueue(Object obj) {
        if (isFull()) {
            if (!grow()) {
                return;
            }
        }
        if (last == -1 || last == max - 1) {
            a[0] = obj;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            a[++last] = obj;
        }
    }

    @Override
    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object obj = a[first];
        if(first==last){
            first=last=-1;
        }else if(first==max-1){
            first=0;
        }else{
            first++;
        }        
        return obj;
    }

    @Override
    public Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return a[first];
    }

    @Override
    public int size() {
       // to do
       return 0;
    }

}
