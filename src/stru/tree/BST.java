package stru.tree;

/**
 * 向上取整（ceil(x) 大于x的最小） 向下取整（floor(x)小于x的最大）
 */
public class BST < K extends Comparable< K >, V > {
    private Node root;

    public static void main ( String[] args ) {
        BST< String, String > tree = new BST<>();
        tree.put( "a", "a" );
        tree.put( "c", "c" );
        tree.put( "e", "e" );
        tree.put( "f", "f" );
        tree.put( "h", "h" );
        tree.put( "z", "z" );
        //System.out.println( tree.size() );
        //System.out.println( tree.get( "a" ) );
        //System.out.println( tree.max() );
        //System.out.println( tree.min() );
        //System.out.println( tree.floor( "b" ) );
        System.out.println( tree.ceiling( "d" ) );
        System.out.println( tree.ceiling( "g" ) );

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
        if ( cmp > 0 ) {
            return ceiling( x.right, key );
            //return min( x.right );
        }
        else {
            Node t = ceiling( x.left, key );
            if ( t != null ) {
                return t;
            }
            else {
                return x;
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
