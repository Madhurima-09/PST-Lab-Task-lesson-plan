import java.util.LinkedList;

class MyHashSet {

    private final int BASE = 769; // A prime number for better hash distribution
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BASE;
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int bucketIndex = hash(key);
        LinkedList<Integer> bucket = buckets[bucketIndex];
        return bucket.contains(key);
    }
}