package test.Array;

public class RotateArray {



    static void leftRotate(int arr[], int d, int n)
    {
        int i;
        for (i = 0; i < d; i++)
            leftRotatebyOne(arr, n);
    }

   static void leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp = arr[0];
        System.out.println("temp: " + temp);

        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        System.out.println("Enters main");

        int[] arr = new int[]{1,2,3,4,5,6,7};
        leftRotate(arr, 2, arr.length);
        System.out.println("print");
        for(int i=0; i< arr.length; i++) {
            System.out.println(""+ arr[i]);
        }


        System.out.println("Exits main");
    }
}
