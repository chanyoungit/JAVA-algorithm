import java.util.Scanner;

public class P11689_오일러피 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; i++) P[i] = i;
        for (int i = 2; i <= n; i++) {
            if (P[i] == i) {
                for (int j = i; j <= n; j += i) {
                    P[j] = P[j] - P[j] / i;
                }
            }
        }
        System.out.println(P[n]);
    }
}