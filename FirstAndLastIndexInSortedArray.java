package test.Array;


public class FirstAndLastIndexInSortedArray {

        public int[] searchRange(int[] nums, int target) {
            int pos = getPosition(nums, 0, nums.length-1, target);

            System.out.println("pos:" + pos);

            if(pos == -1)
                return new int[]{-1,-1};

            int count =1;
            for(int i=pos+1; i < nums.length; i++) {
                if(nums[i] != target) {
                    break;
                }
                else {
                    count++;
                }
            }

            int[] arr = new int[2];
            arr[0] = pos;
            arr[1] = pos+count-1;
            return arr;
        }


        int getPosition(int[] nums, int lo, int hi, int target) {

            while(lo <= hi) {
                int mid = (lo+hi)/2;
                System.out.println("mid:" + mid);
                if(nums[mid] == target) {
                    if((mid -1) >=0 && nums[mid -1] == target) {
                        System.out.println("nums[mid -1] == target, mid="+mid);
                        hi = mid -1;
                    }
                    else {
                        return mid;
                    }
                }
                else if(nums[mid] < target) {
                    lo= mid+1;

                }
                else if(nums[mid] > target){
                    hi = mid -1;
                }
            }

            return -1;

        }


    public static void main(String[] args) {
        System.out.println("");
        FirstAndLastIndexInSortedArray inst = new FirstAndLastIndexInSortedArray();
        int[] nums = new int[]{2,2};
        int[] result = inst.searchRange(nums, 3);
        for(int i: result) {
            System.out.println("i="+i);
        }
    }
}
