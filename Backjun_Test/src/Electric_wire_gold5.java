import java.util.Scanner;

public class Electric_wire_gold5 {
	static int[] dp;
	static int[][] lines;
	
	
	static int countC(int n) {
		if(dp[n] == 0) {
			dp[n] = 1;
			for(int i=0; i<lines.length; i++) {
				if(lines[n][0] < lines[i][0] && lines[n][1] < lines[i][1]) {
					dp[n] = Math.max(dp[n], countC(i) + 1);
				} 
			}
		}
		
		return dp[n];
	}
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        lines = new int[N][2];
        
        dp = new int[N];
        
        for(int i=0; i<N; i++) {
        	lines[i][0] = sc.nextInt();
        	lines[i][1] = sc.nextInt();
        	
        }
        for(int i=0; i<N; i++) {
        	countC(i);
        }
        
        int min = 100;
        
        for(int i : dp) {
        	min = Math.min(N-i, min);
        }
      
        System.out.println(min);
    }
}
