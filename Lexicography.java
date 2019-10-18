package test.Array;

import java.util.ArrayList;
import java.util.List;

public class Lexicography {

    public List<Integer> lexicalOrder(int n) {
        //Edge case
        if(n <= 0) return new ArrayList<Integer>();
        //DFS problem
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= 9; i++)
            dfs(i, n, result);
        return result;
    }

    public void dfs(int start, int n, List<Integer> result) {
        // Base case
        if(start > n)
            return;
        result.add(start);
        start *= 10;

        for(int i = 0; i <= 9; i++)
            dfs(start + i, n, result);

    }

//
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> list = new ArrayList<>(n);
//        int curr = 1;
//
//        for (int i = 1; i <= n; i++) {
//            list.add(curr);
//            if (curr * 10 <= n) {
//                curr *= 10;
//            } else if (curr % 10 != 9 && curr + 1 <= n) {
//                curr++;
//            } else {
//                while ((curr / 10) % 10 == 9) {
//                    curr /= 10;
//                }
//                curr = curr / 10 + 1;
//            }
//        }
//        return list;
//    }



}
