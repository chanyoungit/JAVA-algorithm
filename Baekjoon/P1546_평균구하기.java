import java.util.Scanner;

public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double sum = 0;
        double max = 0;
        for (int i = 0; i < N; i++) {
            double num = sc.nextInt();
            if (num > max) max = num;
            sum += num;
        }
        System.out.println(sum * 100 / max / N);
    }
}
