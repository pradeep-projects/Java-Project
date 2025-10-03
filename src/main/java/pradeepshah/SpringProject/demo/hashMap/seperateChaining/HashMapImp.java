package pradeepshah.SpringProject.demo.hashMap.seperateChaining;

import pradeepshah.SpringProject.demo.hashMap.seperateChaining.Entry;

import java.util.*;
// to avoid collisions, separate chaining algorithm can be used
// in this algorithm, each array index holds a linkedlist of key-value pair, when collision happens,
// it adds key-value pair in linked list
public class HashMapImp <K, V> {
    int capacity;
    LinkedList<Entry<K,V>>[] buckets ;
    public HashMapImp(int capacity){
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
        Arrays.fill(buckets,new LinkedList<>());
    }
    // function to put the values in hashmap
    public void put(K key, V value){
        int index = key.hashCode() % capacity;
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for(Entry<K,V> entry: bucket){
            if(entry.key.equals(key)){
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key){
        int index = key.hashCode() % capacity;
        LinkedList<Entry<K,V>> bucket = buckets[index];
        for(Entry<K, V> entry: bucket){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

}
