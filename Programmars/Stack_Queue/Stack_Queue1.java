import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        int progress = 0; // 먼저 배포되어야 하는 기능의 남은 작업 일수
        int count = 0; // 배포 개수
        
        // 각 기능의 남은 작업 일수 큐에 저장
        for(int i = 0; i < progresses.length; i++) {
            int value = (100-progresses[i])/speeds[i];
            int remainder = (100-progresses[i])%speeds[i];
            if(remainder > 0) value++;
            queue.add(value);
        }
        
        // 각 배포마다 배포되는 기능의 개수
        for(int i = 0; i < progresses.length; i++) {
            count++;
            
            if(count == 1) // 먼저 배포되어야하는 작업
                progress = queue.poll();
            else 
                queue.poll();
            
            if(queue.peek() != null && progress >= queue.peek()) {
                continue;
            }
            
            answer.add(count);
            count = 0;
        }
        
        return answer;
    }
}