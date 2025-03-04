/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Sort {

    static int[] selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int k = i;
            int min = a[k];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > min) {
                    k = j;
                    min = a[j];
                }
            }
            if (k != i) {
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
        return a;
    }

    static int[] insertSort(int[] a) {
        int i, j, x;
        for (i = 1; i < a.length; i++) {
            x = a[i];
            j = i;
            while (j > 0 && x < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            };
            a[j] = x;
        }
        return a;
    }

    static int[] bubbleSort(int[] a) {
        int i;
        boolean swapped;
        do {
            swapped = false;
            for (i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return a;
    }

}
