package crazybbb;

import java.util.ArrayList;

public class Graph {
    int n;
    ArrayList<Integer>[] G;
    public Graph(int n) {
        this.n = n;
        G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }
    }

    public void addUndirectedEdge(int from, int to) {
        G[from].add(to);
        G[to].add(from);
    }

    public void addDirectedEdge(int from, int to) {
        G[from].add(to);
    }

    public ArrayList<Integer> get(int from) {
        return G[from];
    }
}
