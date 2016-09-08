package stru.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 向上取整（ceil(x) 大于x的最小） 向下取整（floor(x)小于x的最大）
 */
public class BST < K extends Comparable< K >, V > {
    private Node root;

    public static void main ( String[] args ) {
        BST< String, String > tree = new BST<>();
        tree.put( "s", "s" );
        tree.put( "e", "e" );
        tree.put( "a", "a" );
        tree.put( "r", "r" );
        tree.put( "c", "c" );
        tree.put( "h", "h" );
        tree.put( "x", "x" );
        tree.put( "m", "m" );
        tree.put( "p", "p" );
        tree.put( "l", "l" );
        tree.delete( "e" );
        tree.print();
        System.out.println();
        //System.out.println( tree.size() );
        //System.out.println( tree.get( "a" ) );
        //System.out.println( tree.max() );
        //System.out.println( tree.min() );
        //System.out.println( tree.floor( "b" ) );
        //System.out.println( tree.ceiling( "g" ) );
        //System.out.println( tree.floor( "g" ) );
        System.out.println( tree.select( 3 ) );
        //System.out.println( tree.ceiling( "" ) );

    }

    public V get ( K key ) {
        return get( root, key );
    }

    public V get ( Node x, K key ) {
        if ( x == null ) {
            return null;
        }
        int cmp = key.compareTo( x.key );
        if ( cmp < 0 ) {
            return get( x.left, key );
        }
        else if ( cmp > 0 ) {
            return get( x.right, key );
        }
        else {
            return x.value;
        }
    }

    public void put ( K key, V value ) {
        root = put( root, key, value );
    }

    //BST的插入会有最坏情况的啊(就是你从小到大插入 abcde这样 你第一个插入的点是根节点,是基于这个构建的树!)
    public Node put ( Node x, K key, V value ) {
        if ( x == null ) {
            return new Node( key, value, 1 );
        }
        int cmp = key.compareTo( x.key );
        if ( cmp < 0 ) {
            x.left = put( x.left, key, value );
        }
        else if ( cmp > 0 ) {
            x.right = put( x.right, key, value );
        }
        else {
            x.value = value;
        }
        x.sumOfChildNode = size( x.left ) + size( x.right ) + 1;
        return x;
    }

    public int size () {
        return size( root );
    }

    public int size ( Node x ) {
        if ( x == null ) {
            return 0;
        }
        else {
            return x.sumOfChildNode;
        }
    }

    public K min () {
        return min( root ).key;
    }

    public K max () {
        return max( root ).key;
    }

    private Node min ( Node x ) {
        if ( x.left == null ) {
            return x;
        }
        else {
            return min( x.left );
        }
    }

    public Node max ( Node x ) {
        if ( x.right == null ) {
            return x;
        }
        else {
            return max( x.right );
        }
    }

    public K floor ( K key ) {
        Node x = floor( root, key );

        if ( x == null ) {
            return null;
        }
        return x.key;
    }

    public K ceiling ( K key ) {
        Node x = ceiling( root, key );

        if ( x == null ) {
            return null;
        }
        return x.key;
    }

    public Node floor ( Node x, K key ) {
        if ( x == null ) {
            return null;
        }
        int cmp = key.compareTo( x.key );
        if ( cmp == 0 ) {
            return x;
        }
        else if ( cmp < 0 ) {
            return floor( x.left, key );
        }
        else {
            Node t = floor( x.right, key );
            if ( t != null ) {
                return t;
            }
            else {
                return x;
            }
        }
    }

    private Node ceiling ( Node x, K key ) {
        if ( x == null ) {
            return null;
        }
        int cmp = key.compareTo( x.key );
        if ( cmp == 0 ) {
            return x;
        }
        if ( cmp < 0 ) {
            // 一定要这里也是个递归啊!!!
            Node t = ceiling( x.left, key );
            if ( t != null ) {
                return t;
            }
            else {
                return x;
            }
        }
        return ceiling( x.right, key );
    }

    public void print () {
        print( root );
    }

    public K select ( int k ) {
        return select( root, k ).key;
    }

    //树中正好有K个小于它的键 往左走减一 往右走不减
    public Node select ( Node x, int k ) {
        if ( x == null ) {
            return null;
        }
        int t = size( x.left );

        if ( t > k ) {//继续往左走
            return select( x.left, k );
        }
        else if ( t < k ) {
            return select( x.right, k - t - 1 );
        }
        else {
            return x;
        }
    }

    public int rank ( K key ) {
        return rank( root, key );
    }

    private int rank ( Node x , K key) {
        if ( x == null ) {
            return 0;
        }
        int cmp = key.compareTo( x.key );
        if ( cmp < 0 ) {
            return rank( x.left, key );
        }
        else if ( cmp > 0 ) {
            return 1 + size( x.left ) + rank( x.right, key );
        }
        else {
            return size( x.left );
        }
    }

    public void deleteMin () {
        root = deleteMin( root );
    }

    public Node deleteMin ( Node x) {
        if ( x.left == null ) {
            return x.right;
        }
        x.left = deleteMin( x.left );//什么递归完了才会到下面
        ////////////////////////////
        x.sumOfChildNode = size( x.left ) + size( x.right ) + 1;
        return x;
    }

    public void delete ( K key )
    {
        root = delete( root, key );
    }

    //todo
    private Node delete ( Node x, K key ) {
        if ( x == null ) {
            return null;
        }

        int cmp = key.compareTo( x.key );

        if ( cmp < 0 ) {//在x的左边
            x.left = delete( x.left, key );//表示当前节点不是,往左边删除
        }
        else if ( cmp < 0 ) {
            x.right = delete( x.right, key );
        }
        else {
            if ( x.right == null ) {
                return x.left;
            }
            if ( x.left == null ) {
                return x.right;
            }
            Node t = x;
            x = min( t.right );
            x.right = deleteMin( t.right );
            x.left = t.left;
        }
        x.sumOfChildNode = size( x.left ) + size( x.right ) + 1;
        return x;
    }

    public void print ( Node x ) {
        if ( root == null ) {
            return;
        }
        Queue< Node > queue = new LinkedList<>();
        queue.add( root );
        while ( !queue.isEmpty() ) {
            Node node = queue.poll();
            System.out.print( node.value + "," );
            if ( node.left != null ) {
                queue.add( node.left );
            }
            if ( node.right != null ) {
                queue.add( node.right );
            }
        }
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int sumOfChildNode;

        public Node ( K key, V value, int sumOfChildNode ) {
            this.key = key;
            this.value = value;
            this.sumOfChildNode = sumOfChildNode;
        }
    }
}
