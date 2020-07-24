public class UnionFind
{

    int numbers[];

    public UnionFind(int n)
    {
        numbers=new int[n];

        for (int i=0;i<n;i++)
        {
            numbers[i]=-1;
        }
    }

    private void validate(int vertex)
    {
        if (vertex<0||vertex>numbers.length-1)
        {
            throw new IndexOutOfBoundsException("vertex not valid");
        }

    }

    public int sizeOf(int v1)
    {
        validate(v1);
        return (numbers[find(v1)]*(-1));
    }


    public int parent(int v1)
    {
        validate(v1);
        return numbers[v1];
    }
    
    public boolean connected(int v1, int v2)
    {
        validate(v1);

        if (find(v1)==find(v2))
        {
            return true;
        }

        return false;
    }


    public void union(int v1, int v2)
    {
        validate(v1);
        validate(v2);

        if (connected(v1,v2)==true)
        {
            return;
        }

        if (numbers[find(v1)] == numbers[find(v2)])
        {
            numbers[find(v1)]=find(v2);
            numbers[find(v2)]*=2;
        }

        else if (numbers[find(v1)] > numbers[find(v2)])
        {
            numbers[find(v1)]+=numbers[find(v2)];
            numbers[find(v2)]=find(v1);
        }

        else
        {
            numbers[find(v2)]+=numbers[find(v1)];
            numbers[find(v1)]=find(v2);
        }
    }


    public int find(int vertex)
    {
        validate(vertex);

        int root=vertex;

        while (numbers[root]>=0)
        {
            root=numbers[root];
        }

        return root;
    }

}
