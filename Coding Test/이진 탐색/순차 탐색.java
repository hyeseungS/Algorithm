import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
	    st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    String target = st.nextToken();
	    
	    System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
	    st = new StringTokenizer(br.readLine());
	    
	    String[] array = new String[n];
	    for(int i = 0; i < n; i++) {
	        array[i] = st.nextToken();
	    }
	    
	    int result = sequentialSearch(n, target, array);
	    if(result == -1) {
	    	bw.write("None");
	    }
	    else bw.write(result + "");
	    
	    bw.close();
	}
	
	public static int sequentialSearch(int n, String target, String[] array) {
	    for(int i = 0; i < n; i++) {
	        if (array[i].equals(target))
	        	return i + 1;
	    }
	    
	    return -1;
	}
}