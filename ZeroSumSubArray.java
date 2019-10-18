package test.Array;

import java.util.*;

/**
 * Created by Stratos Dev on 8/18/17.
 */
public class ZeroSumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,-5,1,2,1};


        int prevSum = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        List<int[]> res = new ArrayList<>();

        for(int i=0; i <= arr.length; i++) {
            Integer oldIndex = sums.get(prevSum);
            if(oldIndex == null && i== arr.length) {
                System.out.println("no sub array summing upto 0");
                return ;
            }
            else if(oldIndex == null) {
                sums.put(prevSum, i);
                prevSum += arr[i];
            }
            else {
                //from: inclusive
                //to:exclusive
                Arrays.copyOfRange(arr, oldIndex, i);
                return;
            }

        }
    }
}
