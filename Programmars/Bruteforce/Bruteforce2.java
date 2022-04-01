import java.util.*;

class Solution {
    boolean[] visit = new boolean[10000000];
    List<Integer> arrNum = new ArrayList<>();
    public int solution(String numbers) {
        int answer = 0;
        String tmp = "";
        for(int i = 0; i < numbers.length(); i++){
            dfs(numbers, tmp, i + 1);
        }
        for(int number : arrNum) {
            if(isPrime(number)) answer++;
        }
        return answer;
    }
    
    // 모든 숫자 조합 만들기 (dfs)
    public void dfs(String numbers, String tmp, int depth) {
        if (tmp.length() == depth) {
            int number = Integer.parseInt(tmp);
            if(!arrNum.contains(number)) arrNum.add(number);
            return;
        }
        else {
            for(int i = 0; i < numbers.length(); i++) {
                if(!visit[i]) {
                    visit[i] = true;
                    tmp += numbers.charAt(i);
                    dfs(numbers, tmp, depth);
                    visit[i] = false;
                    tmp = tmp.substring(0, tmp.length() - 1);
                }
            }
        }
    }
    
    // 소수찾기
    boolean isPrime(int number) {
        if(number == 0 || number ==1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}