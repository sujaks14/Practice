package test.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stratos Dev on 6/18/17.
 */
public class LongestIncreasingSubsequence {


    /**
     * O(n^2)
     */
    static void findLongestIncreasingSeq() {
        System.out.println("Enters findLongestIncreasingSeq");
        int array[] = new int[] {3,10,2,1,20};;
                //{ 10, 22, 9, 33, 21, 50, 41, 60 };
                //{3,10,2,1,20}; // 3->10->20

        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] result = new int[array.length];
        for(int i:result) {
            result[i] =1;
        }

        int max = 0;
        for(int i=1; i < array.length; i++) {
            List<Integer>  list = new ArrayList<>();
            for(int j=0; j <i; j++) {
                if(array[j] < array[i] && result[i] <= result[j] ) {
                    list.add(array[j]);
                    result[i] = result[j]+1;

                    if(max < result[i])
                        max = result[i];
                }
            }
                list.add(array[i]);
                map.put(i,list);
        }
        System.out.println("max: " + max);
        System.out.println("map:" + map);
        System.out.println("Exits findLongestIncreasingSeq");
    }



  public static void findTimeEffective() {
      int array[] = new int[] {3,10,2,1,20};;
      int[] result = new int[array.length];

      result[0] = 1;
      int max = 0;
      for(int i=1; i< array.length;i++) {
          if(array[i] > array[i-1] && result[i] <= result[i-1]) {
              result[i] = result[i - 1] + 1;
              if (max < result[i])
                  max = result[i];
          }
      }

      for(int i=0; i< result.length;i++) {
          System.out.println("res"+result[i]);
      }
      System.out.println("findTimeEffective ::max: " + max);

  }



    // driver program to test above functions
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
//        findLongestIncreasingSeq();
        findTimeEffective();
    }
}
