import java.util.Scanner;

public class P1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] in = new int[str.length()];
        for (int i = 0; i < in.length; i++)
            in[i] = Integer.parseInt(str.substring(i, i + 1));

        for (int i = 0; i < in.length; i++) {
            int max = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[max] < in[j]) max = j;
            }
            if (in[i] < in[max]) {
                int temp = in[i];
                in[i] = in[max];
                in[max] = temp;
            }
        }
        for (int i = 0; i < in.length; i++)
            System.out.printf("%d", in[i]);
    }
}