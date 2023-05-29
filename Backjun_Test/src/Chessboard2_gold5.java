import java.util.Scanner;

public class Chessboard2_gold5 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();        
     
        char[][] frame = new char[N][M];
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(i % 2 == 0) {
        			if(j % 2 == 0) {
        				frame[i][j] = 'B';
        			} else {
        				frame[i][j] = 'W';
        			}
        		} else {
        			if(j % 2 == 0) {
        				frame[i][j] = 'W';
        			} else {
        				frame[i][j] = 'B';
        			}
        		}
        	}
        }
        
        int[][] chess = new int[N][M];
        
        String input;
        
        for(int i=0; i<N; i++) {
        	input = sc.next();
        	for(int j=0; j<M; j++) {
        		if(j == 0) {
        			if(i == 0) {
        				if(input.charAt(j) == frame[i][j]) {
        					chess[i][j] = 0;
        				} else {
        					chess[i][j] = 1;
        				}
        			} else {
        				if(input.charAt(j) == frame[i][j]) {
        					chess[i][j] = chess[i-1][j];
        				} else {
        					chess[i][j] = chess[i-1][j] + 1;
        				}
        			}
        		} else {
        			if(i == 0) {
        				if(input.charAt(j) == frame[i][j]) {
        					chess[i][j] = chess[i][j-1];
        				} else {
        					chess[i][j] = chess[i][j-1] + 1;
        				}
        			} else {
        				if(input.charAt(j) == frame[i][j]) {
        					chess[i][j] = chess[i-1][j] + chess[i][j-1] - chess[i-1][j-1];
        				} else {
        					chess[i][j] = chess[i-1][j] + chess[i][j-1] - chess[i-1][j-1] + 1;
        				}
        			}
        		}
        		
        	}
        }
        
        int minC = 4000000;
        
        int tmp = chess[K-1][K-1];
        if(tmp > K*K/2) tmp = K*K - tmp;
        minC = Math.min(minC, tmp);
        
//      i == 0, j != 0
        for(int j=1; j<=M-K; j++) {
        	tmp = chess[K-1][j+K-1] - chess[K-1][j-1];
        	if(tmp > K*K/2) tmp = K*K - tmp;
        	minC = Math.min(minC, tmp);
        }

//      i != 0, j == 0
        for(int i=1; i<=N-K; i++) {
        	tmp = chess[i+K-1][K-1] - chess[i-1][K-1];
        	if(tmp > K*K/2) tmp = K*K - tmp;
        	minC = Math.min(minC, tmp);
        }
        
        for(int i=1; i<=N-K; i++) {
        	for(int j=1; j<=M-K; j++) {
        		tmp = chess[i+K-1][j+K-1] - chess[i-1][j+K-1] - chess[i+K-1][j-1] + chess[i-1][j-1];
        		if(tmp > K*K/2) tmp = K*K - tmp;
        		minC = Math.min(minC, tmp);
        	}
        }
        
        System.out.println(minC);
    }
}