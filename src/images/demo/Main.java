package images.demo;

import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left>=right) return;
        int mid = left+right>>1;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        int index = 0 ;
        int temp[] = new int[right-left+1];
        int i = left;
        int j = mid+1;
        while(i <= mid && j <=right )
        {
            if(arr[i] <= arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
            }
        }
        while( i <= mid){
            temp[index++] = arr[i++];
        }

        while( j <= right){
            temp[index++] = arr[j++];
        }
        int x =0 ;
        for(i = left; i <= right ; i++){
            arr[i] = temp[x++];
        }
    }
}