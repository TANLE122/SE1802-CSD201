/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Test {

    public static void main(String[] args) {
        try {
            ArrayQueue queue = new ArrayQueue();
            queue.enqueue(5);
            queue.enqueue(3);
            queue.enqueue(4);

            System.out.println(queue.dequeue());
            System.out.println(queue.front());
        } catch (Exception e) {
        }

    }
}
