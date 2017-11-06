package sorting;

/**
 *
 */
public class Quick {

    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int j = position(a, lo, hi);
        sort(a, lo, j);
        sort(a, j+1, hi);
    }

    public static int position(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;

        while (true){
            while (less(a[++i], a[lo])){
                if(i>=hi) break;
            }

            while (!less(a[--j], a[lo])){
                if(j<=lo) break;
            }

            if(i>=j) break;
            exhg(a, i, j);
        }

        exhg(a, lo, j);
        return j;
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exhg(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
