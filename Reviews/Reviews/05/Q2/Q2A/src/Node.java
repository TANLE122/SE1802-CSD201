// Node class for the linked list implementation
class Node {
    Task info;
    Node next;
    
    Node(Task x, Node p) {
        info = x;
        next = p;
    }
    
    Node(Task x) {
        this(x, null);
    }
}
