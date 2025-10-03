package pradeepshah.SpringProject.demo.HLD;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
* Consistent hashing is a hashing technique where keys are mapped to a circular hash space (ring) instead of a
* fixed-size table. When nodes (servers) are added or removed, only a small fraction of keys need to be remapped,
* unlike traditional hashing where most keys may need redistribution.
*
* Why it is used

Scalability → Easily add/remove servers in distributed systems with minimal data movement.

Load balancing → Evenly distributes keys across nodes.

Fault tolerance → When a server fails, only its portion of keys are redistributed.

Common use cases → Distributed caches (e.g., Memcached, Redis), databases, sharded storage, and load balancers.
* */
public class ConsistentHashing {
    private final Set<String> servers; // set of physical servers
    private final TreeMap<Long, String> ring; // hash ring which will store virtual nodes

    private final int numberOfReplicas; // number of virtual nodes for each servers

    public ConsistentHashing(List<String> serverslist, int numberOfReplicas){
        this.numberOfReplicas = numberOfReplicas;
        this.ring = new TreeMap<>();
        this.servers = new HashSet<>();

        // add each server to the hash ring
        for(String server : serverslist){
            addServer(server);
        }
    }

    private long hash(String key){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes());
            byte[] digest = md.digest();
            return  ((long) (digest[0] & 0xFF) << 24) |
                    ((long) (digest[1] & 0xFF) << 16) |
                    ((long) (digest[2] & 0xFF) << 8) |
                    ((long) (digest[3] & 0xFF));
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }



    public void addServer(String server){
        servers.add(server);
        for(int i=0;i<numberOfReplicas;i++){
            long hashValue = hash(server + "_" + i); // Unique hash for each virtual node
            ring.put(hashValue, server);
        }
    }

    public void removeServer(String server){
        if(servers.remove(server)){
            for(int i=0;i<numberOfReplicas;i++){
                long hashValue = hash(server + "_" + i);
                ring.remove(hashValue);
            }
        }
    }

    public String getServer(String key){
        if(ring.isEmpty()){
            return null; // no server available
        }
        long hashValue = hash(key);

        // find the closest server in clockwise direction

        Map.Entry<Long, String> entry = ring.ceilingEntry(hashValue);
        if(entry == null){
            // If we exceed the highest node, wrap around to the first node
            entry = ring.firstEntry();
        }
        return entry.getValue();
    }


    public static void main(String[] args){
        List<String> servers = Arrays.asList("S0","S1","S2","S3","S4","S5");
        ConsistentHashing algo = new ConsistentHashing(servers, 3);

        // Step 2: Assign requests (keys) to servers
        System.out.println("UserA is assigned to: " + algo.getServer("UserA"));
        System.out.println("UserB is assigned to: " + algo.getServer("UserB"));

        // add server dynamically
        algo.addServer("S6");
        System.out.println("UserA is now assigned to: " + algo.getServer("UserA"));


        // Step 4: Remove a server dynamically
        algo.removeServer("S2");
        System.out.println("UserB is now assigned to: " + algo.getServer("UserB"));

        System.out.println("UserC is  assigned to: " + algo.getServer("UserC"));



    }



}
