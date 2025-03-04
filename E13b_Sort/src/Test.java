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
        int[] a = {1, 6, 1, 2, 7, 9 };
        a = Sort.bubbleSort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}
