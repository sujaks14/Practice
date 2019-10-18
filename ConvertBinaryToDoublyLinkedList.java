package test.Tree;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.node.DoubleNode;
import com.sun.source.tree.BinaryTree;
import test.LinkedListTest.DNode;

/**
 * Created by Stratos Dev on 8/15/17.
 */
public class ConvertBinaryToDoublyLinkedList {


    public static void main(String[] args) {
        ConvertBinaryToDoublyLinkedList inst = new ConvertBinaryToDoublyLinkedList();
        inst.buildBinaryTree();
        BNode root = BinaryTree.root;
        System.out.println("root:" + root);

        DNode dNode = buildDoublyLinkedList(root);
        printNode(dNode);


    }


   static public void printNode(DNode dNode) {
        if(dNode == null) {
            return;
        }
        System.out.println("**"+dNode.data +"**");
        printNode(dNode.prev);
        printNode(dNode.next);

    }


    static DNode buildDoublyLinkedList(BNode bNode ) {
        if(bNode == null)
            return null;
        DNode<Integer> node = new DNode<>(bNode.data) ;
        node.prev = buildDoublyLinkedList(bNode.left);
        node.next = buildDoublyLinkedList(bNode.right);
        return node;
    }
    static class BinaryTree {
        static  BNode root;


        // head --> Pointer to head node of created doubly linked list
        BNode head;

        // Initialize previously visited node as NULL. This is
        // static so that the same value is accessible in all recursive
        // calls
        static BNode prev = null;

        // A simple recursive function to convert a given Binary tree
        // to Doubly Linked List
        // root --> Root of Binary Tree
        void BinaryTree2DoubleLinkedList(BNode root)
        {
            // Base case
            if (root == null)
                return;

            // Recursively convert left subtree
            BinaryTree2DoubleLinkedList(root.left);

            // Now convert this node
            if (prev == null)
                head = root;
            else
            {
                root.left = prev;
                prev.right = root;
            }
            prev = root;

            // Finally convert right subtree
            BinaryTree2DoubleLinkedList(root.right);
        }

        /* Function to print nodes in a given doubly linked list */
        void printList(BNode node)
        {
            while (node != null)
            {
                System.out.print(node.data + " ");
                node = node.right;
            }
        }

        // Driver program to test above functions
        public static void main(String[] args)
        {
            // Let us create the tree as shown in above diagram
            BinaryTree tree = new BinaryTree();
            tree.root = new BNode(10);
            tree.root.left = new BNode(12);
            tree.root.right = new BNode(15);
            tree.root.left.left = new BNode(25);
            tree.root.left.right = new BNode(30);
            tree.root.right.left = new BNode(36);

            // convert to DLL
            tree.BinaryTree2DoubleLinkedList(tree.root);

            // Print the converted List
            tree.printList(tree.head);

        }
    }


    public void buildBinaryTree() {
        System.out.println("Enters buildBinaryTree");

        BinaryTree tree = new BinaryTree();
        // Let us create the tree shown in above diagram
        tree.root = new BNode(10);
        tree.root.left = new BNode(12);
        tree.root.right = new BNode(15);
        tree.root.left.left = new BNode(25);
        tree.root.left.right = new BNode(30);
        tree.root.right.left = new BNode(36);

        /**

                 10

         12             15

       25    30         36

         */
    }


    static class BNode
    {
        int data;
        BNode left, right;

        BNode(int item)
        {
            data = item;
            left = right = null;
        }
    }

}
