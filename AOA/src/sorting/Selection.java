package sorting;

public class Selection {

    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i< n; i++) {
            int min = i;
            for(int j = i+1; j<n;j++) {
                if(less(a[j],a[min]))
                    min = j;
            }
            exhg(a, i, min);
        }
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
