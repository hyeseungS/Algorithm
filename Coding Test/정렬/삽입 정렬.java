import java.util.*;

public class Main {
	public static void main (String[] args) {
	    
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        
        for(int i = 1; i < arr.length; i++) {
            // 인덱스 i부터 1까지 감소하며 반복하는 문법
            for(int j = i - 1; j >= 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                if(arr[j] < arr[j - 1]) {
                    swap(j, j - 1, arr);
                }
                // 자기보다 작은 데이터 만나면 그 위치에서 멈춤
                else {
                    break;
                }
            }
        }
        
		for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
	}
	
	public static void swap (int i, int j, int[] arr) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}