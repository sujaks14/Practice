package test.Array;

/**

 Given an integer array sorted in ascending order,
 write a function to search target in nums.
 If target exists, then return its index, otherwise return -1.
 However, the array size is unknown to you.
 You may only access the array using an ArrayReader
 interface, where ArrayReader.get(k) returns the element
 of the array at index k (0-indexed).

 You may assume all integers in the array are less than 10000,
 and if you access the array out of bounds, ArrayReader.get will return 2147483647.


 Example 1:

 Input: array = [-1,0,3,5,9,12], target = 9
 Output: 4
 Explanation: 9 exists in nums and its index is 4
 Example 2:

 Input: array = [-1,0,3,5,9,12], target = 2
 Output: -1
 Explanation: 2 does not exist in nums so return -1


 Note:

 You may assume that all elements in the array are unique.
 The value of each element in the array will be in the range [-9999, 9999].


 */
public class SearchInSortedArray {
    public static void main(String[] args) {
            int[] arr = new int[]{-1,0,3,5,9,12};
            int target = 9;
            int index = getIndex(arr, 0, arr.length-1, target);
            System.out.println("index: " + index);
    }

/**
    public int search(ArrayReader reader, int target) {
        if (reader == null) {
            return 0;
        }
        int left = 0;
        int right = 1;
        //find the right boundary for binary search
        //extends until we  are sure the target is within the [left, right] range.
        while (reader.get(right) < target) {
            //1. move left to right
            //2. double right index
            left = right;
            right = 2*right;
        }
        return binarySearch(reader, target, left, right);
    }

    private int binarySearch(ArrayReader reader, int target, int left, int right) {
        //classical binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) > target) {
                right = mid-1;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

 */

    static int getIndex(int[] arr, int lo, int hi, int target) {
        int mid =  (lo + hi)/2;
        if(arr[mid] == target) {
            return mid;
        }
        else  if(arr[mid] < target){
            lo = mid+1;
        }
        else {
            hi = mid -1;
        }
        return getIndex(arr, lo, hi, target);
    }
}
