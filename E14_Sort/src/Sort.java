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
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return a;
    }

    static void quickSort(int[] a, int first, int last) {
        if (first < last) {
            // Phân hoạch và tìm pivot index
            int pivotIndex = partition(a, first, last);

            // Đệ quy sắp xếp các phần tử trước và sau pivot
            quickSort(a, first, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] a, int first, int last) {
        // Chọn phần tử cuối là pivot
        int pivot = a[last];
        
        int i = first-1;
        
        // Duyệt tất cả các phần tử
        // So sánh từng phần tử với pivot
        for (int j=first; j<last; j++){
            // Nếu phần tử hiện tại nhỏ hơn pivot
            if(a[j]<pivot){
                // tăng i lên 1
                i++;
                // swap a[i] và a[j]
                swap(a, i, j);
            }
        }
        
        // Swap pivot với vị trí i+1;
        swap(a, i+1, last);
        
        return i+1;
    }
    
    public static void swap(int[] a, int i, int j ){
        int temp =a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
