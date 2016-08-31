package stru.tree;

/**
 * 红色链接只可能在左边,将红链接画平就是2-3树
 *
 */
public class RedBlackBST < Key extends Comparable< Key >, Value > {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node{//每个节点都只会有一条从父节点指向自己的链接
        Key key;
        Value value;
        Node left, right;
        int N;//节点总数
        boolean color;//父节点指向它的链接的颜色

        public Node ( Key key, Value value, int n, boolean color ) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }



    private boolean isRed ( Node x ) {
        if ( x == null ) {
            return false;
        }
        return x.color == RED;
    }


}
