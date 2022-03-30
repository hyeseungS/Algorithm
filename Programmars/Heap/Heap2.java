import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0; 
        int currentTime = 0; // 현재 시간
        int index = 0; // 현재 jobs 배열 인덱스
        int workTime = 0; // 작업 소요 시간
        // 작업시간을 기준으로 우선순위 큐에 오름차순 정렬
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
 
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1]; 
            }
        });

        // jobs 요청시간 기준으로 오름차순 정렬
        Arrays.sort(jobs, new Comparator<int[]>() { 
            @Override public int compare(int[] o1, int[] o2) { 
                if(o1[0] == o2[0]) { 
                    return o1[1] - o2[1]; 
                }
                else { 
                    return o1[0] - o2[0]; 
                } 
            } 
        });
        
        while(index < jobs.length || !minHeap.isEmpty()) {
            // 현재시간 (currentTime) 이하 요청시간 가지는 job을 minHeap에 넣기
            while (index < jobs.length && jobs[index][0] <= currentTime)
				minHeap.add(jobs[index++]);
			// minHeap 비어있는 경우
			if (minHeap.isEmpty())
				currentTime = jobs[index][0];
			else {
                		// 작업 시간 계산하고 합하기
				int[] job = minHeap.poll();
				answer += currentTime - job[0] + job[1];
                		// 현재 시간 업데이트
				currentTime += job[1];
			}
        }
        
        // 걸린 시간 평균
        return answer/jobs.length;
    }
}
