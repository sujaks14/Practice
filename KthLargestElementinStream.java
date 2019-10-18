package test.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 Design a class to find the kth largest element in a stream.
 Note that it is the kth largest element in the sorted order,
 not the kth distinct element.

 Your KthLargest class will have a constructor which accepts an integer k
 and an integer array nums, which contains initial elements from the stream.
 For each call to the method KthLargest.add, return the element
 representing the kth largest element in the stream.

 Example:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 Note:
 You may assume that nums' length ≥ k-1 and k ≥ 1.



 */
public class KthLargestElementinStream {

    public static void main(String[] args) {
        System.out.println("enters main");

        int k = 3;
        int[] arr = new int[]{4,5,8,2};
        KthLargestElementinStream kthLargest = new KthLargestElementinStream(3, arr);

        kthLargest.add(3);   // returns 4
        kthLargest.add(5);   // returns 5
        kthLargest.add(10);  // returns 5
        kthLargest.add(9);   // returns 8
        kthLargest.add(4);   // returns 8

    }


    int[] result = new int[3];
    PriorityQueue<Integer> q;
    int k;
    public KthLargestElementinStream(int k, int[] nums) {
        q = new PriorityQueue<>(k);
        this.k = k;

        for(int n:nums) {
            int num = add(n);

        }


    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        System.out.println("n="+ n+ ", kth largest: " + q.peek());
        return q.peek();
    }
}



/**

 Time Complexities
 h = height of tree with the average and best time O(log n) and worst time O(n)

 Constructor O(nh)
 Add O(h)
 findKthLargest O(h)

 Please read this for explanation.

 class KthLargest {
 TreeNode root;
 int k;
 public KthLargest(int k, int[] nums) {
 this.k = k;
 for (int num: nums) root = add(root, num);
 }

 public int add(int val) {
 root = add(root, val);
 return findKthLargest();
 }

 private TreeNode add(TreeNode root, int val) {
 if (root == null) return new TreeNode(val);
 root.count++;
 if (val < root.val) root.left = add(root.left, val);
 else root.right = add(root.right, val);

 return root;
 }

 public int findKthLargest() {
 int count = k;
 TreeNode walker = root;

 while (count > 0) {
 int pos = 1 + (walker.right != null ? walker.right.count : 0);
 if (count == pos) break;
 if (count > pos) {
 count -= pos;
 walker = walker.left;
 } else if (count < pos)
 walker = walker.right;
 }
 return walker.val;
 }

 class TreeNode {
 int val, count = 1;
 TreeNode left, right;
 TreeNode(int v) { val = v; }
 }
 }
 */