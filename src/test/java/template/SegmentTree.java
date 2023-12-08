package template;

public class SegmentTree {
    long[] data;
    long[] maxTree;
    long[] minTree;
    long[] sumTree;

    public SegmentTree(long[] arr) {
        int n = arr.length;
        data = new long[n];
        System.arraycopy(arr, 0, data, 0, n);
        maxTree = new long[4 * n];
        minTree = new long[4 * n];
        sumTree = new long[4 * n];
        build(0, 0, n - 1);
    }

    public SegmentTree(int[] arr) {
        int n = arr.length;
        data = new long[n];
        for (int i = 0; i < n; i++) {
            data[i] = arr[i];
        }
        maxTree = new long[4 * n];
        minTree = new long[4 * n];
        sumTree = new long[4 * n];
        build(0, 0, n - 1);
    }


    private void build(int treeIdx, int l, int r) {
        if (l == r) {
            maxTree[treeIdx] = data[l];
            minTree[treeIdx] = data[l];
            sumTree[treeIdx] = data[l];
            return;
        }
        int mid = ((r - l) >> 1) + l;
        int left = treeIdx * 2 + 1;
        int right = treeIdx * 2 + 2;
        build(left, l, mid);
        build(right, mid + 1, r);
        maxTree[treeIdx] = Math.max(maxTree[left], maxTree[right]);
        minTree[treeIdx] = Math.min(minTree[left], minTree[right]);
        sumTree[treeIdx] = sumTree[left] + sumTree[right];
    }


    public long queryMax(int l, int r) {
        return queryMax(0, 0, data.length - 1, l, r);
    }

    private long queryMax(int treeIdx, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return maxTree[treeIdx];
        }
        int mid = ((r - l) >> 1) + l;
        int left = treeIdx * 2 + 1;
        int right = treeIdx * 2 + 2;
        if (queryL >= mid + 1) {
            return queryMax(right, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return queryMax(left, l, mid, queryL, queryR);
        }

        long leftResult = queryMax(left, l, mid, queryL, mid);
        long rightResult = queryMax(right, mid + 1, r, mid + 1, queryR);
        return Math.max(leftResult, rightResult);
    }

    public long queryMin(int l, int r) {
        return queryMin(0, 0, data.length - 1, l, r);
    }

    private long queryMin(int treeIdx, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return minTree[treeIdx];
        }
        int mid = ((r - l) >> 1) + l;
        int left = treeIdx * 2 + 1;
        int right = treeIdx * 2 + 2;
        if (queryL >= mid + 1) {
            return queryMin(right, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return queryMin(left, l, mid, queryL, queryR);
        }

        long leftResult = queryMin(left, l, mid, queryL, mid);
        long rightResult = queryMin(right, mid + 1, r, mid + 1, queryR);
        return Math.min(leftResult, rightResult);
    }

    public long querySum(int l, int r) {
        return querySum(0, 0, data.length - 1, l, r);
    }

    private long querySum(int treeIdx, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return sumTree[treeIdx];
        }
        int mid = ((r - l) >> 1) + l;
        int left = treeIdx * 2 + 1;
        int right = treeIdx * 2 + 2;
        if (queryL >= mid + 1) {
            return querySum(right, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return querySum(left, l, mid, queryL, queryR);
        }

        long leftResult = querySum(left, l, mid, queryL, mid);
        long rightResult = querySum(right, mid + 1, r, mid + 1, queryR);
        return leftResult + rightResult;
    }

    public void update(int idx, long v) {
        data[idx] = v;
        update(0, 0, data.length - 1, idx, v);
    }

    private void update(int treeIdx, int l, int r, int idx, long v) {
        if (l == r) {
            maxTree[treeIdx] = v;
            minTree[treeIdx] = v;
            sumTree[treeIdx] = v;
            return;
        }
        int mid = ((r - l) >> 1) + l;
        int left = treeIdx * 2 + 1;
        int right = treeIdx * 2 + 2;
        if (idx >= mid + 1) {
            update(right, mid + 1, r, idx, v);
        } else {
            update(left, l, mid, idx, v);
        }
        maxTree[treeIdx] = Math.max(maxTree[left], maxTree[right]);
        minTree[treeIdx] = Math.min(minTree[left], minTree[right]);
        sumTree[treeIdx] = sumTree[left] + sumTree[right];
    }
}
