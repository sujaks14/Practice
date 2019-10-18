package test.DP;

/**
 You have to paint N boards of length {A0, A1, A2, A3 … AN-1}.
 There are K painters available and you are also given
 how much time a painter takes to paint 1 unit of board.
 You have to get this job done as soon as possible under
 the constraints that any painter will only paint contiguous sections of board.


 2 painters cannot share a board to paint. That is to say, a board
 cannot be painted partially by one painter, and partially by another.
 A painter will only paint contiguous boards. Which means a
 configuration where painter 1 paints board 1 and 3 but not 2 is
 invalid.


 Input :
 K : Number of painters
 T : Time taken by painter to paint 1 unit of board
 L : A List which will represent length of each board

 Output:
 return minimum time to paint all boards % 10000003
 */

import java.util.*;

public class Painter{
    public static long getMax(ArrayList<Integer> C, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(C.get(i) > max)
                max = C.get(i);
        }
        return max;
    }

    public static long getSum(ArrayList<Integer> C, int n){
        int total = 0;
        for(int i = 0; i < n; i++){
            total += C.get(i);
        }
        return total;
    }

    public static int getRequiredPainters(ArrayList<Integer> board, int boardSize, int maxLengthPerPainter){
        int total = 0;
        int numPainters = 1;
        System.out.println("\t In get required painters maxLengthPerPainter: " + maxLengthPerPainter);
        for(int i =0;i < boardSize; i++){
            total += board.get(i);
            if(total > maxLengthPerPainter){
                total = board.get(i);
                numPainters++;
            }
        }
        return numPainters;
    }

    public static long partition(ArrayList<Integer> board, int boardSize, int k){
        long lo = getMax(board, boardSize); //Get max value of the board

        System.out.println("Max = " + lo);
        long hi = getSum(board, boardSize); //Total sum of the array
        System.out.println("getSum = " + hi);
        while(lo < hi){
            int mid = (int)(lo + (hi-lo)/2);
            System.out.println("For Mid = " + mid +" \n lo = " + lo + "\n hi = " +  hi);
            int requiredPainters = getRequiredPainters(board, boardSize, mid);
            System.out.println("\t required painters : " + requiredPainters);
            if(requiredPainters <= k) {
                hi = mid;
                System.out.println("\t hi = " + hi);
            }
            else {
                lo = mid + 1;
                System.out.println("\t lo = " + lo);
            }
        }
        return lo;
    }

    //k-> num of painters, time taken by painter to paint one unit, board
    public static int paint(int painters, int timeTakenByPainter, ArrayList<Integer> board) {
        return (int)(partition(board, board.size(), painters) * timeTakenByPainter % 10000003);
    }



    public static void main1(String[] args){
        int K = 3; //Integer.parseInt(5); // Number of painters
        int T = 1; //Integer.parseInt(7); // Time taken by painter to paint 1 unit of board
        ArrayList<Integer> C = new ArrayList<Integer>();
//        C.add(1000000);
//        C.add(1000000);
        C.add(100);
        C.add(200);
        C.add(300);
        C.add(400);
        C.add(500);
        C.add(600);
        C.add(700);
        C.add(800);
        C.add(900);


        System.out.println(paint(K, T, C));
    }


    /*
    Partition problem is to determine whether a given set can be
     partitioned into two subsets such that the sum of elements in both subsets is same.
    **/
    //Brute Force
    public static void main(String[] args) {
        System.out.println("enters main");
        int sumFromLeftt = 0;
        int sumFromRight =0;
        int[] a = new int[]{1,2,3,1,5};
        //O(n^2)
        for(int i=0 ; i < a.length -1; i++) {
            sumFromLeftt += a[i];
            for(int j= a.length -1; j >i; j--) {
                sumFromRight += a[j];
            }
            System.out.println("sumFromLeftt:"+ sumFromLeftt + " sumFromRight:"+ sumFromRight + " at i="+i);
            if(sumFromLeftt == sumFromRight) {
                System.out.println("break after: "+ i );
                break;
            }
            sumFromRight =0;
        }

        sumSubset(a);
    }


    /**
     * How to do it using DP
     Drawback in brute force: loop j is repeated for each i iteration.
     if we can save thees values in a matrix, it is easy
     like sum matrix at j
     sum from right before i:

     1. iterate once and populate -> time complexity -> o(n)
     2. iterate on the go?


     /* Edge cases
     1. if the sum of elements is odd -> cant partition into two sets
     2.

     */

    public static void sumSubset(int a[]) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a.length -1, a[a.length -1]);


        //O(n)
        for(int x=a.length -2; x>0 ;x--) {
            map.put(x, a[x]+map.get(x+1));
        }
        System.out.println(map);

        int sum = 0;
        //O(n)
        for(int i=0; i< a.length -1; i++) {
            sum += a[i];
            if(sum == map.get(i+1)) {
                System.out.println("matching at i "+i);
            }
        }
    }

}