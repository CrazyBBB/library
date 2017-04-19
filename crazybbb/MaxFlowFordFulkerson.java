package crazybbb;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxFlowFordFulkerson {
    ArrayList<Edge>[] graph;
    boolean[] used;
    int INF = Integer.MAX_VALUE;

    public MaxFlowFordFulkerson(int n) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        used = new boolean[n];
    }

    public void addEdge(int from, int to, int cap) {
        graph[from].add(new Edge(to, cap, graph[to].size()));
        graph[to].add(new Edge(from, 0, graph[from].size() - 1));
    }

    private int dfs(int v, int t, int f) {
        if (v == t) return f;
        used[v] = true;
        for (Edge e : graph[v]) {
            if (!used[e.to] && e.cap > 0) {
                int d = dfs(e.to, t, Math.min(f, e.cap));
                if (d > 0) {
                    e.cap -= d;
                    graph[e.to].get(e.rev).cap += d;
                    return d;
                }
            }
        }

        return 0;
    }

    public int maxFlow(int s, int t) {
        int flow = 0;
        while (true) {
            Arrays.fill(used, false);
            int f = dfs(s, t, INF);
            if (f == 0) return flow;
            flow += f;
        }
    }

    class Edge {
        int to, cap, rev;

        public Edge(int to, int cap, int rev) {
            this.to = to;
            this.cap = cap;
            this.rev = rev;
        }
    }
}