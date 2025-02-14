/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tungi
 */
public class Test2 {

    // Phương thức để vẽ cây
    public static void printTree(Node root, String prefix, boolean isLeft) {
        if (root == null || root.getInfo() == null) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getInfo());

        // Vẽ cây con bên trái
        printTree(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
        // Vẽ cây con bên phải
        printTree(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
    }

    public static void displayTree(Node root) {
        System.out.println("Cấu trúc cây:");
        if (root == null || root.getInfo() == null) {
            System.out.println("(empty)");
            return;
        }
        printTree(root, "", false);
        System.out.println();
    }

    public static void main(String[] args) {
        // Tạo cây không cân bằng
        Node tree = new Node();
        System.out.println("\nTạo cây mất cân bằng mới...");
        tree = new Node();
        tree.insert("9");
        tree.insert("8");
        tree.insert("6");
        tree.insert("4");
        tree.insert("2");

        System.out.println("\nCây mất cân bằng:");
        displayTree(tree);

        // Cân bằng cây
        System.out.println("Thực hiện cân bằng cây...");
        tree.balanceTree();

        System.out.println("\nCây sau khi cân bằng:");
        displayTree(tree);

        System.out.println("Các phép duyệt cây sau khi cân bằng:");
        System.out.print("Inorder traversal: ");
        tree.inOrder(tree);
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preOrder(tree);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postOrder(tree);
        System.out.println();

        System.out.print("Breadth-first traversal: ");
        tree.breadth();
        System.out.println();
    }
}
