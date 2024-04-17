package template;

import java.util.Arrays;

public class UnionFindArray {
    // 连通分量个数
    private int count;
    // 存储每个节点的父节点
    private int[] parent;

    int[] size;

    // n 为图中节点的个数
    public UnionFindArray(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
    }

    // 将节点 p 和节点 q 连通
    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return false;

        parent[rootP] = rootQ;
        // 两个连通分量合并成一个连通分量
        count--;
        size[rootQ] += size[rootP];
        return true;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }

    public int size(int i) {
        return size[find(i)];
    }
}
