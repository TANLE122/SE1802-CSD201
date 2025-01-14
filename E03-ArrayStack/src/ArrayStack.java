
import java.util.EmptyStackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tungi
 */
public class ArrayStack implements StackADT {
    private Object[] array;
    private int top, max;

    public ArrayStack() {
        this(50);
    }

    public ArrayStack(int max) {
        this.max = max;
        array = new Object[max];
        top = -1;
    }

    private boolean grow() {
        this.max = this.max + this.max / 2;
        Object[] temp = new Object[this.max];
        for (int i = 0; i <= top; i++) {
            temp[i] = array[i];
        }
        this.array = temp;
        return true;
    }

    public boolean isFull() {
        return top == max - 1;
    }

    @Override
    public void clear() {
        this.array = new Object[max];
    }

    @Override
    public boolean isEmpty() {
//        if (top==-1)
//            return true;
//        else
//            return false;
        return top == -1;
    }

    @Override
    public void push(Object obj) {
        if (isFull()) {
            if (!grow()) {
                return;
            };
        }
        // increase top
        // top++;
        // this.array[top] = obj;
        this.array[++top] = obj;

    }

    @Override
    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object obj = this.array[top];
        top--;
        return obj;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.array[top];
    }

}
