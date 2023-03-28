import java.util.Scanner;

public class Test2 {
    static String[] makeStar(int N) {
        String s = "";

        if (N == 1) {
            String[] ss = {"*"};

            return ss;
        }

        String[] ss = new String[N];

        String[] ex = makeStar(N/3);

        for (int i=0; i<N; i++) {
            ss[i] = "";
            for (int j=0; j<3; j++) {
                if ((i / (N/3) == 1) && (j == 1)) {
                    ss[i] += ex[i%(N/3)].replace("*", " ");
                } else {
                    ss[i] += ex[i%(N/3)];
                }
            }
        }

        return ss;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        String[] ss = makeStar(N);

        for (String s : ss) {
            sb.append(s + "\n");
        }

        System.out.println(sb);


    }
}
