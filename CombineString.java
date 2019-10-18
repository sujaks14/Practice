package test.Array;

import org.json.simple.JSONObject;

public class CombineString {


    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("K1", "Test K1");
        jsonObject.put("K2", "Test K2");
        JSONObject child = new JSONObject();
        child.put("Time", "1990-12-12");
        jsonObject.put("child", child);

        System.out.println("json" + jsonObject.toString());
        System.out.println("json toJsonString()" + jsonObject.toJSONString());

    }

    /**

     Given N strings consisting of ‘R’ and ‘B’. Two strings can be only combined if last character of first string and first character of second string are same. Print the maximum length possible by combining strings.

     Input:
     The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting number of strings and the second line contains N space separated strings of equal length.

     Output:
     For each test case, in a new line print the maximum length possible. If no strings can combine then print "0".

     Constraints:
     1<=T<=100
     2<=N<=1000
     1<=|String length|<=1000

     Example:
     Input:
     2
     3
     RBR BBR RRR
     2
     RRR BBB

     Output:
     9
     0


     */
    public static void main1(String[] args) {
        System.out.println("Value of a :"+test());
    }

    private static int test(){
        int a = 10;
        try {
            return a;
        }finally{
            a= 30;
            return a;
        }

}
}
