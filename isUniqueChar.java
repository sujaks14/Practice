package test.Array;

/**
 * Created by Stratos Dev on 6/19/17.
 */
public class isUniqueChar {

    public static void main(String[] args) {
        System.out.println("Enters main");
        String s = "asujas";
        boolean[] char_set = new boolean[128];

        for(char c: s.toCharArray()) {
            if(char_set[c])
                System.out.println("character found:"+ c);
            else
                char_set[c]=true;
        }

        System.out.println("--"+ usingCount("dog","god"));
        System.out.println("--"+ usingCount("dog","dog1"));
        System.out.println("Exits main");
    }


    private static boolean usingCount(String s1, String s2) {
        int[] letters = new int[128];

        for(char c: s1.toCharArray())
            letters[c]++;

        for(char c:s2.toCharArray()) {
            letters[c]--;
            if(letters[c] < 0)
                return false;
        }
        return true;
    }
}
