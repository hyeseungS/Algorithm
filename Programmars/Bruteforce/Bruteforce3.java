class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total  = 0;
        for(int i = 3; i < 2000; i++) {
            for(int j = 3; j <= i; j++) {
                // 전체 격자 개수
                total = i * j;
                // 찾으면 반복문 나옴
                if((total - (i-2)*(j-2)) == brown && (i-2)*(j-2) == yellow) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}