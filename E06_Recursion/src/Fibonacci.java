/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Fibonacci {
    /*
    Base:
    - f(0) = 1
    - f(1) = 1
    Recursion:
    - f(n) = f(n-1) + f(n-2)
    */
    public static int fibonacci(int n){
        System.out.println("Tính f("+n+")");
        if(n== 0 || n==1)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
    // Chuyển từ đệ quy sang vòng lặp
    public static int fibonacci2(int n){
        if(n==0 || n==1)
            return 1;
        
        int fn = 1;
        int fn_1 = 1;
        int fn_2 = 1;
        for(int i=2; i<=n; i++){
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
            
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fibonacci2(10));
        long end =System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
}
