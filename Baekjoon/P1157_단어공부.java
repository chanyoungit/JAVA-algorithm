import java.util.Scanner;

public class P1157_단어공부 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char[] c_word = word.toCharArray();
        int[] arr = new int[26];
        for (int i = 0; i < c_word.length; i++) {
            if ((c_word[i] >= 'A') && (c_word[i] <= 'Z'))
                arr[c_word[i] - 65]++;
            else
                arr[c_word[i] - 97]++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[max] < arr[i]) max = i;
        }
        int count = 0;
        boolean result = true;
        for (int i = 0; i < 26; i++) {
            if (arr[max] == arr[i]) {
                count++;
                if (count > 1) {
                    System.out.println("?");
                    result = false;
                    break;
                }
            }
        }
        if (result) {
            int number = max + 65;
            char ch = (char) number;
            System.out.println(ch);
        }
    }
}