package leetcode.editor.cn.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangqimeng
 * @date 2020/8/23 13:29
 */
public class CollectionUtils {

    public static<T> List<T> from(T... list) {
        return Arrays.stream(list).collect(Collectors.toList());
    }

}
