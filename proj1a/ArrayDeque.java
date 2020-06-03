public class ArrayDeque <T>
{
    private T items[];
    private int size=0;
    private int nextFirst=0;
    private int nextLast=0;

    public ArrayDeque()
    {
        items=(T[])new Object[8];
        nextFirst=0;
        nextLast=1;
    }

    private int minusOne (int index)
    {
        return (index-1+items.length)%items.length;
    }

    private int plusOne (int index)
    {
        return (index+1)%items.length;
    }

    private void resize (int newSize)
    {
        T [] newArray=(T[])new Object[newSize];

        int index=plusOne(nextFirst);

        for (int i=0;i<size;i++)
        {
            newArray[i]=items[index];
            index=plusOne(index);
        }

        items=newArray;
        nextFirst=newSize-1;
        nextLast=size;
    }

    public void addFirst(T item)
    {
        if (size==items.length)
        {
            resize(size*2);
        }

        items[nextFirst]=item;
        nextFirst=minusOne(nextFirst);
        size++;
    }

    public void addLast (T item)
    {
        if (size==items.length)
        {
            resize(size*2);
        }

        items[nextLast]=item;
        nextLast=plusOne(nextLast);
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
        int index=plusOne(nextFirst);

        for (int i=0;i<size;i++)
        {
            System.out.println(items[index]);
            index=plusOne(index);
        }
    }

    public T removeFirst()
    {
        if (isEmpty()==true)
        {
            return null;
        }

        if ((double)size/items.length<0.25 && size>16)
        {
            resize(size/2);
        }

        T returnItem=items[plusOne(nextFirst)];

        items[(plusOne(nextFirst))]=null;
        nextFirst=plusOne(nextFirst);
        size--;

        return returnItem;

    }

    public T removeLast()
    {
        if (isEmpty()==true)
        {
            return null;
        }

        if ((double)size/items.length<0.25 && size>16)
        {
            resize(size/2);
        }

        T returnItem=items[minusOne(nextLast)];

        items[minusOne(nextLast)]=null;
        nextLast=minusOne(nextLast);
        size--;

        return returnItem;

    }

    public T get(int index)
    {
        return items[plusOne(index-1)];
    }

}
