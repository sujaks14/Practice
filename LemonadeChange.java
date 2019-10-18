package test.Amz;

public class LemonadeChange {

    public static void main(String[] args) {

        int[] arr = new int[]{5,5,5,10,20};

        int balance = 0 ;

       boolean flag = isValid(arr, balance);
        System.out.println("flag: " + flag);

    }

    private static boolean isValid(int[] arr, int balance) {
        for(int i=0; i< arr.length; i++) {
            int amtToReturn = arr[i] - 5;
            if(amtToReturn > 0) {
                balance = balance - amtToReturn;
                if(balance < 0) {
                    System.out.println("--false --" + arr[i] + " at i="+ i);
                    return false;
                }
            }
        }
        return true;
    }
}
