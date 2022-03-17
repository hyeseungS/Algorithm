import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> sortQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> originQueue = new LinkedList<>();
        int max = 0;
        int index = 0;
        int indexValue = 0;
        int answer = 1;
        
        // 우선순위를 큐에 저장
        for(int i = 0; i < priorities.length; i++) {
            sortQueue.add(priorities[i]);
            originQueue.add(i);
        }
        
        while(!sortQueue.isEmpty()) {
            // poll 시 해당 인덱스 반환
            index = originQueue.poll();
            indexValue = priorities[index];
            max = sortQueue.peek();
            if(indexValue < max) {
                originQueue.add(index);
            }
            else if(indexValue == max) {
                if(index == location) {
                    return answer;
                }
                else {
                    answer++;
                    sortQueue.poll();
                }
            }
        }
        return answer;
    }
}