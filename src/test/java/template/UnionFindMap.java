package template;

import java.util.HashMap;
import java.util.Map;

public class UnionFindMap {

    // 连通分量个数
    private int count;
    // 存储每个节点的父节点
    private Map<Integer, Integer> parent;

    public UnionFindMap(int[] origin) {
        parent = new HashMap<>();
        for (int i : origin) {
            parent.put(i, i);
        }
        count = parent.size();
    }


    // 将节点 p 和节点 q 连通
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        if (rootP < rootQ) {
            int temp = rootQ;
            rootQ = rootP;
            rootP = temp;
        }
        parent.put(rootQ, rootP);
        // 两个连通分量合并成一个连通分量
        count--;
    }

    // 判断节点 p 和节点 q 是否连通
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }
}
