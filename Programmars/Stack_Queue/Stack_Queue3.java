import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); 
        
        // 시간은 한번 이동할 때 1초 
        for (int i = 0; i < bridge_length - 1; i++) { 
            // 처음 다리 위는 비어있음. (0) 
            // 0번째 트럭은 무조건 다리 위에 있어서 -1.
            bridge.add(0); 
        } 
        
        // 0번째 트럭은 무조건 다리 위에 있음.  
        int currentWeights = truck_weights[0]; bridge.add(currentWeights); 
        // 현재 다리 위에 있는 트럭은 0 이고 다음에 올 트럭 1. 
        int index = 1; 
        // 다리 위에 0번째 트럭이 올라갔기 때문에 1부터 시작 (0초가 지남) 
        int answer = 1;
        
        // 다리에 트럭이 있는 경우
        while (!bridge.isEmpty()) { 
            // 시간 증가 
            answer++; 
            
            // 다리 위에 있는 첫번째 트럭이 빠짐. or
            // 다리 위에 트럭이 없으면 truck은 0. 
            int truck = bridge.poll(); 
            
            currentWeights -= truck; 
            
            // 대기하는 트럭이 남아 있다면 
            if (index < truck_weights.length) { 
                
                // 현재 무게 + 대기하는 첫번째 트럭의 무게가 weight 보다 작은 경우 
                // 다음 트럭 (대기하는 첫번째 트럭) 은 다리 위에 올 수 있음. 
                if (currentWeights + truck_weights[index] <= weight) { 
                    currentWeights += truck_weights[index]; 
                    // index 를 증가시켜 다음에 올 트럭 index 지정. 
                    bridge.add(truck_weights[index++]); 
                } 
                else { 
                    // 다리 위에 있는 트럭이 앞으로 이동. (대기 트럭 다리 위에 못 옴.) 
                    // 다리 위에 새 트럭은 오지 않음. (0은 트럭이 없음을 의미) 
                    bridge.add(0); 
                } 
            } 
        } 
        return answer; 
    }

}