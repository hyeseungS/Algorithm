import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int start = 0;
        int end = distance;
        while(start <= end) {
            int count = 0; // 제거 개수
            int prev = 0; // 이전 바위 놓인 위치
            int mid = (start + end) / 2; // 거리의 최솟값
            
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid) { // 최솟값보다 작으면 제거
                    count++; // 제거 개수 증가
                    if(count > n) break; // 거리의 최솟값 아님
                }
                else
                    prev = rocks[i]; // 최솟값보다 크면 제거 X
            }
            if(count > n) { // mid(거리의 최솟값)을 너무 크게 잡은 것 
                end = mid - 1;
            }
    	    else { // 구한 mid가 최댓값인지 판단
                answer = answer > mid? answer : mid; 
                start = mid + 1;
            }
        }
        
        return answer;
    }
}