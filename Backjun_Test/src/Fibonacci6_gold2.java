import java.util.Scanner;

public class Fibonacci6_gold2 {
	static long MOD = 1000000007;
    
    public static long[][] power(long[][] m, long n) {
        if (n == 1) {
            return m;
        } else if (n % 2 == 1) {
            return multiply(m, power(m, n - 1));
        } else {
            long[][] half = power(m, n / 2);
            return multiply(half, half);
        }
    }
    
    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	long n = sc.nextLong();
    	
    	if (n == 0) {
    		System.out.println("0");
    		return;
    	} else if (n == 1 || n == 2) {
    		System.out.println("1");
    		return;
    	}
    	
    	long[][] matrix = {{1, 1}, {1, 0}};
    	long[][] result = power(matrix, n - 1);
    	
    	System.out.println(result[0][0]);
    }
}