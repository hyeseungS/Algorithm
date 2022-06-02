class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = lost.length;
        // 여분의 체육복을 가져왔지만 체육복을 잃어버린 학생
        for(int l = 0; l < lost.length; l++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = reserve[j] = -1;
                    answer--;
                    // break;
                }
            }
        }
        System.out.println(answer);
        // 1 , 2, 3, 4, 5  /  1,2, 3, 5,6, 7, 8
        // -1, +1했을시 같다면 체육복 빌려줄 수 있음
        for(int i=0; i<reserve.length; i++){
            if(reserve[i] == -1) continue;
            for(int j=0; j<lost.length; j++){
                if(lost[j] == -1) continue;
                if(reserve[i] - 1 == lost[j] || reserve[i] + 1 == lost[j]){
                    reserve[i] = lost[j] = -1;
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
        return n - answer;
    }
}