import java.util.Scanner;

public class Downhill_gold3 {

	static int M;
	static int N;
	static int[][] testMap;
	static Integer[][] dp;
	
	static void calMap(int i, int j) {
		if(i == 1 && j == 1) {
			dp[1][1] = 1;
			return;
		} 
		dp[i][j] = 0;
		
		// 아래
		if(testMap[i+1][j] != 0 && testMap[i+1][j] > testMap[i][j]) {
			if(dp[i+1][j] == null) {
				calMap(i+1, j);
			}
			dp[i][j] += dp[i+1][j];
		}
		
		// 위
		if(testMap[i-1][j] != 0 && testMap[i-1][j] > testMap[i][j]) {
			if(dp[i-1][j] == null) {
				calMap(i-1, j);
			}
			dp[i][j] += dp[i-1][j];
		}
		
		// 오른쪽
		if(testMap[i][j+1] != 0 && testMap[i][j+1] > testMap[i][j]) {
			if(dp[i][j+1] == null) {
				calMap(i, j+1);
			}
			dp[i][j] += dp[i][j+1];
		}
		
		// 왼쪽
		if(testMap[i][j-1] != 0 && testMap[i][j-1] > testMap[i][j]) {
			if(dp[i][j-1] == null) {
				calMap(i, j-1);
			}
			dp[i][j] += dp[i][j-1];
		}
		
	}
	
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	M = sc.nextInt();
    	N = sc.nextInt();
    	
    	testMap = new int[M+2][N+2];
    	
    	for(int i=1; i<=M; i++) {
    		for(int j=1; j<=N; j++) {
    			testMap[i][j] = sc.nextInt();
    		}
    	}
    	
    	dp = new Integer[M+2][N+2];
    	
    	calMap(M, N);
    	
    	System.out.println(dp[M][N]);
    }
}
