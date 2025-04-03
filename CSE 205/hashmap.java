public class HashMap<K, V> {
    
    // Node class for storing key-value pairs with linking for collision handling
    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    
    private Node<K, V>[] buckets;
    private int size;
    private float loadFactor;
    
    // Constructor with default capacity and load factor
    @SuppressWarnings("unchecked")
    public HashMap() {
        this.buckets = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        this.size = 0;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }
    
    // Constructor with specified initial capacity
    @SuppressWarnings("unchecked")
    public HashMap(int initialCapacity) {
        this.buckets = (Node<K, V>[]) new Node[initialCapacity];
        this.size = 0;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }
    
    // Constructor with specified initial capacity and load factor
    public HashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity);
        this.loadFactor = loadFactor;
    }
    
    // Hash function to determine bucket index
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }
    
    // Put a key-value pair into the hashmap
    public void put(K key, V value) {
        if (size >= loadFactor * buckets.length) {
            resize();
        }
        
        int index = hash(key);
        Node<K, V> node = buckets[index];
        
        // If bucket is empty, create new node
        if (node == null) {
            buckets[index] = new Node<>(key, value);
            size++;
            return;
        }
        
        // Check if key already exists in the chain
        Node<K, V> prev = null;
        while (node != null) {
            if ((key == null && node.key == null) || 
                (key != null && key.equals(node.key))) {
                node.value = value; // Update existing key's value
                return;
            }
            prev = node;
            node = node.next;
        }
        
        // Add new node at the end of the chain
        prev.next = new Node<>(key, value);
        size++;
    }
    
    // Get value for a given key
    public V get(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        
        while (node != null) {
            if ((key == null && node.key == null) || 
                (key != null && key.equals(node.key))) {
                return node.value;
            }
            node = node.next;
        }
        
        return null; // Key not found
    }
    
    // Remove a key-value pair and return the value
    public V remove(K key) {
        int index = hash(key);
        Node<K, V> node = buckets[index];
        Node<K, V> prev = null;
        
        while (node != null) {
            if ((key == null && node.key == null) || 
                (key != null && key.equals(node.key))) {
                if (prev == null) {
                    buckets[index] = node.next; // Remove first node
                } else {
                    prev.next = node.next; // Remove node from chain
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        
        return null; // Key not found
    }
    
    // Check if hashmap contains a key
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    // Get the number of key-value pairs
    public int size() {
        return size;
    }
    
    // Check if hashmap is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Resize the buckets array when load factor exceeded
    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldBuckets = buckets;
        buckets = (Node<K, V>[]) new Node[oldBuckets.length * 2];
        size = 0;
        
        // Rehash all existing entries
        for (Node<K, V> head : oldBuckets) {
            Node<K, V> current = head;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
    
    // Clear all entries
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        size = 0;
    }
}

