import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap <K, V>  implements Map61B<K, V>
{
    int size;
    int numElements=0;
    double loadFactor;
    ArrayList <LinkedList<Node>> buckets;
    HashSet <K> keys;

    private class Node
    {
        K key;
        V value;
        private Node(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap()
    {
        this.size=16;
        this.loadFactor=0.75;
        this.buckets=new ArrayList<>();
        this.keys=new HashSet<>();

        fillHashtable(buckets,size);

    }
    public MyHashMap(int initialSize)
    {
        this.size=initialSize;
        this.loadFactor=0.75;
        this.buckets=new ArrayList<>();
        this.keys=new HashSet<>();

        fillHashtable(buckets,size);
    }

    public MyHashMap(int initialSize, double loadFactor)
    {
        this.size=initialSize;
        this.loadFactor=loadFactor;
        this.buckets=new ArrayList<>();
        this.keys=new HashSet<>();

        fillHashtable(buckets,size);
    }

    private void fillHashtable(ArrayList <LinkedList<Node>> buckets, int size)
    {
        for (int i=0;i<size;i++)
        {
            buckets.add(new LinkedList<>());
        }
    }

    @Override
    public void clear()
    {
        this.buckets=new ArrayList<>();
        keys.clear();
        numElements=0;
        fillHashtable(buckets,size);
    }

    @Override
    public boolean containsKey(K key)
    {
        return keys.contains(key);
    }

    @Override
    public V get(K key)
    {
        for (int i=0;i<buckets.get(key.hashCode()%size).size();i++)
        {
            if (buckets.get(key.hashCode()%size).get(i).key.equals(key))
            {
                return buckets.get(key.hashCode()%size).get(i).value;
            }
        }

        return null;
    }

    @Override
    public int size()
    {
        return numElements;
    }

    @Override
    public void put(K key, V value)
    {
        if (containsKey(key))
        {
            for (int i=0;i<buckets.get(key.hashCode()%size).size();i++)
            {
                if (buckets.get(key.hashCode()%size).get(i).key.equals(key))
                {
                    buckets.get(key.hashCode()%size).get(i).value=value;
                }
            }

            return;
        }

        buckets.get(key.hashCode()%size).add(new Node(key,value));
        numElements++;
        keys.add(key);

        if ((double)(numElements/size)>=loadFactor)
        {
            resize();
        }
    }

    public void resize ()
    {
        ArrayList <LinkedList<Node>> newBuckets=new ArrayList<>(size*2);
        fillHashtable(newBuckets, size*2);

        for (K key: keys)
        {
            newBuckets.get(key.hashCode()%size*2).add(new Node(key,get(key)));
        }

        size*=2;
        this.buckets=newBuckets;
    }

    @Override
    public Set<K> keySet()
    {
        return keys;
    }

    @Override
    public V remove(K key)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator()
    {
        return keys.iterator();
    }
}
