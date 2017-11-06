package sorting;

public class SortingClient {

    public static void main(String[] args){
        Integer[] a = getData();
        Selection.sort(a);
        print(a);

        a = getData();
        Insertion.sort(a);
        print(a);

        a = getData();
        Merge.sort(a);
        print(a);

        a = getData();
        Quick.sort(a);
        print(a);

        a = getData();
        Heap.sort(a);
        print(a);

    }

    public static void print(Comparable[] a){
        for(Comparable val : a)
            System.out.print(val + " ");
        System.out.println();
    }

    public static Integer[] getData(){
        Integer[] a = new Integer[6];
        a[0] = 50;
        a[1] = 10;
        a[2] = 60;
        a[3] = 70;
        a[4] = 20;
        a[5] = 30;
        return a;
    }
}
