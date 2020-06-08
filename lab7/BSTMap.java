import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>
{
    private Node root;                  // root of BST

    private class Node
    {
        private K key;              // sorted by key
        private V val;              // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(K key, V val, int size)
        {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BSTMap ()
    {
        root=null;
    }

    private V getHelper(Node node, K key)
    {
        if (node==null)
        {
            return null;
        }

        else if (key.compareTo(node.key)>0)
        {
            return getHelper(node.right,key);
        }

        else if (key.compareTo(node.key)<0)
        {
            return getHelper(node.left,key);
        }

        return node.val;
    }


    @Override
    public void clear()
    {
        root=null;
        root.size=0;
    }

    @Override
    public boolean containsKey(K key)
    {
        if (get(key)!=null)
        {
            return true;
        }

        return false;
    }




    @Override
    public V get(K key)
    {
        return getHelper(root,key);
    }

    @Override
    public int size()
    {
        return root.size;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}


