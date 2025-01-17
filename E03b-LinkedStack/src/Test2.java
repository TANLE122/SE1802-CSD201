/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Test2 {

    public static void decToBin(int k) {
        LinkedStack s = new LinkedStack();
        System.out.print(k + " in binary system is: ");
        while (k > 0) {
            s.push(new Integer(k % 2));
            k = k / 2;
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        decToBin(11);
        System.out.println();
    }
}
