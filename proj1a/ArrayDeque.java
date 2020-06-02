public class ArrayDeque <T>
{
    private T items[];
    private int size=0;
    private int RFactor=0;
    private int nextFirst=0;
    private int nextLast=0;
    private int first=0;
    private int last=0;

    public ArrayDeque()
    {
        items=(T[])new Object[8];
        nextFirst=0;
        nextLast=1;
    }

    public void resize (int newSize, int start)
    {
        T [] newArray=(T[])new Object[newSize];
        System.arraycopy(items,0,newArray,start,size);
        items=newArray;
    }

    public void addFirst(T item)
    {
        if (nextFirst==0)
        {
            items[nextFirst]=item;
            nextFirst=items.length-1;
            first=0;
            size++;
            return;
        }

        items[nextFirst]=item;
        first=nextFirst;
        nextFirst--;
        size++;

    }

    public void addLast (T item)
    {
        if (nextLast==items.length-1)
        {
            items[nextLast]=item;
            last=nextLast;
            nextLast=0;
            size++;
            return;
        }

        items[nextLast]=item;
        last=nextLast;
        size++;
        nextLast++;
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
        int counter=0;
        int index=first;

        while (counter!=size)
        {
            if (index==items.length-1)
            {
                System.out.println(items[index]);
                index=0;
                counter++;
                continue;
            }

            System.out.println(items[index]);

            index++;
            counter++;
        }
    }

    public T removeFirst()
    {
        T returnItem=items[first];

        if (first==items.length-1)
        {
            items[first]=null;
            nextFirst=first;
            first=0;
            size--;

            return returnItem;
        }

        items[first]=null;
        first++;
        nextFirst=first-1;
        size--;

        return returnItem;

    }

    public T removeLast()
    {
        T returnItem=items[last];

        if (last==0)
        {
            items[last]=null;
            nextLast=last;
            last=items.length-1;
            size--;

            return returnItem;
        }

        items[last]=null;
        last--;
        nextLast=last+1;
        size--;

        return returnItem;

    }

    public T get(int index)
    {
        return items[index];
    }

}
