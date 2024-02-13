import java.util.Scanner;

public class P11659_구간합구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] sum = new int[N + 1];
        sum[0] = 0;
        for (int i = 1; i <= N; i++) {
            sum[i] = sc.nextInt() + sum[i - 1];
        }
        while (M-- > 0) {
            System.out.println((-sum[sc.nextInt()-1]+sum[sc.nextInt()]));
        }
    }
}
