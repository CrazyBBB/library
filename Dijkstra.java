package crazybbb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    int n;
    ArrayList<Pair>[] G;

    private long INF = Long.MAX_VALUE / 3;

    public Dijkstra(int n) {
        this.n = n;
        G = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            G[i] = new ArrayList<>();
        }
    }

    public void addUndirectedEdge(int from, int to, long cost) {
        G[from].add(new Pair(to, cost));
        G[to].add(new Pair(from, cost));
    }

    public void addDirectedEdge(int from, int to, int cost) {
        G[from].add(new Pair(to, cost));
    }

    public long[] getDist(int s) {
        PriorityQueue<Pair> Q = new PriorityQueue<>();
        Q.add(new Pair(s, 0));
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        boolean[] used = new boolean[n];
        while (!Q.isEmpty()) {
            Pair p = Q.poll();
            if (used[p.x]) continue;
            used[p.x] = true;
            dist[p.x] = p.y;

            for (Pair edge : G[p.x]) {
                Q.add(new Pair(edge.x, p.y + edge.y));
            }
        }
        return dist;
    }

    class Pair implements Comparable<Pair> {
        int x;
        long y;

        Pair(int x, long y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p) {
            return Long.compare(y, p.y);
        }
    }
}