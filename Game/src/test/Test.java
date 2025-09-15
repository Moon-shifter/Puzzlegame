package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            int p = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
        }

        int[][] arr2D = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            arr2D[i / 4][i % 4] = arr[i];
        }
        int x=3;
        Random random= new Random();
        while (x!=0){
            x=random.nextInt(4);
            System.out.print(x+" ");
        }


    }
}



