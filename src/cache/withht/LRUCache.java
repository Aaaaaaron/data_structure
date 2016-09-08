//package cache.withht;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Entry是一个双向的链表,KV对不是储存在Entry中的,而是存在map中,map一个个串在Entry上
// */
//public class LRUCache < K , V>
//{
//    private int cacheSize;
//    private HashMap< K, V > nodes;
//    private int currentSize;
//    private Entry first;
//    private Entry last;
//
//    public LRUCache ( int cacheSize )
//    {
//        currentSize = 0;
//        this.cacheSize = cacheSize;
//        nodes = new HashMap<>();
//    }
//
//    public synchronized void addElement ( K key, Map value )
//    {
//        Entry node = nodes.get( key );
//        if ( node == null )
//        {
//            if ( currentSize >= cacheSize )
//            {
//                nodes.remove( last.key );
//            }
//            node = new Entry( key, value );
//            currentSize++;
//        }
//
//        moveToHead( node );
//        nodes.put( key, node );
//    }
//
//    private synchronized void moveToHead ( Entry node )
//    {
//        //一个双向列表的操作
//        if ( node == first )
//        {
//            return;
//        }
//        if ( node.prev != null )
//        {
//            //把node的prev和node断开,再指向node的next
//            node.prev.next = node.next;
//        }
//        if ( node.next != null )
//        {
//            node.next.prev = node.prev;
//        }
//        if ( last == node )
//        {
//            last = node.prev;
//        }
//        if ( first != null )
//        {
//            node.next = first;
//            first.prev = node;
//        }
//
//
//    }
//
//    public Map getElement ( K key )
//    {
//        return null;
//    }
//
//    public boolean isExist ( K key )
//    {
//        return false;
//    }
//
//    public int capacity ()
//    {
//        return 0;
//    }
//
//    public void clear ()
//    {
//
//    }
//
//    class Entry
//    {
//        Entry prev;
//        Entry next;
//        K key;
//        Map value;
//
//        public Entry ( K key, Map value )
//        {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//
//}
