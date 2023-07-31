import java.util.Scanner;

public class Balance_scale_gold3 {
	static int[][] dp;
	static int[] weight;
	static int N;
	
	static void chkW(int n, int num) {
		if(dp[n][num] == 1)
			return;
		
		dp[n][num] = 1;
		
		if(n == N)
			return;
		
		chkW(n+1, num + weight[n]);
		chkW(n+1, num);
		chkW(n+1, Math.abs(num - weight[n]));
		
	}
	
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	StringBuilder sb = new StringBuilder();
    	
    	N = sc.nextInt();
    	
    	weight = new int[N];
    	
    	int sum=0;
    	
    	for(int i=0; i<N; i++) {
    		weight[i] = sc.nextInt();
    		sum += weight[i];
    	}

    	dp = new int[N+1][sum+1];
		
		chkW(0, 0);
    	
    	int M = sc.nextInt();
    	
    	int marble;
    	for(int i=0; i<M; i++) {
    		marble = sc.nextInt();
    		
    		if(marble > sum) {
    			sb.append("N ");
    		} else {
    			if(dp[N][marble] == 1) { 
    				sb.append("Y ");
    			} else {
    				sb.append("N ");
    			}
    		}
    	}

    	System.out.println(sb);
    }
}