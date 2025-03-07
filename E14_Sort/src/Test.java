
import java.util.Random;

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
        int[] a = new int[100000];
        int[] b = new int[100000];

        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            a[i] = b[i] = r.nextInt(100000);
        }

        long start = System.currentTimeMillis();
        Sort.bubbleSort(a);
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort: " + (end - start));

        start = System.currentTimeMillis();
        Sort.quickSort(b, 0, 99999);
        end = System.currentTimeMillis();
        System.out.println("Quick Sort: " + (end - start));

        for (int i = 0; i < 10; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        
         for (int i = 0; i < 10; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println("");
    }
}
