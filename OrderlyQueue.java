package test.Amz;

/**

 A string S of lowercase letters is given.  Then, we may make any number of moves.

 In each move, we choose one of the first K letters (starting from the left), remove it, and place it at the end of the string.

 Return the lexicographically smallest string we could have after any number of moves.



 Example 1:

 Input: S = "cba", K = 1
 Output: "acb"
 Explanation:
 In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
 In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".
 Example 2:

 Input: S = "baaca", K = 3
 Output: "aaabc"
 Explanation:
 In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
 In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".
 */

public class OrderlyQueue {


    public static void main(String[] args) {


        String s1 = "a";
        String s2 = "b";

//        int test1= s1.charAt(0) - 'a';
//        int test2 = s2.charAt(0) - 'a';
//        System.out.println("test1:" + test1 + ", test2:"+ test2);
//        System.exit(0);

        String s = "cba";

        char[] chars = s.toCharArray();
        int index = 0;
        int k = 1;


        while(index <= chars.length - k +1) {
            int indexToRemove = index;
            for(int i=index; i < index +k && i < chars.length -1; i++) {
                int c1 = chars[i] - 'a';
                int c2 = chars[indexToRemove] - 'a';
                System.out.println("c1:" + c1 + ", c2:"+ c2 + "at index= "+i);
                if( c1 > c2 ) {

                    indexToRemove = i;
                    System.out.println("c1:"+ c1 +", c2:"+c2 +", indexToRemoved:"+ indexToRemove );
                }
            }
            swap(chars, indexToRemove, chars.length -1 );
            index = index + k;
            System.out.println("chars:"+ new String(chars));
            System.out.println("exists for loop at index:" + (index));
        }

        System.out.println("finally :" + new String(chars));

    }


    public static void swap (char[] chars, int i, int j) {
        System.out.println("int i: "+i +", j=" + j);
        if(i < chars.length && j < chars.length) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
