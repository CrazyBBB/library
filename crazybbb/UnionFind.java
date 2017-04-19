package crazybbb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class UnionFind {
    int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        Arrays.fill(parent, -1);
    }

    public boolean union(int x, int y) {
        x = root(x);
        y = root(y);
        if (x != y) {
            if (parent[y] < parent[x]) {
                int tmp = y;
                y = x;
                x = tmp;
            }
            parent[x] += parent[y];
            parent[y] = x;
            return true;
        }
        return false;
    }

    public boolean isConnected(int x, int y) {
        return root(x) == root(y);
    }

    public int root(int x) {
        return parent[x] < 0 ? x : (parent[x] = root(parent[x]));
    }

    public int size(int x) {
        return -parent[root(x)];
    }

    public ArrayList<ArrayList<Integer>> getGroups() {
        int n = parent.length;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = root(i);
            if (!map.containsKey(r)) {
                map.put(r, groups.size());
                groups.add(new ArrayList<>());
            }
            groups.get(map.get(r)).add(i);
        }
        return groups;
    }
}
