package test.Tree;

import test.LinkedListTest.SNode;

/**
 * Created by Stratos Dev on 8/19/17.
 */
public class ReverseLinkedList {

    static class  Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "val:"+ val;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.next = two;
        two.next = three;

        reverseList(one);


    }


    public static void reverseList(Node node) {
        Node prev = null;
        Node curr = node;

        while(curr != null) {
            Node temp  = prev;
            prev = curr;
            curr = curr.next;
            prev.next = temp;
        }
        while (prev != null) {
            System.out.println(""+ prev);
            prev = prev.next;
        }

    }

}
