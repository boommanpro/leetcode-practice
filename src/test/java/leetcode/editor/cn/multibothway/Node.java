package leetcode.editor.cn.multibothway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wangqimeng
 * @date 2020/6/23 下午7:36
 */
@Getter
@Setter
@AllArgsConstructor
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
