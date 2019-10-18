package test.SlidingWindow;

public class numSubarrayProductLessThanK {

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4};

        // 1 ,2 ,3,4,   [1,2], [1,2,3],[2,3]
        int k = 10;

//        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k && left < right) {
                prod /= nums[left++];
                //ans += right - left + 1;
//                System.out.println("ans: "+ ans + " at right="+right +", left:"+left);
            }
            ans += right - left + 1;


        }

        System.out.printf("ans: " + ans);
        System.out.printf("res: " +countSubArrayProductLessThanK(nums, 10));


        /**
         prod =



         */

    }


    static int countSubArrayProductLessThanK(int[] a,
                                             long k)
    {
        int n = a.length;
        long p = 1;
        int res = 0;
        for (int start = 0, end = 0; end < n; end++) {

            // Move right bound by 1 step.
            // Update the product.
            p *= a[end];

            // Move left bound so guarantee that
            // p is again less than k.
            while (start < end && p >= k) {
                p /= a[start++];
            }
            // If p is less than k, update the counter.
            // Note that this is working even for
            // (start == end): it means that the
            // previous window cannot grow anymore
            // and a single array element is the only
            // addendum.
            if (p < k) {
                int len = end - start + 1;
                res += len;
            }
        }

        return res;
    }


}
/***

 public int numSubarrayProductLessThanK(int[] nums, int k) {
 if (k <= 1) return 0;
 int prod = 1, ans = 0, left = 0;
 for (int right = 0; right < nums.length; right++) {
 prod *= nums[right];
 while (prod >= k) prod /= nums[left++];
 ans += right - left + 1;
 }
 return ans;
 }

 */