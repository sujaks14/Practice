package test.DP;

/**
 * Created by Stratos Dev on 6/17/17.
 */
public class Paint {


    static int Max_N = 100;
   static void findMax(int A[], int length, int k) {
//    {
//        int M[Max_N + 1][Max_N + 1] = {0};
//        int cum[Max_N + 1] = { 0 };
//        for (int i = 1; i <= length; i++)
//            cum[i] = cum[i - 1] + A[i - 1];
//
//        for (int i = 1; i <= length; i++)
//            M[i][1] = cum[i];
//        for (int i = 1; i <= k; i++)
//            M[1][i] = A[0];
//
//        for (int i = 2; i <= k; i++){    //i is for column
//            for (int j = 2; j <= length; j++){   // j is for row which means p is for row too.
//                int best = Math.INT_MAX;
//                for (int p = 1; p <= j; p++){
//                    best = min(best, max(M[p][i - 1], cum[j] - cum[p]));
//                }
//                M[j][i] = best;
//            }
//        }
//
//        //debug use only
//        for (int i = 1; i <= length; i++)
//        {
//            for (int j = 1; j <= k; j++)
//                cout << " " << M[i][j];
//
//        }
//
//        return M[length][k];
    }

    public static void main(String[] args) {
        int[] A = new int[]{ 100, 200, 300, 400, 500, 600, 700, 800, 900 };
      //  cout <<endl<<endl<< partition(A, 9, 3, 0) << endl;
//        cout<<findMax(A, 9, 3)<<endl;

        //Array, array elements, partition count
//        int max = findMax(A, 9, 3);
//        System.out.println("max:" + max);

    }
}
