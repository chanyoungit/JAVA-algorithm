public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int a = i;
                int b = yellow / i;
                int len = 2 * a + 2 * b + 4;
                if (len == brown) {
                    x = a + 2;
                    y = b + 2;
                    break;
                }
            }
        }

        if (y > x) {
            int temp = y;
            y = x;
            x = temp;
        }

        int[] answer = new int[2];
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
