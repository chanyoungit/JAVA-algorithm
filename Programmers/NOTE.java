import java.util.*;

public class NOTE {
    public static void main(String[] args) {
        int[][] wires = {{1,2}, {1,0}, {2,3}};

        ArrayList<Integer>[] al = new ArrayList[4];

        for (int i=0; i<4; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i=0; i<2; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            al[a].add(b);
            al[b].add(a);
        }

        al[1].remove(Integer.valueOf(2));
        for(int i=0; i<al.length; i++) {
            for (int j=0; j<al[i].size(); j++){
                System.out.printf("%d ", al[i].get(j));
            }
            System.out.println();
        }

    }
}