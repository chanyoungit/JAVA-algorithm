import java.util.ArrayList;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int count1 = 0;
        int k1 = 1;
        for (int i = 0; i < answers.length; i++) {
            if (k1 == answers[i]) {
                count1++;
            }
            k1++;
            if (k1 == 6) {
                k1 = 1;
            }
        }

        int count2 = 0;
        int k2 = 1;
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                if (answers[i] == 2) {
                    count2++;
                }
            } else {
                if (answers[i] == k2) {
                    count2++;
                }
                if (k2 == 1) {
                    k2 = 3;
                } else if (k2 == 5) {
                    k2 = 1;
                } else {
                    k2++;
                }
            }
        }

        int count3 = 0;
        int k3 = 3;
        for (int i = 0; i < answers.length; i++) {
            if (k3 == answers[i]) {
                count3++;
            }

            if (i % 2 == 1) {
                if (k3 == 3) {
                    k3 = 1;
                } else if (k3 == 2) {
                    k3 = 4;
                } else if (k3 == 5) {
                    k3 = 3;
                } else {
                    k3++;
                }
            }
        }
        int[] arr = new int[3];
        arr[0] = count1;
        arr[1] = count2;
        arr[2] = count3;
        ArrayList<Integer> al = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (max == arr[i]) {
                al.add(i + 1);
            }
        }

        return al.stream().mapToInt(i -> i).toArray();
    }
}
