class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int[] dp1 = new int[money.length]; // 첫번째 집 터는 경우
        int[] dp2 = new int[money.length]; // 첫번째 집 털지 않는 경우
        
        // 첫번째 집 터는 경우 (마지막 집 털지 않음)
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);
        
        // 첫번째 집 털지 않는 경우 (마지막 집 털 수 있음)
        dp2[0] = 0;
        dp2[1] = money[1];
        
        // 훔칠 수 있는 돈의 최댓값
        for(int i = 2; i < money.length; i++) {
            
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
            answer = Math.max(answer, dp2[i]);
            
            if(i == money.length - 1) break; // 마지막 집
            
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
            answer = Math.max(answer, dp1[i]);
        
        }
        
        return answer;
    }
}