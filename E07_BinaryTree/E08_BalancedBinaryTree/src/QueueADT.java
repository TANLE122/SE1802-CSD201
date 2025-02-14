/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUPPER LOQ
 */
public interface QueueADT {

    public void clear();

    public boolean isEmpty();

    public void enqueue(Object obj);

    public Object dequeue() throws Exception;

    public Object front() throws Exception;

    public int size();
}
