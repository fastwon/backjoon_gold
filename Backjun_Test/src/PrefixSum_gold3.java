import java.util.Scanner;

public class PrefixSum_gold3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        long[] mods = new long[M];
        mods[0] = 1;
        long sum = 0, count = 0;
        for (int num : nums) {
            sum = (sum + num) % M;
            mods[(int) sum]++;
        }

        for (long m : mods) {
            count += (m * (m - 1)) / 2;
        }

        System.out.println(count);
    }
}
