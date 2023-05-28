class Main {
	public static void main (String[] args) throws Exception {
	    int N = 1260, count = 0;
	    
	    // 큰 단위의 화폐부터 차례대로 확인
	    int[] coinTypes = {500, 100, 50, 10};
	    
	    for (int coin : coinTypes) {
	        count += N / coin; // 해당 화폐로 거슬러 줄 수 있는 동전의 개수 세기
	        N %= coin;
	    }
	    
	    System.out.println(count);
	    
	}
}