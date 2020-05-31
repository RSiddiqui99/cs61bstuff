public class LinkedListDeque <Type>
{
    public Node sentinel;
    private int size=0;

    private class Node
    {
        public Node prev;
        public Type item;
        public Node next;

        public Node(Type item, Node next, Node prev)
        {
            this.item = item;
            this.next = next;
            this.prev=prev;
        }
    }

    public LinkedListDeque()
    {
        sentinel=new Node(null,sentinel,sentinel);
    }

    private void addToEmptyList(Type item)
    {
        sentinel.next=new Node(item,sentinel,sentinel);
        sentinel.prev=sentinel.next;
        size++;

        return;
    }

    public void addFirst(Type item)
    {
        if (isEmpty()==true)
        {
            addToEmptyList(item);

            return;
        }

        sentinel.next=new Node(item,sentinel.next,sentinel);
        sentinel.next.next.prev=sentinel.next;
        size++;
    }

    public void addLast(Type item)
    {
        if (isEmpty()==true)
        {
            addToEmptyList(item);

            return;
        }

        sentinel.prev.next=new Node(item,sentinel,sentinel.prev);
        sentinel.prev=sentinel.prev.next;
        size++;
    }

    public boolean isEmpty()
    {
        if (size==0)
        {
            return true;
        }

        return false;
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

        Node temp=sentinel.next;

        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        size--;

        return temp.item;
    }

    public Type removeLast()
    {
        if (isEmpty()==true)
        {
            return null;
        }

        Node temp=sentinel.prev;

        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
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

    public Type getRecursiveHelper (int index, Node pointer)
    {
        if (index>size-1||index<0)
        {
            return null;
        }

        if (index==0)
        {
            return pointer.item;
        }

        return getRecursiveHelper(index-1,pointer.next);
    }

    public Type getRecursive(int index)
    {
        return getRecursiveHelper(index,sentinel.next);
    }
}
