import java.util.Scanner;

public class Application_memory_gold3 {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	
    	int[][] MC = new int[N+1][2];
    	
    	for(int i=1; i<=N; i++) {
    		MC[i][0] = sc.nextInt();
    	}
    	
    	int maxC = 0;
    	
    	for(int i=1; i<=N; i++) {
    		MC[i][1] = sc.nextInt();
    		maxC += MC[i][1];
    	}
    	
    	int[][] dp = new int[N+1][maxC + 1];
    	
    	int cost = maxC;
    	
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=maxC; j++) {
    			if(MC[i][1] <= j )
    				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-MC[i][1]] + MC[i][0]);
    			else
    				dp[i][j] = dp[i-1][j];
    			
    			if(dp[i][j] >=M) {
    				cost = cost < j ? cost : j;
    			}
    		}
    	}
    	
    	System.out.println(cost);
    }
}