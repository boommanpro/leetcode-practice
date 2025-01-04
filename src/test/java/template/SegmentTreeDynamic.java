package template;

public class SegmentTreeDynamic {

    public class Node {
        private Node left, right;
        private long sum = 0, min = 0, max = 0, val, add;
    }

    private final int N;
    private final Node root;


    public SegmentTreeDynamic(int max) {
        N = max;
        root = new Node();
    }

    public void update(Node node, int start, int end, int l, int r, long add) {
        if (l <= start && end <= r) {
            node.sum += (end - start + 1) * add;
            node.max += add;
            node.min += add;
            node.val = add;
            node.add += add;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            update(node.left, start, mid, l, r, add);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, add);
        }
        pushUp(node);
    }

    public long querySum(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.sum;
        }
        int mid = (start + end) >> 1;
        long ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            ans += querySum(node.left, start, mid, l, r);
        }
        if (r > mid) {
            ans += querySum(node.right, mid + 1, end, l, r);
        }
        return ans;
    }

    public long queryMin(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.min;
        }
        int mid = (start + end) >> 1, ans = 0;
        pushDown(node, mid - start + 1, end - mid);
        long left = Long.MAX_VALUE, right = Long.MAX_VALUE;
        if (l <= mid) {
            left = queryMin(node.left, start, mid, l, r);
        }
        if (r > mid) {
            right = queryMin(node.right, mid + 1, end, l, r);
        }
        return Math.min(left, right);
    }

    public long queryMax(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.min;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        long left = Long.MIN_VALUE, right = Long.MIN_VALUE;
        if (l <= mid) {
            left = queryMax(node.left, start, mid, l, r);
        }
        if (r > mid) {
            right = queryMax(node.right, mid + 1, end, l, r);
        }
        return Math.max(left, right);
    }


    private void pushUp(Node node) {
        node.sum = node.left.sum + node.right.sum;
        node.min = Math.min(node.left.min, node.right.min);
        node.max = Math.max(node.left.max, node.right.max);
    }

    private void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.add == 0) {
            return;
        }
        node.left.sum += node.add * leftNum;
        node.left.max += node.add;
        node.left.min += node.add;
        node.right.sum += node.add * rightNum;
        node.right.max += node.add;
        node.right.min += node.add;
        // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }


    public long queryMax(int l, int r) {
        return queryMax(root, 0, N, l, r);
    }

    public long queryMin(int l, int r) {
        return queryMin(root, 0, N, l, r);
    }


    public long querySum(int l, int r) {
        return querySum(root, 0, N, l, r);
    }


    public void update(int idx, long v) {
        update(root, 0, N, idx, idx, v);
    }

    public long get(int idx) {
        return querySum(root, 0, N, idx, idx);
    }

}
