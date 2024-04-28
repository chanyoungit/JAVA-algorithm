import java.util.*;

class node_island implements Comparable<node_island> {
    int start;
    int end;
    int weight;

    node_island(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(node_island o) {
        return this.weight - o.weight;
    }
}

public class 섬연결하기 {
    static int[] index;
    static int sum = 0;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        PriorityQueue<node_island> queue = new PriorityQueue<>();
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            queue.add(new node_island(a,b,c));
        }

        while (!queue.isEmpty()) {
            node_island o = queue.poll();
            union(o.start, o.end, o.weight);
        }

        System.out.println("sum = " + sum);
    }

    public static void union(int a, int b, int c) {
        a = find(a);
        b = find(b);

        if (a!=b){
            index[b] = a;
            sum += c;
        }
    }

    public static int find(int a){
        if (index[a] == a) {
            return a;
        } else {
            return index[a] = find(index[a]);
        }
    }
}