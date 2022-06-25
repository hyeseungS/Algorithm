import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        List<Integer> arr[] = new ArrayList[triangle.length];
        
        // 삼각형 바닥 숫자 저장
        for(int i = triangle.length-1; i >= 0; i--) {
            arr[i] = new ArrayList<>();
            if(i == triangle.length-1) {
                for(int j = 0; j < triangle[i].length; j++) {
                    arr[i].add(triangle[i][j]);
                }
            }
        }
        
        // 삼각형 각 숫자와 각 숫자의 자식 노드 합 중 큰 것과 합
        for(int i = triangle.length-2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                int max = arr[i+1].get(j) >= arr[i+1].get(j+1)? arr[i+1].get(j) : arr[i+1].get(j+1);
                arr[i].add(triangle[i][j] + max);
            }
        }
        return arr[0].get(0);
    }
}