import java.util.Scanner;

public class Matrix_power_gold4 {
	static int[][] mulMatrix(int[][] matI, int[][] matR) {
		int N = matI.length;
		
		int[][] matP = new int[N][N];

        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		for(int k=0; k<N; k++) {
        			matP[i][j] += matI[i][k] * matR[k][j];
        		}
        		matP[i][j] %= 1000;
        	}
        }
		
		return matP;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        long B = sc.nextLong();
        
        int[][] matrixI = new int[N][N];

        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		matrixI[i][j] = sc.nextInt() % 1000;
        	}
        }
        
        int[][] matrixP = new int[N][N];
        boolean chk = true;
        
        while(B>0) {
        	if(B % 2 == 1) {
        		if(chk) {
        			matrixP = matrixI.clone();
        			chk = false;
        		}
        		else matrixP = mulMatrix(matrixP, matrixI);
        	}
        	matrixI = mulMatrix(matrixI, matrixI);
        	
        	B /= 2;
        }
        
        for(int[] ii : matrixP) {
        	for(int i : ii) {
        		System.out.print(i + " ");
        	}
        	System.out.println();
        }
    }
}
