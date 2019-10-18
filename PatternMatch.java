package test.Array;

/**
 Given a input String and a patterns string. return all
 the start index of the input string whenever the anagrams of the pattern match with input string. eg.
 in : abcbaabba
 pat : ab
 output : index 0
 index 3
 index 5
 index 7
 */
public class PatternMatch {

    public static void main(String[] args) {
        String s = "abcbaabba";
        String pat = "ab";


        for(int i=0; i < s.length() ; i++) {


            int endIndex = i + pat.length() -1;
            //System.out.println( s.charAt(i)+ ", startindex:" + i + ", endIndex:"+ endIndex);

            if(endIndex > s.length() -1) {
                System.out.println("breaks at i:"+i);
                break;
            }
            else {
                //5, 5+2-1 =6 +1
                int end = (i+pat.length());
                String subString = s.substring(i, end);
                //System.out.println("subString:" + subString + ",i="+i +", end:"+ end);
                if(pat.equals(subString)) {
                    System.out.println("**index: " + i);
                }
            }

        }
    }
}
