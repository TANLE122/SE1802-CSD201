/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Heap {
    public static void buildMaxHeap(int[] arr, int n){
        for (int i=1; i<n; i++){
            int x = arr[i];
            int son = i;
            
            while(son>0 && x>arr[(son-1)/2]){
                arr[son] = arr[(son-1)/2];
                son=(son-1)/2;
            }
            arr[son]=x;
        }
    }
    
    // Chuyển heap thành mảng đã sắp xếp
    public static void heapToSortedArray(int[] arr, int n) {
        for (int i = n - 1; i > 0; i--) {
            // Đổi chỗ phần tử đầu (lớn nhất) với phần tử cuối
            int x = arr[i];
            arr[i] = arr[0];
            
            int father = 0;
            int son = 2 * father + 1; // con trái
            
            // Nếu con phải lớn hơn, chọn con phải
            if (son + 1 < i && arr[son] < arr[son + 1]) {
                son = son + 1;
            }
            
            // Sift down: Di chuyển phần tử xuống cho đến khi thỏa mãn tính chất heap
            while (son < i && x < arr[son]) {
                arr[father] = arr[son];
                father = son;
                son = 2 * father + 1;
                
                if (son + 1 < i && arr[son] < arr[son + 1]) {
                    son = son + 1;
                }
            }
            arr[father] = x;
        }
    }
}
