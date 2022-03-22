import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int firstMin = 0; // 가장 맵지 않은 음식의 스코빌 지수
        int secondMin = 0; // 두번째로 맵지 않은 음시그이 스코빌 지수
        
        // 스코빌지수 오름차순으로 저장 (minHeap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s : scoville) {
            minHeap.add(s);
        }
        
        // firstMin, secondMin 뽑기
        firstMin = minHeap.poll();
        secondMin = minHeap.poll();
        
        // 가장 낮은 것이 K 미만이면 반복
        while(firstMin < K) {
            // 섞는 횟수 +1
            answer++;
            // 스코빌 지수 가장 낮은 2개 섞기
            firstMin += secondMin*2;
            // minHeap 에 남아 있는게 없고,
            if(minHeap.isEmpty()) {
                // 섞은 스코빌 지수가 K보다 미만인 경우 
                // == 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없음
                if(firstMin < K) return -1;
                // K 이상인 경우
                // == 마지막으로 섞은 두개가 스코빌 지수를 K 이상으로 만든 것
                else return answer;
            }
            // 반복을 위해 섞은 음식을 다시 minHeap에 넣기
            minHeap.add(firstMin);
            // 반복을 위해 다음 firstMin, secondMin 뽑기
            firstMin = minHeap.poll();
            secondMin = minHeap.poll();
        }        
        return answer;
    }
}