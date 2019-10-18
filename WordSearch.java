package test.Array;

import java.util.*;

/**
 Given an input string and a dictionary of words,
 find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.

 Consider the following dictionary
 { i, like, sam, sung, samsung, mobile, ice,
 cream, icecream, man, go, mango}

 Input:  ilike
 Output: Yes
 The string can be segmented as "i like".

 Input:  ilikesamsung
 Output: Yes
 The string can be segmented as "i like samsung" or "i like sam sung".
 */
public class WordSearch {

    public static void main(String[] args) {

        int n = 1568;


        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> primeNums = new ArrayList<>();
        primeNums.add(2);
        primeNums.add(3);
        primeNums.add(5);
        primeNums.add(7);
        primeNums.add(11);
        primeNums.add(13);
        primeNums.add(17);
        primeNums.add(19);

        for(int i=0; i < primeNums.size(); i++ ) {

            int rem = 0;
            int num = primeNums.get(i);

            while (num > 0) {
                rem = num % 10;
                num = num / 10;


                if (map.get(rem) != null) {
                    map.put(rem, (int) map.get(rem) + 1);
                } else {
                    map.put(rem, 1);
                }
            }

        }

        map.forEach((k,v)-> System.out.println(""+ k +"-"+v));

        System.out.println("->" +map.entrySet().stream().count());



    }

    private static void wordSearch() {
        Set<String> dict = new HashSet<>();

        dict.add("i");
        dict.add("a");
        dict.add("b");
//        dict.add("like");
//        dict.add("su");
        dict.add("suja");
        dict.add("suma");

        String s = "ilikesuja";
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;

        for(int i=1; i <= s.length(); i++) {
            for(int j =0; j <i; j++) {

                if(f[j] && dict.contains(s.substring(j,i))) {
                    f[i] =true;
                    break;
                }

            }
        }
        System.out.println("");
        System.out.println( " last word exists?  " + f[s.length()]);
    }
}
