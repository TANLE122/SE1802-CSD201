/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class DecToBin {
    /*
    12 -> 1100
     - q = n/2
     - r = n%2
    Base: 
     - n == 0 => stop
    Recursion:
     - decToBin(q)
    print(r)
    */
    public static void decToBin(int n){
        int q = n/2;
        int r = n%2;
        // Điều kiện dừng
        if(n==0)
            return;
        else
            decToBin(q);
        // Xuất kết quả
        System.out.print(r);
    }
    public static void main(String[] args) {
        System.out.print("12 => Bin : ");
        decToBin(12);
    }
}
