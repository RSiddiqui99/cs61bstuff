public class LinkedListDeque <Type>
{
    private Node sentinel;
    private int size;
    private Node head;
    private Node tail;

    public class Node
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
        if (sentinel.next==null)
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

}
