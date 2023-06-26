import java.util.*;
import java.io.*;

class Main {
	
	// 특정 원소가 속한 집합 찾기
	public static int findParent(int[] parent, int x) {
		// 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
		if(parent[x] != x) parent[x] = findParent(parent, parent[x]);
		return parent[x];
	}
	
	// 두 원소가 속한 집합을 합치기
	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
    
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	    // 노드의 개수 (N)와 간선(Union 연산)의 개수(M)
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[] parent = new int[N + 1]; // 부모 테이블 초기화
	    
	    // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
	    for(int i = 1; i <= N; i++) {
	    	parent[i] = i;
	    }
	    	    
	    // 각 연산을 하나씩 확인
	    for(int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int op = Integer.parseInt(st.nextToken());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        // 합집합(Union) 연산의 경우
	        if(op == 0) unionParent(parent, a, b);
	        // 찾기(Find) 연산의 경우
	        else {
	        	if(findParent(parent, a) == findParent(parent, b)) {
	        		bw.write("YES\n");
	        	}
	        	else {
	        		bw.write("NO\n");
	        	}
	        }
	        
	    }
	    
	    bw.close();
	}
}