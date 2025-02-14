/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SUPPER LOQ
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{8,3,10,1,6,14,4,7,13};
        Node node = new Node(8);
        for (int i : a) {
            node.insert(i);
        }
        
        System.out.println("BSTree: ");
        node.preOrder(node);
        
        System.out.println(node.search(node, 5));
        System.out.println(node.search(node, 4));
    }
}
