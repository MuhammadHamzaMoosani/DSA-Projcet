import java.util.Arrays;

public class DynamicArray <T extends Comparable<T>>
{
    T[] arr;
    int currIndex;
    int size;

    public DynamicArray()   // default constructor to create an array
    {
        arr = (T[])(new Comparable[10]);
        currIndex=-1;
    }

    DynamicArray(int size)   // constructor to create an array
    {
        arr = (T[])new Comparable[size];
        this.size=size;
        currIndex=-1;
    }
    public boolean isEmpty()
    {
        if(currIndex==-1)
        {
            return true;
        }
        return false;
    }
    public int length()
    {
        return currIndex;
    }
    public void print()
    {
        for(int i=0;i< size;i++)
        {
            if(arr[i]!=null)
                System.out.println(arr[i]);
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
    public void addAtFront(T data)
    {
        if(currIndex>= arr.length)
        {
            Fresizing(data,2);
        }
        else if (currIndex==-1) {
            currIndex=0;
            arr[currIndex]=data;
            currIndex++;
        }
        else
        {
            Fresizing(data,1);
        }
    }
    private void Fresizing(T data,int num)
    {
        T[] temp = (T[])(new Comparable[arr.length*num]);
        temp[0]=data;
        for (int i=1;i<arr.length;i++)
        {
            temp[i]=arr[i];
        }
        arr=temp;
    }
    public void addAtEnd(T data)
    {
        if(currIndex>= arr.length)
        {
            resizing(data);
        }
        else if (currIndex==-1) {
            currIndex=0;
            arr[currIndex]=data;
            currIndex++;
        }
        else
        {
            arr[currIndex]=data;
            currIndex++;
        }
    }
    private void resizing(T data)
    {
        T[] temp = (T[])(new Comparable[arr.length*2]);
        for (int i=0;i<arr.length;i++)
        {
            temp[i]=arr[i];
        }
        temp[arr.length]=data;
        arr=temp;
    }
    public void clear()
    {
        arr = (T[])(new Comparable[10]);
        currIndex=-1;
    }
    public int find(T value)
    {
        for(int i=0;i< arr.length-1;i++) {
            if(arr[i]==null)
            {
                continue;
            }
            if (arr[i].equals(value) )
            {
                return i;
            }
        }
        return -1;
    }
    public void reverse()
    {
        int j= arr.length-1;
        T[] rev=(T[])(new Comparable[10]);
        for(int i=0;i<arr.length;i++)
        {
            rev[j]=arr[i];
            j--;
        }
        arr=rev;
    }
    public T get(int index)
    {
        if(index>arr.length)
        {
            System.out.println("not correct index");
            return null;
        }
        return arr[index-1];
    }
    public void update(int index,T data)
    {
        arr[index]=data;
    }
    public void removeFirst(T value)
    {   int index=find(value);
        currIndex--;
        for(int i=index;i< arr.length-1;i++)
        {
            if(arr[i]!=null)
            {
            arr[i]=arr[i+1];
            }

        }
    }
    public void removeAll(T value)
    {
        for(int i=0;i< arr.length;i++)
        {
            if(find(value)==-1)
            {
                return;
            }
            removeFirst(value);
        }
    }
}

