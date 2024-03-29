import java.util.*;

public class Main {
	public static void main (String[] args) {
	    
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        
        quickSort(arr, 0, arr.length - 1);
        
		for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
	}
	
	public static void swap (int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	public static void quickSort(int[] arr, int start, int end) {
	    if(start >= end) return; // 원소가 1개인 경우 종료
	    int pivot = start, left = start + 1, right = end;
	    while(left <= right) {
	       // 피벗보다 큰 데이터를 찾을 때까지 반복
	       while(left <= end && arr[left] <= arr[pivot]) left++;
	       // 피벗보다 작은 데이터를 찾을 때까지 반복
	       while(right >= start && arr[right] >= arr[pivot]) right--;
	       // 엇갈렸다면 작은 데이터와 피벗 교체
	       if(left > right) {
	           swap(arr, right, pivot);
	       }
	       // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
	       else {
	           swap(arr, left, right);
	       }
	    }
	    // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
	    quickSort(arr, start, right - 1);
	    quickSort(arr, right + 1, end);
	}
}