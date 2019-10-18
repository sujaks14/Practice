package test.DP;

/**
 * Created by Stratos Dev on 8/19/17.
 */
public class MaxProductMatrixFromTopLeftToBottonRight {

    public static void main(String[] args) {

        maxProductForMixedNums();
    }

    static public void maxProductForMixedNums() {
        int[][] matrix = new int[][]{
                {-1, 2, 3},
                {4, 5, -6},
                {7, 8, 9}
        };

        int[][] minCache = new int[matrix.length+1][matrix[0].length+1];
        int[][] maxCache = new int[matrix.length+1][matrix[0].length+1];

        initializeFirstRowAndColumn(minCache);
        initializeFirstRowAndColumn(maxCache);

//        for(int i=1; i < minCache.length;i++) {
//            for(int j=1; j< minCache[0].length; j++) {
//                int curr = matrix[i-1][j-1];
//                /**
//                 *  curr = -ve get minCache()
//                 *  curr =
//                 *
//                 */
//                System.out.printf("i=%d, j = %d, temp=%d, curr=%d, dp[i][j]=%d\n " , i , j, temp, curr, dp[i][j]);
//            }
//        }
//
//        System.out.println("dp[]-> "+ dp[dp.length-1][dp[0].length-1]);


    }

    private static void initializeFirstRowAndColumn(int[][] arr) {
        for(int j=0; j < arr.length;j++) {
            arr[0][j] =1;
        }
        for(int i=0; i< arr.length; i++) {
            arr[i][0] =1;
        }
    }

    public void maxProductForPositiveNums() {
        int[][] matrix = new int[][]{
                {1 ,2,3},
                {4,5,6},
                {7,8,9}

        };

        int[][] dp = new int[matrix.length+1][matrix[0].length+1];


        for(int j=0; j < dp.length;j++) {
            dp[0][j] =1;
        }
        for(int i=0; i< dp.length; i++) {
            dp[i][0] =1;
        }

        for(int i=1; i < dp.length;i++) {
            for(int j=1; j< dp[0].length; j++) {
                int a = Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = a * matrix[i-1][j-1];
            }
        }

        System.out.println("dp[]-> "+ dp[dp.length-1][dp[0].length-1]);
    }
}
