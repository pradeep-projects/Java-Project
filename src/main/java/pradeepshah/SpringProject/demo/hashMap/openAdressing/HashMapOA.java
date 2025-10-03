package pradeepshah.SpringProject.demo.hashMap.openAdressing;
/*
*  In this approach, when a collision occurs, the algorithm searches for an alternative location within the array to place the key-value pair. Some common techniques include linear probing, quadratic probing, and double hashing.

Linear Probing: In linear probing, after a collision, search adjacent buckets until an empty spot or the desired element is found. If the next bucket is occupied, move to the next one and repeat. Linear probing can lead to clustering.
Quadratic Probing: Quadratic Probing is similar to linear probing but uses quadratic increments (1, 3, 6, 10, 15, …) away from the collision point. Quadratic probing helps reduce clustering.
Double Hashing: In double hashing, we use a second hash function to determine the step size for probing. Calculate the next bucket as hash(key) + i * hash2(key). Double hashing provides better distribution than linear or quadratic probing.
* */
public class HashMapOA <K,V> {
    private Object[] keys;
    private Object[] values;
    int capacity;

    public HashMapOA(int capacity){
        this.capacity  = capacity;
        keys = new Object[capacity];
        values = new Object[capacity];
    }

    public void put(K key, V value){
        int index = Math.abs(key.hashCode()) % capacity;
        while(keys[index]!=null){
            if(keys[index].equals(key)){
                values[index] = value; // update the value and return;
                return;
            }
            index = (index + 1) % capacity;
        }
        keys[index] = key;
        values[index] = value;
    }

    // function to get the value of key

    public  V get(K key){
        int index = Math.abs(key.hashCode()) % capacity;
        while(keys[index]!=null){
            if(keys[index].equals(key)){
                return (V) values[index];
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

}
