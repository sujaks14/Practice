package test.Array;

public class SwapAndMakeMaxNum {

    public static void main(String[] args) {
        System.out.println("Enters main");
        String s = "25167849";

    int k = 3;
    int swapCount = 0;

//       char[] cArr = s.toCharArray();
//        for(int i=0; i < cArr.length; i++) {
//            int num = Character.getNumericValue(cArr[i]);
//
//            int maxElement = -1;
//            int maxIndex = -1;
//
//            for(int  j= i+1; j < cArr.length; j++) {
//                int temp = Character.getNumericValue(cArr[j]);
//                if(num < temp && maxElement < temp) {
//                    maxElement = temp;
//                    maxIndex = j;
//                }
//            }
//
//            if(maxIndex > -1) {
//                char c = cArr[i];
//                cArr[i] = cArr[maxIndex];
//                cArr[maxIndex] = c;
//
//                swapCount++;
//                if (swapCount == k)
//                    break;
//
//            }
//            System.out.println("after first iteration:" + new String(cArr));
//
//        }
//        System.out.println("Exits main: " + new String(cArr));
//


        swapCount = 0;
        char[] cArr1 = s.toCharArray();
        for(int i=0; i < k ; i++) {
            int num1 = Character.getNumericValue(cArr1[i]);
            for (int j = i + 1; j < cArr1.length; j++) {
                int num2 = Character.getNumericValue(cArr1[j]);
//                System.out.println("num2:" + num2);
                if (num1 < num2) {
                    char temp = cArr1[i];
                    cArr1[i] = cArr1[j];
                    cArr1[j] = temp;
                }
            }
            System.out.println("after j: " + new String(cArr1));
        }
        System.out.println("CArr1: " + new String(cArr1));

    }
}
