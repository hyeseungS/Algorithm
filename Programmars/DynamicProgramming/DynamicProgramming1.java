import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] arr = new Set[9];
        int digit = N;
        
        // N만으로 이루어진 i 자릿수 숫자 
        for(int i = 1; i < 9; i++) {
            arr[i] = new HashSet<>();
            arr[i].add(digit);
            digit = digit * 10 + N;
        }
        
        // 숫자 N을 i번 가지고 만들 수 있는 사칙연산 값
        for(int i = 2; i < 9; i++) {
            for(int j = 1; j < i; j++) {
                for(Integer k : arr[j]) {
                    for(Integer l : arr[i-j]) {
                        arr[i].add(k + l);
                        arr[i].add(k - l);
                        arr[i].add(k * l);
                        if(l != 0)
                            arr[i].add(k / l);
                    }
                }
            }
        }
        
        // N을 사용한 횟수 중 number을 만드는 가장 작은 횟수
        for(int i = 1; i < 9; i++) {
            if(arr[i].contains(number)) {
                return i;
            }
        }
        return answer;
    }
}