package es.datastructur.synthesizer;
import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue <T> {

    private int first;              /* Index for the next dequeue or peek. */
    private int last;               /* Index for the next enqueue. */
    private int fillCount;          /* Variable for the fillCount. */
    private T[] rb;                 /* Array for storing the buffer data. */

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */

    public ArrayRingBuffer(int capacity)
    {
        rb =(T[])new Object[capacity];
        first=0;
        last=0;
        fillCount=0;
    }

    @Override
    public int capacity()
    {
        return rb.length;
    }

    @Override
    public int fillCount()
    {
        return fillCount;
    }


    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */

    public void enqueue(T x)
    {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.

        if (fillCount==capacity())
        {
            throw new RuntimeException();

        }

        rb[last]=x;
        fillCount++;
        last++;

        if (last==capacity()-1)
        {
            last=0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */

    public T dequeue()
    {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.

        if (fillCount==0)
        {
            throw new RuntimeException();
        }

        T item=rb[first];
        rb[first]=null;
        first++;
        fillCount--;

        if (first==capacity()-1)
        {
            first=0;
        }

        return item;

    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */

    public T peek()
    {
        // TODO: Return the first item. None of your instance variables should
        //       change.

        if (fillCount==0)
        {
            throw new RuntimeException();
        }

        return rb[first];
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.





}
    // TODO: Remove all comments that say TODO when you're done.
