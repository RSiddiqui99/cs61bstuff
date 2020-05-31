public class ArrayDeque <Type>
{
    private Type items[];
    private int size;
    private int RFactor=0;
    private

    public ArrayDeque()
    {
        items=(Type[])new Object[8];

    }

    public void resize (int newSize, int start)
    {
        Type [] newArray=(Type[])new Object[newSize];
        System.arraycopy(items,0,newArray,start,size);
        items=newArray;
    }

    public void addFirst(Type item)
    {
        resize(size+1,1);
        items[0]=item;
        size++;

    }

    public void addLast (Type item)
    {
        resize(size+1,0);
        items[size]=item;
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
        for (int i=0;i<size;i++)
        {
            System.out.println(items[i]);
        }
    }

    public Type removeFirst()
    {


    }

    public Type removeLast()
    {
        Type returnItem=items[size-1];
        items[size-1]=null;
        size--;
        return returnItem;

    }

    public Type get(int index)
    {
        return items[index];
    }

}
