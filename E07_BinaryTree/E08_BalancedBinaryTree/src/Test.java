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
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        
        nodeD.setLeft(nodeC);
        nodeD.setRight(nodeE);
        nodeB.setLeft(nodeA);
        nodeB.setRight(nodeD);
        nodeI.setLeft(nodeH);
        nodeG.setRight(nodeI);
        nodeF.setLeft(nodeB);
        nodeF.setRight(nodeG);
        System.out.println("breadth: ");
        nodeF.breadth();
       
        
        nodeF.balanceTree();
        System.out.println("\nbreadth: ");
        nodeF.breadth();
    }
}
