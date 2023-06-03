import java.util.*;

public class Main {
	public static void main (String[] args) {
	    
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i; // 가장 작은 원소의 인덱스
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, arr);
        }
        
		for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
	}
	
	public static void swap (int i, int minIndex, int[] arr) {
	    int temp = arr[i];
	    arr[i] = arr[minIndex];
	    arr[minIndex] = temp;
	}
}