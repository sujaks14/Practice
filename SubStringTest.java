package test.String;

public class SubStringTest {

    //Find if string b is the sub string of a, assume rotated string
    //http://blog.codingforinterviews.com/string-questions/
    public static void main(String[] args) {

    }

    // it is better practice to separate functions
    public static boolean isSubstring (String a, String b) {
        // we first check the length of the strings
        if (a.length() < b.length()) {
            return b.contains(a);
        }
        // feel free to use indexOf
        return a.contains(b);
    }

    // assuming that a is the rotated string
    public static boolean isRotation (String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return isSubstring(a+a,b);
    }

    // the entire function can be optimized to this
    public static boolean isRotation2 (String a, String b) {
        return (a.length() == b.length() && isSubstring(a+a,b));
    }

}
