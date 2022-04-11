import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0; // 시작 값
        long end = (long) n * times[times.length-1]; // 마지막 값 (가장 오래 걸리는 시간)
        
        // 이분 탐색
        while(start <= end) {
            long count = 0; // 총 심사 받는 사람 수
            long mid = (start + end) / 2; // 중간값
            // 총 심사 받는 사람 수 계산
            for(int i = 0; i < times.length; i++) {
                count += mid / times[i];  
            }
            // 시간을 더 줄여 걸리는 시간 최소로 만들어야 함.
            if(count >= n) {
                end = mid - 1;
                answer = mid;
            }
            // 시간을 더 늘려야 함.
            else { 
                start = mid + 1;
            }
        }
        return answer;
    }
}