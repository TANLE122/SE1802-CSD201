/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class IndirectRecursionExample {
    /*
    n>=1
    print: "Số chẵn / Số lẻ" từ n -> 1;
    */
    
     // Hàm in số chẵn
    public static void print(int n){
        if (n%2==0){
            printEven(n);
        }else{
            printOdd(n);
        }
    }
    
    // Hàm in số chẵn
    public static void printEven(int n){
        if(n<=0)
            return;
        System.out.println("Số chẵn: "+n);
        printOdd(n-1);
    }
    
    // Hàm in số chẵn
    public static void printOdd(int n){
        if(n<=0)
            return;
        System.out.println("Số lẻ: "+n);
        printEven(n-1);
    }
    
    public static void main(String[] args) {
        int n = 25;
        print(25);
    }
}
