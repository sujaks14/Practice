package test.Tree;


/**
 * Created by Stratos Dev on 6/14/17.
 */
public class FrameBinaryTreeUsingArray {


    static class Node {
        Node left;
        Node right;
        int val;

        Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return this.val+"";
        }
    }

   public static Node frameBS(int[] a, int start, int end) {
       if(start > end)
           return null;

       int mid = (start + end)/2;
       Node n = new Node(a[mid]);
       n.left = frameBS(a, start, mid-1);
       n.right = frameBS(a, mid+1, end);
       return n;

   }

    public static void main(String[] args) {
        System.out.println("Enters main");
        int[] a = new int[] {1,2,3,4,5,6};
        Node n = frameBS(a, 0, a.length -1);
        System.out.println("n:"+n + "n:"+n.left + " "+ n.right);

        System.out.println("printing nodes");
        printNodes(n);
        System.out.println("Exits main");
    }


    private static Node  printNodes(Node node){
        if(node != null)
            System.out.println(node.left +" --["+ node.val +"] --"+ node.right);
        if(node.left != null)
            printNodes(node.left);
        if(node.right != null)
            printNodes(node.right);
        return null;
    }
}
