package test.Array;

import java.util.*;

/**

 Given a string of arrays “cat,dog,god,act”. Print all the anagrams which comes first in list.
 eg.  output is cat ,act,dog and god. Means all the similar anagrams should be printed
 together and the next print should be the one which comes earlier in the list.
 https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 hint : Trie approach was expected here.
 */

public class PrintAnagram {

    public static void main(String[] args) {
        String[] arr = new String[]{"cat", "act", "dog", "god", "tac","ogd"};
        Map<String, List<String>> visitedMap = new LinkedHashMap<>();


        for(String s : arr) {
            char[] chars =s.toCharArray();
            Arrays.sort(chars);

            String sortedString = new String(chars);
            List<String> stringList = visitedMap.get(sortedString);

            if(stringList != null) {
                stringList.add(s);
            }
            else {
                stringList = new ArrayList<>();
                stringList.add(s);
                visitedMap.put(sortedString, stringList);
            }
        }


        for(Map.Entry<String, List<String>> entry: visitedMap.entrySet()) {
            System.out.println("Key:" + entry.getKey()  + ", val:"+ entry.getValue());
        }

    }
}
