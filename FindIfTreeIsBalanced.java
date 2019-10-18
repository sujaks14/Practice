package test.Tree;

/**
 * Created by Stratos Dev on 8/18/17.
 */
public class FindIfTreeIsBalanced {

    static Node root;
    static class Node {
        Node left;
        Node right ;
        int val;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return ""+this.val;
        }
    }


    /**

         1

     2       3

  4   5     6   7




     */


    public static void buildTree() {

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);


        one.left = two;
        one.right = three;

        two.left=four;
        two.right=five;


        three.left = six;
        six.left = seven;

        root = one;
    }



    public static boolean isBalanced(Node n) {
        int height = getBalancedTreeHeight(n);
        System.out.println("height:"+ height);
        return  (height > -1);
    }


    public static int getBalancedTreeHeight(Node n) {

        if(n == null) return 0;

        int h1 = getBalancedTreeHeight(n.left);
        int h2 = getBalancedTreeHeight(n.right);

        if(h1 == -1 || h2==-1)
            return -1;

        System.out.println("Math.abs(h1 - h2): " + Math.abs(h1 - h2) + ", node:*" + n + "*h1: "+ h1 + " h2:"+h2);
        if(Math.abs(h1 - h2) > 1) {
            return -1;
        }

        return Math.max(h1, h2)+1;

    }

    public static void main(String[] args) {
        buildTree();
        System.out.println("isBalaned: ? "+ isBalanced(root));
    }

}
