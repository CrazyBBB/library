package crazybbb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StronglyConnectedComponent {
    int n;
    List<Integer>[] graph, reverseGraph;
    boolean[] used;
    List<Integer> list;

    public StronglyConnectedComponent(int n) {
        this.n = n;
        graph = new ArrayList[n];
        reverseGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        used = new boolean[n];
        list = new ArrayList<>();
    }

    public void addEdge(int from, int to) {
        graph[from].add(to);
        reverseGraph[to].add(from);
    }

    public int[] execute() {
        for (int i = 0; i < n; i++) {
            if (!used[i]) dfs(i);
        }

        int[] cmp = new int[n];
        int k = 0;
        Arrays.fill(used, false);
        for (int i = n - 1; i >= 0; i--) {
            if (!used[list.get(i)]) rdfs(list.get(i), k++, cmp);
        }
        return cmp;
    }

    private void dfs(int x) {
        used[x] = true;
        for (int y : graph[x]) {
            if (!used[y]) dfs(y);
        }
        list.add(x);
    }

    private void rdfs(int x, int k, int[] cmp) {
        used[x] = true;
        cmp[x] = k;
        for (int y : reverseGraph[x]) {
            if (!used[y]) rdfs(y, k, cmp);
        }
    }
}
