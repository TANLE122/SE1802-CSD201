/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Factorial {
    /**
     * Tính giai thừa n: n*n-1)*(n-2)*...*2*1;
     * Base: 
     * - n ==0 => 1
     * - n ==1 => 1
     * Recursion: n! = n * (n-1)!
     */
    public static int factorial(int n){
        // Điều kiện dừng
        if(n==0 || n==1){
            return 1;
        }
        // Gọi đệ quy: n! = n * (n-1)!
        return n * factorial(n-1);
    }
    
    public static void main(String[] args) {
        System.out.println("5! = " + factorial(5));
        System.out.println("10! = " + factorial(10));
    }
}
