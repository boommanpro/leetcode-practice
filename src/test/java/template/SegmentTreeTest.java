package template;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeTest {

    @Test
    public void test() {
        long[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);

        Assert.assertEquals(9, segmentTree.queryMax(1, 4));
        Assert.assertEquals(3, segmentTree.queryMin(1, 4));
        Assert.assertEquals(24, segmentTree.querySum(1, 4));
        segmentTree.update(1, 6);
        Assert.assertEquals(9, segmentTree.queryMax(1, 4));
        Assert.assertEquals(5, segmentTree.queryMin(1, 4));
        Assert.assertEquals(27, segmentTree.querySum(1, 4));


    }

}
