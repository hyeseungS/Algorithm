class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total  = brown + yellow; // 전체 격자 개수
        for(int i = 3; i < 2000; i++) {
            // 찾으면 반복문 나옴
            if((total - (i-2)*(total/i-2)) == brown && (i-2)*(total/i-2) == yellow) {
                answer[0] = total/i;
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}