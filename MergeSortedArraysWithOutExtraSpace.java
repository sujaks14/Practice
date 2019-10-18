package test.Array;

/**
 * Created by Stratos Dev on 8/18/17.
 */
public class MergeSortedArraysWithOutExtraSpace {

    public static void main(String[] args) {

        int[] a = new int[]{1,3,5,0,0,0};
        int[] b = new int[] {2,4,6};
        int aCount = 3;
        int bCount = 3;


        int aIndex = aCount -1;
        int bIndex = bCount -1;
        int mergedIndex = aIndex + bIndex +1;

        /*
        Idea: keep populating the larger element
              from the end of the longer array
         */

        while(aIndex >=0 && bIndex >= 0) {

         //check which one is large among the two array elements

            if(a[aIndex] > b[bIndex]) {
                //a is larger, move a[aIndex] to mergedIndex
                a[mergedIndex] = a[aIndex];
                aIndex--;
            }
            else {
                a[mergedIndex] = b[bIndex];
                bIndex--;
            }
            mergedIndex--;
        }


        while(bIndex >=0 ) {
            a[mergedIndex] = b[bIndex];
            bIndex--;
            mergedIndex--;

        }


        for(int num: a) {
            System.out.println("element: " + num);
        }
    }



}
