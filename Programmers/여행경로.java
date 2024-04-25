import java.util.*;

public class 여행경로 {
    static String[] answer;
    static boolean[] visited;
    static int answer_index = 0;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        answer = new String[tickets.length + 1];
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                }
                return o1[0].compareTo(o2[0]);
            }
        });

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                boolean bl = true;
                bfs(tickets, tickets[i][0], tickets[i][1], i);

                for (int j = 0; j < answer.length; j++) {
                    if (answer[j] == null || answer[j] == "") {
                        Arrays.fill(answer, "");
                        Arrays.fill(visited, false);
                        bl = false;
                        answer_index = 0;
                        break;
                    }
                }
                if (bl) {
                    break;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println("answer = " + answer[i]);
        }
    }

    public static void bfs(String[][] tickets, String start, String end, int index) {
        visited[index] = true;

        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        queue.add(end);

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            String s = queue.poll();
            String e = queue.poll();
            answer[answer_index++] = s;

            if (count == tickets.length) {
                answer[answer_index] = e;
                break;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && e.equals(tickets[i][0])) {
                    visited[i] = true;
                    queue.add(tickets[i][0]);
                    queue.add(tickets[i][1]);
                    break;
                }
            }
        }
    }
}