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
	    
	    boolean cycle = false; // 사이클 발생 여부
	    
	    for(int i = 0; i < E; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        // 사이클이 발생한 경우 종료
	        if(findParent(parent, a) == findParent(parent, b)) {
	        	cycle = true;
	        	break;
	        }
	        // 사이클이 발생하지 않았다면 합집합(Union) 연산 수행
	        else {
	        	unionParent(parent, a, b);
	        }
	    }
	    
	    if(cycle) bw.write("사이클이 발생했습니다.");
	    else bw.write("사이클이 발생하지 않았습니다.");
	    
	    bw.close();
	}
}