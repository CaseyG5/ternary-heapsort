package heapsortternary;

class Heap {  // As an experiment, this heap uses 0 as the first position, not 1
    public static void sort(Comparable a[]) {
        int N = a.length - 1;
        for(int i = (N-1)/3; i >= 0; i--)   // begin at first node with children
            sink(a, i, N);                  // sink that and all higher nodes
        while(N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }
    
    private static void sink(Comparable a[], int p, int N) {
        int c = 3*p + 1;                               // 1st possible child of p
        while(c <= N) {         // while a child exists
            if( c < N && less(a[c], a[c+1]) ) {              // if sibling higher?
                c++;                                            // then pick that one
                if( c < N && less(a[c], a[c+1]) ) c++;
            }
            else if( c+1 < N && less(a[c], a[c+2]) ) c+=2;      
                                                                
            if(!less(a[p],a[c])) break;               // if parent >= child, stop
            exch(a, p, c);
            p = c;              // child becomes next node to look at
            c = 3*c + 1;        // first child of that node
        }
    }
    
    private static boolean less(Comparable v, Comparable w) 
    {   return v.compareTo(w) < 0;   }
    
    private static void exch(Comparable a[], int i, int j)
    {   Comparable temp = a[i];  
        a[i] = a[j];  
        a[j] = temp;   
    }
    
    public static void shuffle(Comparable a[]) {
        for(int i=0; i<a.length; i++) {                
            int randindex;
            randindex = (int) (Math.random() * a.length);
            exch(a, i, randindex);
        }
    }
}

public class HeapsortTernary {

    public static void main(String[] args) {
        int sz = 100;
        Integer[] ints = new Integer[sz];
        
        for(int j=0; j<sz; j++)                 // fill the array with 1-100
            ints[j] = j+1;
        
        Heap.shuffle(ints);
        
        for(int k=0; k<sz; k++) {               // print shuffled numbers
            System.out.print(ints[k] + " ");
            if((k+1)%10==0) System.out.println();
        } System.out.println();
        
        Heap.sort(ints);
        
        for(int l=0; l<sz; l++) {               // print sorted numbers
            System.out.print(ints[l] + " ");
            if((l+1)%10==0) System.out.println();
        }
    }
}
/*
run:
21 77 9 71 2 20 15 66 30 1 
4 53 60 98 65 78 31 87 23 45 
50 36 79 41 85 74 70 25 39 92 
73 40 76 62 64 18 8 29 89 38 
88 6 72 37 14 95 59 16 68 48 
35 69 34 81 32 46 63 24 26 11 
19 7 96 3 90 42 43 80 83 27 
97 52 28 54 91 82 86 22 94 5 
55 99 51 49 61 47 44 57 75 58 
67 33 17 12 100 84 56 13 10 93 

1 2 3 4 5 6 7 8 9 10 
11 12 13 14 15 16 17 18 19 20 
21 22 23 24 25 26 27 28 29 30 
31 32 33 34 35 36 37 38 39 40 
41 42 43 44 45 46 47 48 49 50 
51 52 53 54 55 56 57 58 59 60 
61 62 63 64 65 66 67 68 69 70 
71 72 73 74 75 76 77 78 79 80 
81 82 83 84 85 86 87 88 89 90 
91 92 93 94 95 96 97 98 99 100 
*/