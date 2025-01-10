/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class MyList {
    private Node head, tail;

    public MyList() {
        this.head = null;
        this.tail = null;
    }

    public MyList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    
    public void add(int value) {
        if(this.isEmpty()){
            this.head = new Node(value, null);
            this.tail = this.head;
        }else{
            Node newNode = new Node(value, null);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }
    public void traverse(){
        Node p = this.head;
        while (p!=null){
            System.out.print(" " + p.getInfo());
            p = p.getNext();
        }
        System.out.println("");
    }
    public Node search(int value){
        Node p = this.head;
        while(p != null){
            if (p.getInfo()==value){
                return p;
            }else{
                p = p.getNext();
            }
        }
        return null;
    }
    public void delete(int value){
       Node p = this.head;
       Node prev = null;
       
       while(p!=null){
           if(p.getInfo()==value){
               if (prev != null){
                   prev.setNext(p.getNext());
               }else{
                   this.head = p.getNext();
               }
           }
           prev = p;
           p = p.getNext();
       }
    }
    public boolean isEmpty() {
//        if (this.head==null)
//            return true;
//        else 
//            return false;
        return this.head==null;
    }
    
    
    
}
