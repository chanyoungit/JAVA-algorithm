import java.util.Scanner;

public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            if (max < score[i]) max = score[i];
        }
        float sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (float) score[i] / max * 100;
        }
        System.out.println(sum / N);
    }
}