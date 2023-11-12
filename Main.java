public class Main {
    public static void main(String[] args) {
        System.out.println(FindMax(new int[]{1,5,9,2,4},5));
        
        DynamicArray array=new DynamicArray<Integer>(10);
        System.out.println("Checking if array is empty:"+array.isEmpty());
        for(int i=0;i<5;i++)
        {
            array.addAtEnd(i);
        }
        System.out.println("Array value");
        //array printing
        array.print();
        //adding value in front
        array.addAtFront(2);
        System.out.println("Array value");
        array.print();
        //printing length of array
        System.out.println("Size is:"+array.length());
        //printing index of num
        System.out.println("Index:"+array.find(4));
        //reversing array
        array.reverse();
        System.out.println("reversed array");
        array.print();
        //removing first occurrance
        array.removeFirst(2);
        System.out.println("Enter using remove first");
        array.print();
        array.addAtEnd(2);
        array.reverse();
        //remove all occ
        array.removeAll(2);
        System.out.println("Array after removing all occurance function");
        array.print();
    }
    public static int power(int b,int p)
    {
        if(p==1)
        {
            return b;
        }
        return(b*power(b,p-1));
    }
    public static int FindMax(int[]arr,int index)
    {
        if(index==1)
        {
            return arr[0];
        }
        return(Math.max(arr[index-1],FindMax(arr,index-1)));
    }
}
