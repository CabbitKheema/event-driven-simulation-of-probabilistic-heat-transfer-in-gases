public class MinPQ <Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    public MinPQ(){
        pq = (Key[]) new Comparable[2];
    }

    public boolean isEmpty(){ return N==0;}

    // Resizes the array based on two conditions
    // increase array by size * 2 if size increases to N + 1
    // decrease array by size / 2 if size decreases to size/4 == N + 1

    public void resize(int capacity) {
        Key[] copy = (Key[]) new Comparable[capacity];
        for(int i = 1; i <= N; i++) {
            copy[i] = pq[i];
        }
        pq = copy;
    }

    public void insert(Key x){
        // +1 is to include null entry at 0th index
        if (N + 1 == pq.length) {
            resize(2 * pq.length);
        }
        pq[++N] = x;
        swim(N);
    }

    public Key delMin() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Cannot delete from empty priority queue!");
        Key min = pq[1];
        exch(1, N--);
        pq[N+1] = null; // loitering
        sink(1);
        if (N > 0 && N + 1 == pq.length / 4) {
            resize(pq.length / 2);
        }
        return min;
    }

    private void swim(int k){
        while(k > 1 && greater(k/2, k) ){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if(j < N && greater(j, j+1)) j++;
            if(!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j){
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j){
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }
}
