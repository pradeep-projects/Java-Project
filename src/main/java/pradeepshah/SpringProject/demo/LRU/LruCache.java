package pradeepshah.SpringProject.demo.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K,V> extends LinkedHashMap<K,V>{
   private final int capacity;

   public LruCache(int capacity){
       // initial capacity = 16, load factor = 0.75, accessOrder = true
       super(capacity,0.75f,true);
       this.capacity = capacity;
   }


   @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
       // when size exceeds the capacity, remove oldest
       return size() > capacity;
   }

}
