/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Tester {
    public static void main(String[] args) {
        int a[] = new int[]{2, 8, 6, 1, 10, 15, 3, 12, 11};
        Heap.buildMaxHeap(a,9);
        for (int value : a) {
            System.out.print(value+" ");
        }
        
        System.out.println("");
        Heap.heapToSortedArray(a, 9);
        for (int value : a) {
            System.out.print(value+" ");
        }
    }
            
}
