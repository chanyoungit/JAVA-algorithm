import java.util.Scanner;

public class P2018_수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int count = 1;
        int start_index = 0, end_index = 0;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
