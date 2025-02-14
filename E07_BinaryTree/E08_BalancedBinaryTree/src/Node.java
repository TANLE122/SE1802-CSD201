
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SUPPER LOQ
 */
public class Node {

    private Object info;
    private Node left, right;

    public Node() {
    }

    public Node(Object info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void visit(Node p) {
        System.out.print(p.info+" ");
    }

    public void breadth() {
        Node root = this;
        if (root == null) {
            return;
        }
        ArrayQueue q = new ArrayQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            try {
                p = (Node) q.dequeue();

                if (p.left != null) {
                    q.enqueue(p.left);
                }
                if (p.right != null) {
                    q.enqueue(p.right);
                }
                visit(p);
            } catch (Exception ex) {
                Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    // Đếm số lượng node có trong cây:
    public int countNodes(Node p){
        if (p==null) return 0;
        return 1 + countNodes(p.left) + countNodes(p.right);
    }
    
    // Chuyển cây thành mảng bằng inorder traversal
    private int index =0;
    public void treeToArray(Node p, Object[] arr){
        if(p==null) return;
        treeToArray(p.left, arr);
        arr[index++] = p.info;
        treeToArray(p.right, arr);
    }
    
    // Xóa toàn bộ cây:
    public void clear(){
        this.info = null;
        this.left = null;
        this.right = null;
    }
    
    // Phương thức để cân bằng cây
    public void balanceTree(){
        int n = countNodes(this);
        if( n==0 ) return;
        
        // Tạo mảng và chuyển cây sang mảng
        Object[] arr = new Object[n];
        treeToArray(this, arr);
        
        // Xóa cây hiện tại
        clear();
        
        // Tạo lại cây cân bằng
        balance(arr, 0, n-1);
    }
    
    private void balance(Object[] data, int first, int last){
        if(first<=last){
            int middle = (first+last)/2;
            insert(data[middle]);
            balance(data, first, middle-1);
            balance(data, middle+1, last);
        }
    }
    
    public void insert(Object x){
        Node p = new Node(x);
        
        // empty tree
        if(this.info==null){
            this.info = x;
            return;
        }
        
        // non empty tree
        Node f = null;
        Node current = this;
        while(current!=null){
            if(current.info.equals(x)) return;
            f = current;
            if(x.toString().compareTo(current.info.toString())<0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        if(x.toString().compareTo(f.info.toString())<0){
            f.left = p;
        }else{
            f.right = p;
        }
    }
}
