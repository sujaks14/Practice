package test.Array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {


   static String s = "You got beautiful eyes";
    static char[] chars = s.toLowerCase().toCharArray();

    /**
     Example: Input: “you got beautiful eyes”
     Output: ”you gtbeaiful es”
     */

    public static void main(String[] args) {

        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(char c: chars) {

            if(!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
            else
                set.remove(c);
        }

        System.out.println("sb: " + sb.toString());

    }



}
