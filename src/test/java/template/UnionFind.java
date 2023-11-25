package template;

public class UnionFind {
    int[] parents;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) {
            return false;
        }
        if (px > py) {
            int temp = py;
            py = px;
            px = temp;
        }
        parents[px] = py;
        return true;
    }

    private int find(int v) {
        if (v != parents[v]) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
