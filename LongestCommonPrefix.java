package test.String;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"aleets","bleet","leetcode"};
        //String prefix = longestCommonPrefix(strs);
        //System.out.println("prefix:  " + prefix);

        int index = "leet".indexOf("leets");
        System.out.println("index: " + index);

        String sub = "leet".substring(0,0);
        System.out.println("sub:" + sub);


    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
