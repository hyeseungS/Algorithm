import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int count = 0; // 남은 숫자 개수
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최솟값을 구하기 위한 우선순위 큐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최솟값을 구하기 위한 우선순위 큐
        
        // 연산
        for(String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation); 
            String op = st.nextToken(); // 연산 ("I" or "D")
            Integer num = Integer.parseInt(st.nextToken()); // 숫자 (숫자 or 1 or -1)
            
            // 삽입 연산의 경우
            if(op.equals("I")) {
                count++;
                minHeap.add(num);
                maxHeap.add(num);
            }
            
            // 삭제 연산의 경우
            else {
                // 빈 큐라면 해당 연산 무시
                if(count == 0) continue;
                count--;
                // 최솟값 삭제 연산의 경우
                if(num == -1) minHeap.poll();
                // 최댓값 삭제 연산의 경우
                else maxHeap.poll();
                // 빈큐가 되면 minHeap, maxHeap 모두 삭제
                if(count == 0) {
                    minHeap.clear();
                    maxHeap.clear();
                }    
            }
        }
        
        // 결과값
        // 빈 큐의 경우
        if(count == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        
        // 큐에 한 개 남아있을 경우 (최댓값 == 최솟값)
        else if(count == 1) {
            if(maxHeap.size() > minHeap.size()) 
                answer[0] = maxHeap.poll();
            else
                answer[0] = minHeap.poll();
            answer[1] = answer[0];
        }
        
        // 그 외
        else {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        return answer;
    }
}