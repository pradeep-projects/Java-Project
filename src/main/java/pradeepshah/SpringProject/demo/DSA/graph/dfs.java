package pradeepshah.SpringProject.demo.DSA.graph;
import java.util.*;
public class dfs {
 //  splitwise simplify transactions algorithm
    int minTransaction(int[][] transactions){
        Map<Integer, Integer> memberVsBalance = new HashMap<>();
        // compute incoming  - outgoing
        for(int[] txn: transactions){
            int from = txn[0];
            int to = txn[1];
            int amount = txn[2];
            memberVsBalance.put(from, memberVsBalance.getOrDefault(from,0)  - amount);
            memberVsBalance.put(to, memberVsBalance.getOrDefault(to,0) + amount);
        }

        // put into the balance list
        List<Integer> balances = new ArrayList<>(memberVsBalance.values());
        return dfsHelper(balances, 0);
    }

    int dfsHelper(List<Integer> balances, int index){
        if(balances.size() == 0 || index >= balances.size()){
            return 0;
        }
        if(balances.get(index) == 0){
            return dfsHelper(balances, index + 1);
        }
        int currentVal = balances.get(index);
        int minCount = Integer.MAX_VALUE;
        for(int nextIndex = index + 1 ; nextIndex < balances.size(); nextIndex++){
            int nextVal = balances.get(nextIndex);
            if(nextVal * currentVal < 0){
                balances.set(nextIndex, nextVal + currentVal);
                minCount = Math.min(minCount, 1 + dfsHelper(balances, index + 1));
                balances.set(nextIndex, nextVal); // back track
                if(currentVal + nextVal == 0){
                    break;
                }
            }
        }
        return minCount;
    }
}
