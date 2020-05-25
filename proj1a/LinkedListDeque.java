public class LinkedListDeque <Type>
{
    private Node sentinel;
    private int size;

    private class Node
    {
        public Node prev;
        public Type item;
        public Node next;
        public Node sentinelLastPointer=null;

        public Node(Type item, Node next, Node prev)
        {
            this.item = item;
            this.next = next;
            this.prev=prev;
        }
    }

    public LinkedListDeque()
    {
        sentinel=new Node(null,null,null);
    }

    public void addFirst(Type item)
    {
        if (isEmpty()==true)
        {
            sentinel.next=new Node(item,sentinel.next,sentinel);
            sentinel.sentinelLastPointer=sentinel.next;
            size++;

            return;
        }

        sentinel.next=new Node(item,sentinel.next,sentinel);
        size++;
    }

    public void addLast(Type item)
    {
        if (isEmpty()==true)
        {
            sentinel.next=new Node(item,sentinel.next,sentinel);
            sentinel.sentinelLastPointer=sentinel.next;
            size++;

            return;
        }

        sentinel.sentinelLastPointer.next=new Node(item,sentinel,sentinel.sentinelLastPointer);
        size++;
    }

    public boolean isEmpty()
    {
        if (size==0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public int size()
    {
        return size;
    }

    public void printDeque()
    {
        Node temp=sentinel.next;

        while (temp!=sentinel)
        {
            System.out.println(temp.item+" ");
            temp=temp.next;
        }

        System.out.println();
    }

    public Type removeFirst()
    {
        if (isEmpty()==true)
        {
            return null;
        }

        else if (size==1)
        {
            Node temp=sentinel.next;

            sentinel.sentinelLastPointer=null;
            sentinel.next=null;
            size--;

            return temp.item;
        }

        Node temp=sentinel.next;

        sentinel.next=sentinel.next.next;
        sentinel.next.next.prev=sentinel;
        size--;

        return temp.item;
    }

    public Type removeLast()
    {
        if (isEmpty()==true)
        {
            return null;
        }

        else if (size==1)
        {
            Node temp=sentinel.next;

            sentinel.sentinelLastPointer=null;
            sentinel.next=null;
            size--;

            return temp.item;
        }

        Node temp=sentinel.sentinelLastPointer;

        sentinel.sentinelLastPointer=sentinel.sentinelLastPointer.prev;
        sentinel.sentinelLastPointer.next=sentinel;
        size--;

        return temp.item;
    }

    public Type get(int index)
    {
        Node temp=sentinel.next;

        for (int i=0;i<index;i++)
        {
            temp=temp.next;
        }

        return temp.item;
    }
}
