import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = new int[3];
        int max = 0;
        int maxIndex = 0;
        
        // 1, 2, 3번 수포자 정답 개수
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i%5]) count[0]++;
            if(answers[i] == b[i%8]) count[1]++;
            if(answers[i] == c[i%10]) count[2]++;
        }
        
        // 최댓값 찾기
        for(int i = 0; i < 3; i++) {
            if(max < count[i]) {
                max = count[i]; // 최댓값 저장
                maxIndex = i; // 최댓값 인덱스 저장
            }
        }
        
        // 찾은 최댓값 정답에 저장
        answer.add(++maxIndex);
        
        // 동점자 찾기
        for(int i = maxIndex; i < 3; i++) {
            if(max == count[i]) {
                answer.add(i+1); // 찾은 동점자 정답에 저장
            }
        }
        
        return answer;
    }
}