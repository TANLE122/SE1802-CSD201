/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class HeapSort {

    public static void sortAscending(int[] a) {
        int n = a.length;

        transformArrayToHeap(a, n, true);

        transformHeapToSortedArray(a, n, true);
    }

    public static void sortDescending(int[] a) {
        int n = a.length;

        transformArrayToHeap(a, n, false);

        transformHeapToSortedArray(a, n, false);
    }

    public static void transformArrayToHeap(int[] a, int n, boolean isMaxHeap) {
        int i, s;
        int x;
        for (i = 1; i < n; i++) {
            x = a[i];
            s = i; // s is a son, f = (s-1)/2 is a father
            if (isMaxHeap) {
                // Max heap: nút cha >= nút con
                while (s > 0 && x > a[(s - 1) / 2]) {
                    a[s] = a[(s - 1) / 2];
                    s = (s - 1) / 2;
                }
            } else {
                // Max heap: nút cha >= nút con
                while (s > 0 && x < a[(s - 1) / 2]) {
                    a[s] = a[(s - 1) / 2];
                    s = (s - 1) / 2;
                }
            }
            a[s] = x;
        }
    }

     // Biến đổi heap thành mảng đã sắp xếp
    public static void transformHeapToSortedArray(int[] a, int n, boolean isMaxHeap) {
        int i, f, s;
        int x;
        
        for(i = n-1; i > 0; i--) {
            x = a[i];
            a[i] = a[0];
            
            f = 0; // f is father
            s = 2*f+1; // s is a left son
            
            if (isMaxHeap) {
                // Max Heap: chọn con lớn hơn
                if(s+1 < i && a[s]  < a[s+1]) s = s+1;
                
                while(s < i && x < a[s]) {
                    a[f] = a[s];
                    f = s;
                    s = 2*f+1;
                    
                    if(s+1 < i && a[s] < a[s+1]) s = s+1;
                }
            } else {
                // Min Heap: chọn con nhỏ hơn
                if(s+1 < i && a[s] > a[s+1]) s = s+1;
                
                while(s < i && x > a[s]) {
                    a[f] = a[s];
                    f = s;
                    s = 2*f+1;
                    
                    if(s+1 < i && a[s] > a[s+1]) s = s+1;
                }
            }
            
            a[f] = x;
        }
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        int[] arr2 = {12, 11, 13, 5, 6, 7};
        int[] arr3 = {12, 11, 13, 5, 6, 7};

        System.out.println("Mảng ban đầu:");
        printArray(arr1);

        transformArrayToHeap(arr3, arr3.length, true);
        System.out.println("Mảng sau khi chuyển thành Max Heap");
        printArray(arr3);

        sortAscending(arr1);
        System.out.println("Mảng sắp xếp tăng dần");
        printArray(arr1);

        sortDescending(arr2);
        System.out.println("Mảng sắp xếp giảm dần");
        printArray(arr2);
    }
}
