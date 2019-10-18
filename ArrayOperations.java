package test.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayOperations {

    public static void main(String[] args) {
        System.out.println("Enters main");
        palindromePartitions();
        System.out.println("list:"+ words);
        System.out.println("Exits main");
    }



    static int insertSorted(int arr[], int n, int key, int capacity)
    {
        // Cannot insert more elements if n
        // is already more than or equal to
        // capcity
        if (n >= capacity)
            return n;

        arr[n] = key;

        return (n+1);
    }



    public static String reverseString(String input) {
        char[] inputArr = input.toCharArray();
        int l = 0;
        int r = inputArr.length - 1;
        while (l < r) {
            if (!Character.isAlphabetic(inputArr[l])) {
                l++;
            } else if (!Character.isAlphabetic(inputArr[r])) {
                r--;
            } else {
                char tempChar = inputArr[l];
                inputArr[l] = inputArr[r];
                inputArr[r] = tempChar;
                l++;
                r--;
            }
        }
        return new String(inputArr);
    }






    public static void palindromePartitions() {
        String s = "nitin 1221";
        for(int i=0; i < s.length(); i++) {
            addPartitions(s, i);

        }
    }


    public static void addPartitions(String s, int tillPos) {

        for(int start=0; start <=tillPos; start++) {
            isPali(s, start, tillPos);
        }
    }

    static Set<String> words = new HashSet<>();

    public static void isPali(String s, int start, int end) {
        int hi = end;
        int low = start;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return;
            }
            start++;
            end--;
        }

        System.out.println("words to add:" + " low="+low + ", high="+ hi
                + "--" +s.substring(low, hi+1));
        words.add(s.substring(low, hi+1));
    }

}
