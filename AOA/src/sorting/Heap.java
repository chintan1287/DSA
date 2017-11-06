package sorting;

public class Heap {
    public static void sort(Comparable[] a){
        int n = a.length;
        for(int k = n/2; k>0; k--){
            sink(a,k,n);
        }

        while (n > 1) {
            exhg(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private static void sink(Comparable[] a, int k, int n){
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exhg(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int v, int w) {
        return a[v-1].compareTo(a[w-1]) < 0;
    }

    private static void exhg(Comparable[] a, int i, int j) {
        Comparable temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }

}
