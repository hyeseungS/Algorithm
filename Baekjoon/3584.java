import java.io.*;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        int sLength = Integer.parseInt(st.nextToken());
        String W = br.readLine();
        String S = br.readLine();
        
        int[] wArr = new int[52];
        int[] sArr = new int[52];
        
        for(char c : W.toCharArray()) {
            putWord(c, wArr, 1);
        }
        
        int start = 0, cnt = 0, size = 0;
        for(int i = 0; i < S.length(); i++) {
            char sc = S.charAt(i);
            putWord(sc, sArr, 1);
            size++;
            
            if(size == W.length()) {
                if(Arrays.equals(wArr, sArr)) {
                    cnt++;
                }
                putWord(S.charAt(start), sArr, -1);
                start++;
                size--;
            }
        }
        bw.write(cnt + "");
        bw.close();
    }
    static void putWord(char word, int[] arr, int dif) {
        if('a' <= word && word <= 'z') {
            arr[word - 'a'] += dif;
        }
        else {
            arr[word - 'A' + 26] += dif;
        }
    }
}