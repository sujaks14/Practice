package test.String;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static void main(String a[]) {

        String s= "s";
        String s1 = "suja";
        boolean startsWith =  s1.startsWith(s);
        System.out.println("startswith:" + startsWith);

        List<String> output = StringPermutations.generatePermutations("xyz");
        System.out.println("Result size: "+output.size());
        output.stream().forEach(System.out::println);
        System.out.println("------------------");

        output = StringPermutations.generatePermutations("ABCD");
        System.out.println("Result size: "+output.size());
        output.stream().forEach(System.out::println);
    }

    public static List<String> generatePermutations(String input) {

        List<String> strList = new ArrayList<String>();
        StringPermutations.permutations("", input, strList);

        return strList;
    }

    private static void permutations(String consChars, String input, List<String> opContainer) {

        if(input.isEmpty()) {
            opContainer.add(consChars);
            return;
        }

        for(int i=0; i<input.length(); i++) {
            permutations(consChars+input.charAt(i),
                    input.substring(0, i)+input.substring(i+1),
                    opContainer);
        }
    }
}