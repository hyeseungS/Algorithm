import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
    
    private String name;
    private int score;
    
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return this.score;
    }
    
    // 정렬 기준은 '성적이 낮은 순서'
    @Override
    public int compareTo(Student other) {
        if(this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

class Main {
	public static void main (String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    
	    // N을 입력받기
	    int N = Integer.parseInt(br.readLine());
	    
	    // N명의 학생 정보를 입력받아 리스트에 저장
	    List<Student> students = new ArrayList<>();
	    
	    for(int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
	    }
	    
	    Collections.sort(students);
	    
	    for(int i = 0; i < students.size(); i++) {
	        bw.write(students.get(i).getName() + " ");
	    }
	    
	    bw.close();
	}
}