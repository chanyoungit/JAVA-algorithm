import java.util.Scanner;

public class P25305_커트라인 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] score = new int[N];
        for (int i = 0; i < N; i++) score[i] = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int max = i;
            for (int j = i + 1; j < N; j++) {
                if (score[max] < score[j]) {
                    int temp = score[max];
                    score[max] = score[j];
                    score[j] = temp;
                }
            }
        }
        System.out.println(score[k - 1]);
    }
}
