import java.io.*;
import java.util.*;

public class P1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        double[] data = new double[N];
        for (int i = 0; i < N; i++) {
            data[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                stack.push(data[arr[i] - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (arr[i]) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        double result = stack.peek();
        System.out.printf("%.2f", result);
    }
}