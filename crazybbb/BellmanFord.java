package crazybbb;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    int n;
    ArrayList<Edge> edges = new ArrayList<>();

    int INF = Integer.MAX_VALUE / 3;

    public BellmanFord(int n) {
        this.n = n;
    }

    public void addUndirectedEdge(int from, int to, int cost) {
        edges.add(new Edge(from, to, cost));
        edges.add(new Edge(from, to, cost));
    }

    public void addDirectedEdge(int from, int to, int cost) {
        edges.add(new Edge(from, to, cost));
    }

    // 負の閉路を含む場合 null を返す
    public int[] getDist(int s) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        dist[s] = 0;
        for (int i = 0; i < n; i++) {
            boolean update = false;
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.from] + edge.cost < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.cost;

                    if (i == n - 1) return null;
                    update = true;
                }
            }
            if (!update) break;
        }

        return dist;
    }

    class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}