package test.Array;

import java.util.HashSet;
import java.util.Set;

public class MAxDiff {

    public static void main(String[] args) {
        int[] a = new int[] {2,3,10,6,4,8,1,7,11};
        int min = a[0];
        int maxDiff = 0;

        for(int i=1; i < a.length; i++) {
                   min = Math.min(min, a[i]);
                   maxDiff = Math.max(maxDiff, a[i] - min);


        }
        System.out.println("min:"+ min);
        System.out.println("maxDiff: "+ maxDiff);
        longConsecutiveSeq();
    }



    //
    public static void longConsecutiveSeq() {
        int[] arr = new int[]{1,9,3,10,4,20,2};


        //not sorted, find continuously increasing pattern
        int count = 0;
        int maxLen = 0;
        for(int i=0; i < arr.length; i++) {
            count = 1;
            for(int j=i+1; j< arr.length;j++){
                if(arr[j]> arr[j-1])
                    count++;
            }
            maxLen = Math.max(maxLen, count);
        }


        /**
         Not sorted.
         Find the consecutive series at any location
         */
        arr = new int[]{5,1,9,3,11,6,4,20,2};
          //Put it in a hashset, we will  compare it later by using contains method
          Set<Integer> set = new HashSet<>();

          for(int i=0; i < arr.length; i++) {
              set.add(arr[i]);
          }


          int countSoFar = 0;

          for(int i=0; i < arr.length; i++) {
              int element = arr[i] -1;
              if(!set.contains(element)) {
                    int j = i;
                    int val = arr[i];
                    while( j < arr.length && set.contains(val)) {
                        val = val +1;
                        j++;

                    }
                    countSoFar = Math.max(countSoFar, val-arr[i]);
              }
          }

        System.out.println("countSoFar: " + countSoFar);

//        System.out.println("longConsecutiveSeq: " + maxLen);
    }
}
