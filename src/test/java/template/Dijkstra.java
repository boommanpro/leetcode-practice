package template;

import java.util.*;

public class Dijkstra {
    private int n;

    private int m;

    List<int[]>[] g ;

    public Dijkstra(int n,int[][] edges) {
        this.n = n;
        this.m = edges.length;
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];
            int w = edge[2];
            g[x].add(new int[]{y, w, i});
            g[y].add(new int[]{x, w, i});
        }
    }

    public long[] getDistance(){
        long[] f = new long[n];
        Arrays.fill(f, Long.MAX_VALUE);
        f[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        //distance point
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long dis = curr[0];
            int x = (int) curr[1];
            if (dis > f[x]) {
                continue;
            }
            for (int[] next : g[x]) {
                int y = next[0];
                int w = next[1];
                if (dis + w < f[y]) {
                    f[y] = dis + w;
                    pq.offer(new long[]{f[y], y});
                }
            }
        }
        return f;
    }

    public List<int[]>[] getGraph(){
        return g;
    }

    public boolean[] getPassingEdge(){
        long[] f = getDistance();
        boolean[] edges = new boolean[m];
        boolean[] points = new boolean[n];
        if (f[n - 1] == Long.MAX_VALUE) {
            return edges;
        }
        boolean[] vis = new boolean[n];
        dfs(n - 1, g, f, vis, edges,points);
        return edges;
    }


    public boolean[] getPassingPoint(){
        long[] f = getDistance();
        boolean[] edges = new boolean[m];
        boolean[] points = new boolean[n];
        if (f[n - 1] == Long.MAX_VALUE) {
            return points;
        }
        boolean[] vis = new boolean[n];
        dfs(n - 1, g, f, vis, edges,points);
        return points;
    }

    private void dfs(int y, List<int[]>[] g, long[] f, boolean[] vis, boolean[] edges, boolean[] points) {
        vis[y] = true;
        points[y] = true;
        for (int[] next : g[y]) {
            int x = next[0];
            int w = next[1];
            int i = next[2];
            if (w + f[x] != f[y]) {
                continue;
            }
            edges[i] = true;
            if (!vis[x]) {
                dfs(x, g, f, vis, edges, points);
            }
        }
    }
}
