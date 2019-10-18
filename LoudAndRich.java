package test.Amz;

import java.util.*;

/**

 In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money, and different levels of quietness.

 For convenience, we'll call the person with label x, simply "person x".

 We'll say that richer[i] = [x, y] if person x definitely has more money than person y.  Note that richer may only be a subset of valid observations.

 Also, we'll say quiet[x] = q if person x has quietness q.

 Now, return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]), among all people who definitely have equal to or more money than person x.



 Example 1:

 Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 Output: [5,5,2,5,4,5,6,7]
 Explanation:
 answer[0] = 5.
 Person 5 has more money than 3, which has more money than 1, which has more money than 0.
 The only person who is quieter (has lower quiet[x]) is person 7, but
 it isn't clear if they have more money than person 0.

 answer[7] = 7.
 Among all people that definitely have equal to or more money than person 7
 (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x])
 is person 7.

 The other answers can be filled out with similar reasoning.
 Note:

 1 <= quiet.length = N <= 500
 0 <= quiet[i] < N, all quiet[i] are different.
 0 <= richer.length <= N * (N-1) / 2
 0 <= richer[i][j] < N
 richer[i][0] != richer[i][1]
 richer[i]'s are all different.
 The observations in richer are all logically consistent.

 */
public class LoudAndRich {



    ArrayList<Integer>[] graph;
    int[] answer;
    int[] quiet;


    public static void main(String[] args) {
        LoudAndRich inst = new LoudAndRich();
        int[][] richer = new int[][]{
                new int[]{1, 0},
                new int[]{2, 1},
                new int[]{3, 1},
                new int[]{3, 7},
                new int[]{4, 3},
                new int[]{5, 3},
                new int[]{6, 3}};

        int[] quiet = new int[]{3, 2, 5, 4, 6, 1, 7, 0};
        int[] ans = inst.loudAndRich(richer, quiet);
        for(int i=0; i < ans.length; i++){
            System.out.println("ans - :" + ans[i]);
        }
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        graph = new ArrayList[N];
        answer = new int[N];
        this.quiet = quiet;

        for (int node = 0; node < N; ++node)
            graph[node] = new ArrayList<Integer>();

        for (int[] edge: richer) {
            System.out.println("graph[edge[1]]:" + graph[edge[1]] +" adding:" + edge[0]);
            graph[edge[1]].add(edge[0]);
        }
        //add all who are richer than 1

        Arrays.fill(answer, -1);

        for (int node = 0; node < N; ++node)
            dfs(node);
        return answer;
    }

    public int dfs(int node) {
        if (answer[node] == -1) {
            answer[node] = node;
            for (int child: graph[node]) {
                int cand = dfs(child);
                if (quiet[cand] < quiet[answer[node]])
                    answer[node] = cand;
            }
        }
        return answer[node];
    }


//    Knowing the problem is actually want to find among all wealthier people, who got the quietest voice, the problem can simply be solved using BFS.
//
//    Before you do the BFS, you want to simplify the structure a little bit, by putting people wealthier than i in a list. Then use this list to do BFS search. Code:

        public int[] loudAndRich1(int[][] richer, int[] quiet) {
            List<List<Integer>> list = new ArrayList<>();
            int[] res = new int[quiet.length];

            for (int i = 0; i < quiet.length; i++) {
                list.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < richer.length; i++) {
                list.get(richer[i][1]).add(richer[i][0]);
            }

            for (int i = 0; i < res.length; i++) {
                boolean[] visited = new boolean[quiet.length];
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                int min = quiet[i];
                int ans = i;
                while (!q.isEmpty()) {
                    int cur = q.remove();
                    if (visited[cur]) continue;
                    visited[cur] = true;
                    if (quiet[cur] < min) {
                        min = quiet[cur];
                        ans = cur;
                    }
                    List<Integer> tempList = list.get(cur);
                    for (int n : tempList) {
                        q.add(n);
                    }
                }
                res[i] = ans;
            }
            return res;
        }
}
