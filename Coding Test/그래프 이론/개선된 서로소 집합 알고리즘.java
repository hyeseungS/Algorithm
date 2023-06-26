import java.util.*;
import java.io.*;

class Main {
	
	// 특정 원소가 속한 집합을 찾기
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
	    
	    // 노드의 개수 (V)와 간선(Union 연산)의 개수(E)
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    int[] parent = new int[V + 1]; // 부모 테이블 초기화하기
	    
	    // 부모 테이블 상에서, 부모를 자기 자신으로 초기화
	    for(int i = 1; i <= V; i++) {
	    	parent[i] = i;
	    }
	    
	    // Union 연산을 각각 수행
	    for(int i = 0; i < E; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        unionParent(parent, a, b);
	    }
	    
	    // 각 원소가 속한 집합 출력하기
	    bw.write("각 원소가 속한 집합: ");
	    for(int i = 1; i <= V; i++) {
	    	bw.write(findParent(parent, i) + " ");
	    }
	    bw.write("\n");
	    
	    // 부모 테이블 내용 출력하기
	    bw.write("부모 테이블: ");
	    for(int i = 1; i <= V; i++) {
	    	bw.write(parent[i] + " ");
	    }
	    bw.write("\n");
	    
	    bw.close();
	}
}