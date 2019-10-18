package test.Amz;

/**
 https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/

 https://www.careercup.com/page?pid=amazon-interview-questions&sort=recentcomments


 Given a string, count number of subsequences of the form aibjck,
 i.e., it consists of i ’a’ characters, followed by j ’b’ characters,
 followed by k ’c’ characters where i >= 1, j >=1 and k >= 1.

 Note: Two subsequences are considered different if the set of array indexes
 picked for the 2 subsequences are different.

 Expected Time Complexity : O(n)

 Examples:

 Input  : abbc
 Output : 3
 Subsequences are abc, abc and abbc

 Input  : abcabc
 Output : 7
 Subsequences are abc, abc, abbc, aabc
 abcc, abc and abc


 Input : abcabc

 Output : 7

 Explanation

 Valid sub sequences are(1-based indexing):

 {1,2,3}

 {1,2,6}

 {1,5,6}

 {4,5,6}

 {1,2,5,6}

 {1,4,5,6}

 {1,2,3,6}

 thought process:-
 aibjck

 traverse check if a is follewed by b and b followed by c


 followerMap
 prevChar = '\null';
 for(int i=0; i < len; i+2) {
 followerMap.put(charAt(i), prevChar);   followerMAp -{a:null, b:a, c:b}

 }

 char prevChar = strChars.charAt(0);
 int count = 0 ;

 List<String> list = new ArrayList<>();
 StringBuilder s = new StringBuilder();
 for(i=1; i < s.length(); i++) {
   char currChar = s.charAt(i);
   if(currChar != prevChar) {
     if(followMap.get(prevChar) == currChar) {
        for(int cnt =0; cnt < count; cnt++)
            s.append(prevChar)
        }

    else {

        }
    count = 0;
    }


    if(currChar = lastChar) {
       reset StringBuilder
       reset count
    }

 }

 }

 */
public class GoodSequence {
}
