package test.Tree;

public class MaxPathSumInBinaryTree {

    public static void main(String[] args) {
        System.out.println("Enters main");
        method(null);

        long longWithL = 1000*60*60*24*365L;
        long longWithoutL = 1000*60*60*24*365;
        System.out.println(longWithL);
        System.out.println(longWithoutL);

        System.out.println("Exits main");
    }


    public static void method(Object o) {
        System.out.println("Object impl");
    }
    public static void method(String s) {
        System.out.println("String impl");
    }

    
}
