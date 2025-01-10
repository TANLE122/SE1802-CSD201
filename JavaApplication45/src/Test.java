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
    public static void main(String[] args){
        MyList list = new MyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(4);
        list.add(5);
        list.traverse();
        System.out.println(list.search(-1));
        System.out.println(list.search(0));
        list.delete(5);
        list.traverse();
        list.delete(0);
        list.traverse();
        list.delete(1);
        list.traverse();
        
        MyList list2 = new MyList();
        list2.delete(10);
    }
}
