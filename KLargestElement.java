package test.Array;

public class KLargestElement {

    public static void main(String[] args) {
        int[] arr = new int[] {11,4,5,7,6,8,1,2};

        int k =3;
        //bubble sort
        int n = arr.length;
        for(int i=0; i < k; i++) {
            for(int j=i+1; j <= n-i-1; j++) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println("");
        for(int i=0; i < arr.length; i++) {
            System.out.println("array " + arr[i]);
        }

    }


    private static void swap (int[] arr, int i, int j) {
        if(arr == null || arr.length == 0)
            return;
        if(i > arr.length -1 || j > arr.length -1 || i < 0 || j <0)
            return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

