package test.Array;

/**
 Given an array(list) of integers, write a function that
 would determine if the elements in the array can be divided into two parts each giving the same sum.
 */
public class DivideArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,11,5};
                //2,4,5,  1,6,2,2};

        int[] left = new int[arr.length];
        left[0] = 0;

        int[] right = new int[arr.length];
        right[arr.length-1] = 0;

        // 0 1 2 3 4 5 6
        // left[0] = 0, left[1] = arr[0]
        //left to right
        for(int i=1; i < arr.length; i++ ) {
            left[i] = left[i-1] + arr[i-1];
        }

        //right to left

        for(int i=arr.length -2; i>=0; i--) {
            right[i] = right[i+1] +arr[i+1];
        }


        for(int i=0; i <arr.length; i++) {
            if(arr[i] + left[i] == right[i]) {
                System.out.println("left divide at i="+i );
                System.out.println("divide the array till i="+(i));
            }
            else if(arr[i] + right[i] == left[i] ){
                System.out.println("right divide at i"+i);
            }
        }


        System.out.println();

    }
}
