package test.Array;

/**
 Given an array nums,
 write a function to move all 0's to the end of it
 while maintaining the relative order of the non-zero elements.


 Example:

 Input: [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Note:

 You must do this in-place without making a copy of the array.
 Minimize the total number of operations

 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,3,12};
        //[0,1,0,3,12]
        // o/p : 1,3,12,0,0

//        int zeroPos = arr.length -1;
//
//        for(int i=0; i< zeroPos; i++) {
//            if(arr[i] == 0) {
//                System.out.println("i="+i);
//                swap(arr, i, zeroPos);
//                System.out.println("after swap, nonZeroPos:" + i + " , zeroPos:"+ zeroPos);
//                zeroPos--;
//            }
//        }
//        printArray(arr);

        moveZeroes(arr);


    }

   static public void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                snowBallSize++;
            }
            else if(snowBallSize > 0) {
                    int t = nums[i];
                    nums[i] = 0;
                    nums[i - snowBallSize] = t;

            }
        }
        printArray(nums);
    }

    private static void printArray(int[] arr) {
        for(int i=0; i < arr.length; i++) {
            System.out.println(  arr[i]);
        }
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
