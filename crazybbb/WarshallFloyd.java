package crazybbb;

import java.util.Arrays;

public class WarshallFloyd {
    int n;
    int[][] dist;
    int INF = Integer.MAX_VALUE / 3;

    public WarshallFloyd(int[][] a) {
        n = a.length;
        for (int i = 0; i < n; i++) {
            dist[i] = a[i].clone();
        }
    }

    public WarshallFloyd(int n) {
        this.n = n;
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
    }

    public void addUndirectedEdge(int from, int to, int cost) {
        dist[from][to] = cost;
        dist[to][from] = cost;
    }

    public void addDirectedEdge(int from, int to, int cost) {
        dist[from][to] = cost;
    }

    public int[][] getDist() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        return dist;
    }
}
