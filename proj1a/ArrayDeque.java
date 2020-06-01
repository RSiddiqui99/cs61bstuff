public class ArrayDeque <Type>
{
    private Type items[];
    private int size=0;
    private int RFactor=0;
    private int nextFirst=0;
    private int nextLast=0;
    private int first=0;
    private int last=0;

    public ArrayDeque()
    {
        items=(Type[])new Object[8];
        nextFirst=0;
        nextLast=1;
    }

    public void resize (int newSize, int start)
    {
        Type [] newArray=(Type[])new Object[newSize];
        System.arraycopy(items,0,newArray,start,size);
        items=newArray;
    }

    public void addFirst(Type item)
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

    public void addLast (Type item)
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

    public Type removeFirst()
    {
        Type returnItem=items[first];

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

    public Type removeLast()
    {
        Type returnItem=items[last];

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

    public Type get(int index)
    {
        return items[index];
    }

}
