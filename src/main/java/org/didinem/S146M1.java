package org.didinem;

/**
 * Created by zhongzhengmin on 2018/2/28.
 *
 * wrong answer case
 * ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
 [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
 *
 *
 * expected answer
 * [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null]
 */
public class S146M1 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

//        System.out.println(cache.put(1, 1));
//        System.out.println(cache.put(2, 2));
//        System.out.println(cache.get(1));       // returns 1
//        System.out.println(cache.put(3, 3));    // evicts key 2
//        System.out.println(cache.get(2));        // returns -1 (not found)
//        System.out.println(cache.put(4, 4));    // evicts key 1
//        System.out.println(cache.get(1));        // returns -1 (not found)
//        System.out.println(cache.get(3));         // returns 3
//        System.out.println(cache.get(4));        // returns 4

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private static class LRUCache {

    private int capacity;

    private int size;

    private Entry[] values;

    Entry head;

    Entry tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        values = new Entry[capacity];
        head = null;
        tail = null;
    }

    private final int hash(int k) {
        int h = 0;

        Integer key = k;
        h ^= key.hashCode();

        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h, int length) {
        return h & (length-1);
    }

    public int put(int key, int value) {
        int index = indexFor(hash(key), capacity);
        Entry entry = get(index, key);
        if (entry != null) {
            int oldValue = entry.value;
            entry.value = value;
            updateEntry(entry);
            return oldValue;
        }

        if (size == capacity) {
            removeHeader();
        }

        Entry rootEntry = values[index];
        Entry newEntry = new Entry(key, value, index);
        Entry oldEntry = put(rootEntry, newEntry);
        size++;

        if (head == null && tail == null) {
            initLinkedList(newEntry);
        }
        addEntry(newEntry);

        return oldEntry == null ? -1 : oldEntry.value;
    }

    private Entry put(Entry rootEntry, Entry newEntry) {
        if (rootEntry == null) {
            values[newEntry.index] = newEntry;
            return null;
        }

        Entry parentEntry = null;
        for (Entry entry = rootEntry; entry != null; entry = entry.nextEntry) {
            if (entry.key == newEntry.key) {
                Entry oldEntry = new Entry(entry.key, entry.value, entry.index);
                entry.value = newEntry.value;
                return oldEntry;
            }
            parentEntry = entry;
        }
        parentEntry.nextEntry = newEntry;
        return null;
    }

    public int get(int key) {
        int index = indexFor(hash(key), capacity);
        Entry entry = get(index, key);
        if (entry != null && entry.key == key) {
            updateEntry(entry);
            return entry.value;
        }
        return -1;
    }

    private Entry get(int index, int key) {
        Entry rootEntry = values[index];
        for (Entry entry = rootEntry; entry != null; entry = entry.nextEntry) {
            if (entry.key == key) {
                return entry;
            }
        }
        return null;
    }

    private void initLinkedList(Entry entry) {
        head = entry;
        tail = entry;
        head.nextOrderEntry = tail;
        head.prevOrderEntry = tail;
        tail.nextOrderEntry = head;
        tail.prevOrderEntry = head;
    }

    private void addEntry(Entry entry) {
        tail.nextOrderEntry = entry;
        entry.prevOrderEntry = tail;
        entry.nextOrderEntry = head;
        tail = entry;
        head.prevOrderEntry = tail;
    }

    private void updateEntry(Entry entry) {
        if (entry == tail) {
            return;
        }

        Entry prevEntry = entry.prevOrderEntry;
        Entry nextEntry = entry.nextOrderEntry;
        prevEntry.nextOrderEntry = nextEntry;
        nextEntry.prevOrderEntry = prevEntry;

        if (head == entry) {
            head = nextEntry;
        }

        head.prevOrderEntry = entry;
        tail.nextOrderEntry = entry;
        tail = entry;
    }

    private void removeHeader() {
        Entry newHead = head.nextOrderEntry;
        Entry oldHead = head;

        tail.nextOrderEntry = newHead;
        newHead.nextOrderEntry = tail;

        head = newHead;

        values[oldHead.index] = oldHead.nextEntry;
        size--;
    }

    private static class Entry {
        int key;
        int value;
        int index;

        Entry prevOrderEntry;
        Entry nextOrderEntry;
        Entry nextEntry;

        public Entry(int key, int value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }
    }
    }

}
