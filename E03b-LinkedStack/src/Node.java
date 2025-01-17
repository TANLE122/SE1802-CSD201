/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Node {

    private Object info;
    private Node next;

    public Node() {
    }

    public Node(Object info) {
        this.info = info;
        this.next = null;
    }

    public Node(Object info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
