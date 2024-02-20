import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int value = 1;
        boolean result = true;
        Stack<Integer> stackInt = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num >= value) {
                while (num >= value) {
                    stackInt.push(value++);
                    sb.append("+\n");
                }
                stackInt.pop();
                sb.append("-\n");
            } else if (num < value) {
                int n = stackInt.pop();
                if (num < n) {
                    sb.setLength(0);
                    sb.append("NO\n");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) System.out.println(sb);
        else System.out.println(sb);
    }
}