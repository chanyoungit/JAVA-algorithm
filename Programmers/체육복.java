import java.util.Arrays;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] bl = new boolean[n + 1];
        int count = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            bl[reserve[i]] = true;
        }

        for (int i = 0; i < lost.length; i++) {
            if (bl[lost[i]]) {
                count++;
                bl[lost[i]] = false;
                lost[i] = -1;
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) {
                continue;
            } else if (lost[i] == n) {
                if (bl[lost[i] - 1]) {
                    count++;
                    bl[lost[i] - 1] = false;
                }
            } else {
                if (bl[lost[i] - 1]) {
                    count++;
                    bl[lost[i] - 1] = false;
                } else if (bl[lost[i] + 1]) {
                    count++;
                    bl[lost[i] + 1] = false;
                }
            }
        }

        int answer = n - lost.length + count;
        return answer;
    }
}