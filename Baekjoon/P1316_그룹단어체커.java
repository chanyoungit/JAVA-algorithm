import java.util.Scanner;

public class P1316_그룹단어체커 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        boolean abs = true;
        int result = 0;
        for (int i = 0; i < str.length; i++) str[i] = sc.next();

        for (int i = 0; i < str.length; i++) {
            char[] ch = str[i].toCharArray();
            abs = true;
            for (int j = 0; j < ch.length - 1; j++) {
                for (int k = j + 1; k < ch.length; k++) {
                    if (ch[j] == ch[k]) {
                        if (Math.abs(j - k) != 1) abs = false;
                        else break;
                    }
                }
            }
            if (abs) result++;
        }
        System.out.println(result);
    }
}
