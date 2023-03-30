import java.util.Scanner;

public class N_Queen_gold4 {
	static int[][] chess;
    static int count;
    static int ans = 0;
	
    static void fillChess(int a, int b) {
    	if (a == chess.length - 1) {
    		aa : for (int i = 0; i < chess.length; i++) {
    			 
    			for (int j = 0; j < a; j++) {
    				if (chess[j][i] == 1) {
    					continue aa;
    				}
    				if (j < i) {
        				if (chess[a - j - 1][i-1-j] == 1) {
        					continue aa;
        				}
        			}
        			if (i + j <= chess.length - 2) {
        				if (chess[a - j - 1][i+1+j] == 1) {
        					continue aa;
        				}
        			}
				}
    			
    			chess[a][i] = 1;
    			count++;
    			if (count == chess.length) {
    				ans++;
    			}
    			chess[a][i] = 0;
    			count--;
    			return;
    		}
		}
    	
    	if (a == 0) {
			chess[a][b] = 1;
			fillChess(a+1, 0);
		}
    	else {
    		aa : for (int i = 0; i < chess.length; i++) {
    			
    			for (int j = 0; j < a; j++) {
    				if (chess[j][i] == 1) {
    					continue aa;
    				}
    				if (j < i) {
        				if (chess[a - j - 1][i-1-j] == 1) {
        					continue aa;
        				}
        			}
        			if (i + j <= chess.length - 2) {
        				if (chess[a - j - 1][i+1+j] == 1) {
        					continue aa;
        				}
        			}
				}
    			
    			chess[a][i] = 1;
    			count++;
    			fillChess(a+1, 0);
    			chess[a][i] = 0;
    			count--;
    		}
		}
	}
    	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        short N = sc.nextShort();
        
        chess = new int[N][N];
        
        if (N == 1) {
			ans = 1;
		}
        
        else {
        	for (int i = 0; i < chess.length; i++) {
        		count = 1;
        		fillChess(0, i);
        		chess[0][i] = 0;
        	}
		}
        
        System.out.println(ans);
    }
}
